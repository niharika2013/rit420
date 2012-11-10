package DataLayer;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class DLException extends Exception {

	private static final long serialVersionUID = 1L;	
	ArrayList<ArrayList<String>> eList = new ArrayList<>();
	Exception ex;
	
	public DLException(Exception e){
		this.ex = e;
		populateList();
	}

	public DLException(Exception e, ArrayList<ArrayList<String>> eList){
		this.ex = e;
		this.eList = eList;
		populateList();
	}
	
	private void populateList(){
		if(ex.getStackTrace() != null){
			StackTraceElement[] trace = ex.getStackTrace();
			ArrayList<String> traceList = new ArrayList<>();
			for (StackTraceElement element: trace){
				traceList.add(element.toString());
			}//end for
			eList.add(traceList);
		}//end if
	}//end populateList
	
	public void log(){
		try{
			Writer logger = new FileWriter(new File("log.txt"));
			for (int i = 0; i<= eList.size() - 1; i++){
				for(int j = 0; j<= eList.get(i).size() - 1; j++){
					java.util.Date date= new java.util.Date();
					logger.write(new Timestamp(date.getTime()).toString());
					logger.write(eList.get(i).get(j));
					logger.flush();
				}//end inner for
			}//end outer for
			logger.close();
		} catch(IOException e){	}//end catch
	}//end log
}//end class
