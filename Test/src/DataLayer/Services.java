package DataLayer;

import java.util.*;

/**
 * The Services class creates a data object representing multiple rows/tuples
 * from the services table of the faculty activity database (484 project in this case).
 * 
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 */

public class Services {

    private ArrayList<Service> services = new ArrayList<>(0);
    MySQLDatabase myDB = new MySQLDatabase();
   
    
    /**
     * Explicit default constructor for Services don't do nuthin.
     */
    public Services(){
        try {
            fetch();
        } catch (DLException ex) {
            
        }
    }
    
    
    /**
     * This method returns an arraylist of service objects from the services 
     * attribute of this data object.
     * 
     * @return arraylist of Service objects.
     */
    public ArrayList<Service> getServices() {
        return services;
    }
    
    
    /**
     * This method accepts an arraylist of Service objects, and updates this data
     * object's services attribute to match.
     * 
     * @param servicesList 
     */
    public void setServices(ArrayList<Service> servicesList) {
        services = servicesList;
    }
    
    
    /**
     * This retrieves all the rows from the services table and stores them in
     * this data object's services attribute
     * 
     * @return boolean indicating success.
     * @throws DLException 
     */
    public boolean fetch() throws DLException {
        ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT userId, serviceId, year, description, role FROM services");
        if(dataList.size() > 1) {
            for (int i = 1; i <= dataList.size() - 1; i++){
                Service e = new Service(dataList.get(i).get(1).toString());
                e.setUserId(     dataList.get(i).get(0).toString());
                e.setYear(       dataList.get(i).get(2).toString());
                e.setDescription(dataList.get(i).get(3).toString());
                e.setRole(       dataList.get(i).get(4).toString());
                services.add(e);
            }
            return true;
        } else {
            return false;
        }
    }
}
