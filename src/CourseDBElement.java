/**
 * @author Christian Aguirre
 */
public class CourseDBElement implements Comparable<CourseDBElement> {

    private final String id;
    private int crn;
    private final int numCredits;
    private final String roomNum;
    private final String instructor;

    /**
     * Default Constructor
     */
    public CourseDBElement(){
        id = "";
        crn = 0;
        numCredits = 0;
        roomNum = "";
        instructor = "";
    }

    /**
     * CourseDBElement implements Comparable, and consists of five attributes:
     * @param id the Course ID (a String)
     * @param crn the CRN (an int)
     * @param numCredits the number of credits (an int)
     * @param roomNum the room number (a String)
     * @param instructor the instructor name (a String)
     */

    public CourseDBElement(String id,
                           int crn,
                           int numCredits,
                           String roomNum,
                           String instructor)
    {
        this.id = id;
        this.crn = crn;
        this.numCredits = numCredits;
        this.roomNum = roomNum;
        this.instructor = instructor;


    }


    /**
     * Implementation of comparable
     * @param element Element to compare in this case the CRN
     * @return crn number as an element
     */
   @Override
    public int compareTo(CourseDBElement element) {
        return (this.crn - element.crn);
    }

    /**
     * Gets current CRN
     * @return crn
     */
    public int getCRN(){
        return crn;
    }

    /**
     * Sets CRN
     * @param crn Set CRN number
     */

    public void setCRN(int crn){
        this.crn = crn;
    }

    /**
     * Gets CRN and converts it into string, which then the hashcode of the string is returned
     * @return Hash Code as a string
     */

    public int hashCode(){


        return String.valueOf(crn).hashCode();
    }


    /**
     * toString method to return the format requested on the tests
     * @return String method formatted by its different attributes
     */
    public String toString(){
        return "\nCourse:" + id +
                " CRN:" + crn +
                " Credits:" + numCredits +
                " Instructor:" + instructor +
                " Room:" + roomNum;
    }


}
