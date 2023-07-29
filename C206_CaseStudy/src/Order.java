
public class Order extends Item {

	private double cost;
	
	public Order(int id, String name, double cost) {
		super(id, name);
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String toString(){
		String output = super.toString();
		output += String.format("%-10.2f", cost);
		return output;
	}
	
}
