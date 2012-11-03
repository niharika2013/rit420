package BusinessLayer;

import DataLayer.DLException;

/**
 *
 * @author Anthony Gentile
 */
public class Course extends DataLayer.Course {
    
   //Provide	a	default	constructor.
	public Course()
	{   
	}
	
	//Provide	a	constructor	that	accepts	and	sets	the	courseId.
	public Course(String courseId)
	{
		setCourseId(courseId);
	}
	
	//Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Course(String userId, String courseId, String year, String courseNumber, String courseName)
	{
		setUserId(userId);
		setCourseId(courseId);
		setYear(year);
		setCourseNumber(courseNumber);
		setCourseName(courseName);
	}
   
	//Passthrough methods
   public boolean get()
   {
        try {
            fetch();
            return true;
        } catch (DLException ex) {
            ex.log();
            return false;
        }
   }
        
   public boolean save()
   {
       try{
            if(getCourseId() != null)
            {
                             put();
                             return true;
            }
            else
            {
               post();
               return true;
            }
       }
       catch(DLException e){
           e.log();
           return false;
       }
   }
}
