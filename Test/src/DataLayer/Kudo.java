package DataLayer;

import java.util.*;

/**
 * The Kudo class creates a data object representing a single tuple from the 
 * kudos table in the faculty activity database (484 project in this case).
 *
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 */

public class Kudo {
	
        private MySQLDatabase myDB = new MySQLDatabase();

    	private String userId;
	private String kudoId;
	private String year;
	private String kudo;
    	
        
        
        
        
        /**
         * Explicit default constructor for Kudo does nothing!
         */
	public Kudo(){}
	
        /**
         * Constructor for Kudo sets only kudoId.
         * 
         * @param kudoId 
         */
	public Kudo(String kudoId) {
		this.kudoId = kudoId;
	}
       
        /**
         * Constructor for kudo accepts one paramenter for each field of the 
         * data object.
         * 
         * @param userId
         * @param kudoId
         * @param year
         * @param kudo 
         */
	public Kudo(String userId, String kudoId, String year, String kudo) {
		this.userId = userId;
		this.kudoId = kudoId;
		this.year = year;
		this.kudo = kudo;
	}

        
        
        
        
        /**
         * This method uses the kudoId field of the data object to query the
         * kudos table of the faculty activity database. Values retrieved for
         * the kudoId are stored in the fields of this data object.
         * 
         * @return boolean indicating data exists.
         * @throws DLException 
         */
        public boolean fetch() throws DLException {
            try{    
                  ArrayList<String> values = new ArrayList<>(0);
                  values.add(kudoId);
                  ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT userId, kudoId, year, kudo FROM kudos WHERE KudoId = ?", values);
                  if(dataList.size() > 1) {
                          userId    = dataList.get(1).get(1).toString();
                          kudoId    = dataList.get(1).get(2).toString();
                          year      = dataList.get(1).get(3).toString();
                          kudo      = dataList.get(1).get(4).toString();
                          return true;
                  } else {
                          return false;
                  }
              } catch (Exception e){
                  throw new DLException(e);
              }    
	}
	
	/**
         * This method uses this data object's kudoId field to update the kudos
         * table of the faculty activity database with values equal to the 
         * fields of this data object.
         * 
         * @return boolean indicating success.
         * @throws DLException 
         */
        public boolean post() throws DLException{
            try{
                ArrayList<String> values = new ArrayList<>(0);
		values.add(userId); 
		values.add(year);
		values.add(kudo);
		values.add(kudoId);
                myDB.setData("UPDATE kudos UserId = ?, year = ?, Kudo = ? WHERE KudoId = ?", values);
		return true;
            }catch(Exception e){
                throw new DLException(e);
            }
        }
	
	/**
         * This method inserts this data object's attribute values into the 
         * kudos table of the faculty activity database.
         * 
         * @return boolean indicating success
         * @throws DLException 
         */
        public boolean put() throws DLException {
            try {
		ArrayList<String> values = new ArrayList<>(0);
		values.add(userId);
		values.add(kudoId);
		values.add(year);
		values.add(kudo);
                myDB.setData("INSERT INTO kudos (UserId,KudoId,Year,Kudo) VALUES(?,?,?,?)", values);
		return true;
            } catch(Exception e) {
                   throw new DLException(e);
            }
        }
	
	/**
         * This method deletes from the database all values associated with
         * this object's kudoId.
         * 
         * @return boolean indicating success.
         * @throws DLException 
         */
        public boolean delete() throws DLException {
            try {
                    ArrayList<String> values = new ArrayList<>(0);
                    values.add(kudoId);
                    myDB.setData("DELETE FROM kudos WHERE kudoID = ?", values);
                    return true;
            }   catch(Exception e) {
                throw new DLException(e);
            }
        }

        
        
        
        
        
        /**
         * Mutator method for kudoId
         * 
         * @param kudoId 
         */
        public void setKudoId(String kudoId){this.kudoId = kudoId;}
        
        /**
         * Accessor method for kudoId
         * @return String value of kudoId
         */
        public String getKudoId(){return kudoId;}

        /**
         * Mutator method for userId
         * @param userId 
         */
        public void setUserId(String userId){this.userId = userId;}
        
        /**
         * Accessor method for userId
         * @return String value of userId
         */
        public String getUserId(){return userId;}

        /**
         * Mutator method for year
         * @param year 
         */
        public void setYear(String year){this.year = year;}
        
        /**
         * Accessor method for year
         * @return String value of year
         */
        public String getYear(){return year;}

        /**
         * Mutator method for kudo
         * @param kudo 
         */
        public void setKudo(String kudo){this.kudo = kudo;}
        
        /**
         * Accessor method for kudo
         * @return String value for kudo
         */
        public String getKudo(){return kudo;}

}
