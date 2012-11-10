package DataLayer;

import java.util.*;

/**
 * The Service class creates a data object representing a single tuple from the 
 * services table in the faculty activity database (484 project in this case).
 * 
 * 
 * @author Adam Morgan
 * @author Anthony Gentile
 * @author Mike Baszto
 * @author Owen O'Connell*/
public class Service {
	
        private MySQLDatabase myDB = new MySQLDatabase();
	
    
        private String userId;
	private String serviceId;
	private String year;
	private String description;
	private String role;
   
        /**
         * 
         */
	public Service()
	{
	}
	
	// Provide	a	constructor	that	accepts	and	sets	the	serviceId.
	/**
         * 
         * @param serviceId 
         */
        public Service(String serviceId){
		this.serviceId = serviceId;
	}
	
	// Provide	a	constructor	that	accepts	and	sets	all	attributes.
	/**
         * 
         * @param userId
         * @param serviceId
         * @param year
         * @param description
         * @param role 
         */
        public Service(String userId, String serviceId, String year, String description, String role){
		this.userId = userId;
		this.serviceId = serviceId;
		this.year = year;
		this.description = description;
		this.role = role;
	}

        // fetch	uses	the	object�s	serviceId	attribute	and	the	Database	class
	//getData	method	to	retrieve	the	database	values	for	that	particular	serviceId	
	//and	updates	the	object�s	attributes.
	/**
         * 
         * @return
         * @throws DLException 
         */
        public boolean fetch() throws DLException {
            try{                
		ArrayList<String> values = new ArrayList<>(0);
		values.add(serviceId);
		ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT * FROM services WHERE ServiceId = ?", values);
		if(dataList.size() > 1){
                    userId = dataList.get(1).get(1).toString();
                    serviceId = dataList.get(1).get(2).toString();
                    year = dataList.get(1).get(3).toString();
                    description = dataList.get(1).get(4).toString();
                    role = dataList.get(1).get(5).toString();
                    return true;
		} else {
			return false;
		}
            } catch (Exception e){
                throw new DLException(e);
            }
	}
	
	// post updates the database values, for that object�s serviceId, using the	
	//object�s attribute values.
	/**
         * 
         * @return
         * @throws DLException 
         */
        public boolean post() throws DLException {
            try {
		ArrayList<String> values = new ArrayList<>(0);
		values.add(userId); 
		values.add(year);
		values.add(description);
		values.add(role);
		values.add(serviceId);
		return myDB.setData("UPDATE service UserId = ?, Year = ?, Description = ?, Role = ? WHERE ServiceId = ?", values);
            } catch(Exception e) {
                throw new DLException(e);
            }
        }
	
	// put	inserts	the	object�s	attribute	values	into	the	database	as	a	new	record.
	/**
         * 
         * @return
         * @throws DLException 
         */
        public boolean put() throws DLException {
            try {
		ArrayList<String> values = new ArrayList<>(0);
		values.add(userId);
		values.add(serviceId);
		values.add(year);
		values.add(description);
		values.add(role);
        	myDB.setData("INSERT INTO service (UserId,ServiceId,Year,Description,Role) VALUES(?,?,?,?,?)", values);
                return true;
            } catch(Exception e) {
                throw new DLException(e);
            }
        }
	
    // delete removes	from	the	database	any	data	corresponding	to	the	object�s serviceId.
    
        /**
         * 
         * @return
         * @throws DLException 
         */
        public boolean delete() throws DLException {
            try {
                ArrayList<String> values = new ArrayList<>(0);
                values.add(serviceId);
                myDB.setData("DELETE FROM service WHERE serviceID = ?", values);
                return true;
            } catch(Exception e) {
                throw new DLException(e);
            }
        }
    
        // Provide	accessors	and	mutators	for	all	attributes.
	/**
         * 
         * @param serviceId 
         */
        public void setServiceId(String serviceId){this.serviceId = serviceId;}
	
        /**
         * 
         * @return 
         */
        public String getServiceId(){return serviceId;}
	
	/**
         * 
         * @param userId 
         */
        public void setUserId(String userId){this.userId = userId;}
	
        /**
         * 
         * @return 
         */
        public String getUserId(){return userId;}
	
        /**
         * 
         * @param year 
         */
	public void setYear(String year){this.year = year;}
	
        /**
         * 
         * @return 
         */
        public String getYear(){return year;}
	
        /**
         * 
         * @param description 
         */
	public void setDescription(String description){this.description = description;}
	
        /**
         * 
         * @return 
         */
        public String getDescription(){return description;}
	
        /**
         * 
         * @param role 
         */
	public void setRole(String role){this.role = role;}
	
        /**
         * 
         * @return 
         */
        public String getRole(){return role;}
}