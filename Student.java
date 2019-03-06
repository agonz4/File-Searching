
/**
 * Represents students enrolled at the College at Brockport
 *
 * @author Anthony Gonzalez
 * @version March 3,2019
 */
import java.text.*;
public class Student
{
    // instance variables \
    private String bannerID;
    private String name;
    private int creditsCompleted;
    private double cumulativeGPA;
    
    /**
     * Constructor for objects of class Student
     */
    public Student (String bannerID, int creditsCompleted, double cumulativeGPA, String name)
    {
        // initialise instance variables
        this.bannerID = bannerID;
        this.name = name;
        this.creditsCompleted = creditsCompleted;
        this.cumulativeGPA = cumulativeGPA;
        
    }

    /**
     * Getter methods
     */
    public String getBannerID () {return bannerID;}
    public String getName () {return name;}
    public int getCreditsCompleted () {return creditsCompleted;}
    public double getCumulativeGPA () {return cumulativeGPA;}
    
    /**
     * toString methods
     */
    public String toString ()
    {
        DecimalFormat gpaFormatter = new DecimalFormat ("0.00");
        DecimalFormat creditsFormatter = new DecimalFormat ("000");
        String result = "";
        result = result + gpaFormatter.format(cumulativeGPA) + "    "
                        + creditsFormatter.format(creditsCompleted) + "    " + bannerID + "   " + name;
        return result;
    }
}
