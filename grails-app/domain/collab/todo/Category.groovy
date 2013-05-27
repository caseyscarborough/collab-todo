package collab.todo

class Category {
	
	String name
	String description
	User user
	
	static belongsTo = User
	// Designates one-to-many relationship with Todo
	static hasMany = [todos: Todo]
	
    static constraints = {
		name(blank:false)
		description()
		user()
    }
	
	String toString() {
		name
	}
}
