import requiredClasses.AirlineReservationSystem;
import requiredClasses.User;

import java.io.IOException;

public class TesterClass
{
    public static void main(String[] args) throws IOException
    {
//        requiredClasses.Region s1 = requiredClasses.RegionsOfAircraftFly.getRegion("delhi");
//        System.out.println(s1);

        User user1 = new User("n1",100,"id1","pass1",30);
        AirlineReservationSystem system1 = new AirlineReservationSystem(user1);
        system1.bookTicket();

    }
}
