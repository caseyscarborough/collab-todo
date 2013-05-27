package collab.todo

class SecurityFilters {

    def filters = {
		collabTodoFilter(controller:'*', action:'*') {
            before = {
				if(!session.user && 
					!controllerName.equals('simpleCaptcha') && 
					!controllerName.equals('home') && 
					!controllerName.equals('login')) {
					
					redirect(controller:'login')
					return false
				}
            }
        }
    }
}
