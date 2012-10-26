package DataLayer;


import java.util.*;

public class Pub
{
	// Provide	attributes	that	mirror	the	Pubs	table.
	private String userId;
	private String pubId;
	private String year;
	private String citation;
	private String tease;
	private String status;
	private MySQLDatabase myDB;
	
	// Provide	a	default	constructor.
	public Pub()
	{
	}
	
	// Provide	a	constructor	that	accepts	and	sets	the	pubId.
	public Pub(String pubId, MySQLDatabase myDB)
	{
		this.pubId = pubId;
		this.myDB = myDB;
	}
	
	// Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Pub(String userId, String pubId, String year, String citation, String tease, String status, MySQLDatabase myDB)
	{
		this.userId = userId;
		this.pubId = pubId;
		this.year = year;
		this.citation = citation;
		this.tease = tease;
		this.status = status;
		this.myDB = myDB;
	}
	
	// Provide	accessors	and	mutators	for	all	attributes.
	public void setPubId(String pubId){this.pubId = pubId;}
	public String getPubId(){return pubId;}
	
	public void setUserId(String userId){this.userId = userId;}
	public String getUserId(){return userId;}
	
	public void setYear(String year){this.year = year;}
	public String getYear(){return year;}
	
	public void setCitation(String citation){this.citation = citation;}
	public String getCitation(){return citation;}
	
	public void setTease(String tease){this.tease = tease;}
	public String getTease(){return tease;}
	
	public void setStatus(String status){this.status = status;}
	public String getStatus(){return status;}
	
	public void setDB(MySQLDatabase myDB){this.myDB = myDB;}
	public MySQLDatabase getDB(){return myDB;}
	
	// fetch	uses	the	object�s	pubId	attribute	and	the	Database	class
	//getData	method	to	retrieve	the	database	values	for	that	particular	pubId	
	//and	updates	the	object�s	attributes.
	public boolean fetch()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(pubId);
		ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM pubs WHERE PubId = ?", values);
		if(dataList != null)
		{
			userId = dataList.get(1).get(1).toString();
			pubId = dataList.get(1).get(2).toString();
			year = dataList.get(1).get(3).toString();
			citation = dataList.get(1).get(4).toString();
			tease = dataList.get(1).get(5).toString();
			status = dataList.get(1).get(6).toString();
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	// post updates the database values, for that object�s pubId, using the	
	//object�s attribute values.
	public boolean post()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId); 
		values.add(year);
		values.add(citation);
		values.add(tease);
		values.add(status);
		values.add(pubId);
		return myDB.setData("UPDATE pub UserId = ?, Year = ?, Citation = ?, Tease = ?, Status = ? WHERE PubId = ?", values);
	}
	
	// put	inserts	the	object�s	attribute	values	into	the	database	as	a	new	record.
	public boolean put()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId);
		values.add(pubId);
		values.add(year);
		values.add(citation);
		values.add(tease);
		values.add(status);
		return myDB.setData("INSERT INTO pub (UserId,PubId,Year,Citation,Tease,Status) VALUES(?,?,?,?,?,?)", values);
	}
	
	// delete removes	from	the	database	any	data	corresponding	to	the	object�s pubId.
	public boolean delete()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(pubId);
		return myDB.setData("DELETE FROM pub WHERE pubID = ?", values);
	}
}