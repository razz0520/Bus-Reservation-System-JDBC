import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


public class passenger {
    String name;
    int age;
    Date dateBooked;
    double amount;
    int busId;
    String start;
    String dest;

    public passenger(Scanner sc) {
        // 1. Validating Name
        System.out.println("Enter Passenger Name: ");
        this.name = sc.next();

        // 2. Validating Age(loop until correct)
        while (true) {
            try {
                System.out.println("Enter Age: ");
                this.age = sc.nextInt();
                if (age <= 0 || age > 100) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("Invalid age! Please enter a number between 1-100.");
                sc.nextLine();
            }
        }

        //3. Validating Date
        while (true) {
            try {
                System.out.println("Enter Travel Date (yyyy-mm-dd): ");
                this.dateBooked = Date.valueOf(sc.next());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid format! Use YYYY-MM-DD.");
            }
        }

        //4. Validating Bus ID
        while(true) {
            try {
                System.out.println("Enter Bus Number: ");
                this.busId = sc.nextInt();
                break;
            }catch(InputMismatchException e){
                System.out.println("Bus No must be a number!");
                sc.nextLine();
            }
        }

        System.out.println("Enter Amount: ");this.amount = sc.nextDouble();


        System.out.println("From: ");this.start = sc.next();

        System.out.println("To: ");this.dest = sc.next();

    }
}
