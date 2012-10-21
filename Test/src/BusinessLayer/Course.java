package BusinessLayer;

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
   public void get()
   {
       fetch();
   }
        
   public void save()
   {
       if(getCourseId() != null)
       {
		 	put();
       }
       else
       {
          post();
       }
   }
}
