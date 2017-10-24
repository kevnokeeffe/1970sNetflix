package controlers;

import java.util.Scanner;

import util.FileLogger;
import models.User;


public class Interface {
	public static void main(String[]args)
    {
        int choice;
        int choice2;
        System.out.println("Hello and welcome to 1970's Netflix: ");
        
        
        //create User


        //show menu
        do{
            System.out.println();
            System.out.println("1. User Database");
            System.out.println("2. Movie Archive");
            System.out.println("3. Quit");
            System.out.println();
            System.out.print("Enter choice [1-3]: ");
            
            //get choice
            Scanner sc = new Scanner(System.in);
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
                        Scanner sc2 = new Scanner(System.in);
                        choice2 = sc2.nextInt();
                        
                        System.out.println();
                        
                        //process the menu choice
                        
                        switch(choice2)
                        {
                            case 1:
                            	
                            	
                            break;
                            
                            case 2: 
                            	
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
