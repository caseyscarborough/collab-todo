package collab.todo

import org.springframework.dao.DataIntegrityViolationException
import org.apache.commons.codec.digest.DigestUtils
import grails.converters.*

class UserController {
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def listUsers = {
		render User.list() as JSON
	}
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]
    }

    def create() {
        [userInstance: new User(params)]
    }

    def save() {
		params.password = DigestUtils.shaHex(params.password)
        def userInstance = new User(params)
        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.userName])
        redirect(action: "show", id: userInstance.id)
    }

    def show(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        } else if (session.user.id != id) {
			flash.message = "You do not have access to view or edit this user."
			redirect(action: "list")
        }

        [userInstance: userInstance]
    }

    def edit(Long id) {
		if(session?.user && session.user.id == id) {
	        def userInstance = User.get(id)
	        if (!userInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
	            redirect(action: "list")
	            return
	        }
	
	        [userInstance: userInstance]
		} else {
			redirect(action: "list")
		}
    }

    def update(Long id, Long version) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'user.label', default: 'User')] as Object[],
                          "Another user has updated this User while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }
		params.password = User.hashPassword(params.password)
        userInstance.properties = params

        if (!userInstance.save(flush: true)) {
            render(view: "edit", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    def delete(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        try {
            userInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), userInstance?.userName])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), userInstance?.userName])
            redirect(action: "show", id: id)
        }
    }
	
	def login() {}
	
	
	
}
