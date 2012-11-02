package BusinessLayer;

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
   public void get()
   {
       fetch();
   }
        
   public void save()
   {
       if(getGrantId() != null)
       {
		 	put();
       }
       else
       {
          post();
       }
   }
}
