//Connection with bus table
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDob {

    public static void display() throws SQLException {
        System.out.println("1.View Available Buses: ");
        System.out.println("----------------------------------");
        Connection con = DbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from bus");
        while (rs.next()) {
            System.out.println("Bus Number:" + rs.getInt(1) + " |Route:" + rs.getNString(2) + " |Capacity:" + rs.getInt(3) + " |AC:" + rs.getString(4));
        }

    }

}
