import java.io.IOException;
import java.util.LinkedList;

/**
 * @author Christian Aguirre
 */
public class CourseDBStructure implements CourseDBStructureInterface {

    protected int size;
    protected String testing;
    protected LinkedList<CourseDBElement>[] hashTable;


    /**
     * Two constructors for the CDS will be required,
     * one that takes in an integer that is the estimated number of courses
     * @param size Size of the list
     */
    public CourseDBStructure(int size){
        this.size = size;
        hashTable = new LinkedList[size];

    }

    /**
     * the other is used for testing purposes.
     * @param testing Testing as a string
     * @param size size of the list as another parameter of this constructor
     */
    public CourseDBStructure(String testing, int size){
        this.testing = testing;
        this.size = size;
        hashTable = new LinkedList[size];
    }

    /**
     * Use the hashcode of the CourseDatabaseElement to see if it is
     * in the hashtable.
     * If the CourseDatabaseElement does not exist in the hashtable,
     * add it to the hashtable.
     *
     * @param element the CDE to be added
     */
    public void add(CourseDBElement element){
        int index = element.hashCode() % size; //Check if it's in the table
        if(hashTable[index] == null) //If it's not in the table
            hashTable[index] = new LinkedList<>();  //add to the table
        hashTable[index].add(element); //add element to the table
    }

    /**
     * Use the hashcode of the CourseDatabaseElement to see if it is
     * in the hashtable.
     *
     * If the CourseDatabaseElement is in the hashtable, return it
     * If not, throw an IOException
     *
     * @param crn the CDE to be added
     * @throws IOException Throw exception if element is not in the table
     */
    public CourseDBElement get(int crn) throws IOException{

        if(hashTable[String.valueOf(crn).hashCode() % size] == null){//If not in table
            throw new IOException(); //Return exception
        }
        else{
            for(int i = 0; i < size; i++){ //Loop through table
                CourseDBElement temp =
                        hashTable[String.valueOf(crn).hashCode() % size].get(i); //return element if it's in the hashtable
                if(temp.getCRN() == crn){
                    return temp;
                }
            }
            return null;
        }
    }

    /**
     *Size of the table
     * @return Returns the table size
     */

    public int getTableSize(){
        return size;
    }


}
