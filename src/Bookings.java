//booking class responsible for taking booking
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Bookings {
    String passengerName;
    int passengerAge;
    String gender;
    int busNumber;
    Date date;

    Bookings() {
        System.out.println("Enter passenger name: ");
        Scanner sc = new Scanner(System.in);
        this.passengerName = sc.nextLine();
        System.out.println("Enter passenger age: ");
        this.passengerAge = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter gender: ");
        this.gender = sc.nextLine();
        System.out.println("Enter date dd-mm-yyyy: ");
        String dateStr = sc.nextLine();


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Setting today's date by default.");
            this.date = new Date();
        }
        System.out.println("Enter bus number: ");
        this.busNumber = sc.nextInt();
        if(busNumber != 101 && busNumber != 102 && busNumber != 103) {
            System.out.println("Invalid Bus Number");
        }


    }

    public boolean isAvailable() throws SQLException {
        DbCon db = new DbCon();
        BookingDob bookingDob = new BookingDob();
        int cap = db.getCapcity(busNumber);

        int booked = bookingDob.getBookCount(busNumber,date);


        return booked < cap ;
    }


}
