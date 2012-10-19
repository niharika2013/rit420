import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class OracleDatabase{

	public Connection connection;
	private final String address = "jdbc:oracle:thin:@//homer/jobs";
	private final String userName = "endUser";
	private final String password = "useStuff";
	
	public OracleDatabase()
	{
	}
	
	public boolean connect()
	{
		try {
			//String driverName = "oracle.jdbc.OracleDriver";
    		//Class.forName(driverName);
			connection = DriverManager.getConnection(address, userName, password);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean close()
	{
		try {
			connection.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}