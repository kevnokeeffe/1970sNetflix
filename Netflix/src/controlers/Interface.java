package controlers;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

import controlers.NetflixAPI;
//import util.FileLogger;
import models.User;
//import util.FileLogger;
//import util.Serializer;
//import util.XMLSerializer;
//import models.Movie;


public class Interface {
	public static void main(String[]args) throws Exception
    {
        int choice;
        int choice2;
        System.out.println("Hello and welcome to 1970's Netflix: ");
        
        String fname,lname,gender,occupation,userid; 
        String age;
        //creating variables for inputs by user;
        
        Scanner sc = new Scanner(System.in);
        //create User
        NetflixAPI netflixAPI = new NetflixAPI();

        //show menu
        do{
            System.out.println();
            System.out.println("1. User Database");
            System.out.println("2. Movie Archive");
            System.out.println("3. Quit");
            System.out.println();
            System.out.print("Enter choice [1-3]: ");
            
            //get choice
            
            choice = sc.nextInt();
            System.out.println();
            //process the menu choice
            
            switch(choice)
            {
                case 1: 
           
                	
                	do{
                        System.out.println();
                        System.out.println("1. List User Details");
                        System.out.println("2. Enter New User");
                        System.out.println("3. Back");
                        System.out.println();
                        System.out.print("Enter choice [1-3]: ");
                        
                        //get choice
                        choice2 = sc.nextInt();
                        
                        System.out.println();
                        
                        //process the menu choice
                        
                        switch(choice2)
                       
                        {
                            case 1:
                            	//netflixAPI.initialLoad();
                            	Collection<User> users = netflixAPI.getUsers();
                            	System.out.println(users);
                            
                         
                            	
                            break;
                            
                            case 2: 
                            	System.out.println("Please enter your details:");
                            	System.out.println();
                            	System.out.print("Please your first name:");
                            	fname = sc.nextLine();
                                System.out.println();
                                System.out.print("Please your second name:");
                            	lname = sc.nextLine();
                                System.out.println();
                                System.out.print("Please your age:");
                            	age = sc.nextLine();
                                System.out.println();
                                System.out.print("Please your gender:");
                            	gender = sc.nextLine();
                                System.out.println();
                                System.out.print("Please your occupation:");
                            	occupation = sc.nextLine();
                                System.out.println();
                                System.out.print("Please enter your PPS number:");
                            	userid = sc.nextLine();
                                System.out.println();
                                
                            	netflixAPI.createUser(fname, lname, age, gender, occupation,userid);
                            	//netflixAPI.store();
                            	
                            break;
                            
                            case 3: 
                            break;
                            
                            default: System.out.println("Invalid entry");
                            
                        }
                        
                    }
                    while(choice2 != 3);
                	
                break;
                
                case 2: 
                	
                break;
                
                case 3: 
                	System.out.println("Thanks for useing our system. Have a most wonderful day.");
                	break;
                
                default: System.out.println("Invalid entry");
                
            }
            
        }
        while(choice != 3);

    }
}
