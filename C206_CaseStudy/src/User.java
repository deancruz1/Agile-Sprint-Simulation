
public class User extends Item {
	private int age;
	private String role;
	
	public User(int id, String name, int age, String role) {
		super(id, name);
		this.age = age;
		this.role = role;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString(){
		String output = super.toString();
		output += String.format("%-10d %-10s", age, role);
		return output;
	}
	
}
