package requiredClasses;

import java.util.*;

public class User
{
    String name;
    double wallet_amount;
    String user_id;
    String password;
    int age;

    Vector<UserAirTravelStatus> travelStatuses;

    public User(String name, double wallet_amount, String user_id, String password, int age)
    {
        this.name = name;
        this.wallet_amount = wallet_amount;
        this.user_id = user_id;
        this.password = password;
        this.age = age;
        travelStatuses = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public double getWallet_amount() {
        return wallet_amount;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public void setWallet_amount(double wallet_amount) {
        this.wallet_amount = wallet_amount;
    }

    public void showAirTravelStatuses()
    {
        if(travelStatuses.isEmpty())
        {
            System.out.println("No Air Ticket Bookings Done up till now !!!");
            return;
        }

        for(UserAirTravelStatus statusObject : travelStatuses)
        {
            statusObject.showStatus();
            System.out.println("\n\n");
        }

        System.out.println("\n\n");
    }
}
