import java.util.ArrayList;
import java.util.Scanner;

public class TechnicianDashboard {
    private Scanner scanner;
    private ArrayList<Ticket> tickets;
    private ArrayList<User> users;

    public TechnicianDashboard(ArrayList<Ticket> tickets, ArrayList<User> users) {
        scanner = new Scanner(System.in);
        this.tickets = tickets;
        this.users = users;
    }

    public void updateTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void updateUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void displayTickets(User user) {
        System.out.println("Helpdesk Ticketing System");
        System.out.println("-------------------------");
        System.out.println("Technician Dashboard");
        System.out.println("--------------------");

        // Get all open or assigned tickets for the current user
        for (Ticket ticket : tickets) {
            if ((ticket.getStatus().equals("OPENED") || ticket.getStaff().equals(user)) &&
                    (user.getRole().equals("technician") || user.getRole().equals("admin"))) {
                System.out.println("Ticket #" + ticket.getTicketNumber() + ": " + ticket.getSubject());
                System.out.println("Description: " + ticket.getDescription());
                System.out.println("Status: " + ticket.getStatus());
                System.out.println("Priority: " + ticket.getPriority());
                if(ticket.getStaff() == null) {
                    System.out.println("Staff: Unassigned");
                } else System.out.println("Staff: " + ticket.getStaff().getName());


                System.out.println("--------------------");
            }
        }

        // Prompt user to select a ticket to open or resolve
        System.out.print("Enter ticket number to open or resolve (or type 'cancel' to go back to main menu): ");
        String ticketNumberInput = scanner.nextLine();

        if (ticketNumberInput.equals("cancel")) {
            return;
        }

        // Find the ticket with the matching ticket number and prompt user to assign or resolve it
        for (Ticket ticket : tickets) {
            if (ticket.getTicketNumber().equals(ticketNumberInput)) {
                System.out.println("Ticket #" + ticket.getTicketNumber() + ": " + ticket.getSubject());
                System.out.println("Description: " + ticket.getDescription());
                System.out.println("Status: " + ticket.getStatus());
                System.out.println("Priority: " + ticket.getPriority());
                if(ticket.getStaff() == null) {
                    System.out.println("Staff: Unassigned");
                } else System.out.println("Staff: " + ticket.getStaff().getName());
                System.out.println("--------------------");

                if (ticket.getStatus().equals("OPENED")) {
                    System.out.print("Enter 'assign' to assign the ticket, 'resolve' to resolve and close the ticket, or 'cancel' to go back to main menu: ");
                    String action = scanner.nextLine();

                    if (action.equals("cancel")) {
                        return;
                    } else if (action.equals("assign")) {
                        // Prompt user to enter the username of the technician to assign the ticket to
                        System.out.print("Enter name of technician to assign ticket to: ");
                        String name = scanner.nextLine();
                        User staff = null;

                        // Find the user with the matching username
                        for (User u : users) {
                            if (u.getName().equals(name)) {
                                staff = u;
                                break;
                            }
                        }

                        if (staff == null) {
                            System.out.println("Invalid username. Ticket assignment failed.");
                        } else {
                            ticket.setStaff(staff);
                            ticket.setStatus("ASSIGNED");
                            System.out.println("Ticket assigned to " + staff.getName() + " successfully.");
                        }
                    } else if (action.equals("resolve")) {
                        // Prompt user to enter the resolution details
                        System.out.print("Enter resolution details: ");
                        String resolution = scanner.nextLine();

                        ticket.setResolution(resolution);
                        ticket.setStatus("RESOLVED");
                        System.out.println("Ticket resolved successfully.");
                    }
                }

                break;
            }
        }
    }
}