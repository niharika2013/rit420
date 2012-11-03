package BusinessLayer;

import DataLayer.DLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            fetch();
        } catch (DLException e) {
            e.log();
        }
    }
    
}
