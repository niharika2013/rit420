package DataLayer;

import java.util.*;

/**
 * The Course class creates a data object representing a single tuple from the 
 * courses table in the faculty activity database (484 project in this case).
 * 
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 */

public class Course {	
       
        private MySQLDatabase myDB = new MySQLDatabase();
        
        private String userId;
	private String courseId;
	private String year;
	private String courseNumber;
	private String courseName;
	
        /**
         * Explicit default constructor does nothing.
         */
        public Course(){}
        
        
        /**
         * Constructor for course ID only.
         * 
         * @param pCourseId 
         */
	public Course(String pCourseId) {
		this.courseId = pCourseId;
	}
	
        
        /**
         * Constructor to set all fields at instantiation.
         * 
         * @param pUserId
         * @param pCourseId
         * @param pYear
         * @param pCourseNumber
         * @param pCourseName 
         */
	public Course(String pUserId, String pCourseId, String pYear, String pCourseNumber, String pCourseName) {
		this.userId = pUserId;
		this.courseId = pCourseId;
		this.year = pYear;
		this.courseNumber = pCourseNumber;
		this.courseName = pCourseName;
	}
	
        
        
        
        
        
        /**
         * This method uses the object's course ID field to query the courses
         * table of the database and retrieve the information for all remaining
         * fields of the data object.
         * 
         * @return boolean indicating whether the table contained any data.
         * @throws DLException 
         */
        public boolean fetch() throws DLException {
            try{
                ArrayList<String> values = new ArrayList<>(0);
                values.add(courseId);
                String sql = "SELECT userId, courseId, year, courseNumber, courseName "+
                             "FROM courses WHERE CourseId = ?";
                ArrayList<ArrayList<String>> dataList = myDB.getData(sql, values);
                if(dataList.size() > 1) {
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
          
	
	/**
         * This method updates the database values for this object's courseId,
         * using the object's attribute values.
         * 
         * @return a boolean indicating success.
         * @throws DLException 
         */
        public boolean post() throws DLException {
            try{
                ArrayList<String> values = new ArrayList<>(0);
		values.add(userId); 
		values.add(year);
		values.add(courseNumber);
		values.add(courseName);
		values.add(courseId);
                String sql = "UPDATE courses SET UserId = ?, Year = ?, CourseNumber = ?, CourseName = ? "+
                             "WHERE CourseId = ?";
                myDB.setData(sql, values);
                return true; 
            }catch(Exception e){
                System.err.println(e);
                throw new DLException(e);
            }
        }
	
        
        /**
         * This method inserts the object's attribute values into the database
         * as a new record. 
         * 
         * @return a boolean indicating success.
         * @throws DLException 
         */
        public boolean put() throws DLException	{
           try {
		ArrayList<String> values = new ArrayList<>();
                values.add(userId);
		values.add(courseId);
		values.add(year);
		values.add(courseNumber);
		values.add(courseName);
                myDB.setData("INSERT INTO courses (UserId,CourseId,Year,CourseNumber,CourseName) VALUES(?,?,?,?,?)", values);                
		return true;      
            }catch (Exception e){
                throw new DLException(e);
            }
           
        }

        
        /**
         * This method removes from the database any data corresponding to the
         * object's course ID.
         * 
         * @return
         * @throws DLException 
         */
        public boolean delete() throws DLException {
            try {            
                ArrayList<String> values = new ArrayList<>(0);
                values.add(courseId);
                return myDB.setData("DELETE FROM course WHERE courseID = ?", values);
            } catch (Exception e) {
                throw new DLException(e);
            }
        }
        
        
        
        
        
        
        /**
         * Mutator method for courseId.
         * 
         * @param pCourseId 
         */
        public void setCourseId(String pCourseId){this.courseId = pCourseId;}
	
        /**
         * Accessor method for courseId.
         * @return String value of courseId
         */
        public String getCourseId(){return courseId;}
	
        /**
         * Mutator method for userID.
         * 
         * @param pUserId 
         */
	public void setUserId(String pUserId){this.userId = pUserId;}
	
        /**
         * Accessor method for userID.
         * 
         * @return String value of userId
         */
        public String getUserId(){return userId;}
	
        /**
         * Mutator method for year
         * 
         * @param pYear 
         */
	public void setYear(String pYear){this.year = pYear;}
	
        /**
         * Accessor method for year
         * 
         * @return String value for year
         */
        public String getYear(){return year;}
	
        /**
         * Mutator method for courseNumber
         * 
         * @param pCourseNumber 
         */
	public void setCourseNumber(String pCourseNumber){this.courseNumber = pCourseNumber;}
	
        /**
         * Accessor method for courseNumber
         * 
         * @return String value of courseNumber
         */
        public String getCourseNumber(){return courseNumber;}
	
        /**
         * Mutator method for courseName.
         * 
         * @param pCourseName 
         */
	public void setCourseName(String pCourseName){this.courseName = pCourseName;}
	
        /**
         * Accessor method for courseName
         * 
         * @return String value of courseName.
         */
        public String getCourseName(){return courseName;}
	
        /**
         * Override with custom toString()
         * 
         * @return String
         */
          @Override
        public String toString(){
            return "userId: " + userId + "\ncourseId: " + courseId + "\nyear: " + year + "\ncourseNumber: " + courseNumber + "\ncourseName : " + courseName;}
}