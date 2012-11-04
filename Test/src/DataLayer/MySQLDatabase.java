package DataLayer;

import java.sql.*;
import java.util.*;

public class MySQLDatabase{
    
    // Rather important for Data Layer objects

    // Connection Data
    protected Connection connection;
    private final String address = "jdbc:mysql://mysql.spoolishness.com/484project";
    private final String userName = "484user";
    private final String password = "484password";
    private final String driver = "com.mysql.jdbc.Driver";

    public boolean connect() throws DLException {
        try
        {
            
            Class.forName(driver).newInstance();
            System.out.println("Attempting Connection");
            this.connection = DriverManager.getConnection(address, userName, password);
            
            return true;
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e)
        {
            System.out.println("Connection failed");
            System.err.println(e.getMessage());
            throw new DLException(e);
        }
    }

    protected boolean close() {
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
    //if	using	.NET). This	will	be	used	for	doing	�SELECT�	sql	statements.
    protected ArrayList<String> getData(String sql) throws DLException  {
        try {
            connect();
            //i. getData	should	perform	the	query	that	was	passed	in	
            Statement getData = connection.createStatement();
            ResultSet data = getData.executeQuery(sql);
            //then	convert	the ResultSet	(or	RecordSet)	into	a	simple	2-d	ArrayList	(or	List).
            ResultSetMetaData rsmd = data.getMetaData();
            int numCols = rsmd.getColumnCount();
            ArrayList<String> dataList = new ArrayList<String>();
            while (data.next())
            {
                //ii. The	first	row	in	the	ArrayList	should	be	the	column	names.	
                for (int i=1; i<=numCols; i++)
                {
                    System.out.println(data.getString(i));
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
            throw new DLException(e);
        }
    }

    //Add	a	method	named	setData	that	accepts	an	SQL	string	and	returns	a	Boolean.	This	will	be	
    //used	for	doing	�UPDATE�,	�DELETE�,	and	�INSERT�	operations.
    protected boolean setData(String sql) throws DLException {
        //i. setData	should	perform	the	query	that	was	passed.
        try {	
            connect();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            close();
            return true;
        }
        //ii. If the query runs successfully, it should return true. Otherwise it should return false.
        catch (SQLException e)
        {
            throw new DLException(e);
        }
    }

    //Add a method named �prepare� that accepts an SQL string and an arraylist of string values
    protected PreparedStatement prepare(String sql, ArrayList<String> values)   {
        try {
            //prepares it
            PreparedStatement statement = connection.prepareStatement(sql);
            //binds the values
            for(int i = 1; i <= values.size(); i++) {
                System.out.println("Setting data: " + values.get(i-1));
                statement.setString(i, values.get(i-1));
            }
            //returns a prepared statement
            return statement;
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //Add a method named �getData� (in addition to one you already have) that accepts an SQL
    //string and an arraylist of string values.
    protected ArrayList<ArrayList<String>> getData(String sql, ArrayList<String> values) throws DLException   {
        try {
            System.out.println("Attempting to get data...");
            PreparedStatement statement = prepare(sql, values);
            ResultSet data = statement.executeQuery();
            
            ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>(0);
            ResultSetMetaData rsmd = data.getMetaData();
            int numCols = rsmd.getColumnCount();
            ArrayList<String> row = new ArrayList<String>(numCols);
            for (int j = 0; j < numCols; j++) {
                row.add(j, rsmd.getColumnName(j+1));
            }
            dataList.add(row);
            while (data.next()) {
                row = new ArrayList<String>(numCols);
                for (int i = 1; i <= numCols; i++) {
                    System.out.println(data.getString(i));
                    row.add(data.getString(i)); 
                }
                dataList.add(row);
            }
            return dataList;
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            throw new DLException(e);
        }
    }

    //Add a method named �setData� (in addition to one you already have) that accepts an SQL 
    //string and an arraylist of string values.
    protected boolean setData(String sql, ArrayList<String> values) throws DLException   {
        PreparedStatement statement = null;
        
        try {
            statement = this.prepare(sql, values);
            statement.execute();
            return true;
        }
        catch(SQLException e){
            System.err.print(e);
            return false;
        }
    }
   
    //Add a method named executeProc that accepts a string and an arraylist of string values
    //The string that is passed in should represent a stored procedure to be executed
    //Assume that the procedure returns a single integer value.
    protected int executeProc(String storedProcedure, ArrayList<String> values) throws DLException
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
        catch(Exception e)
        {
            throw new DLException(e);
        }
    }

    //Add methods �startTrans�, �endTrans�, and �rollbackTrans� that perform the obvious activities.
    protected boolean startTrans() throws DLException
    {
        try
        {
            connection.setAutoCommit(false);
            return true;
        }
        catch(SQLException e)
        {
            throw new DLException(e);
        }
    }

    protected boolean endTrans() throws DLException
    {
        try
        {
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }
        catch(SQLException e)
        {
            throw new DLException(e);
        }
    }

    protected boolean rollbackTrans() throws DLException
    {
        try
        {
            connection.rollback();
            return true;
        }
        catch(SQLException e)
        {
            throw new DLException(e);
        }
    }
}