package DataLayer;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Anthony Gentile
 */

public class Users {
    
	 // Array of all users
    private ArrayList<User> users = new ArrayList<User>(0);
    
	 // Default Constructor
    public Users()
    {
    }
    
	 // Getter
    public ArrayList<User> getUsers()
    {
        return users;
    }
    
	 // Setter
    public void setUsers(ArrayList<User> usersList)
    {
        users = usersList;
    }
    
	 // Get all the users and basic details
    public boolean fetch()
    {
        ArrayList<ArrayList<String>> dataList = JavaConnection.mdb.getData("SELECT * FROM users", null);
        if(dataList != null)
        {
      	for (int i = 1; i <= dataList.size(); i++)
         {
            User e = new User(dataList.get(i).get(1).toString());
            e.setFName(dataList.get(i).get(2).toString());
            e.setLName(dataList.get(i).get(3).toString());
            e.setEmail(dataList.get(i).get(4).toString());
            e.setPswd(dataList.get(i).get(5).toString());
            e.setRole(dataList.get(i).get(6).toString());
            users.add(e);
         }
         return true;
		}
		else
		{
			return false;
		}
   }
}
