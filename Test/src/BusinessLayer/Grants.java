package BusinessLayer;

import DataLayer.DLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony Gentile
 */
 
// Business Layer Abstraction
public class Grants extends DataLayer.Grants {
    
    public Grants()
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
