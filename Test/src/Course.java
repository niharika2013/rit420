import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Course
{
	//a. Provide	attributes	that	mirror	the	Equipment	table.
	private String equipID;
	private String equipmentName;
	private String equipmentDescription;
	private String equipmentCapacity;
	
	//b. Provide	a	default	constructor.
	public Course()
	{
	}
	
	//c. Provide	a	constructor	that	accepts	and	sets	the	equipmentId.
	public Course(String equipID)
	{
		this.equipID = equipID;
	}
	
	//d. Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Course(String equipID, String equipmentName, String equipmentDescription, String equipmentCapacity)
	{
		this.equipID = equipID;
		this.equipmentName = equipmentName;
		this.equipmentDescription = equipmentDescription;
		this.equipmentCapacity = equipmentCapacity;
	}
	
	//e. Provide	accessors	and	mutators	for	all	attributes.
	public void setEquipID(String equipID){this.equipID = equipID;}
	public String getEquipID(){return equipID;}
	
	public void setEquipmentName(String equipmentName){this.equipmentName = equipmentName;}
	public String getEquipmentName(){return equipmentName;}
	
	public void setEquipmentDescription(String equipmentDescription){this.equipmentDescription = equipmentDescription;}
	public String getEquipmentDescription(){return equipmentDescription;}
	
	public void setEquipmentCapacity(String equipmentCapacity){this.equipmentCapacity = equipmentCapacity;}
	public String getEquipmentCapacity(){return equipmentCapacity;}

	//f. Provide	a	public	methods	named	“fetch”,	“put”,	“post”,	and	“delete”.	These	methods	will	
	//interact	between	the	object’s	attributes	and	the	database	values	(using	the	database	class).

	//Change the fetch, put, post, and delete methods to use the new getData() and setData() 
	//methods of the database class.
	
	public boolean fetch()
	{
		//i. fetch	will	that	use	the	object’s	equipmentId	attribute	and	the	Database	class’	
		//getData	method	to	retrieve	the	database	values	for	that	particular	equipmentId	
		//and	update	the	object’s	attributes.
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(equipID);
		ArrayList<ArrayList<String>> dataList = JavaConnection.mdb.getData("SELECT * FROM equipment WHERE EquipID = ?", values);
		if(dataList != null)
		{
			equipmentName = dataList.get(1).get(1).toString();
			equipmentDescription = dataList.get(1).get(2).toString();
			equipmentCapacity = dataList.get(1).get(3).toString();
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean post()
	{
		//ii. post will update the database values, for that object’s equipmentId, using the	
		//object’s attribute values.
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(equipID);
		values.add(equipmentName); 
		values.add(equipmentDescription);
		values.add(equipmentCapacity);
		values.add(equipID);
		return JavaConnection.mdb.setData("UPDATE equipment SET EquipID = ?, EquipmentName = ?, EquipmentDescription = ?, EquipmentCapacity = ? WHERE EquipID = ?", values);
	}
	
	public boolean put()
	{
		//iii. put	will	insert	the	object’s	attribute	values	into	the	database	as	a	new	record.
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(equipID);
		values.add(equipmentName);
		values.add(equipmentDescription);
		values.add(equipmentCapacity);
		return JavaConnection.mdb.setData("INSERT INTO equipment (EquipID,EquipmentName,EquipmentDescription,EquipmentCapacity) VALUES(?,?,?,?)", values);
	}
	
	//iv. delete	will	remove	from	the	database	any	data	corresponding	to	the	object’s equipmentId.
	public boolean delete()
	{
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(equipID);
		return JavaConnection.mdb.setData("DELETE FROM equipment WHERE EquipID = ?", values);
	}
	
	//Add a method named “swap” that accepts an integer value.
	public boolean swap(int id)
	{
		//The purpose of this method is to  swap the names of two pieces of equipment
		//One equipment piece is represented by the  object
		//the other is identified by the integer value passed in
		//Because this involves more than one SQL operation it should be done as a transaction
		try
		{
			if(JavaConnection.mdb.startTrans())
			{
				//sql
				String name = equipmentName;
				Equipment switchEquipment = new Equipment(Integer.toString(id));
				switchEquipment.fetch();
				setEquipmentName(switchEquipment.getEquipmentName());
				switchEquipment.setEquipmentName(name);
				post();
				switchEquipment.post();
				if(JavaConnection.mdb.endTrans())
				{
					return true;
				}
				else
				{
					JavaConnection.mdb.rollbackTrans();
					return false;
				}
			}
			else
			{
				JavaConnection.mdb.rollbackTrans();
				return false;
			}
		}
		catch(Exception e)
		{
			JavaConnection.mdb.rollbackTrans();
			return false;
		}
	}
}