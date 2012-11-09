import DataLayer.*;

public class Test_Main {

    public static void main(String[] args){
        
    	//testDatabase();
    	//testUserFetch();
        testUserDelete();
        //testUserPut();
        //testUserPost();
    	
       
    }

    public static void testDatabase(){
    	MySQLDatabase db = new MySQLDatabase();
    	
    	try {
    		System.out.println("Connection: "+ db.connect()) ;
    		System.out.println("Closed: "+ db.close()) ;
    	} catch (DLException DLE){
    		System.out.println(DLE);
    	}
    	
    	
    	
    } //works
    
    public static void testUserPost(){
        
        User testUser = new User("6","xxx","Lucifer","Morningstar","webmaster@aol.com","3");
        
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
    } //works
    
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
    } //works

    public static void testUserPut(){
        User testUser = new User("6","666","Lucifer","Morningstar","webmaster@aol.com","3");
        
        try{
            testUser.put();
        } catch (Exception e){
            System.err.print(e+ "From Put");
        }
        
        testUser = null;
         
        testUser = new User("6");
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
    } //works

    public static void testUserDelete(){
        User testUser = new User("19","666","Lucifer","Morningstar","webmaster@aol.com","3");
        testUser.put();
        try{
            testUser.delete();
            testUser = new User("19");
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
}