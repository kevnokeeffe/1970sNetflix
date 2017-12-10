package models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//import java.util.Map;
//import java.util.Objects;
import com.google.common.base.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

public class User implements Comparable<User> {

	static long counter = 1;
	public long id;
	public String firstName;
	public String lastName;
	public String age;
	public String gender;
	public String occupation;
	public String zipcode;
	public String role = "default";
	public Map<Long,Rating> rating = new HashMap<>();
	public Object userRatings;
	
	
	
	 public User(String firstName, String lastName, String age, String gender,
				String occupation, String zipcode)
	  {
	    this(firstName, lastName, age, gender, occupation, zipcode, "default");
	  }

	 
	 
	
	 
	public User(String firstName, String lastName, String age, String gender,
			String occupation, String zipcode,String role) {
		this.id = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.role = role;
		this.zipcode = zipcode;
	
	}

	@Override
	public String toString() {
		return toStringHelper(this).addValue(id)
				.addValue(firstName)
				.addValue(lastName)
				.addValue(age)
				.addValue(gender)
				.addValue(occupation)
				.addValue(zipcode +"\n").toString();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id, 
				this.firstName, 
				this.lastName,
				this.age, 
				this.gender, 
				this.occupation,
				this.zipcode
				);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof User) {
			final User other = (User) obj;
			return Objects.equal(firstName, other.firstName)
					&& Objects.equal(lastName, other.lastName)
					&& Objects.equal(age, other.age)
					&& Objects.equal(gender, other.gender)
					&& Objects.equal(occupation, other.occupation)
					&& Objects.equal(zipcode, other.zipcode);
					

		} else {
			return false;
		}

	}

	
	public int compareTo(User user) {
		return this.firstName.compareTo(user.firstName);
	}
	
}
