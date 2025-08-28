import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class BookingDAO {
    public void addBooking(Booking booking) {
        String query = "INSERT INTO bookings (passengerName, busNumber, seats, bookingDate) VALUES (?, ?, ?, ?)";
        try (Connection con = jdbc.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, booking.passengerName);
            pst.setInt(2, booking.busNumber);
            pst.setInt(3, booking.seats);
            pst.setDate(4, new Date(booking.date.getTime()));

            int rows = pst.executeUpdate();
            System.out.println(rows + " booking inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
