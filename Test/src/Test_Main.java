import BusinessLayer.*;
import DataLayer.DLException;

public class Test_Main {

    public static void main(String[] args)
    {
        try{
            Course myCourse = new Course("20", "484", "2012", "25", "Database client/Server");
            myCourse.put();
            myCourse.fetch();
            //Test Course

            Grant myGrant = new Grant("20", "500", "2012", "Insert Citation", "tease", "amount", "status");
            myGrant.put();
            myGrant.fetch();
            //Test Grant

            Kudo myKudo = new Kudo("20", "123", "2012", "Did great!");
            myKudo.put();
            myKudo.fetch();
            //Test Kudo

            Service myService = new Service("20", "456", "2012", "Teaches DB Client/Server", "Teacher");
            myService.put();
            myService.fetch();
            //Test Service

            User myUser = new User("20", "Steven", "Zilora", "email here", "pswd", "Teacher");
            myUser.put();
            myUser.fetch();
            //Test User

            Pub myPub = new Pub("20", "789", "2012", "Insert Citation", "tease", "status");
            myPub.put();
            myPub.fetch();
            //Test Pub
        }
        catch(DLException e){
            System.err.println("We dun goofed");
        }
    }
}
