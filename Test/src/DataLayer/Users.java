package DataLayer;

import java.util.*;

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
     * 
     */
    public Users() {}
    

    /**
     * 
     * @return 
     */
    public ArrayList<User> getUsers() {
        return users;
    }
    

    /**
     * 
     * @param usersList 
     */
    public void setUsers(ArrayList<User> usersList) {
        users = usersList;
    }
    

    /**
     * 
     * @return
     * @throws DLException 
     */
    public boolean fetch() throws DLException {
        ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM users", null);
        if(dataList != null) {
            for (int i = 1; i <= dataList.size(); i++) {
                User e = new User(dataList.get(i).get(1).toString());
                e.setFName(dataList.get(i).get(2).toString());
                e.setLName(dataList.get(i).get(3).toString());
                e.setEmail(dataList.get(i).get(4).toString());
                e.setPswd(dataList.get(i).get(5).toString());
                e.setRole(dataList.get(i).get(6).toString());
                users.add(e);
            }
            return true;
         } else {
            return false;
	 }
     }
}
