package models;


import java.util.HashMap;

import java.util.Map;

import com.google.common.base.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;


public class Movie {

	static Long counter = (long) 01;
	public Long id;
	public String title;
	public String year;
	public String url;
	
	
	public Map<Long,Rating> rating = new HashMap<>();
	
	public Movie(String title, String year, String url)
	  {
		this.id        	= counter++;
	    this.title	= title;
	    this.year 	= year;
	    this.url 		= url;
	    
	  }
	
	//ToString
	@Override
	  public String toString()
	  {
	    return toStringHelper(this)	.addValue(id)
	    							.addValue(title)
	    							.addValue(year)
	    							.addValue(url)
	    							.toString();
	  }
	
	//Hash Code
	@Override  
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.id, this.title, this.year, this.url);  
	  } 
	
	//Equals to
	@Override
	  public boolean equals(final Object obj)
	  {
	    if (obj instanceof Movie)
	    {	//Changed .equals to .equal!!!!!!!!! It asked me to, may cause problems!
	      final Movie other = (Movie) obj;
	      return Objects.equal(title, other.title) 
	          && Objects.equal(year,  other.year)
	          && Objects.equal(url,     other.url);
	               
	    }
	    else
	    {
	      return false;
	    }
	  }
	
}
