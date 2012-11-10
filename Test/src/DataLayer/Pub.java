package DataLayer;

import java.util.*;

/**
 * The Pub class creates a data object representing a single tuple from the 
 * pubs table in the faculty activity database (484 project in this case).
 *
 * Also a local drinking establishment.
 * 
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 */
public class Pub {
	// Provide	attributes	that	mirror	the	Pubs	table.
	private String userId;
	private String pubId;
	private String year;
	private String citation;
	private String tease;
	private String status;
        private MySQLDatabase myDB;
	
	// Provide	a	default	constructor.
        /**
         * 
         */
        public Pub()
	{
	}
	
	// Provide	a	constructor	that	accepts	and	sets	the	pubId.
	/**
         * 
         * @param pubId 
         */
        public Pub(String pubId)
	{
		this.pubId = pubId;
	}
	
	// Provide	a	constructor	that	accepts	and	sets	all	attributes.
	/**
         * 
         * @param userId
         * @param pubId
         * @param year
         * @param citation
         * @param tease
         * @param status 
         */
        public Pub(String userId, String pubId, String year, String citation, String tease, String status)
	{
		this.userId = userId;
		this.pubId = pubId;
		this.year = year;
		this.citation = citation;
		this.tease = tease;
		this.status = status;
	}
	

	
	// fetch	uses	the	object�s	pubId	attribute	and	the	Database	class
	//getData	method	to	retrieve	the	database	values	for	that	particular	pubId	
	//and	updates	the	object�s	attributes.
	
        /**
         * 
         * @return
         * @throws DLException 
         */
        public boolean fetch() throws DLException {
             try{    
            	ArrayList<String> values = new ArrayList<>(0);
		values.add(pubId);
                ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM pubs WHERE PubId = ?", values);
                if(dataList.size() > 1) {
			userId = dataList.get(1).get(1).toString();
			pubId = dataList.get(1).get(2).toString();
			year = dataList.get(1).get(3).toString();
			citation = dataList.get(1).get(4).toString();
			tease = dataList.get(1).get(5).toString();
			status = dataList.get(1).get(6).toString();
			return true;
		} else {
			return false;
		}
            } catch (Exception e){
                throw new DLException(e);
            }
	}
	
	// post updates the database values, for that object�s pubId, using the	
	//object�s attribute values.
	/**
         * 
         * @return
         * @throws DLException 
         */
        public boolean post() throws DLException {
             try{
		ArrayList<String> values = new ArrayList<>(0);
		values.add(userId); 
		values.add(year);
		values.add(citation);
		values.add(tease);
		values.add(status);
		values.add(pubId);
                myDB.setData("UPDATE pub UserId = ?, Year = ?, Citation = ?, Tease = ?, Status = ? WHERE PubId = ?", values);
                return true; 	
            } catch(Exception e){
                throw new DLException(e);
            }
        }
	
	// put	inserts	the	object�s	attribute	values	into	the	database	as	a	new	record.
	/**
         * 
         * @return
         * @throws DLException 
         */
        public boolean put() throws DLException	{
            try {
                ArrayList<String> values = new ArrayList<>(0);
		values.add(userId);
		values.add(pubId);
		values.add(year);
		values.add(citation);
		values.add(tease);
		values.add(status);
		myDB.setData("INSERT INTO pub (UserId,PubId,Year,Citation,Tease,Status) VALUES(?,?,?,?,?,?)", values);
	        return true;
             } catch(Exception e) {
                throw new DLException(e);
             }
        }
            
	
	// delete removes	from	the	database	any	data	corresponding	to	the	object�s pubId.
	/**
         * 
         * @return
         * @throws DLException 
         */
        public boolean delete() throws DLException {
            try {
		ArrayList<String> values = new ArrayList<>(0);
		values.add(pubId);
                myDB.setData("DELETE FROM pub WHERE pubID = ?", values);
                return true;
            } catch(Exception e) {
               throw new DLException(e);
            }
        }
        
        // Provide	accessors	and	mutators	for	all	attributes.
	
        /**
         * 
         * @param pubId 
         */
        public void setPubId(String pubId){this.pubId = pubId;}
	
        /**
         * 
         * @return 
         */
        public String getPubId(){return pubId;}
	
        
        /**
         * 
         * @param userId 
         */
	public void setUserId(String userId){this.userId = userId;}
	
        /**
         * 
         * @return 
         */
        public String getUserId(){return userId;}
	
        /**
         * 
         * @param year 
         */
	public void setYear(String year){this.year = year;}
	
        /**
         * 
         * @return 
         */
        public String getYear(){return year;}
	
        /**
         * 
         * @param citation 
         */
	public void setCitation(String citation){this.citation = citation;}
	
        
        /**
         * 
         * @return 
         */
        public String getCitation(){return citation;}
	
        
        /**
         * 
         * @param tease 
         */
	public void setTease(String tease){this.tease = tease;}
	
        /**
         * 
         * @return 
         */
        public String getTease(){return tease;}
	
        /**
         * 
         * @param status 
         */
	public void setStatus(String status){this.status = status;}
	
        /**
         * 
         * @return 
         */
        public String getStatus(){return status;}
}