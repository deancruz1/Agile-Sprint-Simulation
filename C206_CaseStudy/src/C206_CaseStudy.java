import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialize ArrayList for each object
		ArrayList<User> userList = new ArrayList<User>();
		
		// Add initial objects to ArrayList
		userList.add(new User(1, "Peter Tan", 32, "Parent"));
		userList.add(new User(2, "Mary Lim", 35, "Guardian"));
		
		int option = 0;

		while (option != 4) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				itemTypeMenu();
				
				
			} else if (option == 2) {
				itemTypeMenu();
				
				
			} else if (option == 3) {
				itemTypeMenu();
				
				
			} else if (option == 4) 
				System.out.println("Bye!");
			else
				System.out.println("Invalid option.");
			
		}

	}

	public static void menu() {
		setHeader("LUNCHBOX ORDERING SYSTEM");
		System.out.println("1. View Item");
		System.out.println("2. Add Item");
		System.out.println("3. Delete Item");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	private static void itemTypeMenu() {
		setHeader("ITEM TYPES");
		System.out.println("1. Users");
		System.out.println("2. Schools");
		System.out.println("3. Menu");
		System.out.println("4. Orders");
		System.out.println("5. Payment Methods");
		System.out.println("6. Vendors");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
		
}


