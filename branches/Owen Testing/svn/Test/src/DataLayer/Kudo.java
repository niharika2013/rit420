package DataLayer;

import java.util.*;

public class Kudo
{
	// Provide	attributes	that	mirror	the	Kudos	table.
	private String userId;
	private String kudoId;
	private String year;
	private String kudo;
	private MySQLDatabase myDB;
	
	// Provide	a	default	constructor.
	public Kudo()
	{
	}
	
	// Provide	a	constructor	that	accepts	and	sets	the	kudoId.
	public Kudo(String kudoId, MySQLDatabase myDB)
	{
		this.kudoId = kudoId;
		this.myDB = myDB;
	}
	
	// Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Kudo(String userId, String kudoId, String year, String kudo, MySQLDatabase myDB)
	{
		this.userId = userId;
		this.kudoId = kudoId;
		this.year = year;
		this.kudo = kudo;
		this.myDB = myDB;
	}
	
	// Provide	accessors	and	mutators	for	all	attributes.
	public void setKudoId(String kudoId){this.kudoId = kudoId;}
	public String getKudoId(){return kudoId;}
	
	public void setUserId(String userId){this.userId = userId;}
	public String getUserId(){return userId;}
	
	public void setYear(String year){this.year = year;}
	public String getYear(){return year;}
	
	public void setKudo(String kudo){this.kudo = kudo;}
	public String getKudo(){return kudo;}
	
	public void setDB(MySQLDatabase myDB){this.myDB = myDB;}
	public MySQLDatabase getDB(){return myDB;}
	
	// fetch	uses	the	object’s	kudoId	attribute	and	the	Database	class’	
	//getData	method	to	retrieve	the	database	values	for	that	particular	kudoId	
	//and	updates	the	object’s	attributes.
	public boolean fetch()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(kudoId);
		ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM kudos WHERE KudoId = ?", values);
		if(dataList != null)
		{
			userId = dataList.get(1).get(1).toString();
			kudoId = dataList.get(1).get(2).toString();
			year = dataList.get(1).get(3).toString();
			kudo = dataList.get(1).get(4).toString();
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	// post updates the database values, for that object’s kudoId, using the	
	//object’s attribute values.
	public boolean post()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId); 
		values.add(year);
		values.add(kudo);
		values.add(kudoId);
		return myDB.setData("UPDATE kudos UserId = ?, year = ?, Kudo = ? WHERE KudoId = ?", values);
	}
	
	// put	inserts	the	object’s	attribute	values	into	the	database	as	a	new	record.
	public boolean put()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId);
		values.add(kudoId);
		values.add(year);
		values.add(kudo);
		return myDB.setData("INSERT INTO kudos (UserId,KudoId,Year,Kudo) VALUES(?,?,?,?)", values);
	}
	
	// delete removes	from	the	database	any	data	corresponding	to	the	object’s kudoId.
	public boolean delete()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(kudoId);
		return myDB.setData("DELETE FROM kudos WHERE kudoID = ?", values);
	}
}