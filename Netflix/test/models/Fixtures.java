package models;

import models.User;
import models.Movie;
//import models.Rating;
//import controlers.NetflixAPI;

public class Fixtures
{
  public static User[] users =
  {
    new User ("firstname", "secondname", "0",  "secret","secret","secret"),
    new User ("firstname", "secondname", "0",  "secret","secret","secret"),
    new User ("firstname", "secondname", "0",  "secret","secret","secret"),
    new User ("firstname", "secondname", "0",  "secret","secret","secret")
  };
  
  public static Movie[] movies =
	  {
	    new Movie ("title", "year","url"),
	    new Movie ("title", "year","url"),
	    new Movie ("title", "year","url"),
	    new Movie ("title", "year","url")
	  };
  
  public static Rating[] ratings =
	  {
	    new Rating ("rat1", "rat2","rat3","rat4"),
	    new Rating ("rat1", "rat2","rat3","rat4"),
	    new Rating ("rat1", "rat2","rat3","rat4"),
	    new Rating ("rat1", "rat2","rat3","rat4")
	  };
}
