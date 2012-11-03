package BusinessLayer;

import DataLayer.DLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony Gentile
 */
 
// Business Layer Abstraction
public class Courses extends DataLayer.Courses {
    
    public Courses()
    {
    }
    
    public boolean get()
    {
        try {
            fetch();
            return true;
        } catch (DLException ex) {
            ex.log();
            return false;
        }
    }
    
}
