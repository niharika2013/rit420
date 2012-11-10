package DataLayer;

import java.util.*;

/**
 * The Grant class creates a data object representing a single tuple from the 
 * grants table in the faculty activity database (484 project in this case).
 *
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 */

public class Grant {
	
        private MySQLDatabase myDB = new MySQLDatabase();
    
        private String userId;
	private String grantId;
	private String year;
	private String citation;
	private String tease;
	private String amount;
	private String status;
	
        /**
         * Explicit default constuctor for Grant does nothing.
         */
        public Grant() { }
		
        /**
         * Constructor sets only the grantId.
         * @param grantId 
         */
        public Grant(String grantId) {
		this.grantId = grantId;
	}
        
	/**
         * Constructor with parameters for all fields of Grant.
         * 
         * @param userId
         * @param grantId
         * @param year
         * @param citation
         * @param tease
         * @param amount
         * @param status 
         */
        public Grant(String userId, String grantId, String year, String citation, String tease, String amount, String status) {
		this.userId     = userId;
		this.grantId    = grantId;
		this.year       = year;
		this.citation   = citation;
		this.tease      = tease;
		this.amount     = amount;
		this.status     = status;
	}

        
        
        
	
        /**
         * This method uses the grantId field of the dataobject to query the 
         * grants table in the faculty activity database, and complete the remaining
         * fields of the data object with the returned values.
         * 
         * @return boolean indicating data exists
         * @throws DLException 
         */
        public boolean fetch() throws DLException {
            try{            
		ArrayList<String> values = new ArrayList<>(0);
		values.add(grantId);
		ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT userId, grantId, year, citation, tease, amount, status FROM grants WHERE GrantId = ?", values);
		if(dataList.size() > 1) {
			userId      = dataList.get(1).get(1).toString();
			grantId     = dataList.get(1).get(2).toString();
			year        = dataList.get(1).get(3).toString();
			citation    = dataList.get(1).get(4).toString();
			tease       = dataList.get(1).get(5).toString();
			amount      = dataList.get(1).get(6).toString();
			status      = dataList.get(1).get(7).toString();
			return true;
		} else {
			return false;
		}
            } catch (Exception e){
                throw new DLException(e);
            }
	}
        
        /**
         * This method uses all of the fields of the present data object to
         * update the database for the object's grantId.
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
		values.add(amount);
		values.add(status);
		values.add(grantId);
		myDB.setData("UPDATE grant UserId = ?, Year = ?, Citation = ?, Tease = ?, Amount = ?, Status = ? WHERE GrantId = ?", values);
                return true;
            } catch(Exception e){
                throw new DLException(e);
            }
        }
        
	/**
         * This method inserts the the values of this data object's fields into
         * the grants table.
         * 
         * @return boolean indicating success
         * @throws DLException 
         */
        public boolean put() throws DLException {
            try {            
		ArrayList<String> values = new ArrayList<>(0);
		values.add(userId);
		values.add(grantId);
		values.add(year);
		values.add(citation);
		values.add(tease);
		values.add(amount);
		values.add(status);
		myDB.setData("INSERT INTO grant (UserId,GrantId,Year,Citation,Tease,Amount,Status) VALUES(?,?,?,?,?,?,?)", values);      
                return true;
	    } catch(Exception e) {
                throw new DLException(e);
            }
        }
	
        /**
         * This method deletes an entire row corresponding to this data object's
         * grantId field.
         * 
         * @return boolean indicating success
         * @throws DLException 
         */
        public boolean delete() throws DLException {       
            try {
        	ArrayList<String> values = new ArrayList<>(0);
                values.add(grantId);
		myDB.setData("DELETE FROM grant WHERE grantID = ?", values);
                return true;
            } catch(Exception e) {
                throw new DLException(e);
            }
        }
        
        
        
        
        
        
	/**
         * Mutator method for grantID.
         * 
         * @param grantId 
         */
        public void setGrantId(String grantId){this.grantId = grantId;}
	
        /**
         * Accessor Method for grantId
         * 
         * @return String value of grantID.
         */
        public String getGrantId(){return grantId;}
	
        /**
         * Mutator method for usedId.
         * 
         * @param userId 
         */
	public void setUserId(String userId){this.userId = userId;}
	
        /**
         * Accessor method for userId.
         * 
         * @return String value of userId.
         */
        public String getUserId(){return userId;}
	
        /**
         * Mutator value for year.
         * 
         * @param year 
         */
	public void setYear(String year){this.year = year;}
	
        /**
         * Accessor value for year.
         * 
         * @return String value of year.
         */
        public String getYear(){return year;}
	
        /**
         * Mutator method for citation
         * 
         * @param citation 
         */
	public void setCitation(String citation){this.citation = citation;}
	
        /**
         * Accessor method for citation
         * 
         * @return String value of citation
         */
        public String getCitation(){return citation;}   
        
        /**
         * Mutator method for tease.
         * 
         * @param tease 
         */
	public void setTease(String tease){this.tease = tease;}
	
        /**
         * Accessor method for tease.
         * 
         * @return String value of tease.
         */
        public String getTease(){return tease;}
	
        /**
         * Mutator method for amount.
         * 
         * @param amount 
         */
	public void setAmount(String amount){this.amount = amount;}
	
        /**
         * Accessor method for amount.
         * 
         * @return String value of amount.
         */
        public String getAmount(){return amount;}
	
        /**
         * Mutator method for status.
         * 
         * @param status 
         */
	public void setStatus(String status){this.status = status;}
	
        /**
         * Accessor method for status.
         * 
         * @return String value of status.
         */
        public String getStatus(){return status;}
		

}//end class