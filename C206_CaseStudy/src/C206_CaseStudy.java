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
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<PaymentMethod> paymentList = new ArrayList<PaymentMethod>();
		ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
		
		// Add initial objects to ArrayList
		userList.add(new User(1, "Peter Tan", 32, "Parent"));
		userList.add(new User(2, "Mary Lim", 35, "Guardian"));
		
		schoolList.add(new School(1, "Republic Poly", "Woodlands"));
		schoolList.add(new School(2, "NUS", "Kent Ridge"));
		
		menuList.add(new Menu(1, "Diet Menu", "Salad, Bread with Eggs", 7.5));
		menuList.add(new Menu(2, "Full Lunch Menu", "Chicken Thigh with rice", 10));
		
		orderList.add(new Order(1, "Lunch Order (5 pax)", 50));
		orderList.add(new Order(2, "Diet Order(10 pax)", 75));
		
		paymentList.add(new PaymentMethod(1, "Visa"));
		paymentList.add(new PaymentMethod(2, "PayLah"));
		
		vendorList.add(new Vendor(1, "Aunt May's Bread", "Bread"));
		vendorList.add(new Vendor(2, "Fan Fan Cai Png", "Cai Png"));
		
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
					viewAllOrder(orderList);
					 
				else if (itemType == ITEM_TYPE_PAYMENT)
					viewAllPayment(paymentList); 
				
				else if (itemType == ITEM_TYPE_VENDOR)
					viewAllVendor(vendorList);
					
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
					System.out.println("Menu added.");
					
				} else if (itemType == ITEM_TYPE_ORDER) {
					// Add an order
					Order order = inputOrder();
					addOrder(orderList, order);
					System.out.println("Order added.");
					
				} else if (itemType == ITEM_TYPE_PAYMENT) {
					// Add a Payment Method
					PaymentMethod paymentMethod = inputPayment();
					addPayment(paymentList, paymentMethod);
					System.out.println("Payment Method added.");
					
				} else if (itemType == ITEM_TYPE_VENDOR) {
					// Add a Vendor
					Vendor vendor = inputVendor();
					addVendor(vendorList, vendor);
					System.out.println("Vendor added.");
					
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
					deleteOrder(orderList);
					
				else if (itemType == ITEM_TYPE_PAYMENT)
					deletePayment(paymentList);
				
				else if (itemType == ITEM_TYPE_VENDOR)
					deleteVendor(vendorList);
					
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
		String output = String.format("%-5s %-29s %-30s %-10s\n", "ID", "NAME", "FOOD ITEMS", "PRICE");
		 output += retrieveAllMenu(menuList);	
		System.out.println(output);
	}
	
	public static String retrieveAllOrder(ArrayList<Order> orderList) {
		String output = "";
		
		for (int i = 0; i < orderList.size(); i++) {
			output += String.format("%s \n", orderList.get(i).toString());
		}
		
		return output;
	}
	
	public static void viewAllOrder(ArrayList<Order> orderList) {
		setHeader("ORDER LIST");
		String output = String.format("%-5s %-29s %-10s\n", "ID", "NAME", "TOTAL COST");
		 output += retrieveAllOrder(orderList);	
		System.out.println(output);
	}
	
	public static String retrieveAllPayment(ArrayList<PaymentMethod> paymentList) {
		String output = "";
		
		for (int i = 0; i < paymentList.size(); i++) {
			output += String.format("%s \n", paymentList.get(i).toString());
		}
		
		return output;
	}
	
	public static void viewAllPayment(ArrayList<PaymentMethod> paymentList) {
		setHeader("PAYMENT METHOD LIST");
		String output = String.format("%-5s %-29s\n", "ID", "PAYMENT METHOD");
		 output += retrieveAllPayment(paymentList);	
		System.out.println(output);
	}
	
	public static String retrieveAllVendor(ArrayList<Vendor> vendorList) {
		String output = "";
		
		for (int i = 0; i < vendorList.size(); i++) {
			output += String.format("%s \n", vendorList.get(i).toString());
		}
		
		return output;
	}
	
	public static void viewAllVendor(ArrayList<Vendor> vendorList) {
		setHeader("VENDOR LIST");
		String output = String.format("%-5s %-29s %-10s\n", "ID", "NAME", "SPECIALTY");
		 output += retrieveAllVendor(vendorList);	
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
		double price = Helper.readInt("Enter the total cost of items in menu > ");
		
		Menu menu = new Menu(id, name, foodItem, price);
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
	
	public static Order inputOrder() {		
		int id = Helper.readInt("Enter id > ");
		String name = Helper.readString("Enter order name > ");
		double cost = Helper.readInt("Enter the total cost of items in order > ");
		
		Order order = new Order(id, name, cost);
		return order;
		
	}
	
	public static void addOrder(ArrayList<Order> orderList, Order order) {
		Order item;
		
		for(int i = 0; i < orderList.size(); i++) {
			item = orderList.get(i);
			if (item.getId() == order.getId())
				return;
		}
		
		if ((order.getId() == 0) || (order.getName().isEmpty())) {
			return;
		}
		
		orderList.add(order);
		
	}
	
	public static PaymentMethod inputPayment() {		
		int id = Helper.readInt("Enter id > ");
		String name = Helper.readString("Enter payment method name > ");
		
		PaymentMethod paymentMethod = new PaymentMethod(id, name);
		return paymentMethod;
		
	}
	
	public static void addPayment(ArrayList<PaymentMethod> paymentList, PaymentMethod paymentMethod) {
		PaymentMethod item;
		
		for(int i = 0; i < paymentList.size(); i++) {
			item = paymentList.get(i);
			if (item.getId() == paymentMethod.getId())
				return;
		}
		
		if ((paymentMethod.getId() == 0) || (paymentMethod.getName().isEmpty())) {
			return;
		}
		
		paymentList.add(paymentMethod);
		
	}
	
	public static Vendor inputVendor() {		
		int id = Helper.readInt("Enter id > ");
		String name = Helper.readString("Enter vendor name > ");
		String specialty = Helper.readString("Enter vendor's specialty > ");
		
		Vendor vendor = new Vendor(id, name, specialty);
		return vendor;
		
	}
	
	public static void addVendor(ArrayList<Vendor> vendorList, Vendor vendor) {
		Vendor item;
		
		for(int i = 0; i < vendorList.size(); i++) {
			item = vendorList.get(i);
			if (item.getId() == vendor.getId())
				return;
		}
		
		if ((vendor.getId() == 0) || (vendor.getName().isEmpty())) {
			return;
		}
		
		vendorList.add(vendor);
		
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
	
	public static void deleteOrder(ArrayList<Order> orderList) {
		viewAllOrder(orderList);
		int id = Helper.readInt("Enter ID of order to be deleted > ");
		
		Boolean isDeleted = doDeleteOrder(orderList, id);
		
		if (isDeleted == false)
			System.out.println("Invalid ID");
		else
			System.out.println("Order ID: " + id + " deleted");
	}
	
	public static boolean doDeleteOrder(ArrayList<Order> orderList, int id) {
		
		boolean isDeleted = false;

		if (id == 0)
			return false;
		
		for (int i = 0; i < orderList.size(); i++) {
					
			int arrayListId = orderList.get(i).getId();
			if (id == arrayListId) {
				orderList.remove(i);
				isDeleted = true;
			}
		}
		
		return isDeleted;
	}
		
	public static void deletePayment(ArrayList<PaymentMethod> paymentList) {
		viewAllPayment(paymentList);
		int id = Helper.readInt("Enter ID of payment method to be deleted > ");
		
		Boolean isDeleted = doDeletePayment(paymentList, id);
		
		if (isDeleted == false)
			System.out.println("Invalid ID");
		else
			System.out.println("Payment Method ID: " + id + " deleted");
	}
	
	public static boolean doDeletePayment(ArrayList<PaymentMethod> paymentList, int id) {
		
		boolean isDeleted = false;

		if (id == 0)
			return false;
		
		for (int i = 0; i < paymentList.size(); i++) {
					
			int arrayListId = paymentList.get(i).getId();
			if (id == arrayListId) {
				paymentList.remove(i);
				isDeleted = true;
			}
		}
		
		return isDeleted;
	}
	
	public static void deleteVendor(ArrayList<Vendor> vendorList) {
		viewAllVendor(vendorList);
		int id = Helper.readInt("Enter ID of vendor to be deleted > ");
		
		Boolean isDeleted = doDeleteVendor(vendorList, id);
		
		if (isDeleted == false)
			System.out.println("Invalid ID");
		else
			System.out.println("Vendor ID: " + id + " deleted");
	}
	
	public static boolean doDeleteVendor(ArrayList<Vendor> vendorList, int id) {
		
		boolean isDeleted = false;

		if (id == 0)
			return false;
		
		for (int i = 0; i < vendorList.size(); i++) {
					
			int arrayListId = vendorList.get(i).getId();
			if (id == arrayListId) {
				vendorList.remove(i);
				isDeleted = true;
			}
		}
		
		return isDeleted;
	}
	
}


