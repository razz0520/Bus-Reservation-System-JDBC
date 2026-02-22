
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BookingDAO dao = new BookingDAO();

        try{
            passenger p= new passenger(sc);
            if(dao.isAvailable(p.busId, p.dateBooked)){
                dao.finalizeBooking(p);
                System.out.println("Success! Ticket Booked.");
            }else{
                System.out.println("Sorry, the bus is full for this date.");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
