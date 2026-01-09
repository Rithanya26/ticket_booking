package con.trainbooking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketService service = new TicketService();
        int choice;

        do {
            System.out.println("\n--- Train Ticket Booking System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Show All Tickets");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter seat number: ");
                    int seat = sc.nextInt();
                    sc.nextLine();

                    if (service.bookTicket(name, age, seat)) {
                        System.out.println("Ticket booked successfully!");
                    } else {
                        System.out.println("Booking failed. Seat might be taken.");
                    }
                    break;

                case 2:
                    service.showAllTickets();
                    break;

                case 3:
                    System.out.print("Enter ticket ID to cancel: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (service.cancelTicket(id)) {
                        System.out.println("Ticket cancelled successfully!");
                    } else {
                        System.out.println("Cancellation failed. Invalid ticket ID.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
