package DataLayer;

import java.util.*;

/**
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
     * 
     */
    public Courses(){
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Course> getCourses(){
        return courses;
    }
    
    /**
     * 
     * @param coursesList 
     */
    public void setCourses(ArrayList<Course> coursesList){
        courses = coursesList;
    }
    
    /**
     * 
     * @return
     * @throws DLException 
     */
    public boolean fetch() throws DLException {
        ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM courses", null);
        if(dataList != null) {
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
