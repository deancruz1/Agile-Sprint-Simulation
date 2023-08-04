
public class Vendor extends Item {
	
	private String specialty;

	public Vendor(int id, String name, String specialty) {
		super(id, name);
		this.specialty = specialty;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	public String toString(){
		String output = super.toString();
		output += String.format("%-10s", specialty);
		return output;
	}
}
