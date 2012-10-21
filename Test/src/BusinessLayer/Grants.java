package BusinessLayer;

/**
 *
 * @author Anthony Gentile
 */
 
// Business Layer Abstraction
public class Grants extends DataLayer.Grants {
    
    public Grants()
    {
    }
    
    public void get()
    {
        fetch();
    }
    
}
