package DataLayer;

import java.util.*;

/**
 * The Courses class creates a data object representing multiple rows/tuples
 * from the courses table of the faculty activity database (484 project in this case).
 * 
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 */
public class Courses {
    
    private ArrayList<Course> courses = new ArrayList<>(0);
    private MySQLDatabase myDB = new MySQLDatabase();
   
    /**
     * Explicit default constructor for Courses does nothing.
     */
    public Courses(){
    }
    
    /**
     * This method returns an arraylist representing multiple course objects.
     * 
     * @return arrayList of course objects.
     */
    public ArrayList<Course> getCourses(){
        return courses;
    }
    
    /**
     * This method accepts an arraylist of courses and populates this data 
     * object's courses field with that arraylist.
     * 
     * @param coursesList 
     */
    public void setCourses(ArrayList<Course> coursesList){
        courses = coursesList;
    }
    
    /**
     * This method retrieves all the rows from the courses table and stores them
     * in a 2D array list in the courses field of this data object.
     * 
     * @return boolean indicating data was present.
     * @throws DLException 
     */
    public boolean fetch() throws DLException {
        ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM courses", null);
        if(dataList.size() > 1) {
            for (int i = 1; i <= dataList.size(); i++) {
                Course e = new Course(dataList.get(i).get(2).toString());
                e.setUserId(dataList.get(i).get(1).toString());
                e.setYear(dataList.get(i).get(3).toString());
                e.setCourseNumber(dataList.get(i).get(4).toString());
                e.setCourseName(dataList.get(i).get(5).toString());
                courses.add(e);
            }
            return true;
        } else {
            return false;
        }
    }
}
