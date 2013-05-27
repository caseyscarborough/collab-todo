import collab.todo.User
import collab.todo.Category
import collab.todo.Todo
import org.apache.commons.codec.digest.DigestUtils

class BootStrap {

    def init = { servletContext ->
		if(!User.count()) {
			println "Creating users..."
			def casey = new User(userName: "casey", password: DigestUtils.shaHex("password"), firstName: "Casey", lastName: "Scarborough", categories: [:], todos: [:]).save(failOnError: true)
			def testUser = new User(userName: "user", password: DigestUtils.shaHex("password"), firstName: "John", lastName: "Doe", categories: [:], todos: [:]).save(failOnError: true)
			println "Success. Creating categories..."
			def home = new Category(name: "Home", description: "For things around the house.", user: casey).save(failOnError: true)
			def weekend = new Category(name: "Weekend", description: "Things to do this weekend.", user: testUser).save(failOnError: true)
			def work = new Category(name: "Work", description: "For things around the workplace.", user: casey).save(failOnError: true)
			println "Success."
			
			def todo1 = new Todo(name: "Take out trash", createdDate: new Date(), priority: "High", status: "Started", note: "The trash is piling up, take it out!", completedDate: null, dueDate: null, category: home, owner: casey).save(failOnError: true)
			def todo2 = new Todo(name: "Get milk", createdDate: new Date(), priority: "Medium", status: "Started", note: "No milk for cereal, purchase ASAP.", completedDate: null, dueDate: null, category: home, owner: casey).save(failOnError: true)
			def todo3 = new Todo(name: "Finish project", createdDate: new Date(), priority: "Low", status: "Started", note: "Finish that one project.", completedDate: null, dueDate: null, category: work, owner: casey).save(failOnError: true)
			def todo4 = new Todo(name: "Go fishing", createdDate: new Date(), priority: "Low", status: "Started", note: "It's the weekend, go fishing!", completedDate: null, dueDate: null, category: weekend, owner: testUser).save(failOnError: true)
			
			println "Adding categories to users..."
			casey.categories.add(home)
			casey.categories.add(work)
			casey.todos.add(todo1)
			casey.todos.add(todo2)
			casey.todos.add(todo3)
			casey.save(failOnError: true)
			testUser.categories.add(weekend)
			testUser.todos.add(todo4)
			testUser.save(failOnError: true)
			println "Success! Starting application."
		}
    }
    def destroy = {
    }
}
