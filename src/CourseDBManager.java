import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Christian Aguirre
 */
public class CourseDBManager  implements CourseDBManagerInterface {

    /**
     * Set the table a number higher than the text list
     */
    private CourseDBStructure CDS = new CourseDBStructure(20);


    /**
     *Add method calls the elements from CDE
     * @param id the Course ID (a String)
     * @param crn the CRN (an int)
     * @param credits the number of credits (an int)
     * @param roomNum the room number (a String)
     * @param instructor the instructor name (a String)
     */
    public void add(String id,
                    int crn,
                    int credits,
                    String roomNum,
                    String instructor){

        CourseDBElement newElement =
                new CourseDBElement(id,
                                    crn,
                                    credits,
                                    roomNum,
                                    instructor);

        CDS.add(newElement);
    }

    /**
     *  If the CourseDatabaseElement is in the hashtable, return it
     *  If not, throw an IOException
     * @param crn CRN number which is the key value
     * @return CRN if it's in the CDE otherwise return null
     */

    public CourseDBElement get(int crn){
        try{
            return CDS.get(crn);
        }catch (IOException e){//Inherited from CDE
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Text file to import to DB
     * @param input File to choose from to import
     * @throws FileNotFoundException If file not found throw FileNotFoundException
     */

    public void readFile(File input) throws FileNotFoundException{
        try{
            Scanner fileData = new Scanner(input);
            while(fileData.hasNext()){
                String id = fileData.next();
                int crn = fileData.nextInt();
                int numCredits = fileData.nextInt();
                String roomNum = fileData.next();
                String instructor = fileData.nextLine();
                add(id, crn, numCredits, roomNum, instructor);
            }
            fileData.close();
        }
        catch (FileNotFoundException e){
            System.out.print("File Not Found");
            //e.getMessage();
        }
    }

    /**
     *Array list that calls all the elements from CDE in the hashtable
     * @return List of all elements as a toString from CDE
     */
    public ArrayList<String> showAll(){
        ArrayList<String> list = new ArrayList<>();
        for(int i =0; i < CDS.hashTable.length; i++){
            LinkedList<CourseDBElement> tempList = CDS.hashTable[i];
            if(tempList != null){
                for (CourseDBElement element : tempList) {
                    list.add(element.toString());
                }
            }
        }
        return list;

    }
}
