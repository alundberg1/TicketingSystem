import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelpDeskSystem {
    private ArrayList<User> users;
    private ArrayList<Ticket> tickets;
    private int ticketNumberCounter;
    private Scanner scanner;
    private User currUser;
    private String username;
    private String password;

    public HelpDeskSystem() {
        this.users = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.ticketNumberCounter = 0;
        scanner = new Scanner(System.in);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addTicket(Ticket ticket) {
        ticket.setTicketNumber(String.format("%06d", ++ticketNumberCounter));
        tickets.add(ticket);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public User getCurrUser() {
        return currUser;
    }

    public void setCurrUser(User currUser) {
        this.currUser = currUser;
    }

    public void printLogin() {
        System.out.println("Helpdesk Ticketing System");
        System.out.println("-------------------------");

        System.out.print("Enter username: ");
        this.username = scanner.nextLine();

        System.out.print("Enter password: ");
        this.password = scanner.nextLine();
    }
    public User validateLogin() {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

}
