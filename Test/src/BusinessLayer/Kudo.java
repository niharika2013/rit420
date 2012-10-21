package BusinessLayer;

/**
 *
 * @author Anthony Gentile
 */
public class Kudo extends DataLayer.Kudo {
    
   //Provide	a	default	constructor.
	public Kudo()
	{   
	}
	
	//Provide	a	constructor	that	accepts	and	sets	the	kudoId.
	public Kudo(String kudoId)
	{
		setKudoId(kudoId);
	}
	
	//Provide	a	constructor	that	accepts	and	sets	all	attributes.
	public Kudo(String userId, String kudoId, String year, String kudo)
	{
		setUserId(userId);
		setKudoId(kudoId);
		setYear(year);
		setKudo(kudo);
	}
   
	//Passthrough methods
   public void get()
   {
       fetch();
   }
        
   public void save()
   {
       if(getKudoId() != null)
       {
		 	put();
       }
       else
       {
          post();
       }
   }
}
