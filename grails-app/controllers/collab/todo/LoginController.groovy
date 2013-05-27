package collab.todo

class LoginController {
	def simpleCaptchaService
	
    def index() { }
	
	def handleLogin() {
		def hashedPassword = User.hashPassword(params.password)
		def user = User.findByUserNameAndPassword(params.userName, hashedPassword)
		if(!user) {
			flash.message = "Username and password combination not found"
			redirect(controller:'login')
			return
		} else {
			session.user = user
			redirect(controller:'todo')
		}
	}
	
	def handleRegistration() {
		def user = new User()
		println params
		user.properties = params
		boolean captchaValid = simpleCaptchaService.validateCaptcha(params.captcha)
		if(captchaValid) {
			if(params.password != params.confirm) {
				flash.message = "The passwords did not match."
				render(view:'register', model:[user:user])
			} else {
				user.password = User.hashPassword(user.password)
				
				if(user.save()) {
					flash.message = "Account created successfully!"
					redirect(controller:'login')
				} else {
					println "Couldn't save."
					flash.user = user
					render(view:'register', model:[user:user])
				}
			}
		} else {
			flash.message = "Access code did not match."
			redirect(action:'register')
		}
	}
	
	def logout() {
		if(session.user) {
			session.user = null
			session.invalidate()
			flash.message = "Successfully logged out."
			redirect(controller: 'login')
		}
	}
	
	def register() {}
	
}
