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
	public Pub(String pubId)
	{
		this.pubId = pubId;
	}
	
	// Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Pub(String userId, String pubId, String year, String citation, String tease, String status)
	{
		this.userId = userId;
		this.pubId = pubId;
		this.year = year;
		this.citation = citation;
		this.tease = tease;
		this.status = status;
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
	
	// fetch	uses	the	object�s	pubId	attribute	and	the	Database	class
	//getData	method	to	retrieve	the	database	values	for	that	particular	pubId	
	//and	updates	the	object�s	attributes.
	public boolean fetch() throws DLException
	{
             try{    
            myDB = new MySQLDatabase();
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(pubId);
		myDB.connect();
                ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM pubs WHERE PubId = ?", values);
		myDB.close();
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
            } catch (Exception e){
                throw new DLException(e);
            }
	}
	
	// post updates the database values, for that object�s pubId, using the	
	//object�s attribute values.
	public boolean post() throws DLException
	{
                myDB = new MySQLDatabase();
                try{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId); 
		values.add(year);
		values.add(citation);
		values.add(tease);
		values.add(status);
		values.add(pubId);
                myDB.connect();
                myDB.setData("UPDATE pub UserId = ?, Year = ?, Citation = ?, Tease = ?, Status = ? WHERE PubId = ?", values);
		myDB.close();
                return true; 
	
                }
            catch(DLException e){
                return false;
            }
        }
	
	// put	inserts	the	object�s	attribute	values	into	the	database	as	a	new	record.
	public boolean put() throws DLException
	{
              myDB = new MySQLDatabase();

            try {
            
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId);
		values.add(pubId);
		values.add(year);
		values.add(citation);
		values.add(tease);
		values.add(status);
		myDB.setData("INSERT INTO pub (UserId,PubId,Year,Citation,Tease,Status) VALUES(?,?,?,?,?,?)", values);
	        return true;
    } catch(DLException e) {
        return false;
    }
            }
            
	
	// delete removes	from	the	database	any	data	corresponding	to	the	object�s pubId.
	public boolean delete() throws DLException
	{
               myDB = new MySQLDatabase();
    	try {
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(pubId);
		myDB.connect();
                myDB.setData("DELETE FROM pub WHERE pubID = ?", values);
                myDB.close();
                return true;
        } catch(DLException e) {
            return false;
        }
    }
}