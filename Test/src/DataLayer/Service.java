package DataLayer;

import java.util.*;

public class Service
{
	// Provide	attributes	that	mirror	the	Services	table.
	private String userId;
	private String serviceId;
	private String year;
	private String description;
	private String role;
	
	// Provide	a	default	constructor.
	public Service()
	{
	}
	
	// Provide	a	constructor	that	accepts	and	sets	the	serviceId.
	public Service(String serviceId)
	{
		this.serviceId = serviceId;
	}
	
	// Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Service(String userId, String serviceId, String year, String description, String role, MySQLDatabase myDB)
	{
		this.userId = userId;
		this.serviceId = serviceId;
		this.year = year;
		this.description = description;
		this.role = role;
	}
	
	// Provide	accessors	and	mutators	for	all	attributes.
	public void setServiceId(String serviceId){this.serviceId = serviceId;}
	public String getServiceId(){return serviceId;}
	
	public void setUserId(String userId){this.userId = userId;}
	public String getUserId(){return userId;}
	
	public void setYear(String year){this.year = year;}
	public String getYear(){return year;}
	
	public void setDescription(String description){this.description = description;}
	public String getDescription(){return description;}
	
	public void setRole(String role){this.role = role;}
	public String getRole(){return role;}
	
	// fetch	uses	the	object�s	serviceId	attribute	and	the	Database	class
	//getData	method	to	retrieve	the	database	values	for	that	particular	serviceId	
	//and	updates	the	object�s	attributes.
	public boolean fetch()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(serviceId);
		ArrayList<ArrayList<String>> dataList = JavaConnection.mdb.getData("SELECT * FROM services WHERE ServiceId = ?", values);
		if(dataList != null)
		{
			userId = dataList.get(1).get(1).toString();
			serviceId = dataList.get(1).get(2).toString();
			year = dataList.get(1).get(3).toString();
			description = dataList.get(1).get(4).toString();
			role = dataList.get(1).get(5).toString();
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	// post updates the database values, for that object�s serviceId, using the	
	//object�s attribute values.
	public boolean post()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId); 
		values.add(year);
		values.add(description);
		values.add(role);
		values.add(serviceId);
		return JavaConnection.mdb.setData("UPDATE service UserId = ?, Year = ?, Description = ?, Role = ? WHERE ServiceId = ?", values);
	}
	
	// put	inserts	the	object�s	attribute	values	into	the	database	as	a	new	record.
	public boolean put()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId);
		values.add(serviceId);
		values.add(year);
		values.add(description);
		values.add(role);
		return JavaConnection.mdb.setData("INSERT INTO service (UserId,ServiceId,Year,Description,Role) VALUES(?,?,?,?,?)", values);
	}
	
	// delete removes	from	the	database	any	data	corresponding	to	the	object�s serviceId.
	public boolean delete()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(serviceId);
		return JavaConnection.mdb.setData("DELETE FROM service WHERE serviceID = ?", values);
	}
}