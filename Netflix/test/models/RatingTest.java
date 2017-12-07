package models;

//import static models.Fixtures.movies;
import static models.Fixtures.ratings;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class RatingTest {

	Rating numbers = new Rating (345L, 222L, 333F);

	  @Test
	  public void testCreate()
	  {
	    assertEquals ("345",              	 numbers.rat1);
	    assertEquals ("222",            	 numbers.rat2);
	    assertEquals ("333",   				 numbers.rat3); 
	     
	       
	  }

	  @Test
	  public void testIds()
	  {
	    Set<Long> ids = new HashSet<>();
	    for (Rating rating : ratings)
	    {
	      ids.add(rating.id);
	    }
	    assertEquals (ratings.length, ids.size());
	  }

	  @Test
	  public void testToString()
	  {
	    assertEquals ("Rating{" + numbers.id + ", 345, 222, 333}", numbers.toString());
	  }
	  
	  
	  @Test
	  public void testEquals()
	  {
	    Rating numbers2 = new Rating (345L, 222L, 333F); 
	    Rating elseNumbers   = new Rating ( 543L, 666L, 777F); 

	    assertEquals(numbers, numbers);
	    assertEquals(numbers, numbers2);
	    assertNotEquals(numbers, elseNumbers);
	    assertSame(numbers,numbers);
	    assertNotSame(numbers,numbers2);
	  }
	  
	
}
