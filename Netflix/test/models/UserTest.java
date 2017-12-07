package models;



import static models.Fixtures.users;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;




public class UserTest
{
  User aedin = new User ("aedin", "o'keeffe", "0", "female",  "secret", "secret","default");

  @Test
  public void testCreate()
  {
    assertEquals ("aedin", 				aedin.firstName);
    assertEquals ("o'keeffe", 			aedin.lastName);
    assertEquals ("0",   					aedin.age);   
    assertEquals ("female",  			aedin.gender);   
    assertEquals ("secret",             aedin.occupation);
    assertEquals ("secret",             aedin.userid);
    
    assertEquals ("default",             aedin.role);
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
    User aedin2 = new User ("aedin", "o'keeffe", "0", "female",  "secret", "secret","default"); 
    User bart   = new User ("bart", "simpson", "100", "male", "secret","secret","default"); 

    assertEquals(aedin, aedin);
    assertEquals(aedin, aedin2);
    assertNotEquals(aedin, bart);
    assertSame(aedin,aedin);
    assertNotSame(aedin,aedin2);
  }
  
  
  /*
  @Test
  public void testUserLogin() {
      // checking with lisa's login(admin)
      assertTrue(pacemaker.login(users[1].email, users[1].password));
      assertEquals(pacemaker.currentUser.get(), users[1]);
      // check logout
      pacemaker.logout();
      assertEquals(pacemaker.currentUser, Optional.absent());
      // check failed login
      assertFalse(pacemaker.login(users[1].email, "wrongpass"));
      assertEquals(pacemaker.currentUser, Optional.absent());
  }*/
  
  
  
}