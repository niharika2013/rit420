package BusinessLayer;

/**
 *
 * @author Anthony Gentile
 */
 
// Business Layer Abstraction
public class Users extends DataLayer.Users {
    
    public Users()
    {
    }
    
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
    
}
