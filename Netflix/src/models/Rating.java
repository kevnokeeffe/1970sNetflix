package models;

import static com.google.common.base.MoreObjects.toStringHelper;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
import com.google.common.base.Objects;
public class Rating {

	static Long counter = (long) 01;
	
	public Long id;
	//public String rating;
	public String rat1,rat2,rat3,rat4;
	
	
	
	
	public Rating(String rat1, String rat2, String rat3, String rat4)
	  {
		this.id        	= counter++;
	    this.rat1	= rat1;
	    this.rat2 	= rat2;
	    this.rat3 	= rat3;
	    this.rat4 	= rat4;
	    
	    
	    
	  }
	public Rating()
	  {
	  }
	@Override
	  public String toString()
	  {
	    return toStringHelper(this)	.addValue(id)
	    							.addValue(rat1)
	                               .addValue(rat2)
	                               .addValue(rat3)
	                               .addValue(rat4)  
	                               .toString();
	  }
	
	
	@Override  
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.id, this.rat1, this.rat2, this.rat3 , this.rat4);  
	  } 
	
	
	@Override
	  public boolean equals(final Object obj)
	  {
	    if (obj instanceof User)
	    {
	      final Rating other = (Rating) obj;
	      return Objects.equal(rat1, other.rat1) 
	          && Objects.equal(rat2,  other.rat2)
	          && Objects.equal(rat3,     other.rat3)
	          && Objects.equal(rat4,  other.rat4);
	          
	      
	    }
	    else
	    {
	      return false;
	    }
	
	  }
	
}
