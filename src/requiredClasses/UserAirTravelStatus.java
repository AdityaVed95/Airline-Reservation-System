package requiredClasses;

public class UserAirTravelStatus
{
    String source;
    String destination;
    String timing; // use 24 hr clock format
    String date;
    double ticket_cost;

    public UserAirTravelStatus(String source, String destination, String timing, double ticket_cost , String date)
    {
        this.source = source;
        this.destination = destination;
        this.timing = timing;
        this.ticket_cost = ticket_cost;
        this.date = date;
    }

    public void showStatus()
    {
        System.out.println("Ticket Status  : ");
        System.out.println("Date           :  "+date);
        System.out.println("Source         :  "+source);
        System.out.println("Destination    :  "+destination);
        System.out.println("Timing         :  "+timing);
        System.out.println("Ticket Cost    :  "+ticket_cost);

    }
}
