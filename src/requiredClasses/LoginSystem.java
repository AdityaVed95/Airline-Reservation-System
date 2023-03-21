package requiredClasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;

import static java.lang.System.exit;


public class LoginSystem
{
    Vector<User> registeredUsers;


    LoginSystem()
    {
        registeredUsers = new Vector<>();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void login() throws IOException
    {
        while(true)
        {
            System.out.println("Enter 1 to sign in");
            System.out.println("Enter 2 to sign up");
            System.out.println("Enter 3 to exit");
            String response;
            response = br.readLine();

            switch (response)
            {
                case "1" -> sign_in();
                case "2" -> signUp();
                case "3" -> exit(0);
                default -> System.out.println("Invalid input please try again ..... !!!");
            }

        }


    }

    public void signUp() throws IOException
    {
        System.out.println("Enter Your Name :");
        String name = br.readLine();

        System.out.println("Enter Your Age :");
        int age =Integer.parseInt(br.readLine());

        System.out.println("Enter Your User ID : ");
        String user_id = br.readLine();

        System.out.println("Enter Password for your account :");
        String password = br.readLine();

        double wallet_amount = 100000;

        registeredUsers.add(new User(name,wallet_amount,user_id,password,age));

    }

    public void sign_in() throws IOException
    {

        int dummy = 0;

        if(registeredUsers.isEmpty())
        {
            System.out.println("There are no signed up users , thus sign in is invalid !!!");
            return;
        }

        label1:
        while(dummy == 0)
        {
            int flag = 0;
            System.out.println("Enter Your User ID :");
            String input_user_id = br.readLine();
            System.out.println("Enter Your Password : ");
            String input_password = br.readLine();

            label2:
            for (User userObject : registeredUsers)
            {
                if (userObject.getUser_id().equals(input_user_id))
                {
                    System.out.println("Existence of given User ID has been confirmed !!!");
                    flag = 1;
                    if(userObject.getPassword().equals(input_password))
                    {
                        System.out.println("Password Authentication was successful !!!");
                        System.out.println("You have successfully logged into your account !!!");
                        UserHomePage userHomePage1 = new UserHomePage(userObject);
                        userHomePage1.userPage();
                        break label1;
                    }
                    else
                    {
                        System.out.println("Password Authentication unsuccessful !!!\nPlease try again");
                        break label2;
                    }
                }
            }

            if(flag == 0)
            {
                System.out.println("Given User ID does not exist, please try again !!!");
            }

        }


    }

}
