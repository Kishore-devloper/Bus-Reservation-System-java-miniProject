//Connection with booking table
import java.sql.*;
import java.util.Date;


public class BookingDob {

    public int getBookCount(int busno, Date date) throws SQLException {
        String sql = "select count(*) from booking where busNumber = ? and bookingdate = ?";
        Connection con = DbCon.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        java.sql.Date d = new java.sql.Date(date.getTime());
        ps.setInt(1, busno);
        ps.setDate(2, d);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);

    }

    public void addBooking(Bookings booking) throws SQLException {
        String sql = "insert into booking(passengerName,passengerAge,gender,busNumber,bookingdate) values(?,?,?,?,?)";
        Connection con = DbCon.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        java.sql.Date d = new java.sql.Date(booking.date.getTime());
        ps.setString(1, booking.passengerName);
        ps.setInt(2,booking.passengerAge);
        ps.setString(3, booking.gender);
        ps.setInt(4,booking.busNumber);
        ps.setDate(5, d);
        ps.executeUpdate();


    }

}
