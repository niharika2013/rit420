package BusinessLayer;

import DataLayer.DLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony Gentile
 */
public class Pub extends DataLayer.Pub {
    
   //Provide	a	default	constructor.
	public Pub()
	{   
	}
	
	//Provide	a	constructor	that	accepts	and	sets	the	pubId.
	public Pub(String pubId)
	{
		setPubId(pubId);
	}
	
	//Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Pub(String userId, String pubId, String year, String citation, String tease, String status)
	{
		setUserId(userId);
		setPubId(pubId);
		setYear(year);
		setCitation(citation);
		setTease(tease);
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
            if(getPubId() != null)
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
