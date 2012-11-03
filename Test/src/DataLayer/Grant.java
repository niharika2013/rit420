package DataLayer;

import java.util.*;

public class Grant
{
	// Provide	attributes	that	mirror	the	Grants	table.
	private String userId;
	private String grantId;
	private String year;
	private String citation;
	private String tease;
	private String amount;
	private String status;
	
	// Provide	a	default	constructor.
	public Grant()
	{
	}
	
	// Provide	a	constructor	that	accepts	and	sets	the	grantId.
	public Grant(String grantId)
	{
		this.grantId = grantId;
	}
	
	// Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Grant(String userId, String grantId, String year, String citation, String tease, String amount, String status)
	{
		this.userId = userId;
		this.grantId = grantId;
		this.year = year;
		this.citation = citation;
		this.tease = tease;
		this.amount = amount;
		this.status = status;
	}
	
	// Provide	accessors	and	mutators	for	all	attributes.
	public void setGrantId(String grantId){this.grantId = grantId;}
	public String getGrantId(){return grantId;}
	
	public void setUserId(String userId){this.userId = userId;}
	public String getUserId(){return userId;}
	
	public void setYear(String year){this.year = year;}
	public String getYear(){return year;}
	
	public void setCitation(String citation){this.citation = citation;}
	public String getCitation(){return citation;}
	
	public void setTease(String tease){this.tease = tease;}
	public String getTease(){return tease;}
	
	public void setAmount(String amount){this.amount = amount;}
	public String getAmount(){return amount;}
	
	public void setStatus(String status){this.status = status;}
	public String getStatus(){return status;}
		
	// fetch	uses	the	object�s	grantId	attribute	and	the	Database	class
	//getData	method	to	retrieve	the	database	values	for	that	particular	grantId	
	//and	updates	the	object�s	attributes.
	public boolean fetch() throws DLException
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(grantId);
		ArrayList<ArrayList<String>> dataList = MySQLDatabase.mdb.getData("SELECT * FROM grants WHERE GrantId = ?", values);
		if(dataList != null)
		{
			userId = dataList.get(1).get(1).toString();
			grantId = dataList.get(1).get(2).toString();
			year = dataList.get(1).get(3).toString();
			citation = dataList.get(1).get(4).toString();
			tease = dataList.get(1).get(5).toString();
			amount = dataList.get(1).get(6).toString();
			status = dataList.get(1).get(7).toString();
			System.out.println("fetch() grant");
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	// post updates the database values, for that object�s grantId, using the	
	//object�s attribute values.
	public boolean post() throws DLException
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId); 
		values.add(year);
		values.add(citation);
		values.add(tease);
		values.add(amount);
		values.add(status);
		values.add(grantId);
		return MySQLDatabase.mdb.setData("UPDATE grant UserId = ?, Year = ?, Citation = ?, Tease = ?, Amount = ?, Status = ? WHERE GrantId = ?", values);
	}
	
	// put	inserts	the	object�s	attribute	values	into	the	database	as	a	new	record.
	public boolean put() throws DLException
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId);
		values.add(grantId);
		values.add(year);
		values.add(citation);
		values.add(tease);
		values.add(amount);
		values.add(status);
		for (String value: values){
			System.out.println(value);
		}
		System.out.println("put() grant");
		return MySQLDatabase.mdb.setData("INSERT INTO grant (UserId,GrantId,Year,Citation,Tease,Amount,Status) VALUES(?,?,?,?,?,?,?)", values);
	}
	
	// delete removes	from	the	database	any	data	corresponding	to	the	object�s grantId.
	public boolean delete() throws DLException
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(grantId);
		return MySQLDatabase.mdb.setData("DELETE FROM grant WHERE grantID = ?", values);
	}
}