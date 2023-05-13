import java.util.Scanner;

public class TicketCreationPage {
    private Scanner scanner;
    private int ticketNumberCounter;

    public TicketCreationPage() {
        scanner = new Scanner(System.in);
        ticketNumberCounter = 0;
    }

    public Ticket createTicket(User user) {
        ticketNumberCounter++;
        String ticketNumber = String.format("%06d", ticketNumberCounter);

        System.out.println("Helpdesk Ticketing System");
        System.out.println("-------------------------");
        System.out.println("Create New Ticket (Ticket #" + ticketNumber + ")");
        System.out.println("--------------------------------------------");

        System.out.print("Enter ticket subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter ticket description: ");
        String description = scanner.nextLine();

        Ticket ticket = new Ticket(ticketNumber, subject, description, "OPENED", user);

        // Save the new ticket to the database or ticket repository

        System.out.println("Ticket #" + ticketNumber + " created successfully!");
        return ticket;
    }
}
