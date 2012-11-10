package DataLayer;

import java.util.*;

/**
 * The Kudos class creates a data object representing multiple rows/tuples
 * from the 'kudos' table of the faculty activity database (484 project in this case).
 * 
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 */
public class Kudos {
    
    private ArrayList<Kudo> kudos = new ArrayList<>(0);
    private MySQLDatabase myDB = new MySQLDatabase();
   
    /**
     * Explicit default constructor for Kudos, does nothing!
     */
    public Kudos(){
    }
    
    /**
     * This method returns an ArrayList of Kudos from this data object's kudos
     * field.
     * 
     * @return arraylist of kudo objects. 
     */
    public ArrayList<Kudo> getKudos() {
        return kudos;
    }
   
    /**
     * This method accepts an arraylist of Kudo objects, and sets this object's
     * kudosList field.
     * 
     * 
     * @param kudosList 
     */
    public void setKudos(ArrayList<Kudo> kudosList) {
        kudos = kudosList;
    } 
    
    /**
     * This method queries the kudos table of the faculty activity database and
     * stores the resulting values in the kudos field of this data object.
     * 
     * @return boolean indicating success
     * @throws DLException 
     */
    public boolean fetch() throws DLException {
        ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM kudos", null);
	if(dataList.size() > 1) {
            for (int i = 1; i <= dataList.size(); i++) {
         	Kudo e = new Kudo(dataList.get(i).get(2).toString());
                e.setUserId(dataList.get(i).get(1).toString());
                e.setYear(dataList.get(i).get(3).toString());
                e.setKudo(dataList.get(i).get(4).toString());
                kudos.add(e);
            }
            return true;
	} else {
            return false;
	}
    }
}
