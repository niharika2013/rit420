import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Course
{
	// Provide	attributes	that	mirror	the	Courses	table.
	private String userId;
	private String courseId;
	private String year;
	private String courseNumber;
	private string courseName;
	
	// Provide	a	default	constructor.
	public Course()
	{
	}
	
	// Provide	a	constructor	that	accepts	and	sets	the	courseId.
	public Course(String courseId)
	{
		this.courseId = courseId;
	}
	
	// Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Course(String userId, String courseId, String year, String courseNumber, String courseName)
	{
		this.userId = userId;
		this.courseId = courseId;
		this.year = year;
		this.courseNumber = courseNumber;
		this.courseName = courseName;
	}
	
	// Provide	accessors	and	mutators	for	all	attributes.
	public void setCourseId(String courseId){this.courseId = courseId;}
	public String getCourseId(){return courseId;}
	
	public void setUserId(String userId){this.userId = userId;}
	public String getUserId(){return userId;}
	
	public void setYear(String year){this.year = year;}
	public String getYear(){return year;}
	
	public void setCourseNumber(String courseNumber){this.courseNumber = courseNumber;}
	public String getCourseNumber(){return courseNumber;}
	
	public void setCourseName(String courseName){this.courseName = courseName;}
	public String getCourseName(){return courseName;}
	
	// fetch	uses	the	object’s	courseId	attribute	and	the	Database	class’	
	//getData	method	to	retrieve	the	database	values	for	that	particular	courseId	
	//and	updates	the	object’s	attributes.
	public boolean fetch()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(courseId);
		ArrayList<ArrayList<String>> dataList = JavaConnection.mdb.getData("SELECT * FROM courses WHERE CourseId = ?", values);
		if(dataList != null)
		{
			userId = dataList.get(1).get(1).toString();
			courseId = dataList.get(1).get(2).toString();
			year = dataList.get(1).get(3).toString();
			courseNumber = dataList.get(1).get(4).toString();
			courseName = dataList.get(1).get(5).toString();
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	// post updates the database values, for that object’s courseId, using the	
	//object’s attribute values.
	public boolean post()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId); 
		values.add(year);
		values.add(courseNumber);
		values.add(courseName);
		values.add(courseId);
		return JavaConnection.mdb.setData("UPDATE course UserId = ?, Year = ?, CourseNumber = ?, CourseName = ? WHERE CourseId = ?", values);
	}
	
	// put	inserts	the	object’s	attribute	values	into	the	database	as	a	new	record.
	public boolean put()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId);
		values.add(courseId);
		values.add(year);
		values.add(courseNumber);
		values.add(courseName);
		return JavaConnection.mdb.setData("INSERT INTO course (UserId,CourseId,Year,CourseNumber,CourseName) VALUES(?,?,?,?,?)", values);
	}
	
	// delete removes	from	the	database	any	data	corresponding	to	the	object’s courseId.
	public boolean delete()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(courseId);
		return JavaConnection.mdb.setData("DELETE FROM course WHERE courseID = ?", values);
	}
}