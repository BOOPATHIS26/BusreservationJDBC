import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class busDAO {
    public void addBus(Bus bus) {
        String query = "INSERT INTO buses (busNumber, source, destination, totalSeats, busType, sleeper) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = jdbc.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, bus.busNumber);
            pst.setString(2, bus.from);
            pst.setString(3, bus.to);
            pst.setInt(4, bus.totalSeats);
            pst.setString(5, bus.busType);
            pst.setBoolean(6, bus.sleeper);

            int rows = pst.executeUpdate();
            System.out.println(rows + " bus inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
