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
         * Explicit default constructor for service doesn't do much.
         */
	public Service()	{
	}
	
	/**
         * Constructor accepts a string value for service ID only.
         * 
         * @param serviceId 
         */
        public Service(String serviceId){
		this.serviceId = serviceId;
	}
	
	/**
         * Constructor accepts and sets parameters for all attributes. 
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

        
        
        
	/**
         * This method uses the object's serviceId attribute to query the 
         * services table and retrieve all values for that id.
         * 
         * @return boolean indicating success.
         * @throws DLException 
         */
        public boolean fetch() throws DLException {
            try{                
		ArrayList<String> values = new ArrayList<>(0);
		values.add(serviceId);
		ArrayList<ArrayList<String>> dataList = myDB.getData("SELECT userId, serviceId, year, description, role FROM services WHERE ServiceId = ?", values);
		if(dataList.size() > 1){
                    userId      = dataList.get(1).get(1).toString();
                    serviceId   = dataList.get(1).get(2).toString();
                    year        = dataList.get(1).get(3).toString();
                    description = dataList.get(1).get(4).toString();
                    role        = dataList.get(1).get(5).toString();
                    return true;
		} else {
			return false;
		}
            } catch (Exception e){
                throw new DLException(e);
            }
	}
	
	/**
         * This method updates the database values, for that object's serviceId, 
         * using the object's attribute values.
         * 
         * @return boolean indicating success
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
		return myDB.setData("UPDATE services UserId = ?, Year = ?, Description = ?, Role = ? WHERE ServiceId = ?", values);
            } catch(Exception e) {
                throw new DLException(e);
            }
        }
	
	/**
         * Inserts this data object's attribute values into the services table.
         * 
         * @return boolean indicating success.
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
        	myDB.setData("INSERT INTO services (UserId,ServiceId,Year,Description,Role) VALUES(?,?,?,?,?)", values);
                return true;
            } catch(Exception e) {
                throw new DLException(e);
            }
        }
	
        /**
         * Removes from the database any data corresponding to this data object's
         * serviceID
         * 
         * @return boolean indicating success
         * @throws DLException 
         */
        public boolean delete() throws DLException {
            try {
                ArrayList<String> values = new ArrayList<>(0);
                values.add(serviceId);
                myDB.setData("DELETE FROM services WHERE serviceID = ?", values);
                return true;
            } catch(Exception e) {
                throw new DLException(e);
            }
        }
    
        
        
        
        
	/**
         * Mutator method for serviceId
         * @param serviceId 
         */
        public void setServiceId(String serviceId){this.serviceId = serviceId;}
	
        /**
         * Accessor method for serviceId   
         * @return String value of serviceId
         */
        public String getServiceId(){return serviceId;}
	
	/**
         * Mutator method for userId
         * @param userId 
         */
        public void setUserId(String userId){this.userId = userId;}
	
        /**
         * Accessor method for userId
         * @return String value of userId
         */
        public String getUserId(){return userId;}
	
        /**
         * Mutator method for year
         * @param year 
         */
	public void setYear(String year){this.year = year;}
	
        /**
         * Accessor method for year
         * @return String value of year
         */
        public String getYear(){return year;}
	
        /**
         * Mutator method for description
         * @param description 
         */
	public void setDescription(String description){this.description = description;}
	
        /**
         * Accessor method for description
         * @return String value of description
         */
        public String getDescription(){return description;}
	
        /**
         * Mutator method for role
         * @param role 
         */
	public void setRole(String role){this.role = role;}
	
        /**
         * Accessor method for role
         * @return String value of role
         */
        public String getRole(){return role;}
}