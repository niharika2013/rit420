package BusinessLayer;

/**
 *
 * @author Anthony Gentile
 */
 
// Business Layer Abstraction
public class Pubs extends DataLayer.Pubs {
    
    public Pubs()
    {
    }
    
    public void get()
    {
        fetch();
    }
    
}
