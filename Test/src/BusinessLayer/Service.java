package BusinessLayer;

import DataLayer.DLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony Gentile
 */
public class Service extends DataLayer.Service {
    
   //Provide	a	default	constructor.
	public Service()
	{   
	}
	
	//Provide	a	constructor	that	accepts	and	sets	the	serviceId.
	public Service(String serviceId)
	{
		setServiceId(serviceId);
	}
	
	//Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Service(String userId, String serviceId, String year, String description, String role)
	{
		setUserId(userId);
		setServiceId(serviceId);
		setYear(year);
		setDescription(description);
		setRole(role);
	}
   
	//Passthrough methods
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
        
   public boolean save()
   {
       try{
            if(getServiceId() != null)
            {
                             put();
                             return true;
            }
            else
            {
               post();
               return true;
            }
       }
       catch(DLException e){
           e.log();
           return false;
       }
   }
}
