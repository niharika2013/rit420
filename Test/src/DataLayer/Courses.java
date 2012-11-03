package DataLayer;

import java.util.*;
/**
 *
 * @author Anthony Gentile
 */

public class Courses {
    
	 // Array of all courses
    private ArrayList<Course> courses = new ArrayList<Course>(0);
    
	 // Default Constructor
    public Courses()
    {
    }
    
	 // Getter
    public ArrayList<Course> getCourses()
    {
        return courses;
    }
    
	 // Setter
    public void setCourses(ArrayList<Course> coursesList)
    {
        courses = coursesList;
    }
    
	 // Get all the courses and basic details
    public boolean fetch() throws DLException
    {
        try{
            ArrayList<ArrayList<String>> dataList = JavaConnection.mdb.getData("SELECT * FROM courses", null);
            if(dataList != null)
            {
                for (int i = 1; i <= dataList.size(); i++)
                {
                    Course e = new Course(dataList.get(i).get(2).toString());
                    e.setUserId(dataList.get(i).get(1).toString());
                    e.setYear(dataList.get(i).get(3).toString());
                    e.setCourseNumber(dataList.get(i).get(4).toString());
                    e.setCourseName(dataList.get(i).get(5).toString());
                    courses.add(e);
                }
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(DLException e){
            throw new DLException(e);
        }
    }
}
