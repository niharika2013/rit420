package BusinessLayer;

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
   public void get()
   {
       fetch();
   }
        
   public void save()
   {
       if(getServiceId() != null)
       {
		 	put();
       }
       else
       {
          post();
       }
   }
}
