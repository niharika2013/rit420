package DataLayer;

import java.util.*;

public class Course {	
       
        private MySQLDatabase myDB = new MySQLDatabase();
        
        private String userId;
	private String courseId;
	private String year;
	private String courseNumber;
	private String courseName;
	
        public Course(){}
        
	public Course(String pCourseId) {
		this.courseId = pCourseId;
	}
	
	public Course(String pUserId, String pCourseId, String pYear, String pCourseNumber, String pCourseName) {
		this.userId = pUserId;
		this.courseId = pCourseId;
		this.year = pYear;
		this.courseNumber = pCourseNumber;
		this.courseName = pCourseName;
	}
	
        public boolean fetch() throws DLException {
            try{
                ArrayList<String> values = new ArrayList<String>(0);
                values.add(courseId);
                ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM courses WHERE CourseId = ?", values);
                if(dataList != null) {
                        userId = dataList.get(1).get(1).toString();
                        courseId = dataList.get(1).get(2).toString();
                        year = dataList.get(1).get(3).toString();
                        courseNumber = dataList.get(1).get(4).toString();
                        courseName = dataList.get(1).get(5).toString();
                        return true;
                } else {
                        return false;
                }
            } catch (Exception e) {
                throw new DLException(e);
            }
         }
          
	
	// post updates the database values, for that object�s courseId, using the	
	//object�s attribute values.
	public boolean post() throws DLException {
            try{
                ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId); 
		values.add(year);
		values.add(courseNumber);
		values.add(courseName);
		values.add(courseId);
                myDB.setData("UPDATE course UserId = ?, Year = ?, CourseNumber = ?, CourseName = ? WHERE CourseId = ?", values);
                return true; 
            }catch(DLException e){
                return false;
            }
        }
	
	// put	inserts	the	object�s	attribute	values	into	the	database	as	a	new	record.
	public boolean put() throws DLException	{
           try {
		ArrayList<String> values = new ArrayList<String>();
                values.add(this.getUserId());
		values.add(this.getCourseId());
		values.add(this.getYear());
		values.add(this.getCourseNumber());
		values.add(this.getCourseName());
                myDB.setData("INSERT INTO courses (UserId,CourseId,Year,CourseNumber,CourseName) VALUES(?,?,?,?,?)", values);                
		return true;      
            }catch (Exception e){
                    throw new DLException(e);
            }
           
        }
	
	// delete removes	from	the	database	any	data	corresponding	to	the	object�s courseId.
	public boolean delete() throws DLException {
            try {            
                ArrayList<String> values = new ArrayList<String>(0);
                values.add(courseId);
                return myDB.setData("DELETE FROM course WHERE courseID = ?", values);
            } catch (Exception e) {
                throw new DLException(e);
            }
        }
        
        public void setCourseId(String pCourseId){this.courseId = pCourseId;}
	public String getCourseId(){return courseId;}
	
	public void setUserId(String pUserId){this.userId = pUserId;}
	public String getUserId(){return userId;}
	
	public void setYear(String pYear){this.year = pYear;}
	public String getYear(){return year;}
	
	public void setCourseNumber(String pCourseNumber){this.courseNumber = pCourseNumber;}
	public String getCourseNumber(){return courseNumber;}
	
	public void setCourseName(String pCourseName){this.courseName = pCourseName;}
	public String getCourseName(){return courseName;}
	
}