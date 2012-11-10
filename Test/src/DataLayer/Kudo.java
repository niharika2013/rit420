package DataLayer;

import java.util.*;

public class Kudo {
	
        private MySQLDatabase myDB = new MySQLDatabase();

    	private String userId;
	private String kudoId;
	private String year;
	private String kudo;
    	
	public Kudo(){}
	
	public Kudo(String kudoId) {
		this.kudoId = kudoId;
	}
	
	public Kudo(String userId, String kudoId, String year, String kudo) {
		this.userId = userId;
		this.kudoId = kudoId;
		this.year = year;
		this.kudo = kudo;
	}
	
	
	// fetch	uses	the	object�s	kudoId	attribute	and	the	Database	class�	
	//getData	method	to	retrieve	the	database	values	for	that	particular	kudoId	
	//and	updates	the	object�s	attributes.
	public boolean fetch() throws DLException {
            try{    
                  ArrayList<String> values = new ArrayList<>(0);
                  values.add(kudoId);
                  ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM kudos WHERE KudoId = ?", values);
                  if(dataList != null) {
                          userId = dataList.get(1).get(1).toString();
                          kudoId = dataList.get(1).get(2).toString();
                          year = dataList.get(1).get(3).toString();
                          kudo = dataList.get(1).get(4).toString();
                          return true;
                  } else {
                          return false;
                  }
              } catch (Exception e){
                  throw new DLException(e);
              }    
	}
	
	// post updates the database values, for that object�s kudoId, using the	
	//object�s attribute values.
	public boolean post() throws DLException{
            try{
                ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId); 
		values.add(year);
		values.add(kudo);
		values.add(kudoId);
                myDB.setData("UPDATE kudos UserId = ?, year = ?, Kudo = ? WHERE KudoId = ?", values);
		return true;
            }catch(Exception e){
                throw new DLException(e);
            }
        }
	
	// put	inserts	the	object�s	attribute	values	into	the	database	as	a	new	record.
	public boolean put() throws DLException {
            try {
		ArrayList<String> values = new ArrayList<String>(0);
		values.add(userId);
		values.add(kudoId);
		values.add(year);
		values.add(kudo);
                myDB.setData("INSERT INTO kudos (UserId,KudoId,Year,Kudo) VALUES(?,?,?,?)", values);
		return true;
            } catch(Exception e) {
                   throw new DLException(e);
            }
        }
	
	// delete removes	from	the	database	any	data	corresponding	to	the	object�s kudoId.
	public boolean delete() throws DLException {
            try {
                    ArrayList<String> values = new ArrayList<String>(0);
                    values.add(kudoId);
                    myDB.setData("DELETE FROM kudos WHERE kudoID = ?", values);
                    return true;
            }   catch(Exception e) {
                throw new DLException(e);
            }
        }

        
    //paired getters and setters follow    
    public void setKudoId(String kudoId){this.kudoId = kudoId;}
    public String getKudoId(){return kudoId;}

    public void setUserId(String userId){this.userId = userId;}
    public String getUserId(){return userId;}

    public void setYear(String year){this.year = year;}
    public String getYear(){return year;}

    public void setKudo(String kudo){this.kudo = kudo;}
    public String getKudo(){return kudo;}

}
