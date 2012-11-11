package DataLayer;

import java.sql.*;
import java.util.*;

/**
 * 
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 */

public class MySQLDatabase{
  
    protected Connection connection;
    private final String ADDRESS = "jdbc:mysql://mysql.spoolishness.com/484project";
    private final String USER_NAME = "484user";
    private final String PASSWORD = "484password";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 
     * @return
     * @throws DLException 
     */
    public boolean connect() throws DLException {
        try {
            Class.forName(DRIVER).newInstance();
            this.connection = DriverManager.getConnection(ADDRESS, USER_NAME, PASSWORD);
            return true;
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e)
        {
            throw new DLException(e);
        }
    }

    /**
     * 
     * @return
     * @throws DLException 
     */
    public boolean close() throws DLException {
        try {
            connection.close();
            return true;
        }        
        catch(SQLException e)
        {
            throw new DLException(e);
        }//end catch
    }//end close

    
    //prepared statement method accepts a SQL string and the values to be 
    //bound to that string before query submission
    /**
     * 
     * @param sql
     * @param values
     * @return 
     */
    protected PreparedStatement prepare(String sql, ArrayList<String> values) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            for(int i = 1; i <= values.size(); i++) {
                //System.out.println("Setting data: " + values.get(i-1));
                statement.setString(i, values.get(i-1));
            }

            return statement;
        } catch(SQLException e) {
                e.printStackTrace();
            return null;
        }
    }

       
 
    /**
     * Calls the database with a prepared statement and accepts rows of data
     * 
     * @param sql
     * @param values
     * @return
     * @throws DLException 
     */
    protected ArrayList<ArrayList<String>> getData(String sql, ArrayList<String> values) throws DLException   {
        try {
            connect();

            PreparedStatement statement = prepare(sql, values);
            ResultSet data = statement.executeQuery();
           
            ArrayList<ArrayList<String>> dataList = new ArrayList<>(0);
           
            ResultSetMetaData rsmd = data.getMetaData();
            int numCols = rsmd.getColumnCount();
            
            ArrayList<String> row = new ArrayList<>(numCols);
            for (int j = 0; j < numCols; j++) {
                row.add(j, rsmd.getColumnName(j+1));
            }
            
            dataList.add(row);
            while (data.next()) {
                row = new ArrayList<>(numCols);
                for (int i = 1; i <= numCols; i++) {
                    //System.out.println(data.getString(i));
                    row.add(data.getString(i)); 
                }
                dataList.add(row);
            }

            close();
            
            return dataList;
        } catch(SQLException e){
            throw new DLException(e);
        }
    }
    
    /**
     * gets the data utilizing a non-prepared statement
     * 
     * @param sql
     * @return
     * @throws DLException 
     */
    protected ArrayList<ArrayList<String>> getData(String sql) throws DLException   {
        try {
            connect();

            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(sql);
           
            ArrayList<ArrayList<String>> dataList = new ArrayList<>(0);
           
            ResultSetMetaData rsmd = data.getMetaData();
            int numCols = rsmd.getColumnCount();
            
            ArrayList<String> row = new ArrayList<>(numCols);
            for (int j = 0; j < numCols; j++) {
                row.add(j, rsmd.getColumnName(j+1));
            }
            
            dataList.add(row);
            while (data.next()) {
                row = new ArrayList<>(numCols);
                for (int i = 1; i <= numCols; i++) {
                    //System.out.println(data.getString(i));
                    row.add(data.getString(i)); 
                }
                dataList.add(row);
            }

            close();
            
            return dataList;
        } catch(SQLException e){
            throw new DLException(e);
        }
    }

    
    //sends an update or insert statement to the database and returns a boolean 
    /**
     * 
     * @param sql
     * @param values
     * @return
     * @throws DLException 
     */
    protected boolean setData(String sql, ArrayList<String> values) throws DLException {
        PreparedStatement statement = null;
        
        try {
            connect();
            statement = this.prepare(sql, values);
            statement.execute();
            close();
            return true;
        } catch(SQLException e){
            System.err.print(e);
            return false;
        }
    }
    
    
    //transaction methods follow
   /**
    * 
    * @return
    * @throws DLException 
    */
    protected boolean startTrans() throws DLException {
        try {
            connection.setAutoCommit(false);
            return true;
        } catch(SQLException e) {
            throw new DLException(e);
        }
    }

    /**
     * 
     * @return
     * @throws DLException 
     */
    protected boolean endTrans() throws DLException {
        try {
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch(SQLException e) {
            throw new DLException(e);
        }
    }

    
    /**
     * 
     * @return
     * @throws DLException 
     */
    protected boolean rollbackTrans() throws DLException {
        try {
            connection.rollback();
            return true;
        } catch(SQLException e) {
            throw new DLException(e);
        }
    }
}//end class