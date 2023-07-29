import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User u1, u2;
	private School s1, s2;
	private Menu m1, m2;
	private Order o1, o2;
	
	private ArrayList<User> userList;
	private ArrayList<School> schoolList;
	private ArrayList<Menu> menuList;
	private ArrayList<Order> orderList;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data		
		u1 = new User(1, "Peter Tan", 32, "Parent");
		u2 = new User(2, "Mary Lim", 35, "Guardian");
		userList = new ArrayList<User>();
		
		s1 = new School(1, "Republic Poly", "Woodlands");
		s2 = new School(2, "NUS", "Kent Ridge");
		schoolList = new ArrayList<School>();
		
		m1 = new Menu(1, "Diet Menu", "Salad, Bread with Eggs", 7.5);
		m2 = new Menu(2, "Full Lunch Menu", "Chicken Thigh with rice", 10);
		menuList = new ArrayList<Menu>();
		
		o1 = new Order(1, "Lunch Order (5 pax)", 50);
		o2 = new Order(2, "Diet Order(10 pax)", 75);
		orderList = new ArrayList<Order>();
	}

	@After
	public void tearDown() throws Exception {
		u1 = null;
		u2 = null;
		userList = null;
		
		s1 = null;
		s2 = null;
		schoolList = null;
		
		m1 = null;
		m2 = null;
		menuList = null;
		
		o1 = null;
		o2 = null;
		orderList = null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	
	@Test
	public void testRetrieveAllUser() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid User arraylist to retrieve item", userList);
		
		//test if the list of users retrieved from the CaseStudy is empty - boundary
		String allUser = C206_CaseStudy.retrieveAllUser(userList);
		String testOutput = "";
		assertEquals("Check that ViewAllUserlist", testOutput, allUser);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addUser(userList, u1);
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Test that User ArrayList size is 2", 2, userList.size());
		
		//test if the expected output string same as the list of users retrieved from the CaseStudy	
		allUser = C206_CaseStudy.retrieveAllUser(userList);
		testOutput = String.format("%-5s %-29s %-10s %-11s\n", "1", "Peter Tan", "32", "Parent");
		testOutput += String.format("%-5s %-29s %-10s %-11s\n", "2", "Mary Lim", "35", "Guardian");
	
		assertEquals("Test that ViewAllUserlist", testOutput, allUser);
		
	}
	
	@Test
	public void testAddUser() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid User arraylist to add to", userList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addUser(userList, u1);
		assertEquals("Check that User arraylist size is 1", 1, userList.size());
		assertSame("Check that User is added", u1, userList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Check that User arraylist size is 2", 2, userList.size());
		assertSame("Check that User is added", u2, userList.get(1));
	}
	
	@Test
	public void testDoDeleteUser() {
		//boundary
		assertNotNull("test if there is valid User arraylist to delete from", userList);
		
		C206_CaseStudy.addUser(userList, u1);
		// normal
		Boolean ok = C206_CaseStudy.doDeleteUser(userList, 1);
		assertTrue("Test if user can be deleted?", ok);
		// normal
		C206_CaseStudy.addUser(userList, u2);	
		ok = C206_CaseStudy.doDeleteUser(userList, 2);
		assertTrue("Test that second item is ok to delete?", ok);
		//error condition
		ok = C206_CaseStudy.doDeleteUser(userList, 1);
		assertFalse("Test if an same item is NOT ok to delete again?", ok);	
		//error condition
		ok = C206_CaseStudy.doDeleteUser(userList, 2);
		assertFalse("Test if an same item is NOT ok to delete again?", ok);	
		//error condition
		ok = C206_CaseStudy.doDeleteUser(userList, 3 );
		assertFalse("Test that non-existing item is NOT ok to delete?", ok);
		
	}
	
	@Test
	public void testRetrieveAllSchool() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid School arraylist to retrieve item", schoolList);
		
		//test if the list of schools retrieved from the CaseStudy is empty - boundary
		String allSchool = C206_CaseStudy.retrieveAllSchool(schoolList);
		String testOutput = "";
		assertEquals("Check that ViewAllSchoolList", testOutput, allSchool);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addSchool(schoolList, s1);
		C206_CaseStudy.addSchool(schoolList, s2);
		assertEquals("Test that School ArrayList size is 2", 2, schoolList.size());
		
		//test if the expected output string same as the list of users retrieved from the CaseStudy	
		allSchool = C206_CaseStudy.retrieveAllSchool(schoolList);
		testOutput = String.format("%-5s %-29s %-11s\n", "1", "Republic Poly", "Woodlands");
		testOutput += String.format("%-5s %-29s %-11s\n", "2", "NUS", "Kent Ridge");
	
		assertEquals("Test that ViewAllSchoollist", testOutput, allSchool);
		
	}
	
	@Test
	public void testAddSchool() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid School arraylist to add to", schoolList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addSchool(schoolList, s1);
		assertEquals("Check that School arraylist size is 1", 1, schoolList.size());
		assertSame("Check that School is added", s1, schoolList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addSchool(schoolList, s2);
		assertEquals("Check that School arraylist size is 2", 2, schoolList.size());
		assertSame("Check that School is added", s2, schoolList.get(1));
	}
	
	@Test
	public void testDoDeleteSchool() {
		//boundary
		assertNotNull("test if there is valid School arraylist to delete from", schoolList);
		
		C206_CaseStudy.addSchool(schoolList, s1);
		// normal
		Boolean ok = C206_CaseStudy.doDeleteSchool(schoolList, 1);
		assertTrue("Test if school can be deleted?", ok);
		// normal
		C206_CaseStudy.addSchool(schoolList, s2);	
		ok = C206_CaseStudy.doDeleteSchool(schoolList, 2);
		assertTrue("Test that second item is ok to delete?", ok);
		//error condition
		ok = C206_CaseStudy.doDeleteSchool(schoolList, 1);
		assertFalse("Test if an same item is NOT ok to delete again?", ok);	
		//error condition
		ok = C206_CaseStudy.doDeleteSchool(schoolList, 2);
		assertFalse("Test if an same item is NOT ok to delete again?", ok);	
		//error condition
		ok = C206_CaseStudy.doDeleteSchool(schoolList, 3 );
		assertFalse("Test that non-existing item is NOT ok to delete?", ok);
		
	}

	@Test
	public void testRetrieveAllMenu() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Menu arraylist to retrieve item", menuList);
		
		//test if the list of menus retrieved from the CaseStudy is empty - boundary
		String allMenu = C206_CaseStudy.retrieveAllMenu(menuList);
		String testOutput = "";
		assertEquals("Check that ViewAllMenuList", testOutput, allMenu);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addMenu(menuList, m1);
		C206_CaseStudy.addMenu(menuList, m2);
		assertEquals("Test that Menu ArrayList size is 2", 2, menuList.size());
		
		//test if the expected output string same as the list of users retrieved from the CaseStudy	
		allMenu = C206_CaseStudy.retrieveAllMenu(menuList);
		testOutput = String.format("%-5s %-29s %-30s %-11s\n", "1", "Diet Menu", "Salad, Bread with Eggs", "7.50");
		testOutput += String.format("%-5s %-29s %-30s %-11s\n", "2", "Full Lunch Menu", "Chicken Thigh with rice", "10.00");
	
		assertEquals("Test that ViewAllMenulist", testOutput, allMenu);
		
	}
	
	@Test
	public void testAddMenu() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Menu arraylist to add to", menuList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addMenu(menuList, m1);
		assertEquals("Check that School arraylist size is 1", 1, menuList.size());
		assertSame("Check that School is added", m1, menuList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addMenu(menuList, m2);
		assertEquals("Check that Menu arraylist size is 2", 2, menuList.size());
		assertSame("Check that Menu is added", m2, menuList.get(1));
	}
	
	@Test
	public void testDoDeleteMenu() {
		//boundary
		assertNotNull("test if there is valid Menu arraylist to delete from", menuList);
		
		C206_CaseStudy.addMenu(menuList, m1);
		// normal
		Boolean ok = C206_CaseStudy.doDeleteMenu(menuList, 1);
		assertTrue("Test if menu can be deleted?", ok);
		// normal
		C206_CaseStudy.addMenu(menuList, m2);	
		ok = C206_CaseStudy.doDeleteMenu(menuList, 2);
		assertTrue("Test that second item is ok to delete?", ok);
		//error condition
		ok = C206_CaseStudy.doDeleteMenu(menuList, 1);
		assertFalse("Test if an same item is NOT ok to delete again?", ok);	
		//error condition
		ok = C206_CaseStudy.doDeleteMenu(menuList, 2);
		assertFalse("Test if an same item is NOT ok to delete again?", ok);	
		//error condition
		ok = C206_CaseStudy.doDeleteMenu(menuList, 3 );
		assertFalse("Test that non-existing item is NOT ok to delete?", ok);
		
	}
	
	@Test
	public void testRetrieveAllOrder() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Menu arraylist to retrieve item", orderList);
		
		//test if the list of orders retrieved from the CaseStudy is empty - boundary
		String allOrder = C206_CaseStudy.retrieveAllOrder(orderList);
		String testOutput = "";
		assertEquals("Check that ViewAllMenuList", testOutput, allOrder);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addOrder(orderList, o1);
		C206_CaseStudy.addOrder(orderList, o2);
		assertEquals("Test that Order ArrayList size is 2", 2, orderList.size());
		
		//test if the expected output string same as the list of users retrieved from the CaseStudy	
		allOrder = C206_CaseStudy.retrieveAllOrder(orderList);
		testOutput = String.format("%-5s %-29s %-11s\n", "1", "Lunch Order (5 pax)", "50.00");
		testOutput += String.format("%-5s %-29s %-11s\n", "2", "Diet Order(10 pax)", "75.00");
	
		assertEquals("Test that ViewAllOrderlist", testOutput, allOrder);
		
	}
	
	@Test
	public void testAddOrder() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Order arraylist to add to", orderList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addOrder(orderList, o1);
		assertEquals("Check that Order arraylist size is 1", 1, orderList.size());
		assertSame("Check that SOrder is added", o1, orderList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addOrder(orderList, o2);
		assertEquals("Check that Order arraylist size is 2", 2, orderList.size());
		assertSame("Check that Order is added", o2, orderList.get(1));
	}
	
	@Test
	public void testDoDeleteOrder() {
		//boundary
		assertNotNull("test if there is valid Menu arraylist to delete from", orderList);
		
		C206_CaseStudy.addOrder(orderList, o1);
		// normal
		Boolean ok = C206_CaseStudy.doDeleteOrder(orderList, 1);
		assertTrue("Test if order can be deleted?", ok);
		// normal
		C206_CaseStudy.addOrder(orderList, o2);	
		ok = C206_CaseStudy.doDeleteOrder(orderList, 2);
		assertTrue("Test that second item is ok to delete?", ok);
		//error condition
		ok = C206_CaseStudy.doDeleteOrder(orderList, 1);
		assertFalse("Test if an same item is NOT ok to delete again?", ok);	
		//error condition
		ok = C206_CaseStudy.doDeleteOrder(orderList, 2);
		assertFalse("Test if an same item is NOT ok to delete again?", ok);	
		//error condition
		ok = C206_CaseStudy.doDeleteOrder(orderList, 3 );
		assertFalse("Test that non-existing item is NOT ok to delete?", ok);
		
	}
	
}
