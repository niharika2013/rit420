package DataLayer;

import java.util.*;

public class User {

    private MySQLDatabase myDB = new MySQLDatabase();

    private String userId;
    private String fName;
    private String lName;
    private String email;
    private String pswd;
    private String role;

    //User ID only constuctor
    public User(String userId) {  
            this.userId = userId; 
    }


    //Constructor with all fields as parameters.
    public User(String userId, String fName, String lName, String email, String pswd, String role)	{
            this.userId = userId;
            this.fName = fName;
            this.lName = lName;
            this.email = email;
            this.pswd = pswd;
            this.role = role;
    }


    // gets all the data for a specific user ID, fills out the remaining
    // fields of this data object with those values.
    public boolean fetch() throws DLException {
        try{    
            ArrayList<String> values = new ArrayList<>(0);
            values.add(userId);
            ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM users WHERE UserId = ?", values);
            if(dataList != null){                
                    fName = dataList.get(1).get(1).toString();
                    lName = dataList.get(1).get(2).toString();
                    email = dataList.get(1).get(3).toString();
                    pswd = dataList.get(1).get(4).toString();
                    role = dataList.get(1).get(5).toString();
                    return true;
            } else {
                    return false;
            }
        } catch (Exception e){
            throw new DLException(e);
        }
    }


    //updates the given user ID with new values according to the
    //fields of the present object
    public boolean post() throws DLException {
        try{
            ArrayList<String> values = new ArrayList<>(0);
            values.add(userId);
            values.add(fName); 
            values.add(lName);
            values.add(email);
            values.add(pswd);
            values.add(role);
            myDB.setData("UPDATE users FName = ?, LName = ?, Email = ?, Pswd = ?, Role = ? WHERE UserId = ?", values);
            return true;
        } catch(Exception e){
            throw new DLException(e);
        }
    }


    //takes all the fields of the data object and inserts them into the 
    //database under the given UID
    public boolean put() throws DLException{
        try {
            ArrayList<String> values = new ArrayList<>(0);
            values.add(userId);
            values.add(fName);
            values.add(lName);
            values.add(email);
            values.add(pswd);
            values.add(role);
            myDB.setData("INSERT INTO users (UserId,FName,LName,Email,Pswd,Role) VALUES(?,?,?,?,?,?)", values);
            return true;
        } catch(Exception e) {
            throw new DLException(e);
        }
    }


    //deletes the user with this Object UID from the database.
    public boolean delete(){
    	try {
            ArrayList<String> values = new ArrayList<>(0);
            values.add(userId);
            myDB.setData("DELETE FROM users WHERE userID = ?", values);
            return true;
        } catch(Exception e) {
            throw new DLException(e);
        }
    }
    
    

    
    //paired getters and setters follow
    public void setUserId(String userId){this.userId = userId;}
    public String getUserId(){return userId;}

    public void setFName(String fName){this.fName = fName;}
    public String getFName(){return fName;}

    public void setLName(String lName){this.lName = lName;}
    public String getLName(){return lName;}

    public void setEmail(String email){this.email = email;}
    public String getEmail(){return email;}

    public void setPswd(String pswd){this.pswd = pswd;}
    public String getPswd(){return pswd;} //ORLY?

    public void setRole(String role){this.role = role;}
    public String getRole(){return role;}

}