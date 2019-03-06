
/**
 * Analyzes students that have the highest GPA and produces a report
 *
 * @author Anthony Gonzalez
 * @version March 3, 2019
 */
import java.util.*;
import java.io.*;
public class Database
{
    public static void main (String args [])
    {
        String inFileName; //obtained through keyboard input
        File inFile; // File object to process student info file
        Scanner keyboard; // to read user input
        Scanner input; // to read file input 

        Student [] studentinfo; // array of student objects
        int numStudents; // number of students
        int index;       // index for the array

        String bannerID; //Student id numbers
        String name;     // name of students
        int creditsCompleted; //number of credits student completed
        double cumulativeGPA;  //gpa of student

        Student newStudent; //one student object

        //display purpose
        System.out.println ("This program processes a text file containing student information");
        System.out.println ("and guarantess a report in descending order of GPA");
        System.out.println ("");
        System.out.println ("Author: Anthony Gonzalez \t Version: March 3, 2019");

        //create a scanner object named keyboard to handle user input
        keyboard = new Scanner (System.in);
        //Prompt and read file name
        System.out.print ("Enter file name (show complete path): ");
        inFileName = keyboard.nextLine();
        
        System.out.println ("");

        //open data file and read into an array 
        try {
            // create a File object 
            inFile = new File (inFileName);
            //create a new Scanner object named input to handle the file input
            input = new Scanner (inFile);
            // create an array named studentinfo to hold Student objects (256 componets)
            studentinfo = new Student [256];

            // initliaze numStudents to zero
            numStudents = 0;

            // initialize index for the array 
            index = 0;

            //process line by line until end 
            while (input.hasNext()) {
                //read four pieces of information for a student for the next line of the file
                bannerID = input.next ();
                creditsCompleted = input.nextInt ();
                cumulativeGPA = input.nextDouble ();
                name = input.nextLine ();
                
                //create a new student object with data obtained by file and call it newStudent
                newStudent = new Student (bannerID,creditsCompleted,cumulativeGPA, name);
                //place newStudent in the array 
                studentinfo [index] = newStudent;
                //increment numStudents
                numStudents ++;
                //increment index for the array
                index ++;
            }
            // close the file 
            input.close ();

            //sort studentinfo array in decreasing order of cumulativeGPA 
            for (int pass = 0; pass < numStudents - 1; pass ++ ) {
                for (index = numStudents - 1; index >= pass +1; index --) {
                    //compare cumulativeGPA of studentinfo [index] and cumulativeGPA of studentinfo studentinfo [index-1]
                    // and swap studentinfo [index] and studentinfo [index - 1] if necessary
                    if (studentinfo[index].getCumulativeGPA () > studentinfo[index-1].getCumulativeGPA())
                    {
                        Student temp = studentinfo [index];
                        studentinfo [index] = studentinfo [index-1];
                        studentinfo[index-1] = temp;
                    }
                }     
            }
            //print report 
            System.out.println ("Number of students processed: " + numStudents);
            System.out.println ("Below is the list of students in decreasing order of cumulative GPA");
            System.out.println ("----------------------------------------------------------------------------------");
            for (index = 0; index < numStudents; index ++) {
                if (studentinfo[index].getCumulativeGPA () >= 2.00  && studentinfo[index].getCreditsCompleted () >= 120)
                {
                    System.out.print (studentinfo[index].toString () + "  Ready to graduate ");
                    System.out.println ("");
                }
                else {
                    System.out.print (studentinfo[index].toString ());
                }
            }
            //display closing message
            System.out.println ("");
            System.out.println ("Program has terminated");
        }
        catch (FileNotFoundException exception){
            System.out.println ("The file " + inFileName + "was not found");
            System.out.println ("");
        }
        }
    }   
