package DataLayer;

import java.util.*;

public class Kudo
{
	// Provide	attributes	that	mirror	the	Kudos	table.
	private String userId;
	private String kudoId;
	private String year;
	private String kudo;
	
	// Provide	a	default	constructor.
	public Kudo()
	{
	}
	
	// Provide	a	constructor	that	accepts	and	sets	the	kudoId.
	public Kudo(String kudoId)
	{
		this.kudoId = kudoId;
	}
	
	// Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Kudo(String userId, String kudoId, String year, String kudo)
	{
		this.userId = userId;
		this.kudoId = kudoId;
		this.year = year;
		this.kudo = kudo;
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
	
	// fetch	uses	the	object�s	kudoId	attribute	and	the	Database	class�	
	//getData	method	to	retrieve	the	database	values	for	that	particular	kudoId	
	//and	updates	the	object�s	attributes.
	public boolean fetch() throws DLException
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(kudoId);
		ArrayList<ArrayList<String>> dataList = MySQLDatabase.mdb.getData("SELECT * FROM kudos WHERE KudoId = ?", values);
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
	
	// post updates the database values, for that object�s kudoId, using the	
	//object�s attribute values.
	public boolean post() throws DLException
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId); 
		values.add(year);
		values.add(kudo);
		values.add(kudoId);
		return MySQLDatabase.mdb.setData("UPDATE kudos UserId = ?, year = ?, Kudo = ? WHERE KudoId = ?", values);
	}
	
	// put	inserts	the	object�s	attribute	values	into	the	database	as	a	new	record.
	public boolean put() throws DLException
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId);
		values.add(kudoId);
		values.add(year);
		values.add(kudo);
		return MySQLDatabase.mdb.setData("INSERT INTO kudos (UserId,KudoId,Year,Kudo) VALUES(?,?,?,?)", values);
	}
	
	// delete removes	from	the	database	any	data	corresponding	to	the	object�s kudoId.
	public boolean delete() throws DLException
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(kudoId);
		return MySQLDatabase.mdb.setData("DELETE FROM kudos WHERE kudoID = ?", values);
	}
}