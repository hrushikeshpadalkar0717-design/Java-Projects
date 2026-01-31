package BASICS.JAVA_PROJECTS;

import java.util.Scanner;

class MovieTicket {
    String movieName;
    String seatNumber;
    double price;

   
    public MovieTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

   
    public void displayTicket() {
        System.out.println("Movie: " + movieName + ", Seat: " + seatNumber + ", Price: " + price);
    }
}

public class MovieBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tickets: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        MovieTicket[] tickets = new MovieTicket[n];
        double totalAmount = 0;

      
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Ticket " + (i + 1));
            System.out.print("Enter Movie Name: ");
            String movieName = sc.nextLine();
            System.out.print("Enter Seat Number: ");
            String seatNumber = sc.nextLine();
            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            tickets[i] = new MovieTicket(movieName, seatNumber, price);
            totalAmount += price;
        }


        if (n > 3) {
            System.out.println("\nMore than 3 tickets booked! Applying 10% discount...");
            totalAmount = totalAmount - (totalAmount * 0.10);
        }

      
        System.out.println("\n--- Ticket Details ---");
        for (MovieTicket ticket : tickets) {
            ticket.displayTicket();
        }

       
        System.out.println("\nTotal Amount to Pay: Rs. " + totalAmount);
    }
}

