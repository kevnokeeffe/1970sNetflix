package models;

import static com.google.common.base.MoreObjects.toStringHelper;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
import com.google.common.base.Objects;
public class Rating {

	static Long counter = (long) 01;
	
	public Long id;
	public Long rat1 = 0L;
	public Long rat2 = 0L;
	public Float rat3 = 0F;
	
	public Rating()
	  {
	  }
	
	
	
	// Rating
	public Rating(Long rat1, Long rat2, Float rat3)
	  {
		this.id        	= counter++;
	    this.rat1	= rat1;
	    this.rat2 	= rat2;
	    this.rat3 	= rat3;
	    
	    
	    
	    
	  }
	
	
	//ToString
	@Override
	  public String toString()
	  {
	    return toStringHelper(this)	.addValue(id)
	    							.addValue(rat1)
	                               .addValue(rat2)
	                               .addValue(rat3)
	                                 
	                               .toString();
	  }
	
	//Hash
	@Override  
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.id, this.rat1, this.rat2, this.rat3 );  
	  } 
	
	//Equals to
	@Override
	  public boolean equals(final Object obj)
	  {
	    if (obj instanceof User)
	    {
	      final Rating other = (Rating) obj;
	      return Objects.equal(rat1, other.rat1) 
	          && Objects.equal(rat2,  other.rat2)
	          && Objects.equal(rat3,     other.rat3)
	          ;
	          
	      
	    }
	    else
	    {
	      return false;
	    }
	
	  }
	
}
