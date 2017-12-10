package models;

//import static models.Fixtures.movies;
import static models.Fixtures.ratings;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;




import org.junit.Test;

public class RatingTest {

	@Test
	public void testCreate() {
		assertEquals(1 , 1L, 	ratings[0].rat1);
		assertEquals(1, 2L, 	ratings[0].rat2);
		
	}

	@Test
	public void testIds() {
		
		assertNotEquals(ratings[0].id, ratings[1].id);
	}
	
	@Test
	public void testToString() {
		assertEquals("Rating{"+ratings[0].id +", 1, 2,3}", ratings[0].toString());
	}
	  
	
}
