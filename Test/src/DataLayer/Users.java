package DataLayer;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Users class creates a data object representing multiple rows/tuples
 * from the 'users' table of the faculty activity database (484 project in this case).
 * 
 * 
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 */
public class Users {
  
    private ArrayList<User> users = new ArrayList<>(0);
    private MySQLDatabase myDB = new MySQLDatabase();

    
    /**
     * Explicit default constructor does nothing.
     */
    public Users() {
        try {
            fetch();
        } catch (DLException ex) {
            //System.err.println(ex);
        }
    }
    

    /**
     * This method returns an arraylist representing multiple rows 
     * selected from the database
     * 
     * @return an arrayList of User Objects
     */
    public ArrayList<User> getUsers() {
        return users;
    }
    

    /**
     * This method accepts an arraylist representing one or more rows
     * to be inserted into the database
     * 
     * @param usersList an arraylist of User objects
     */
    public void setUsers(ArrayList<User> usersList) {
        users = usersList;
    }
    

    /**
     * This method retrieves all rows from the Users table in the database,
     * and stores the resulting arraylist in the corresponding field of this
     * Users data object.
     * 
     * @return boolean value indicates whether table contains any data.
     * @throws DLException 
     */
    public boolean fetch() throws DLException {
        ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT userId, fName, lName, email, pswd, role FROM users");
        if(dataList.size() > 1) {
            for (int i = 1; i <= dataList.size() - 1; i++) {                
                User e = new User(dataList.get(i).get(0).toString());
                e.setFName( dataList.get(i).get(1).toString());
                e.setLName( dataList.get(i).get(2).toString());
                e.setEmail( dataList.get(i).get(3).toString());
                e.setPswd(  dataList.get(i).get(4).toString());
                e.setRole(  dataList.get(i).get(5).toString());
                users.add(e);
                //System.out.println(e.toString());
            }
            return true;
         } else {
            return false;
	 }
     }
}
