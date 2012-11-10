package DataLayer;

import java.util.*;

public class Courses {
    
    private ArrayList<Course> courses = new ArrayList<>(0);
    private MySQLDatabase myDB = new MySQLDatabase();
    
    public Courses(){
    }
    
    public ArrayList<Course> getCourses(){
        return courses;
    }
    
    public void setCourses(ArrayList<Course> coursesList){
        courses = coursesList;
    }
    
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
