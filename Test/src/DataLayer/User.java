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

    /**
     * User Login Credentials constuctor
     * @param email
     * @param pswd
     */
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
    public boolean fetch() throws DLException{
        try{
            ArrayList<String> values = new ArrayList<>(0);
            values.add(userId);
            ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM users WHERE UserId = ?", values);
            System.out.println();
            if(dataList.size() > 1){                
                    fName = dataList.get(1).get(1).toString();
                    lName = dataList.get(1).get(2).toString();
                    email = dataList.get(1).get(3).toString();
                    //pswd = dataList.get(1).get(4).toString();
                    role = dataList.get(1).get(5).toString();
                    return true;
            } else {
                    return false;
            }
        } catch (Exception e){
             e.printStackTrace();
             throw new DLException(e);
        }
    }
    
    /**
     * Checks the email and password input by the user against the database. 
     * 
     * @return boolean indicates user/password combination exists in database.
     * @throws DLException 
     */
    public boolean login() throws DLException{
        try{
            ArrayList<String> values = new ArrayList<>(0);
            values.add(email);
            values.add(pswd);
            ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT UserId, FName, LName, Role FROM users WHERE Email = ? AND Pswd = ?", values);
            if(dataList.size() > 1){
                    userId = dataList.get(1).get(0).toString(); 
                    fName = dataList.get(1).get(1).toString();
                    lName = dataList.get(1).get(2).toString();
                    role = dataList.get(1).get(3).toString();
                    return true;
            } else {
                    return false;
            }
        } catch (Exception e){
             e.printStackTrace();
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
            JEncryption encrypter = new JEncryption();
            //Adam's comment
            String encryptedPassword = new  String(encrypter.encrypt(pswd.toCharArray().toString()));
            values.add(encryptedPassword);
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
            JEncryption encrypter = new JEncryption();
            //Adam's comment
            String encryptedPassword = new  String(encrypter.encrypt(pswd.toCharArray().toString()));
            values.add(encryptedPassword);
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
     * Override with custom toString()
     * 
     * @return String
     */

    @Override
    public String toString(){
        return "userId: " + userId + "\nfname: " + fName + "\nlname: " + lName + "\npswd: " + pswd + "\nemail: " + email + "\nrole: " + role;
    }

    
    /**
     * Mutator method for userId
     * 
     * @param userId 
     */
    public void setUserId(String userId){this.userId = userId;}
    
    /**
     * Accessor method for userId
     * @return String value of userId
     */
    public String getUserId(){return userId;}

    /**
     * Mutator method for fName
     * @param fName 
     */
    public void setFName(String fName){this.fName = fName;}
    
    /**
     * Accessor method for fname
     * @return String value of fName
     */
    public String getFName(){return fName;}

    /**
     * Mutator method for lName
     * @param lName 
     */
    public void setLName(String lName){this.lName = lName;}
    
    /**
     * Accessor method for  lName
     * @return String value of lName
     */
    public String getLName(){return lName;}

    /**
     * Mutator method for email
     * @param email 
     */
    public void setEmail(String email){this.email = email;}
    
    /**
     * Accessor method for email
     * @return String value of email
     */
    public String getEmail(){return email;}

    /**
     * Mutator method for pswd
     * @param pswd 
     */
    public void setPswd(String pswd){this.pswd = pswd;}
    
    /**
     * Accessor method for pswd
     * @return String value of pswd
     */
    public String getPswd(){return pswd;} //ORLY?

    /**
     * Mutator method for role
     * @param role 
     */
    public void setRole(String role){this.role = role;}
    
    /**
     * Accessor method for role
     * @return String value of role
     */
    public String getRole(){return role;}

}
