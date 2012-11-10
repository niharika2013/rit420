package DataLayer;

import java.util.*;

public class Kudos {
    
    private ArrayList<Kudo> kudos = new ArrayList<>(0);
    private MySQLDatabase myDB = new MySQLDatabase();
    
    public Kudos(){
    }
    
    public ArrayList<Kudo> getKudos() {
        return kudos;
    }
    
    public void setKudos(ArrayList<Kudo> kudosList) {
        kudos = kudosList;
    }
    
    public boolean fetch() throws DLException {
        ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM kudos", null);
	if(dataList != null) {
            for (int i = 1; i <= dataList.size(); i++) {
         	Kudo e = new Kudo(dataList.get(i).get(2).toString());
                e.setUserId(dataList.get(i).get(1).toString());
                e.setYear(dataList.get(i).get(3).toString());
                e.setKudo(dataList.get(i).get(4).toString());
                kudos.add(e);
            }
            return true;
	} else {
            return false;
	}
    }
}
