import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Christian Aguirre
 */
public class CourseDB_STUDENT_Test {

    private CourseDBElement studentElem = new CourseDBElement();
    private CourseDBManager studentDBManager = new CourseDBManager();
    private CourseDBStructure studentDBStructure = new CourseDBStructure(1000);


    public void setUp() throws Exception{
        studentElem = new CourseDBElement();
        studentDBManager = new CourseDBManager();
        studentDBStructure = new CourseDBStructure(1000);
    }

    public void tearDown() throws Exception{
        studentElem = null;
        studentDBManager = null;
        studentDBStructure = null;
    }

    public void testHashCode(){
        studentDBManager.add("TestID",
                12345,
                5,
                "Room number test",
                "Instructor Test");





    }
    @Test
    public void testShowAll() {
        studentDBManager.add("testID1",12345,3,"CS101","Test Instructor 1");
        studentDBManager.add("testID2",67891,4,"CS201","Test Instructor 2");
        studentDBManager.add("testID3",11111,5,"CS301","Test Instructor 3");
        ArrayList<String> list = studentDBManager.showAll();

        assertEquals(list.get(0),"\nCourse:testID3 CRN:11111 Credits:5 Instructor:Test Instructor 3 Room:CS301");
        assertEquals(list.get(1),"\nCourse:testID2 CRN:67891 Credits:4 Instructor:Test Instructor 2 Room:CS201");
        assertEquals(list.get(2),"\nCourse:testID1 CRN:12345 Credits:3 Instructor:Test Instructor 1 Room:CS101");
    }


    @Test
    public void studentTestRead() {
        try {
            File inputFile = new File("StudentTest1.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("testID1 12345 3 CS101 Test Instructor 1");
            inFile.print("testID2 67891 4 CS301 Test Instructor 2");

            inFile.close();
            studentDBManager.readFile(inputFile);
            //System.out.println(dataMgr.showAll());
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }

    @Test
    public void testAddToDB() {
        try {
            studentDBManager.add("testID1",12345,3,"CS101","Test Instructor 1");
            studentDBManager.add("testID2",67891,4,"CS201","Test Instructor 2");
            studentDBManager.add("testID3",11111,5,"CS301","Test Instructor 3");
        }
        catch(Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testGetTableSize()
    {
        assertEquals(1000, studentDBStructure.getTableSize());
        assertEquals(1000, studentDBStructure.getTableSize());
    }

    @Test
    public void testElements()
    {
        studentElem.setCRN(20);
        studentElem.getCRN();
        assertEquals(20, studentElem.getCRN());

        CourseDBElement test = new CourseDBElement("testID", 1234, 4, "CS202", "Instructor");
        studentElem.setCRN(100);
        test.toString();
        assertEquals("\nCourse:testID CRN:1234 Credits:4 Instructor:Instructor Room:CS202", test.toString());

    }


}
