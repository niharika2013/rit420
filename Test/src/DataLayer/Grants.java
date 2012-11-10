package DataLayer;

import java.util.*;

public class Grants {
    
    private ArrayList<Grant> grants = new ArrayList<Grant>(0);
    private MySQLDatabase myDB = new MySQLDatabase();

    public Grants() {}
    
    public ArrayList<Grant> getGrants() {
        return grants;
    }
    
    public void setGrants(ArrayList<Grant> grantsList) {
        grants = grantsList;
    }
    
    public boolean fetch() throws DLException {
        ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM grants", null);
	if(dataList != null) {
            for (int i = 1; i <= dataList.size(); i++) {
                Grant e = new Grant(dataList.get(i).get(2).toString());
                e.setUserId(dataList.get(i).get(1).toString());
                e.setYear(dataList.get(i).get(3).toString());
                e.setCitation(dataList.get(i).get(4).toString());
                e.setTease(dataList.get(i).get(5).toString());
                e.setAmount(dataList.get(i).get(6).toString());
                e.setStatus(dataList.get(i).get(7).toString());
                grants.add(e);
            }
            return true;
	} else {
	    return false;
        }
    }
}
