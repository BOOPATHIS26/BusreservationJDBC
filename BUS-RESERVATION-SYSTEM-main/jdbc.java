import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
    private static final String URL = "jdbc:mysql://localhost:3306/busrev";
    private static final String USER = "root";
    private static final String PASSWORD = "Bhuvi@2613";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
