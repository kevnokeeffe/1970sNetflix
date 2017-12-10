package models;

import models.User;
import models.Movie;
import models.Rating;


public class Fixtures
{
  public static User[] users =
  {
    new User ("Kevin", "OKeeffe", "33",  "male","student","kevokeeffe@gmail.com","admin"),
    new User ("Cristina", "Zein", "33",  "female","beauty","c.zein@gmail.com","admin"),
     };
  
  public static Movie[] movies =
	  {
	  new Movie("Gonnies", "1989", "Gonnies.com"),
		new Movie("Twilight", "2008", "Twilight.com"), 
		new Movie("Shrek", "2001", "Shrek.org"),
		new Movie("Robocop", "1992", "Robocop.net")
	  };
  
  public static Rating[] ratings =
	  {
	  new Rating(1L, 2L, 3F),
		new Rating(2L, 3L, 4F), 
		new Rating(3L, 4L, 5F),
		new Rating(4L, 5L, 6F)
	  };
}
