package controlers;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import asg.cliche.Command;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;

import com.google.common.base.Optional;

import asg.cliche.Param;
import models.Movie;
import models.Rating;
import models.User;
import util.Serializer;
import util.XMLSerializer;


public class Main implements ShellDependent {
	
	private static final String ADMIN = "admin";
	public NetflixAPI netApi = new NetflixAPI();
	private Shell theShell;
	
	
		
	//Create Data Store
	public Main() throws Exception {
		
		File storage = new File("./Data/datastore.xml");
		Serializer serializer = new XMLSerializer(storage);
		netApi = new NetflixAPI(serializer);
		if (storage.isFile()){
			netApi.load();
			
		}
	}
	
	/*
	//Load initial Data 
	@Command(description = "Load Data",abbrev = "load")
	public void LoadData() throws Exception{
		
		netApi.initialLoad();
		netApi.store();
	}
	*/
		
	
	
//LOGIN Administrator  or Default user
	
	@Command(description = "Log in", abbrev = "login")
	public void logIn(@Param(name = "id") Long id, @Param(name = "lastName")String lastName )
	throws IOException{
		
		if (netApi.login(id, lastName) && netApi.currentUser.isPresent()) {
		      User user = netApi.currentUser.get();
		      System.out.println("You are logged in as " + user.firstName +" "+ user.lastName);
		      
		if (user.role!=null && user.role.equals(ADMIN)) {
		        AdminMenu adminMenu = new AdminMenu(netApi, user.firstName);
		        ShellFactory.createSubshell(user.firstName, theShell, "Admin", adminMenu).commandLoop();
		      } 
		
		else {
		        DefaultMenu defaultMenu = new DefaultMenu(netApi, user);
		        ShellFactory.createSubshell(user.firstName, theShell, "Default", defaultMenu).commandLoop();
		      }
		    } 
		
		else
		     System.out.println("Unknown username/password.");
		
	}
	
//CLICHE
	 public static void main(String[] args) throws Exception {
		    Main main = new Main();
		    main.netApi.createUser("Kevin", "OKeeffe", "33", "Male", "Student", "2007", "admin");
		    Shell shell = ShellFactory.createConsoleShell("pm", "Welcome to 1970's Netflix, ?help for instructions",
		        main);
		    
		    shell.commandLoop();
		    main.netApi.initialLoad();
		    
		    main.netApi.store();
		    
		  }
		
	 
	 @Override
		public void cliSetShell(Shell theShell) {
		    this.theShell = theShell;
		  }
	
}
