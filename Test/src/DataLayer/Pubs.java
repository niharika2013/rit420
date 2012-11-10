package DataLayer;

import java.util.*;

/**
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
     * 
     */
    public Pubs() {}
    
    
    /**
     * 
     * @return 
     */
    public ArrayList<Pub> getPubs() {
        return pubs;
    }
    
    /**
     * 
     * @param pubsList 
     */
    public void setPubs(ArrayList<Pub> pubsList) {
        pubs = pubsList;
    }
    
    /**
     * 
     * @return
     * @throws DLException 
     */
    public boolean fetch() throws DLException {
	ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM pubs", null);
	if(dataList != null){
            for (int i = 1; i <= dataList.size(); i++){
                Pub e = new Pub(dataList.get(i).get(2).toString());
                e.setUserId(dataList.get(i).get(1).toString());
                e.setYear(dataList.get(i).get(3).toString());
                e.setCitation(dataList.get(i).get(4).toString());
                e.setTease(dataList.get(i).get(5).toString());
                e.setStatus(dataList.get(i).get(6).toString());
                pubs.add(e);
            }
            return true;
	}else{
            return false;
	}
    }
}
