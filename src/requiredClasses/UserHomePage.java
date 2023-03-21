package requiredClasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserHomePage
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    User userObject;

    public UserHomePage(User userObject)
    {
        this.userObject = userObject;
    }

    public void userPage() throws IOException
    {
        System.out.println("Welcome  "+userObject.getName());

        while(true)
        {
            System.out.println("Enter 1 to Book Ticket :");
            System.out.println("Enter 2 to Check Wallet Balance");
            System.out.println("Enter 3 to Add money to Wallet");
            System.out.println("Enter 4 to check Your Air travel status :");
            System.out.println("Enter 5 to logout from your account");

            String response;
            response = br.readLine();

            if (response.equals("1"))
            {
                AirlineReservationSystem system1 = new AirlineReservationSystem(userObject);
                system1.bookTicket();
            }

            else if(response.equals("2"))
            {
                System.out.println("Wallet Balance of "+userObject.getName()+" is : ₹"+userObject.getWallet_amount());
            }

            else if(response.equals("3"))
            {
                System.out.println("Enter the amount to be added to your wallet : ");
                double amount = Double.parseDouble(br.readLine());
                userObject.setWallet_amount(userObject.getWallet_amount()+amount);
                System.out.println("Successfully Added  ₹"+amount+" to "+userObject.getName()+"'s account");
            }

            else if(response.equals("4"))
            {
                userObject.showAirTravelStatuses();
            }

            else if (response.equals("5"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid input please try again ..... !!!");
            }
        }



    }
}
