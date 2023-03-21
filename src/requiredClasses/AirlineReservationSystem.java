package requiredClasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;

public class AirlineReservationSystem
{
    User userObject;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String source;
    String destination;
    String timing; // use 24 hr clock format
    String date;
    double ticket_cost;

    public AirlineReservationSystem(User userObject)
    {
        this.userObject = userObject;
    }


    public void bookTicket() throws IOException
    {
        selectSourceAndDestination();
        selectTiming();
        selectDate();
        initialiseTicketCost();
        int status = confirmTicket();
        if(status == 0)
        {
            return;
        }
        finalTicketBook();
    }


    public void selectSourceAndDestination() throws IOException
    {

        System.out.println("United Airlines takes you to the following Destinations:");

        for(Map.Entry<String,Region> entry : RegionsOfAircraftFly.regionsMap.entrySet())
        {
            System.out.println(entry.getKey());
        }


        while(true)
        {
            System.out.println("Enter Source : ");
            source = br.readLine();
            Region s1 = RegionsOfAircraftFly.getRegion(source);
            if(s1 == null)
            {
                System.out.println("Invalid Source , Please try again");
            }
            else
            {
                break;
            }

        }

        while(true)
        {
            System.out.println("Enter Destination : ");
            destination = br.readLine();
            Region s1 = RegionsOfAircraftFly.getRegion(destination);
            if(s1 == null)
            {
                System.out.println("Invalid Destination , Please try again");
            }
            else
            {
                break;
            }

        }

        System.out.println("----------------------------------------------------------------");

    }

    public void selectTiming() throws IOException
    {
        System.out.println("Selecting Timing for Air Travel :");
        System.out.println("1)Boarding -> 8:30 am ");
        System.out.println("2)Boarding -> 1:45 pm ");
        System.out.println("3)Boarding -> 7:15 pm ");

        while(true)
        {
            String time_choice;
            time_choice = br.readLine();

            if(time_choice.equals("1"))
            {
                timing = "8:30";
                break;
            }

            else if(time_choice.equals("2"))
            {
                timing = "13:45";
                break;
            }

            else if(time_choice.equals("3"))
            {
                timing = "19:15";
                break;
            }

            else
            {
                System.out.println("Invalid choice, please try again !!!");
            }
        }


    }

    public void initialiseTicketCost()
    {
        switch (timing)
        {
            case "8:30" -> ticket_cost = 70000;
            case "13:45" -> ticket_cost = 75000;
            case "19:15" -> ticket_cost = 80000;
        }
    }

    public void selectDate() throws IOException
    {
        System.out.println("Select Date of Air Travel : ");
        System.out.println("Enter the Date in dd/mm/yy format");
        date = br.readLine();

    }

    public int confirmTicket() throws IOException
    {
        if(ticket_cost> userObject.getWallet_amount())
        {
            System.out.println("Sorry !! Due to insufficient balance in your account , the transaction was unsuccessful !!");
            System.out.println("You will now be redirected to your logged in home page ");
            return 0 ;
        }

        System.out.println("Your Total Cost for the Air Travel Ticket is : "+ticket_cost);

        System.out.println("Press Y to confirm your Air Travel ticket booking and N to cancel booking");

        while (true)
        {
            String confirm  = br.readLine();
            if(confirm.equals("N") || confirm.equals("n"))
            {
                return 0;
            }

            else if(confirm.equals("Y") || confirm.equals("y"))
            {
                return 1;
            }

            else
            {
                System.out.println("Invalid choice, please try again !!!");
            }

        }


    }

    public void finalTicketBook()
    {
        userObject.setWallet_amount(userObject.getWallet_amount()-ticket_cost);
        System.out.println("Congratulations, Your Ticket has been confirmed !!!");

        UserAirTravelStatus currentAirTravelStatus = new UserAirTravelStatus(source,destination,timing,ticket_cost,date);
        userObject.travelStatuses.add(currentAirTravelStatus);

        System.out.println("Your Booking Details are : ");
        currentAirTravelStatus.showStatus();

        System.out.println("You can even view the above details from your logged in page ");
        System.out.println("Redirecting you to your logged in page ");



    }
}
