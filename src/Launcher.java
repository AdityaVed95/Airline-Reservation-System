import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Launcher
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        System.out.println("\n\n------------------------------------------------------------------\n\t\t\t\t\tWelcome to United Airlines\n------------------------------------------------------------------");


        label1:
        while(true)
        {
            int flag=0;
            String choice  = home_page();

            label2:
            switch (choice)
            {
                case "1":
                    flag = 1;
                    // sign_up();
                    break label2;

                case "2":
                    flag = 1;
                    break label2;

                default:
                    System.out.println("Please Enter a Valid choice !! ");
                    break label2;
            }


        }



    }

    public static String home_page() throws IOException
    {

        System.out.println("\n");
        System.out.println("\tEnter 1 to sign up");
        System.out.println("\tEnter 2 to sign in");
        return br.readLine();

//        System.out.println("\nEnter Username: ");
//
//        System.out.println("\nEnter Password");
    }
}
