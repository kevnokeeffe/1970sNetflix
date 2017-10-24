package models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import static com.google.common.base.MoreObjects.toStringHelper;

public class User {

	static long  	counter = 0l;
	public long   	id;
	public String 	firstName;
	public String 	lastName;
	public int 		age;
	public String 	gender;
	public String 	occupation;
	public String   userid;
		
	
	
	
	
	public User(String firstName, String lastName, int age, String gender, String occupation, String userid)
	  {
		this.id        	= counter++;
	    this.firstName	= firstName;
	    this.lastName 	= lastName;
	    this.age 		= age;
	    this.gender 	= gender;
	    this.occupation = occupation;
	    this.userid		= userid;
	    
	    
	  }
	
	@Override
	  public String toString()
	  {
	    return toStringHelper(this)	.addValue(id)
	    							.addValue(firstName)
	                               .addValue(lastName)
	                               .addValue(age)
	                               .addValue(gender)  
	                               .addValue(occupation)
	                               .addValue(userid)
	                               .toString();
	  }
	
	@Override
	  public boolean equals(final Object obj)
	  {
	    if (obj instanceof User)
	    {
	      final User other = (User) obj;
	      return Objects.equals(firstName, other.firstName) 
	          && Objects.equals(lastName,  other.lastName)
	          && Objects.equals(age,     other.age)
	          && Objects.equals(gender,  other.gender)
	          && Objects.equals(occupation,  other.occupation)
	          && Objects.equals(userid,  other.userid);
	      
	    }
	    else
	    {
	      return false;
	    }
	
	  }
	
}
