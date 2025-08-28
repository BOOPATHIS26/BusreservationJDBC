public class Bus {
    int busNumber;
    String from;
    String to;
    int totalSeats;
    String busType;
    boolean sleeper;
    int bookedSeats;

    public Bus(int busNumber, String from, String to, int totalSeats, String busType, boolean sleeper) {
        this.busNumber = busNumber;
        this.from = from;
        this.to = to;
        this.totalSeats = totalSeats;
        this.busType = busType;
        this.sleeper = sleeper;
        this.bookedSeats = 0;
    }

    boolean bookTicket(int seats) {
        if (bookedSeats + seats <= totalSeats) {
            bookedSeats += seats;
            return true;
        }
        return false;
    }

    int availableSeats() {
        return totalSeats - bookedSeats;
    }

    void showDetails() {
        System.out.println("Bus No: " + busNumber +
                " | From: " + from +
                " | To: " + to +
                " | Total Seats: " + totalSeats +
                " | Available: " + availableSeats());
    }
}
