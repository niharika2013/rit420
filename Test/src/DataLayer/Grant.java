package DataLayer;

import java.util.*;

/**
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
         * 
         */
        public Grant() { }
	
		
        /**
         * Provide a constructor that accepts and sets the grantId.
         * @param grantId 
         */
        public Grant(String grantId) {
		this.grantId = grantId;
	}
	
	/**
         * Provide a constructor that accepts and sets all attributes.
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
		this.userId = userId;
		this.grantId = grantId;
		this.year = year;
		this.citation = citation;
		this.tease = tease;
		this.amount = amount;
		this.status = status;
	}

	
        /**
         * @return
         * @throws DLException 
         */
        
        public boolean fetch() throws DLException {
            try{            
		ArrayList<String> values = new ArrayList<>(0);
		values.add(grantId);
		ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM grants WHERE GrantId = ?", values);
		if(dataList != null) {
			userId = dataList.get(1).get(1).toString();
			grantId = dataList.get(1).get(2).toString();
			year = dataList.get(1).get(3).toString();
			citation = dataList.get(1).get(4).toString();
			tease = dataList.get(1).get(5).toString();
			amount = dataList.get(1).get(6).toString();
			status = dataList.get(1).get(7).toString();
			return true;
		} else {
			return false;
		}
            } catch (Exception e){
                throw new DLException(e);
            }
	}
	
        
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
         * 
         * @return
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
         * 
         * @return
         * @throws DLException 
         */
        public boolean delete() throws DLException {        myDB = new MySQLDatabase();
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
         * 
         * @param grantId 
         */
        public void setGrantId(String grantId){this.grantId = grantId;}
	
        /**
         * 
         * @return 
         */
        public String getGrantId(){return grantId;}
	
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
         * @param amount 
         */
	public void setAmount(String amount){this.amount = amount;}
	
        /**
         * 
         * @return 
         */
        public String getAmount(){return amount;}
	
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
		

}//end class