import java.text.SimpleDateFormat;
import java.util.*;

public class BusReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Bus> buses = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();
    static busDAO busDAO = new busDAO();
    static BookingDAO bookingDAO = new BookingDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- BUS RESERVATION SYSTEM ---");
            System.out.println("1. Add Bus (Admin)");
            System.out.println("2. View Buses");
            System.out.println("3. Book Ticket");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addBus();
                case 2 -> viewBuses();
                case 3 -> bookTicket();
                case 4 -> viewBookings();
                case 5 -> {
                    System.out.println("Thank you for using the Bus Reservation System!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addBus() {
        System.out.print("Enter Bus Number: ");
        int number = sc.nextInt(); sc.nextLine();
        System.out.print("From: "); String from = sc.nextLine();
        System.out.print("To: "); String to = sc.nextLine();
        System.out.print("Total Seats: ");
        int seats = sc.nextInt(); sc.nextLine();
        System.out.print("Bus type (AC/Non-AC): ");
        String busType = sc.nextLine();
        System.out.print("Is sleeper Bus? (yes/no): ");
        boolean sleeper = sc.nextLine().equalsIgnoreCase("yes");

        Bus bus = new Bus(number, from, to, seats, busType, sleeper);
        buses.add(bus);              // keep in memory
        busDAO.addBus(bus);          // also save to DB
        System.out.println("Bus added successfully!");
    }

    static void viewBuses() {
        if (buses.isEmpty()) {
            System.out.println("No buses available.");
            return;
        }
        System.out.println("--- Available Buses ---");
        for (Bus b : buses) {
            b.showDetails();
        }
    }

    static void bookTicket() {
        sc.nextLine();
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter Bus Number to book: ");
        int busNo = sc.nextInt();
        System.out.print("Number of seats: ");
        int seats = sc.nextInt(); sc.nextLine();
        System.out.print("Enter travel date (dd-MM-yyyy): ");
        String datestr = sc.nextLine();
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(datestr);
            for (Bus b : buses) {
                if (b.busNumber == busNo) {
                    if (b.bookTicket(seats)) {
                        Booking booking = new Booking(name, busNo, seats, date);
                        bookings.add(booking);           // in memory
                        bookingDAO.addBooking(booking);  // in DB
                        System.out.println("Booking successful!");
                        return;
                    } else {
                        System.out.println("Not enough seats available.");
                        return;
                    }
                }
            }
            System.out.println("Bus not found.");
        } catch (Exception e) {
            System.out.println("Invalid date format!");
        }
    }

    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }
        System.out.println("--- Booked Tickets ---");
        for (Booking b : bookings) {
            b.showBooking();
        }
    }
}
