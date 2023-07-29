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
		ArrayList<School> schoolList = new ArrayList<School>();
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		
		// Add initial objects to ArrayList
		userList.add(new User(1, "Peter Tan", 32, "Parent"));
		userList.add(new User(2, "Mary Lim", 35, "Guardian"));
		
		schoolList.add(new School(1, "Republic Poly", "Woodlands"));
		schoolList.add(new School(2, "NUS", "Kent Ridge"));
		
		menuList.add(new Menu(1, "Diet Menu", "Salad, Bread with Eggs", 150));
		menuList.add(new Menu(2, "Full Lunch Menu", "Chicken Thigh with rice", 400));
		
		int option = 0;

		while (option != OPTION_QUIT) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				setHeader("VIEW");
				itemTypeMenu();
				int itemType = Helper.readInt("Enter option to select item type > ");
				
				if (itemType == ITEM_TYPE_USER)
					viewAllUser(userList);
				
				else if (itemType == ITEM_TYPE_SCHOOL)
					viewAllSchool(schoolList);

				else if (itemType == ITEM_TYPE_MENU)
					viewAllMenu(menuList);
					
				else if (itemType == ITEM_TYPE_ORDER)
					viewAllUser(userList); // Will update later
					 
				else if (itemType == ITEM_TYPE_PAYMENT)
					viewAllUser(userList); // Will update later
					
				else if (itemType == ITEM_TYPE_VENDOR)
					viewAllUser(userList); // Will update later
					
				else
					System.out.println("Invalid Type.");
				
			} else if (option == OPTION_ADD) {
				setHeader("ADD");
				itemTypeMenu();
				int itemType = Helper.readInt("Enter option to select item type > ");
				
				if (itemType == ITEM_TYPE_USER) {
					// Add a User
					User user = inputUser();
					addUser(userList, user);
					System.out.println("User added.");
					
				} else if (itemType == ITEM_TYPE_SCHOOL) {
					// Add a school
					School school = inputSchool();
					addSchool(schoolList, school);
					System.out.println("School added.");
					
				} else if (itemType == ITEM_TYPE_MENU) {
					// Add a menu
					Menu menu = inputMenu();
					addMenu(menuList, menu);
					System.out.println("School added.");
					
				} else if (itemType == ITEM_TYPE_ORDER) {
					
				} else if (itemType == ITEM_TYPE_PAYMENT) {
					
				} else if (itemType == ITEM_TYPE_VENDOR) {
					
				} else
					System.out.println("Invalid Type.");
				
			} else if (option == OPTION_DELETE) {
				setHeader("DELETE");
				itemTypeMenu();
				int itemType = Helper.readInt("Enter option to select item type > ");
				
				if (itemType == ITEM_TYPE_USER)
					deleteUser(userList);
					
				else if (itemType == ITEM_TYPE_SCHOOL)
					deleteSchool(schoolList);

				else if (itemType == ITEM_TYPE_MENU)
					deleteMenu(menuList);
					
				else if (itemType == ITEM_TYPE_ORDER)
					deleteUser(userList); // Will update later
					
				else if (itemType == ITEM_TYPE_PAYMENT)
					deleteUser(userList); // Will update later
				
				else if (itemType == ITEM_TYPE_VENDOR)
					deleteUser(userList); // Will update later
					
				else
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
			output += String.format("%s \n", userList.get(i).toString());
		}
		
		return output;
	}
	
	public static void viewAllUser(ArrayList<User> userList) {
		setHeader("USER LIST");
		String output = String.format("%-5s %-29s %-10s %-10s\n", "ID", "NAME", "AGE","ROLE");
		 output += retrieveAllUser(userList);	
		System.out.println(output);
	}
	
	public static String retrieveAllSchool(ArrayList<School> schoolList) {
		String output = "";
		
		for (int i = 0; i < schoolList.size(); i++) {
			output += String.format("%s \n", schoolList.get(i).toString());
		}
		
		return output;
	}
	
	public static void viewAllSchool(ArrayList<School> schoolList) {
		setHeader("SCHOOL LIST");
		String output = String.format("%-5s %-29s %-10s\n", "ID", "NAME", "ADDRESS");
		 output += retrieveAllSchool(schoolList);	
		System.out.println(output);
	}
		
	public static String retrieveAllMenu(ArrayList<Menu> menuList) {
		String output = "";
		
		for (int i = 0; i < menuList.size(); i++) {
			output += String.format("%s \n", menuList.get(i).toString());
		}
		
		return output;
	}
	
	public static void viewAllMenu(ArrayList<Menu> menuList) {
		setHeader("MENU LIST");
		String output = String.format("%-5s %-29s %-30s %-10s\n", "ID", "NAME", "FOOD ITEMS", "CALORIES");
		 output += retrieveAllMenu(menuList);	
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
	
	public static School inputSchool() {		
		int id = Helper.readInt("Enter id > ");
		String name = Helper.readString("Enter school's name > ");
		String address = Helper.readString("Enter school's address > ");

		School school = new School(id, name, address);
		return school;
		
	}
	
	public static void addSchool(ArrayList<School> schoolList, School school) {
		School item;
		
		for(int i = 0; i < schoolList.size(); i++) {
			item = schoolList.get(i);
			if (item.getId() == school.getId())
				return;
		}
		
		if ((school.getId() == 0) || (school.getName().isEmpty())) {
			return;
		}
		
		schoolList.add(school);
		
	}
	
	public static Menu inputMenu() {		
		int id = Helper.readInt("Enter id > ");
		String name = Helper.readString("Enter menu name > ");
		String foodItem = Helper.readString("Enter the food items in menu > ");
		int calories = Helper.readInt("Enter the total amount of calories in menu > ");
		
		Menu menu = new Menu(id, name, foodItem, calories);
		return menu;
		
	}
	
	public static void addMenu(ArrayList<Menu> menuList, Menu menu) {
		Menu item;
		
		for(int i = 0; i < menuList.size(); i++) {
			item = menuList.get(i);
			if (item.getId() == menu.getId())
				return;
		}
		
		if ((menu.getId() == 0) || (menu.getName().isEmpty())) {
			return;
		}
		
		menuList.add(menu);
		
	}
	
	
	//================================= Option 3 Delete (CRUD - Delete) =================================
	public static void deleteUser(ArrayList<User> userList) {
		viewAllUser(userList);
		int id = Helper.readInt("Enter ID of user to be deleted > ");
		
		Boolean isDeleted = doDeleteUser(userList, id);
		
		if (isDeleted == false)
			System.out.println("Invalid ID");
		else
			System.out.println("User ID: " + id + " deleted");
	}
	
	public static boolean doDeleteUser(ArrayList<User> userList, int id) {
		
		boolean isDeleted = false;

		if (id == 0)
			return false;
		
		for (int i = 0; i < userList.size(); i++) {
					
			int arrayListId = userList.get(i).getId();
			if (id == arrayListId) {
				userList.remove(i);
				isDeleted = true;
			}
		}
		
		return isDeleted;
	}
	
	public static void deleteSchool(ArrayList<School> schoolList) {
		viewAllSchool(schoolList);
		int id = Helper.readInt("Enter ID of school to be deleted > ");
		
		Boolean isDeleted = doDeleteSchool(schoolList, id);
		
		if (isDeleted == false)
			System.out.println("Invalid ID");
		else
			System.out.println("School ID: " + id + " deleted");
	}
	
	public static boolean doDeleteSchool(ArrayList<School> schoolList, int id) {
		
		boolean isDeleted = false;

		if (id == 0)
			return false;
		
		for (int i = 0; i < schoolList.size(); i++) {
					
			int arrayListId = schoolList.get(i).getId();
			if (id == arrayListId) {
				schoolList.remove(i);
				isDeleted = true;
			}
		}
		
		return isDeleted;
	}
	
	public static void deleteMenu(ArrayList<Menu> menuList) {
		viewAllMenu(menuList);
		int id = Helper.readInt("Enter ID of menu to be deleted > ");
		
		Boolean isDeleted = doDeleteMenu(menuList, id);
		
		if (isDeleted == false)
			System.out.println("Invalid ID");
		else
			System.out.println("Menu ID: " + id + " deleted");
	}
	
	public static boolean doDeleteMenu(ArrayList<Menu> menuList, int id) {
		
		boolean isDeleted = false;

		if (id == 0)
			return false;
		
		for (int i = 0; i < menuList.size(); i++) {
					
			int arrayListId = menuList.get(i).getId();
			if (id == arrayListId) {
				menuList.remove(i);
				isDeleted = true;
			}
		}
		
		return isDeleted;
	}
		
}


