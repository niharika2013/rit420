package DataLayer;

import java.util.*;

/**
 * The Grants class creates a data object representing multiple rows/tuples
 * from the 'grants' table of the faculty activity database (484 project in this case).
 * 
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 */
public class Grants {
    
    private ArrayList<Grant> grants = new ArrayList<>(0);
    private MySQLDatabase myDB = new MySQLDatabase();

   /**
    * Explicit default constructor for grants does nothing.
    */
    public Grants() {}
    
    /**
     * This method returns an arrayList containing the values from this
     * data object's grants field.
     * 
     * @return arraylist of Grant objects 
     */
    public ArrayList<Grant> getGrants() {
        return grants;
    }
   
    /**
     * This method accepts an arrayList of Grant objects and sets this
     * data object's value.
     * 
     * @param grantsList 
     */
    public void setGrants(ArrayList<Grant> grantsList) {
        grants = grantsList;
    }
    
    /**
     * This method retrieves all entries from the grants table of the faculty
     * activity database, and stores those rows in this data object's 'grants'
     * field.
     * 
     * @return boolean indicating presence of data.
     * @throws DLException 
     */
    public boolean fetch() throws DLException {
        ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM grants", null);
	if(dataList.size() > 1) {
            for (int i = 1; i <= dataList.size(); i++) {
                Grant e = new Grant(dataList.get(i).get(2).toString());
                e.setUserId(dataList.get(i).get(1).toString());
                e.setYear(dataList.get(i).get(3).toString());
                e.setCitation(dataList.get(i).get(4).toString());
                e.setTease(dataList.get(i).get(5).toString());
                e.setAmount(dataList.get(i).get(6).toString());
                e.setStatus(dataList.get(i).get(7).toString());
                grants.add(e);
            }
            return true;
	} else {
	    return false;
        }
    }
}
