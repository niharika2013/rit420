package DataLayer;

import java.util.*;


public class Users {
    
    private ArrayList<User> users = new ArrayList<User>(0);
    private MySQLDatabase myDB = new MySQLDatabase();

    public Users() {
    }
    

    public ArrayList<User> getUsers() {
        return users;
    }
    

    public void setUsers(ArrayList<User> usersList) {
        users = usersList;
    }
    

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
