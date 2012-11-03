package BusinessLayer;

import DataLayer.DLException;


/**
 *
 * @author Anthony Gentile
 */
 
// Business Layer Abstraction
public class Services extends DataLayer.Services {
    
    public Services()
    {
    }
    
    public boolean get()
    {
        try {
            fetch();
            return true;
        } catch (DLException e) {
            e.log();
            return false;
        }
    }
    
}
