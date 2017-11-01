package models;

import static org.junit.Assert.*;
import static models.Fixtures.movies;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;



public class MovieTest
{
  Movie starTrek = new Movie ("Star Trek", "1984", "www.startrek.com");

  @Test
  public void testCreate()
  {
    assertEquals ("Star Trek",               starTrek.title);
    assertEquals ("1984",             starTrek.year);
    assertEquals ("www.startrek.com",   starTrek.url); 
  
       
  }

  @Test
  public void testIds()
  {
    Set<Long> ids = new HashSet<>();
    for (Movie movie : movies)
    {
      ids.add(movie.id);
    }
    assertEquals (movies.length, ids.size());
  }

  @Test
  public void testToString()
  {
    assertEquals ("Movie{" + starTrek.id + ", Star Trek, 1984, www.startrek.com}", starTrek.toString());
  }
  
  @Test
  public void testEquals()
  {
    Movie starTrek2 = new Movie ("Star Trek", "1984", "www.startrek.com"); 
    Movie starWars   = new Movie ("Star Wars", "1974", "www.starwars.com"); 

    assertEquals(starTrek, starTrek);
    assertEquals(starTrek, starTrek2);
    assertNotEquals(starTrek, starWars);
    assertSame(starTrek,starTrek);
    assertNotSame(starTrek,starTrek2);
  }
  
}