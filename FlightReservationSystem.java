package BASICS.JAVA_PROJECTS;

import java.util.*;

class Flight {
    int flightId;
    String source;
    String destination;
    String date;
    double price;

    public Flight(int flightId, String source, String destination, String date, double price) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.price = price;
    }

    @Override
    public String toString() {
        return flightId + " | " + source + " -> " + destination + " | Date: " + date + " | Price: " + price;
    }
}

class Booking {
    int bookingId;
    Flight flight;
    String passengerName;

    public Booking(int bookingId, Flight flight, String passengerName) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passengerName = passengerName;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + " | " + passengerName + " | " + flight.toString();
    }
}

public class FlightReservationSystem {
    static List<Flight> flights = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();
    static int bookingCounter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initializeFlights();

        while (true) {
            System.out.println("\n--- Flight Reservation System ---");
            System.out.println("1. View All Flights");
            System.out.println("2. Search Flights");
            System.out.println("3. Sort Flights by Price");
            System.out.println("4. Book a Flight");
            System.out.println("5. Cancel Booking");
            System.out.println("6. View All Bookings");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewAllFlights();
                    break;
                case 2:
                    System.out.print("Enter Destination: ");
                    String destination = sc.nextLine();
                    searchFlights(destination);
                    break;
                case 3:
                    sortFlightsByPrice();
                    break;
                case 4:
                    System.out.print("Enter Flight ID: ");
                    int flightId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Passenger Name: ");
                    String name = sc.nextLine();
                    bookFlight(flightId, name);
                    break;
                case 5:
                    System.out.print("Enter Booking ID to Cancel: ");
                    int bookingId = sc.nextInt();
                    cancelBooking(bookingId);
                    break;
                case 6:
                    viewAllBookings();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.out.println("Exited.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void initializeFlights() {
        flights.add(new Flight(101, "Mumbai", "Delhi", "2025-09-01", 4500));
        flights.add(new Flight(102, "Mumbai", "Bangalore", "2025-09-02", 3500));
        flights.add(new Flight(103, "Delhi", "Kolkata", "2025-09-03", 5000));
        flights.add(new Flight(104, "Pune", "Hyderabad", "2025-09-04", 3000));
    }

    static void viewAllFlights() {
        for (Flight f : flights) {
            System.out.println(f);
        }
    }

    static void searchFlights(String destination) {
        for (Flight f : flights) {
            if (f.destination.equalsIgnoreCase(destination)) {
                System.out.println(f);
            }
        }
    }

    static void sortFlightsByPrice() {
        flights.sort(Comparator.comparingDouble(f -> f.price));
        System.out.println("Flights Sorted by Price:");
        viewAllFlights();
    }

    static void bookFlight(int flightId, String name) {
        for (Flight f : flights) {
            if (f.flightId == flightId) {
                bookings.add(new Booking(bookingCounter++, f, name));
                System.out.println("Booking Successful! Booking ID: " + (bookingCounter - 1));
                return;
            }
        }
        System.out.println("Flight not found!");
    }

    static void cancelBooking(int bookingId) {
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking b = iterator.next();
            if (b.bookingId == bookingId) {
                iterator.remove();
                System.out.println("Booking Cancelled!");
                return;
            }
        }
        System.out.println("Booking ID not found!");
    }

    static void viewAllBookings() {
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }
}
