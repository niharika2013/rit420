package DataLayer;

import java.util.*;

/**
 * The User class creates a data object representing a single tuple from the 
 * users table in the faculty activity database (484 project in this case).
 *
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 */
public class User {

    
    private MySQLDatabase myDB = new MySQLDatabase();

    private String userId;
    private String fName;
    private String lName;
    private String email;
    private String pswd;
    private String role;

    
    /**
     * User ID only constructor
     * @param userId 
     */
    
    public User(String userId) {  
        this.userId = userId; 
    }

    //User Login Credentials constuctor
    public User(String email, String pswd) {  
        this.email = email;
        this.pswd = pswd;
    }
    
    
     
    /**
     * Constructor with all fields as parameters.
     * 
     * @param userId
     * @param fName
     * @param lName
     * @param email
     * @param pswd
     * @param role 
     */
    
    public User(String userId, String fName, String lName, String email, String pswd, String role)	{
            this.userId = userId;
            this.fName = fName;
            this.lName = lName;
            this.email = email;
            this.pswd = pswd;
            this.role = role;
    }


     
     
    /**
     * gets all the data for a specific user ID, fills out the remaining
     * fields of this data object with those values.
     * 
     * @return
     * @throws DLException 
     */
    
    public boolean fetch() throws DLException {
        try{
            ArrayList<String> values = new ArrayList<>(0);
            values.add(userId);
            ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM users WHERE UserId = ?", values);
            if(dataList.size() > 1){                
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


    
    
    /**
     * updates the given user ID with new values according to the
     * fields of the present object
     * 
     * @return
     * @throws DLException 
     */
    
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


    
    
    
    /**
     * takes all the fields of the data object and inserts them into the 
     * database under the given UID
     * 
     * @return
     * @throws DLException 
     */
    
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


    
    /**
     * deletes the user with this Object UID from the database.
     * 
     * @return
     * @throws DLException 
     */
    
    public boolean delete() throws DLException {
    	try {
            ArrayList<String> values = new ArrayList<>(0);
            values.add(userId);
            myDB.setData("DELETE FROM users WHERE userID = ?", values);
            return true;
        } catch(Exception e) {
            throw new DLException(e);
        }
    }
    
    /**
     * 
     * 
     * @return String
     */
    @Override
    public String toString(){
        return "userId: " + userId + "\nfname: " + fName + "\nlname: " + lName + "\npswd: " + pswd + "\nemail: " + email + "\nrole: " + role;
    }

    
    /**
     * 
     * @param userId 
     */
    public void setUserId(String userId){this.userId = userId;}
    
    /**
     * 
     * @return 
     */
    public String getUserId(){return userId;}

    /**
     * 
     * @param fName 
     */
    public void setFName(String fName){this.fName = fName;}
    
    /**
     * 
     * @return 
     */
    public String getFName(){return fName;}

    /**
     * 
     * @param lName 
     */
    public void setLName(String lName){this.lName = lName;}
    
    /**
     * 
     * @return 
     */
    public String getLName(){return lName;}

    /**
     * 
     * @param email 
     */
    public void setEmail(String email){this.email = email;}
    
    /**
     * 
     * @return 
     */
    public String getEmail(){return email;}

    /**
     * 
     * @param pswd 
     */
    public void setPswd(String pswd){this.pswd = pswd;}
    
    /**
     * 
     * @return 
     */
    public String getPswd(){return pswd;} //ORLY?

    /**
     * 
     * @param role 
     */
    public void setRole(String role){this.role = role;}
    
    /**
     * 
     * @return 
     */
    public String getRole(){return role;}

}
