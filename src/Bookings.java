import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public boolean isAvailable(ArrayList<Bookings> bookings, ArrayList<Bus> bus) {
        int cap = 0;

        for(Bus bu : bus) {
            if (bu.getBusNumber() == this.busNumber) {
               cap = bu.getCapacity();


            }
        }
        int booked = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String thisBookingDate = sdf.format(this.date);
        for(Bookings bu : bookings) {
            String existingBookingDate = sdf.format(bu.date);
            if(bu.busNumber == this.busNumber && existingBookingDate.equals(thisBookingDate)) {
                booked++;
                }
            }


        return booked < cap ;
    }


}
