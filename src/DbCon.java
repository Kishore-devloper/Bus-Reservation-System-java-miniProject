//Connection with DataBase
import java.sql.*;

public class DbCon {
        private static final String url = "jdbc:mysql://localhost:3306/busrev";
        private static final String user = "root";
        private static final String pass = "Kishore";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url,user,pass);


        }

        public int getCapcity(int busno) throws SQLException {
                String sql = "select capcity from bus where busNumber =" + busno;
                Connection con = getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                return rs.getInt(1);
        }



}
