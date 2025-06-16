import java.sql.*;
import java.util.Scanner;

public class TicketDob {

    public static void TicketDetails(Ticket ticket) throws SQLException {
        Connection con = DbCon.getConnection();
        String query = "insert into ticket(busNumber,passengerName, passengerAge, gender, bookingdate) values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        java.sql.Date d = new java.sql.Date(ticket.date.getTime());
        ps.setInt(1,ticket.busno);
        ps.setString(2, ticket.name);
        ps.setInt(3,ticket.age);
        ps.setString(4, ticket.gender);
        ps.setDate(5, d);

        ps.executeUpdate();
    }

    public static void ShowTicket() throws SQLException {
        Connection con = DbCon.getConnection();
        String query = "select * from ticket";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println("Ticket Details:");
        while (rs.next()) {
            System.out.println("Bus No: " + rs.getInt(1));
            System.out.println("Ticket ID: " + rs.getInt(2));
            System.out.println("Name: " + rs.getString(3));
            System.out.println("Age: " + rs.getInt(4));
            System.out.println("Gender: " + rs.getString(5));
            System.out.println("Date: " + rs.getString(6));

        }
    }

    public static void CancelTicket() throws SQLException {
        int TicketId;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Ticket ID: ");
        TicketId = sc.nextInt();
        Connection con = DbCon.getConnection();
        String query = "delete from ticket where TicketID = " + TicketId;
        PreparedStatement st = con.prepareStatement(query);
        int rowAffected = st.executeUpdate(query);

        if (rowAffected > 0) {
            System.out.println("Ticket Canceled");
        }
        else {
            System.out.println(" Ticket ID not found.");
        }


    }

}
