import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User u1, u2;
	
	private ArrayList<User> userList;

	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data		
		u1 = new User(1, "Peter Tan", 32, "Parent");
		u2 = new User(2, "Mary Lim", 35, "Guardian");
		
		userList = new ArrayList<User>();
	}

	@After
	public void tearDown() throws Exception {
		u1 = null;
		u2 = null;
		userList = null;
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
	
		assertEquals("Test that ViewAllCamcorderlist", testOutput, allUser);
		
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
		assertNotNull("test if there is valid Camcorder arraylist to loan from", userList);
		
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

}
