package przychodnia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by adam on 04/01/2017.
 */
public class DBUtil {

    private static final String url = "jdbc:mysql://localhost:3306/przychodnia";
    private static final String username = "root";
    private static final String password = "gostyn255";
    private static Connection connection = null;

    public static void DBConnect() {

        System.out.println("Connecting database...");

        try
        {   connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public static void DBDisconnect() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Diconnnected!!!!!");
            }
        } catch (Exception e){
            throw e;
        }
    }


}







