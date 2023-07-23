import java.util.ArrayList;

public class C206_CaseStudy {

	// Add static variables
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_QUIT = 4;
	
	private static final int ITEM_TYPE_USER = 1;
	private static final int ITEM_TYPE_SCHOOL = 2;
	private static final int ITEM_TYPE_MENU = 3;
	private static final int ITEM_TYPE_ORDER = 4;
	private static final int ITEM_TYPE_PAYMENT = 5;
	private static final int ITEM_TYPE_VENDOR = 6;
	
	public static void main(String[] args) {
		
		// Initialize ArrayList for each object
		ArrayList<User> userList = new ArrayList<User>();
		
		// Add initial objects to ArrayList
		userList.add(new User(1, "Peter Tan", 32, "Parent"));
		userList.add(new User(2, "Mary Lim", 35, "Guardian"));
		
		int option = 0;

		while (option != OPTION_QUIT) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				itemTypeMenu();
				int itemType = Helper.readInt("Enter option to select item type > ");
				
				if (itemType == ITEM_TYPE_USER)
					viewAllUser(userList);
				
				else if (itemType == ITEM_TYPE_SCHOOL)
					viewAllUser(userList); // Will update later

				else if (itemType == ITEM_TYPE_MENU)
					viewAllUser(userList); // Will update later
					
				else if (itemType == ITEM_TYPE_ORDER)
					viewAllUser(userList); // Will update later
					 
				else if (itemType == ITEM_TYPE_PAYMENT)
					viewAllUser(userList); // Will update later
					
				else if (itemType == ITEM_TYPE_VENDOR)
					viewAllUser(userList); // Will update later
					
				else
					System.out.println("Invalid Type.");
				
			} else if (option == OPTION_ADD) {
				itemTypeMenu();
				int itemType = Helper.readInt("Enter option to select item type > ");
				
				if (itemType == ITEM_TYPE_USER) {
					// Add a User
					User user = inputUser();
					addUser(userList, user);
					System.out.println("User added.");
					
				} else if (itemType == ITEM_TYPE_SCHOOL) {
					
				} else if (itemType == ITEM_TYPE_MENU) {
					
				} else if (itemType == ITEM_TYPE_ORDER) {
					
				} else if (itemType == ITEM_TYPE_PAYMENT) {
					
				} else if (itemType == ITEM_TYPE_VENDOR) {
					
				} else
					System.out.println("Invalid Type.");
				
			} else if (option == OPTION_DELETE) {
				itemTypeMenu();
				int itemType = Helper.readInt("Enter option to select item type > ");
				
				if (itemType == ITEM_TYPE_USER) {
					
				} else if (itemType == ITEM_TYPE_SCHOOL) {
					
				} else if (itemType == ITEM_TYPE_MENU) {
					
				} else if (itemType == ITEM_TYPE_ORDER) {
					
				} else if (itemType == ITEM_TYPE_PAYMENT) {
					
				} else if (itemType == ITEM_TYPE_VENDOR) {
					
				} else
					System.out.println("Invalid Type.");
				
			} else if (option == OPTION_QUIT) 
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
	
	//================================= Option 1 View (CRUD - Read) =================================
	public static String retrieveAllUser(ArrayList<User> userList) {
		String output = "";
		
		for (int i = 0; i < userList.size(); i++) {
			output += String.format("%-84s \n", userList.get(i).toString());
		}
		
		return output;
	}
	
	public static void viewAllUser(ArrayList<User> userList) {
		setHeader("USER LIST");
		String output = String.format("%-5s %-29s %-10s %-10s\n", "ID", "NAME", "AGE","ROLE");
		 output += retrieveAllUser(userList);	
		System.out.println(output);
	}
	
	
	
	//================================= Option 2 Add (CRUD - Create) =================================
	public static User inputUser() {		
		int id = Helper.readInt("Enter id > ");
		String name = Helper.readString("Enter your name > ");
		int age = Helper.readInt("Enter age > ");
		String role = Helper.readString("Enter role to child (Parent/Guardian) > ");

		User user = new User(id, name, age, role);
		return user;
		
	}
	
	public static void addUser(ArrayList<User> userList, User user) {
		User item;
		
		for(int i = 0; i < userList.size(); i++) {
			item = userList.get(i);
			if (item.getId() == user.getId())
				return;
		}
		
		if ((user.getId() == 0) || (user.getName().isEmpty())) {
			return;
		}
		
		userList.add(user);
		
	}
	
	
	
	//================================= Option 3 Delete (CRUD - Delete) =================================

		
}


