package BusinessLayer;

import DataLayer.DLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony Gentile
 */
public class Grant extends DataLayer.Grant {
    
   //Provide	a	default	constructor.
	public Grant()
	{   
	}
	
	//Provide	a	constructor	that	accepts	and	sets	the	grantId.
	public Grant(String grantId)
	{
		setGrantId(grantId);
	}
	
	//Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Grant(String userId, String grantId, String year, String citation, String tease, String amount, String status)
	{
		setUserId(userId);
		setGrantId(grantId);
		setYear(year);
		setCitation(citation);
		setTease(tease);
		setAmount(amount);
		setStatus(status);
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
            if(getGrantId() != null)
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
