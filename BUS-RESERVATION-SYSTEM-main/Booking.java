import java.util.Date;

public class Booking {
    String passengerName;
    int busNumber;
    int seats;
    Date date;

    public Booking(String name, int busNumber, int seats, Date date) {
        this.passengerName = name;
        this.busNumber = busNumber;
        this.seats = seats;
        this.date = date;
    }

    void showBooking() {
        System.out.println("Passenger: " + passengerName +
                " | Bus No: " + busNumber +
                " | Seats: " + seats +
                " | Date: " + date);
    }
}
