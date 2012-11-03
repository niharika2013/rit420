package DataLayer;

import java.io.*;
import java.util.*;
import java.sql.Timestamp;

public class DLException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	
	ArrayList<ArrayList<String>> eList = new ArrayList<ArrayList<String>>();
	Exception ex;
	
	public DLException(Exception e){
		this.ex = e;
		populateList();
	}
	
	private void populateList(){
		if(ex.getStackTrace() != null){
			StackTraceElement[] trace = ex.getStackTrace();
			ArrayList<String> traceList = new ArrayList<String>();
			for (StackTraceElement element: trace){
				traceList.add(element.toString());
			}
			eList.add(traceList);
		}
	}
	
	public DLException(Exception e, ArrayList<ArrayList<String>> eList){
		this.ex = e;
		this.eList = eList;
		populateList();
	}
	
	// Provide	a method named “log” that writes out any available information,
    //including a timestamp, to a text file.
    public void log()
    {
        try
        {
            java.util.Date today = new java.util.Date();
            Timestamp t = new Timestamp(today.getTime());
            PrintWriter pw = new PrintWriter(new FileOutputStream("Log", true));
            pw.format("Timestamp of error: " + t +"\n");
            printStackTrace(pw);
            pw.close();
        }
        catch(Exception ex)
        {
            //If you hit this, nothing is ever logged
        }
    }
}
