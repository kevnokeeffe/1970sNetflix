package controlers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.util.ArrayList;
import java.util.Collection;
//import java.util.List;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;




import util.FileLogger;
import models.User;

public class Main
{
	public static void main(String[] args) throws IOException
	  {
	    FileLogger logger = FileLogger.getLogger();
	    logger.log("Creating user list");
	    
	    
	    NetflixAPI netflixAPI = new NetflixAPI();
	   // List<User> users = new ArrayList<User>();
	    
	    netflixAPI.createUser("Kevin", "O'Keeffe", 33 , "Male", "SSD Student", "190D");
	    netflixAPI.createUser("Diarmuid", "O'Keeffe", 30 , "Male", "Programmer", "190C" );
	    
	    Collection<User> users = netflixAPI.getUsers();
	    
	      
	    
	   
	    System.out.println(users);

	    logger.log("Serializing contacts to XML");
	    XStream xstream = new XStream(new DomDriver());
	    ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("users.xml"));
	    out.writeObject(users);
	    out.close();    

	   /* logger.log("Finished - shutting down");
	    
	    XStream xstream = new XStream(new DomDriver());
	    ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("datastore.xml"));
	    out.writeObject(users);
	    */
	  }
	
	
	
	  
}