package models;



import static models.Fixtures.users;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;




public class UserTest
{
  User aedin = new User ("aedin", "o'keeffe", "0", "female",  "secret", "secret");

  @Test
  public void testCreate()
  {
    assertEquals ("aedin", 				aedin.firstName);
    assertEquals ("o'keeffe", 			aedin.lastName);
    assertEquals ("0",   					aedin.age);   
    assertEquals ("female",  			aedin.gender);   
    assertEquals ("secret",             aedin.occupation);
    assertEquals ("secret",             aedin.userid);
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
  public void testToString()
  {
    assertEquals ("User{" + aedin.id + ", aedin, o'keeffe, 0, female, secret, secret}", aedin.toString());
  }
  
  @Test
  public void testEquals()
  {
    User aedin2 = new User ("aedin", "o'keeffe", "0", "female",  "secret", "secret"); 
    User bart   = new User ("bart", "simpson", "100", "male", "secret","secret"); 

    assertEquals(aedin, aedin);
    assertEquals(aedin, aedin2);
    assertNotEquals(aedin, bart);
    assertSame(aedin,aedin);
    assertNotSame(aedin,aedin2);
  }
  
}