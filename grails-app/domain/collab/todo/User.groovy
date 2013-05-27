package collab.todo
import org.apache.commons.codec.digest.DigestUtils

class User {
	
	static transients = [ "confirmPassword" ]
	
	String userName
	String firstName
	String lastName
	String password
	
	static hasMany = [todos: Todo, categories: Category]
	
    static constraints = {
		userName(blank:false, unique:true)
		password(blank:false, password:true, display:false)
		firstName(blank:false)
		lastName(blank:false)
    }
	
	String toString() {
		"$lastName, $firstName"
	}
	
	String hashPassword(String password) {
		DigestUtils.shaHex(password)
	}
}
