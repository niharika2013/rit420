package BusinessLayer;

/**
 *
 * @author Anthony Gentile
 */
 
// Business Layer Abstraction
public class Kudos extends DataLayer.Kudos {
    
    public Kudos()
    {
    }
    
    public void get()
    {
        fetch();
    }
    
}
