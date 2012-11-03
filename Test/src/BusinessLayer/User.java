package BusinessLayer;

/**
 *
 * @author Anthony Gentile
 */
public class User extends DataLayer.User {
    
   //Provide	a	default	constructor.
	public User()
	{   
	}
	
	//Provide	a	constructor	that	accepts	and	sets	the	userId.
	public User(String userId)
	{
		setUserId(userId);
	}
	
	//Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public User(String userId, String fName, String lName, String email, String pswd, String role)
	{
		setUserId(userId);
		setFName(fName);
		setLName(lName);
		setEmail(email);
		setPswd(pswd);
		setRole(role);
	}
   
	//Passthrough methods
   public void get()
   {
       try
       {
           fetch();
       }
       catch(Exception e)
       {
           
       }
   }
        
   public void save()
   {
       if(getUserId() != null)
       {
           put();
       }
       else
       {
           try
           {
            post();
           }
           catch(Exception e)
           {
           
           }
       }
   }
}
