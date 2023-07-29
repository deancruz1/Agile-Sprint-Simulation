
public class Menu extends Item {

	private double price;
	private String foodItems;
	
	public Menu(int id, String name, String foodItems, double price) {
		super(id, name);
		this.price = price;
		this.foodItems = foodItems;
	}

	public double getPrice() {
		return price;
	}
	
	public String getFoodItems() {
		return foodItems;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}
	
	public String toString(){
		String output = super.toString();
		output += String.format("%-30s %-10.2f", foodItems, price);
		return output;
	}
	
}
