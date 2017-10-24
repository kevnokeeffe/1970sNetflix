package util;
/*
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
//import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
*/
	

//import java.util.Scanner;
//import javax.swing.JOptionPane;
public class Serializer {
	/*
	private static String[] dataLines;
	private static Scanner userInput;

    public static void main(String[] args) {
        userInput = new Scanner(System.in);
        String studentName = "";

        System.out.println("Please enter the path and file name to data file:");
        String filePath = userInput.nextLine();
        if ("".equals(filePath)) { System.exit(0); }
        fillDataArray(filePath);

        do {
            System.out.println("\nEnter 'ALL' to display all Student data or\n"
                             + "enter a Student name to return data for.\n"
                             + "(To exit enter nothing): -> ");
            studentName = userInput.nextLine();
            if ("".equals(studentName)) { System.exit(0); }
            if ("all".equals(studentName.toLowerCase())) {
                displayAllStudents();
            }
            else { 
                displayStudent(studentName); 
            }
        } while (!"".equals(studentName));
    }

    private static void fillDataArray(String fileName) {
        try {
            dataLines = (String[]) Files.readAllLines(new File(fileName).toPath()).toArray(new String[0]);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog (null, "Error Accessing The Data File "
                    + "Indicated Below!\n\n" + fileName + "\n\n" + ex.getMessage(), 
                    "FillDataArray() Method Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private static void displayAllStudents() {
        System.out.println("**************  ALL STUDENTS  ***************");
        for (int i = 0; i < dataLines.length; i++) {
            String courseID = dataLines[i].substring(0, 4).trim();
            String courseName = dataLines[i].substring(4, 24).trim();
            String courseCredit = dataLines[i].substring(24, 25).trim();
            String studName = dataLines[i].substring(25, 45).trim();
            String studMajor = dataLines[i].substring(45, 65).trim();
            String studGrade = dataLines[i].substring(65, 66).trim();

            System.out.println("Student Name : " + studName);
            System.out.println("Course ID    : " + courseID);
            System.out.println("Course Name  : " + courseName);
            System.out.println("Course Credit: " + courseCredit);
            System.out.println("Student Major: " + studMajor);
            System.out.println("Student Grade: " + studGrade);
            System.out.println("---------------------------------------------");
        }
        System.out.println("***********  END OF STUDENT DATA  ***********");

    }

    private static void displayStudent(String studentName) {
        System.out.println("********* COURSE DATA FOR " + studentName + " *********");
        ArrayList<String> student = new ArrayList<String>();
        for (int i = 0; i < dataLines.length; i++) {
            String studName = dataLines[i].substring(25, 45).trim().toLowerCase();
            if (studName.contains(studentName.toLowerCase())) {
                student.add(dataLines[i]);
            }
        }    

        for (int i = 0; i < student.size(); i++) {
            String courseID = student.get(i).substring(0, 4).trim();
            String courseName = student.get(i).substring(4, 24).trim();
            String courseCredit = student.get(i).substring(24, 25).trim();
            String studName = student.get(i).substring(25, 45).trim();
            String studMajor = student.get(i).substring(45, 65).trim();
            String studGrade = student.get(i).substring(65, 66).trim();

            System.out.println("Student Name : " + studName);
            System.out.println("Course ID    : " + courseID);
            System.out.println("Course Name  : " + courseName);
            System.out.println("Course Credit: " + courseCredit);
            System.out.println("Student Major: " + studMajor);
            System.out.println("Student Grade: " + studGrade);
            System.out.println("---------------------------------------------");
        }
        System.out.println("***********  END OF STUDENT DATA  ***********");
    
}*/
}