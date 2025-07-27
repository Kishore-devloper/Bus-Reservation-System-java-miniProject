//Ticket class working with tickets
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ticket {
    int busno;
    static int  getTicketID=101;
    int ticketID;
    String name;
    int age;
    String gender;
    Date date;

    Ticket(){
        System.out.println("=================================================");
        System.out.println("Booked Tickets:");
        System.out.println("=================================================");
    }


    Ticket(int busno,String name, int age, String gender, Date date) {
        this.busno = busno;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.date = date;
        this.ticketID = getTicketID++;
    }
    public void displayTicket() {
        System.out.println("===========================================");
        System.out.println("Ticket ID: " + this.ticketID);
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Gender: " + this.gender);
        System.out.println("Date: " + this.date);
        System.out.println("===========================================");

    }
    public int getTicketID() {
        return ticketID;
    }

     public static void cancelTicket(ArrayList<Ticket> tickets) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Ticket ID to cancel: ");
        int id = input.nextInt();

        Ticket found = null;
        for (Ticket t : tickets) {
            if (t.getTicketID() == id) {
                found = t;
                break;
            }
        }

        if (found != null) {
            tickets.remove(found);
            System.out.println("Ticket ID " + id + " cancelled successfully.");
        } else {
            System.out.println("Ticket ID not found.");
        }
    }

      void bookeedTicket(ArrayList<Ticket> tickets) {
        for (Ticket t : tickets) {
            if(t != null) {
                System.out.println("Ticket ID: " + t.ticketID);
                System.out.println("Name: " + t.name);
                System.out.println("Age: " + t.age);
                System.out.println("Gender: " + t.gender);
                System.out.println("Date: " + t.date);
            }
            else{
                System.out.println("Ticket ID not found.");
            }
        }

    }

}
