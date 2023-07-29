
public class Menu extends Item {

	private int calories;
	private String foodItems;
	
	public Menu(int id, String name, String foodItems, int calories) {
		super(id, name);
		this.calories = calories;
		this.foodItems = foodItems;
	}

	public int getCalories() {
		return calories;
	}
	
	public String getFoodItems() {
		return foodItems;
	}
	
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}
	
	public String toString(){
		String output = super.toString();
		output += String.format("%-30s %-10d", foodItems, calories);
		return output;
	}
	
}
