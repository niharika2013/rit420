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

public class Kudos {
    
	 // Array of all kudos
    private ArrayList<Kudo> kudos = new ArrayList<Kudo>(0);
    
	 // Default Constructor
    public Kudos()
    {
    }
    
	 // Getter
    public ArrayList<Kudo> getKudos()
    {
        return kudos;
    }
    
	 // Setter
    public void setKudos(ArrayList<Kudo> kudosList)
    {
        kudos = kudosList;
    }
    
	 // Get all the kudos and basic details
    public boolean fetch() throws DLException
    {
		ArrayList<ArrayList<String>> dataList = JavaConnection.mdb.getData("SELECT * FROM kudos", null);
		if(dataList != null)
		{
      	for (int i = 1; i <= dataList.size(); i++)
         {
         	Kudo e = new Kudo(dataList.get(i).get(2).toString());
            e.setUserId(dataList.get(i).get(1).toString());
				e.setYear(dataList.get(i).get(3).toString());
				e.setKudo(dataList.get(i).get(4).toString());
            kudos.add(e);
         }
         return true;
		}
		else
		{
			return false;
		}
   }
}
