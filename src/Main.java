
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Bus> bus = new ArrayList<>();
        ArrayList<Bookings> bookings = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();
        bus.add(new Bus(101,32));
        bus.add(new Bus(102,20));
        bus.add(new Bus(103,15));

        System.out.println("=================================================");
        System.out.println(" Welcome to the RK Travels ");
        System.out.println("=================================================");
        int userChoice = 0;
        String userOPt = "y";
        while (userOPt.equals("y") && userChoice != 5 ){
        System.out.println("1.View Available Buses " + '\n' + "2.Book Ticket" + '\n' + "3.Cancel Ticket" + '\n'+"4. View Booked Tickets" + '\n' + "5. Exit");
        Scanner Choice = new Scanner(System.in);
        System.out.println("Enter your choice : ");
        userChoice = Choice.nextInt();
        switch (userChoice) {
            case 1:
                Bus.display();
                break;
            case 2:
               Bookings bookings1 = new Bookings();

                if(bookings1.isAvailable(bookings,bus)){
                    bookings.add(bookings1);
                    Ticket ticket = new Ticket(bookings1.busNumber, bookings1.passengerName, bookings1.passengerAge, bookings1.gender, bookings1.date);
                    tickets.add(ticket);
                    System.out.println("Booking successful! Your ticket details:");
                    ticket.displayTicket();
                }
                else {
                    System.out.println("Bus is full,try any other bus or date");
                }
                break;
            case 3:
                Ticket.cancelTicket(tickets);
                break;
            case 4:
                Ticket ticket = new Ticket();
                ticket.bookeedTicket(tickets);
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