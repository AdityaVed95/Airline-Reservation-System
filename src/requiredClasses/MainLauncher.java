package requiredClasses;

import java.io.IOException;

public class MainLauncher
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Welcome to United Airlines Air Travel Ticket Booking !!!");
        System.out.println("-------------------------------------------------------------------");

        LoginSystem loginSystem1 = new LoginSystem();
        loginSystem1.login();
    }
}
