package models;

//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
import com.google.common.base.Objects;
import static com.google.common.base.MoreObjects.toStringHelper;

public class User {

	static long  	counter = 1;
	public long   	id;
	public String 	firstName;
	public String 	lastName;
	public String 		age;
	public String 	gender;
	public String 	occupation;
	public String   userid;
		
	
	
	
	
	public User(String firstName, String lastName, String age, String gender, String occupation, String userid)
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
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.id, this.firstName, this.lastName, this.age,this.gender,this.occupation,this.userid);  
	  } 
	
	
	@Override
	  public boolean equals(final Object obj)
	  {
	    if (obj instanceof User)
	    {
	      final User other = (User) obj;
	      return Objects.equal(firstName, other.firstName) 
	          && Objects.equal(lastName,  other.lastName)
	          && Objects.equal(age,     other.age)
	          && Objects.equal(gender,  other.gender)
	          && Objects.equal(occupation,  other.occupation)
	          && Objects.equal(userid,  other.userid);
	      
	    }
	    else
	    {
	      return false;
	    }
	
	  }
	
}
