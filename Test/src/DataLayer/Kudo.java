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
         * 
         */
        
	public Kudo(){}
	
        /**
         * 
         * @param kudoId 
         */
	public Kudo(String kudoId) {
		this.kudoId = kudoId;
	}
	
        
        /**
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
	
	
	// fetch	uses	the	object�s	kudoId	attribute	and	the	Database	class�	
	//getData	method	to	retrieve	the	database	values	for	that	particular	kudoId	
	//and	updates	the	object�s	attributes.
	
        /**
         * 
         * @return
         * @throws DLException 
         */
        public boolean fetch() throws DLException {
            try{    
                  ArrayList<String> values = new ArrayList<>(0);
                  values.add(kudoId);
                  ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM kudos WHERE KudoId = ?", values);
                  if(dataList.size() > 1) {
                          userId = dataList.get(1).get(1).toString();
                          kudoId = dataList.get(1).get(2).toString();
                          year = dataList.get(1).get(3).toString();
                          kudo = dataList.get(1).get(4).toString();
                          return true;
                  } else {
                          return false;
                  }
              } catch (Exception e){
                  throw new DLException(e);
              }    
	}
	
	// post updates the database values, for that object�s kudoId, using the	
	//object�s attribute values.
	/**
         * 
         * @return
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
	
	// put	inserts	the	object�s	attribute	values	into	the	database	as	a	new	record.
	/**
         * 
         * @return
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
	
	// delete removes	from	the	database	any	data	corresponding	to	the	object�s kudoId.
	/**
         * 
         * @return
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
         * 
         * @param kudoId 
         */
        public void setKudoId(String kudoId){this.kudoId = kudoId;}
        
        /**
         * 
         * @return 
         */
        public String getKudoId(){return kudoId;}

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
         * @param kudo 
         */
        public void setKudo(String kudo){this.kudo = kudo;}
        
        /**
         * 
         * @return 
         */
        public String getKudo(){return kudo;}

}
