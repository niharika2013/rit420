import DataLayer.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This test class contains methods to test the methods of 
 * each data object.
 * 
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell
 * 
 */
public class Test_Main {

    public static void main(String[] args){
        
    	//testDatabase(); //works
    	//testUserFetch(); //works
        //testUserDelete(); //works 
        //testUserPut(); //works
        //testUserPost(); //works
        //System.out.println("runing");
        //setNewPasswords();
    }

    public static void setNewPasswords(){
        User u = new User("12");
        User i = new User("13");
        User d = new User("14");
        

        try {          
            u.fetch();
            i.fetch();
            d.fetch();

            
            u.setPswd(u.saltHash( u.getPswd()) );
            System.out.println(u.getPswd() );

            i.setPswd(i.saltHash( i.getPswd()) );
            d.setPswd(d.saltHash( d.getPswd()) );

            u.post();
            i.post();
            d.post();
        } catch (DLException ex) {
            Logger.getLogger(Test_Main.class.getName()).log(Level.SEVERE, null, ex);
       
            System.out.println("hey!");
        }
        

    }
    
    public static void testDatabase(){
    	MySQLDatabase db = new MySQLDatabase();
    	
    	try {
    		System.out.println("Connection: "+ db.connect()) ;
    		System.out.println("Closed: "+ db.close()) ;
    	} catch (DLException DLE){
    		System.out.println(DLE);
    	}
    } 
    
    public static void testUserPost(){
        
        User testUser = new User("","xxx","Lucifer","Morningstar","webmaster@aol.com","3");
        
        try{
            testUser.post();
            testUser = new User("6");
            testUser.fetch();
        } catch (Exception e){
            System.err.print(e);
        }
        
        System.out.println("UserId: "+testUser.getUserId());
        System.out.println("FirstName: "+testUser.getFName());
        System.out.println("LastName: "+testUser.getLName());
        System.out.println("Email: "+testUser.getEmail());
        System.out.println("Password: "+testUser.getPswd());
        System.out.println("Role: "+testUser.getRole());  
    } 
    
    public static void testUserFetch(){
        User testUser = new User("2");
       
        try{
            testUser.fetch();
        } catch (Exception e){
            System.err.print(e);
        }
        
        System.out.println("UserId: "+testUser.getUserId());
        System.out.println("FirstName: "+testUser.getFName());
        System.out.println("LastName: "+testUser.getLName());
        System.out.println("Email: "+testUser.getEmail());
        System.out.println("Password: "+testUser.getPswd());
        System.out.println("Role: "+testUser.getRole());  
    } 

    public static void testUserPut(){
        User testUser = new User("1000","Anthony","Gentile","mrsmiley381@gmail.com","DaisyChain","3");
        
        try{
            testUser.put();
        } catch (Exception e){
            System.err.print(e+ "From Put");
        }
        
        testUser = null;
         
        testUser = new User("1000");
        try{ 
            testUser.fetch();
        } catch (Exception e){
            System.err.println(e);
        }
        
             System.out.println("after fetch ");
   
        System.out.println("UserId: "+testUser.getUserId());
        System.out.println("FirstName: "+testUser.getFName());
        System.out.println("LastName: "+testUser.getLName());
        System.out.println("Email: "+testUser.getEmail());
        System.out.println("Password: "+testUser.getPswd());
        System.out.println("Role: "+testUser.getRole());
    } 

    public static void testUserDelete(){
        User testUser = new User("19","666","Lucifer","Morningstar","webmaster@aol.com","3");
        
        try{
            testUser.put();
            testUser.delete();
            testUser = new User("19");
            testUser.fetch();
        } catch (DLException e){
            //System.err.print(e);
        }
        
        System.out.println("UserId: "   +testUser.getUserId());
        System.out.println("FirstName: "+testUser.getFName());
        System.out.println("LastName: " +testUser.getLName());
        System.out.println("Email: "    +testUser.getEmail());
        System.out.println("Password: " +testUser.getPswd());
        System.out.println("Role: "     +testUser.getRole());
    } 
}//end class