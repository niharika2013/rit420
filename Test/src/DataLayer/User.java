package DataLayer;


import java.util.*;

public class User {
    private String userId;
    private String fName;
    private String lName;
    private String email;
    private String pswd;
    private String role;
    private MySQLDatabase myDB;//db object instantiated as needed in methods below

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
            myDB = new MySQLDatabase();

            ArrayList<String> values = new ArrayList<>(0);
            values.add(userId);
            myDB.connect();
            ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM users WHERE UserId = ?", values);
            myDB.close();
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
    }


    //updates the given user ID with new values according to the
    //fields of the present object
    public boolean post() throws DLException {
            myDB = new MySQLDatabase();

            try{
                ArrayList<String> values = new ArrayList<>(0);

                values.add(userId);
                values.add(fName); 
                values.add(lName);
                values.add(email);
                values.add(pswd);
                values.add(role);
                myDB.connect();
                myDB.setData("UPDATE users FName = ?, LName = ?, Email = ?, Pswd = ?, Role = ? WHERE UserId = ?", values);
                myDB.close();
                return true;
            }
            catch(DLException e){
                return false;
            }
    }


    //takes all the fields of the data object and inserts them into the 
    //database under the given UID
    public boolean put(){
        myDB = new MySQLDatabase();

            try {
                    ArrayList<String> values = new ArrayList<>(0);
                    values.add(userId);
                    values.add(fName);
                    values.add(lName);
                    values.add(email);
                    values.add(pswd);
                    values.add(role);
                    myDB.connect();
                    myDB.setData("INSERT INTO users (UserId,FName,LName,Email,Pswd,Role) VALUES(?,?,?,?,?,?)", values);
                    myDB.close();

        return true;
    } catch(DLException e) {
        return false;
    }
}


    //deletes the user with this Object UID from the database.
    public boolean delete(){
        myDB = new MySQLDatabase();
    	try {
            ArrayList<String> values = new ArrayList<>(0);
            values.add(userId);
            myDB.connect();
            myDB.setData("DELETE FROM users WHERE userID = ?", values);
            myDB.close();
            return true;
        } catch(DLException e) {
            return false;
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