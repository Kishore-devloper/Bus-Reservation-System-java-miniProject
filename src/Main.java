import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)  {


        System.out.println("=================================================");
        System.out.println(" Welcome to the RK Travels ");
        System.out.println("=================================================");
        int userChoice = 0;
        String userOPt = "y";
        while (userOPt.equals("y") && userChoice != 5 ){
            System.out.println("1.View Available Buses " + "\n" + "2.Book Ticket" + '\n' + "3.Cancel Ticket" + '\n'+"4. View Booked Tickets" + '\n' + "5. Exit");
            Scanner Choice = new Scanner(System.in);
            System.out.println("Enter your choice : ");
            userChoice = Choice.nextInt();
            switch (userChoice) {
                case 1:
                    try {
                        BusDob.display();
                    }
                    catch (Exception e) {
                        System.err.println("server down, please try again");
                    }
                    break;
                case 2:
                    Bookings bookings= new Bookings();
                    try {
                        if (bookings.isAvailable()) {
                            BookingDob bookingDob = new BookingDob();
                            bookingDob.addBooking(bookings);
                            Ticket ticket = new Ticket(bookings.busNumber, bookings.passengerName, bookings.passengerAge, bookings.gender, bookings.date);
                            TicketDob.TicketDetails(ticket);
                            System.out.println("Booking successful! Your ticket details:");
                            TicketDob.ShowTicket();
                        } else {
                            System.out.println("Bus is full,try any other bus or date");
                        }
                    }
                    catch (Exception e) {
                        System.err.println("server down, please try again");
                    }
                    break;
                case 3:
                    try {
                        TicketDob.CancelTicket();
                    }
                    catch (Exception e) {
                        System.err.println("server down, please try again");
                    }
                    break;
                case 4:
                    try {
                        TicketDob.ShowTicket();
                    }
                    catch (Exception e) {
                        System.err.println("server down, please try again");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using RK Travels,Have a safe journey!");
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;

            }
            if(userChoice != 5) {
                Scanner UserInput = new Scanner(System.in);
                System.out.println("Do you want to continue (Y/N): ");
                userOPt = UserInput.nextLine();
            }
        }
    }
}
