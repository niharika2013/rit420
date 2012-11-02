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

public class Pubs {
    
	 // Array of all pubs
    private ArrayList<Pub> pubs = new ArrayList<Pub>(0);
    
	 // Default Constructor
    public Pubs()
    {
    }
    
	 // Getter
    public ArrayList<Pub> getPubs()
    {
        return pubs;
    }
    
	 // Setter
    public void setPubs(ArrayList<Pub> pubsList)
    {
        pubs = pubsList;
    }
    
	 // Get all the pubs and basic details
    public boolean fetch()
    {
		ArrayList<ArrayList<String>> dataList = JavaConnection.mdb.getData("SELECT * FROM pubs");
		if(dataList != null)
		{
      	for (int i = 1; i <= dataList.size(); i++)
         {
         	Pub e = new Pub(dataList.get(i).get(2).toString());
            e.setUserId(dataList.get(i).get(1).toString());
				e.setYear(dataList.get(i).get(3).toString());
				e.setCitation(dataList.get(i).get(4).toString());
				e.setTease(dataList.get(i).get(5).toString());
				e.setStatus(dataList.get(i).get(6).toString());
            pubs.add(e);
         }
         return true;
		}
		else
		{
			return false;
		}
   }
}
