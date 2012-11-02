package DataLayer;

import java.sql.*;
import java.util.*;

public class MySQLDatabase{

	// Connection Data
	public Connection connection;
	private final String address = "jdbc:mysql://db4395955151.db.1and1.com";
	private final String userName = "dbo439595151";
	private final String password = "W3S4allBu1ldAD4t4b4se!!!";
	private final String driver = "com.mysql.jdbc.Driver";
	private Connection myConnection;
	
	public MySQLDatabase()
	{
	}
	
	public boolean connect(){
		try{
			Class.forName(driver).newInstance();
			this.myConnection = DriverManager.getConnection(address, userName, password);
			System.out.println("Connection sucessful!");
			return true;
		}
		catch(Exception e) {
			e.getMessage();
			System.out.println("Connection failed.");
			return false;
		}
	}
	
	public boolean close()
	{
		try
		{
			connection.close();
			System.out.println("Connection Closed");
			return true;
		}
		catch (SQLException e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	//Add	a	method	named	getData	that	accepts	an	SQL string	and	returns	a	2-d	ArrayList	(or	List	
	//if	using	.NET). This	will	be	used	for	doing	“SELECT”	sql	statements.
	public ArrayList<String> getData(String sql)
	{
		try
		{
			connect();
			//i. getData	should	perform	the	query	that	was	passed	in	
			Statement getData = connection.createStatement();
			ResultSet data = getData.executeQuery(sql);
			//then	convert	the ResultSet	(or	RecordSet)	into	a	simple	2-d	ArrayList	(or	List).
			ResultSetMetaData rsmd = data.getMetaData();
			int numCols = rsmd.getColumnCount();
			ArrayList<String> dataList = new ArrayList<String>();
			while (data.next()){
				//ii. The	first	row	in	the	ArrayList	should	be	the	column	names.	
				for (int i=1; i<=numCols; i++) {
					dataList.add(data.getString(i)); 
				}
			}
			close();
			return dataList;
		}
		//If the query	fails	to	run, return null.
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	//Add	a	method	named	setData	that	accepts	an	SQL	string	and	returns	a	Boolean.	This	will	be	
	//used	for	doing	“UPDATE”,	“DELETE”,	and	“INSERT”	operations.
	public boolean setData(String sql)
	{
		//i. setData	should	perform	the	query	that	was	passed.
		try
		{	
			connect();
			Statement statement = connection.createStatement();
			statement.execute(sql);
			close();
			return true;
		}
		//ii. If the query runs successfully, it should return true. Otherwise it should return false.
		catch (SQLException e)
		{
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	//Add a method named “prepare” that accepts an SQL string and an arraylist of string values
	public PreparedStatement prepare(String sql, ArrayList<String> values)
	{
		try
		{
			//prepares it
			PreparedStatement statement = connection.prepareStatement(sql);
			//binds the values
			for(int i = 1; i <= values.size(); i++)
			{
				statement.setString(i, values.get(i-1));
			}
			//returns a prepared statement
			return statement;
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	//Add a method named “getData” (in addition to one you already have) that accepts an SQL
	//string and an arraylist of string values.
	public ArrayList<ArrayList<String>> getData(String sql, ArrayList<String> values)
	{
		try
		{
			connect();
			//This method should call the “prepare” method
			PreparedStatement statement = prepare(sql, values);
			//execute the statement
			ResultSet data = statement.executeQuery();
			//return a 2d Arraylist. As with your other getData method, this getData method should 
			//convert the ResultSet into a simple 2d arrayList with the first row being the column names.
			ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>(0);
			ResultSetMetaData rsmd = data.getMetaData();
			int numCols = rsmd.getColumnCount();
			ArrayList<String> row = new ArrayList<String>(numCols);
			for (int j = 0; j < numCols; j++)
			{
				row.add(j, rsmd.getColumnName(j+1));
			}
			dataList.add(row);
			while (data.next())
			{
				row = new ArrayList<String>(numCols);
				for (int i = 1; i <= numCols; i++)
				{
					row.add(data.getString(i)); 
   			}
				dataList.add(row);
			}
			close();
			return dataList;
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	//Add a method named “setData” (in addition to one you already have) that accepts an SQL 
	//string and an arraylist of string values.
	public boolean setData(String sql, ArrayList<String> values)
	{
		try
		{
			connect();
			//This method should call the “prepare” method
			PreparedStatement statement = prepare(sql, values);
			//execute the statement
			statement.execute();
			//return a Boolean indicating success or failure of the query exection.
			close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	//Add a method named executeProc that accepts a string and an arraylist of string values
	//The string that is passed in should represent a stored procedure to be executed
	//Assume that the procedure returns a single integer value.
	public int executeProc(String storedProcedure, ArrayList<String> values)
	{
		try
		{
			connect();
			//Write code in executeProc so that the values are bound 
			CallableStatement statement = connection.prepareCall(storedProcedure);
			for(int i = 0; i < values.size(); i++)
			{ 
				statement.setString(i, values.get(i)); 
			}
			//the procedure is executed
			//Pass back any result from the stored procedure.
			statement.executeUpdate();
			close();
			return 1;
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			return 0;
		}
	}
	
	//Add methods “startTrans”, “endTrans”, and “rollbackTrans” that perform the obvious activities.
	public boolean startTrans()
	{
		try
		{
			connection.setAutoCommit(false);
			return true;
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public boolean endTrans()
	{
		try
		{
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public boolean rollbackTrans()
	{
		try
		{
			connection.rollback();
			return true;
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			return false;
		}
	}
}