package DataLayer;

import java.util.*;

/**
 * The Pubs class creates a data object representing multiple rows/tuples
 * from the pubs table of the faculty activity database (484 project in this case).
 * 
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 */

public class Pubs {
    
    private ArrayList<Pub> pubs = new ArrayList<>(0);
    MySQLDatabase myDB = new MySQLDatabase();
   
    /**
     * Explicit default constructor for Pubs doesn't serve any purpose really.
     */
    public Pubs() {}
    
    /**
     * This method returns and arraylist of Pub objects from the pubs attribute
     * of this data object.
     * @return arraylist of pubs.
     */
    public ArrayList<Pub> getPubs() {
        return pubs;
    }
    
    /**
     * This method sets the pubs attribute of this data object equal to the 
     * arraylist of pub objects accepted in its parameter.
     * @param pubsList 
     */
    public void setPubs(ArrayList<Pub> pubsList) {
        pubs = pubsList;
    }
    
    /**
     * This method retrieves all rows from the pubs table in the faculty activity
     * database and stores it in the pubs attribute of this data object.
     * 
     * @return
     * @throws DLException 
     */
    public boolean fetch() throws DLException {
	ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT userId, pubId, year, citation, tease, status FROM pubs", null);
	if(dataList.size() > 1){
            for (int i = 1; i <= dataList.size(); i++){
                Pub e = new Pub(dataList.get(i).get(2).toString());
                e.setUserId(    dataList.get(i).get(1).toString());
                e.setYear(      dataList.get(i).get(3).toString());
                e.setCitation(  dataList.get(i).get(4).toString());
                e.setTease(     dataList.get(i).get(5).toString());
                e.setStatus(    dataList.get(i).get(6).toString());
                pubs.add(e);
            }
            return true;
	}else{
            return false;
	}
    }
}
