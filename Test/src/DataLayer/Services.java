package DataLayer;

import java.util.*;

/**
 * 
 * @author owen
 */

public class Services {

    private ArrayList<Service> services = new ArrayList<>(0);
    MySQLDatabase myDB = new MySQLDatabase();
   
    
    /**
     * 
     */
    public Services(){
    }
    
    
    /**
     * 
     * @return 
     */
    public ArrayList<Service> getServices() {
        return services;
    }
    
    
    /**
     * 
     * @param servicesList 
     */
    public void setServices(ArrayList<Service> servicesList) {
        services = servicesList;
    }
    
    
    /**
     * 
     * @return
     * @throws DLException 
     */
    public boolean fetch() throws DLException {
        ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM services", null);
        if(dataList != null) {
            for (int i = 1; i <= dataList.size(); i++){
                Service e = new Service(dataList.get(i).get(2).toString());
                e.setUserId(dataList.get(i).get(1).toString());
                e.setYear(dataList.get(i).get(3).toString());
                e.setDescription(dataList.get(i).get(4).toString());
                e.setRole(dataList.get(i).get(5).toString());
                services.add(e);
            }
            return true;
        } else {
            return false;
        }
    }
}
