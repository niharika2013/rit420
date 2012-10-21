package BusinessLayer;

/**
 *
 * @author Anthony Gentile
 */
 
// Business Layer Abstraction
public class Courses extends DataLayer.Courses {
    
    public Courses()
    {
    }
    
    public void get()
    {
        fetch();
    }
    
}
