package BusinessLayer;

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
   public void get()
   {
       fetch();
   }
        
   public void save()
   {
       if(getPubId() != null)
       {
		 	put();
       }
       else
       {
          post();
       }
   }
}
