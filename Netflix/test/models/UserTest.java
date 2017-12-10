package models;



import static models.Fixtures.users;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;

import controlers.NetflixAPI;




public class UserTest
{
  User aedin = new User ("aedin", "okeeffe", "21", "female",  "secret", "secret","secret");

 
	
	
	
	@Test
	public void testCreate() {
		assertEquals("aedin", aedin.firstName);
		assertEquals("okeeffe", aedin.lastName);
		assertEquals("21", aedin.age);
		assertEquals("female", aedin.gender);
		assertEquals("secret", aedin.occupation);
		assertEquals("secret", aedin.zipcode);
	}
	
	@Test
	public void testEquals() {
		User aedin = new User("aedin", "okeeffe", "21", "female", "secret","secret");
		User sinead = new User("sinead", "okeeffe", "19", "F", "Student","secret");
		assertEquals(aedin, aedin);
		assertEquals(sinead, sinead);
		assertNotEquals(aedin, sinead);
	}
	
	@Test
	  public void testIds()
	  {
	    Set<Long> ids = new HashSet<>();
	    for (User user : users)
	    {
	      ids.add(user.id);
	    }
	    assertEquals (users.length, ids.size());
	  }
	
	@Test
	public void testToString() {
		assertEquals("User{" + aedin.id + ",aedin,okeeffe,21,female,secret,secret,secret}", aedin.toString());
	}
	
  
  
}