package DataLayer;

public class Test_Main {

	
	public static void main(String[] args) {
		
		MySQLDatabase myDB = new MySQLDatabase();
		
		Course myCourse = new Course("20", "484", "2012", "25", "Database client/Server", myDB);
		myCourse.put();
		myCourse.fetch();
		//Test Course
		
		Grant myGrant = new Grant("20", "500", "2012", "Insert Citation", "tease", "amount", "status", myDB);
		myGrant.put();
		myGrant.fetch();
		//Test Grant
		
		Kudo myKudo = new Kudo("20", "123", "2012", "Did great!", myDB);
		myKudo.put();
		myKudo.fetch();
		//Test Kudo
		
		Service myService = new Service("20", "456", "2012", "Teaches DB Client/Server", "Teacher", myDB);
		myService.put();
		myService.fetch();
		//Test Service
		
		User myUser = new User("20", "Steven", "Zilora", "email here", "pswd", "Teacher", myDB);
		myUser.put();
		myUser.fetch();
		//Test User
		
		Pub myPub = new Pub("20", "789", "2012", "Insert Citation", "tease", "status", myDB);
		myPub.put();
		myPub.fetch();
		//Test Pub
		
		
		//OWEN WAS HERE
	}

}
