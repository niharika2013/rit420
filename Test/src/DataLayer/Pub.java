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
	private String userId;
	private String pubId;
	private String year;
	private String citation;
	private String tease;
	private String status;
        private MySQLDatabase myDB;
	
        
	/**
         * Explicit default constructor for Pub does nothing! 
         */
        public Pub(){
	}
	
	/**
         * Constructor accepts pubId only.
         * @param pubId 
         */
        public Pub(String pubId) {
		this.pubId = pubId;
	}
	
	/**
         * Constructor accepts parameters for all fields of this data object.
         * 
         * @param userId
         * @param pubId
         * @param year
         * @param citation
         * @param tease
         * @param status 
         */
        public Pub(String userId, String pubId, String year, String citation, String tease, String status){
		this.userId = userId;
		this.pubId = pubId;
		this.year = year;
		this.citation = citation;
		this.tease = tease;
		this.status = status;
	}
	
        
        
        
        /**
         * This method retrieves the row corresponding to this data object's
         * pubId field and sets this data object's attributes accordingly.
         * 
         * @return boolean indicating data exists.
         * @throws DLException 
         */
        public boolean fetch() throws DLException {
             try{    
            	ArrayList<String> values = new ArrayList<>(0);
		values.add(pubId);
                ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT userId, pubId, year, citation, tease, status FROM pubs WHERE PubId = ?", values);
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
	
	/**
         * This method updates the database with values equal to this data 
         * object's attributes.
         *
         * @return boolean indicating success.
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
	
	/**
         * This method inserts this data object's values into the database.
         * @return boolean indicating success
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
	
	/**
         * This method removes from the database all values corresponding to
         * this data object's pubId.
         * 
         * @return boolean indicating success.
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
        
        
        
        
        
        /**
         * Mutator method for pubId
         * @param pubId 
         */
        public void setPubId(String pubId){this.pubId = pubId;}
	
        /**
         * Accessor method for pubId
         * @return String value of pubId
         */
        public String getPubId(){return pubId;}
        
        /**
         * Mutator method for userId
         * @param userId 
         */
	public void setUserId(String userId){this.userId = userId;}
	
        /**
         * Accessor method for userId
         * @return String value for userId
         */
        public String getUserId(){return userId;}
	
        /**
         * Mutator method for year
         * @param year 
         */
	public void setYear(String year){this.year = year;}
	
        /**
         * Accessor method for year
         * @return String value for year
         */
        public String getYear(){return year;}
	
        /**
         * Mutator method for citation
         * @param citation 
         */
	public void setCitation(String citation){this.citation = citation;}
        
        /**
         * Accessor method for citation
         * @return String value for citation
         */
        public String getCitation(){return citation;}
        
        /**
         * Mutator method for tease
         * @param tease 
         */
	public void setTease(String tease){this.tease = tease;}
	
        /**
         * Accessor method for tease
         * @return String value for tease
         */
        public String getTease(){return tease;}
	
        /**
         * Mutator method for status
         * @param status 
         */
	public void setStatus(String status){this.status = status;}
	
        /**
         * Accessor method for status
         * @return String value for status
         */
        public String getStatus(){return status;}
}