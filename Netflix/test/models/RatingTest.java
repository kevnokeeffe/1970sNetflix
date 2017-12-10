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
		assertEquals(1, 3F, 	ratings[0].rat3);
	}

	@Test
	public void testIds() {
		
		assertNotEquals(ratings[0].id, ratings[1].id);
	}
	
	
	  
	
}
