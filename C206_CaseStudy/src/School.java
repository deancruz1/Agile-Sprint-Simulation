
public class School extends Item {

	private String address;
	
	public School(int id, String name, String address) {
		super(id, name);
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString(){
		String output = super.toString();
		output += String.format("%-10s", address);
		return output;
	}
	
}
