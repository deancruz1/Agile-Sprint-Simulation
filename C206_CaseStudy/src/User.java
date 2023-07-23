
public class User {
	
	private int id, age;
	private String name, role;
	
	public User(int id, String name, int age, String role) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.role = role;
	}
	
	public int getId() { return id; }
	public String getName() { return name; }
	public int getAge() { return age; }
	public String getRole() { return role; }
	
	public void setId(int id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }
	public void setRole(String role) { this.role = role; }
	
}
