package DataLayer;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class User
{
	// Provide	attributes	that	mirror	the	User	table.
	private String userId;
	private String fName;
	private String lName;
	private String email;
	private String pswd;
	private string role;
	
	// Provide	a	default	constructor.
	public User()
	{
	}
	
	// Provide	a	constructor	that	accepts	and	sets	the	userId.
	public User(String userId)
	{
		this.userId = userId;
	}
	
	// Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public User(String userId, String fName, String lName, String email, String pswd, String role)
	{
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pswd = pswd;
		this.role = role;
	}
	
	// Provide	accessors	and	mutators	for	all	attributes.
	public void setUserId(String userId){this.userId = userId;}
	public String getUserId(){return userId;}
	
	public void setFName(String fName){this.fName = fName;}
	public String getFName(){return fName;}
	
	public void setLName(String lName){this.lName = lName;}
	public String getLName(){return lName;}
	
	public void setEmail(String email){this.email = email;}
	public String getEmail(){return email;}
	
	public void setPswd(String pswd){this.pswd = pswd;}
	public String getPswd(){return pswd;}
	
	public void setRole(String role){this.role = role;}
	public String getRole(){return role;}
	
	// fetch	uses	the	object’s	userId	attribute	and	the	Database	class’	
	//getData	method	to	retrieve	the	database	values	for	that	particular	userId	
	//and	updates	the	object’s	attributes.
	public boolean fetch()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId);
		ArrayList<ArrayList<String>> dataList = JavaConnection.mdb.getData("SELECT * FROM users WHERE UserId = ?", values);
		if(dataList != null)
		{
			fName = dataList.get(1).get(1).toString();
			lName = dataList.get(1).get(2).toString();
			email = dataList.get(1).get(3).toString();
			pswd = dataList.get(1).get(4).toString();
			role = dataList.get(1).get(5).toString();
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	// post updates the database values, for that object’s userId, using the	
	//object’s attribute values.
	public boolean post()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(fName); 
		values.add(lName);
		values.add(email);
		values.add(pswd);
		values.add(role);
		values.add(userId)
		return JavaConnection.mdb.setData("UPDATE users FName = ?, LName = ?, Email = ?, Pswd = ?, Role = ? WHERE UserId = ?", values);
	}
	
	// put	inserts	the	object’s	attribute	values	into	the	database	as	a	new	record.
	public boolean put()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId);
		values.add(fName);
		values.add(lName);
		values.add(email);
		values.add(pswd);
		values.add(role);
		return JavaConnection.mdb.setData("INSERT INTO users (UserId,FName,LName,Email,Pswd,Role) VALUES(?,?,?,?)", values);
	}
	
	// delete removes	from	the	database	any	data	corresponding	to	the	object’s userId.
	public boolean delete()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId);
		return JavaConnection.mdb.setData("DELETE FROM users WHERE userID = ?", values);
	}
}