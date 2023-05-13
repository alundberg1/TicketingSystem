import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Initialize the helpdesk system with some sample data
        HelpDeskSystem helpdeskSystem = new HelpDeskSystem();

        // Initialize a scanner for user input
        Scanner scanner = new Scanner(System.in);

        User test = new User("Anthony", "Lundberg", "alundberg", "admin", "admin");
        helpdeskSystem.addUser(test);

        User currUser = null;

        while (currUser == null) {
            helpdeskSystem.printLogin();
            currUser = helpdeskSystem.validateLogin();
            if (currUser == null) System.out.println("Invalid username or password. Please try again.");
        }
        helpdeskSystem.setCurrUser(currUser);
        System.out.println("Welcome, " + helpdeskSystem.getCurrUser().getUsername() + " (" + helpdeskSystem.getCurrUser().getRole() + ")");
        System.out.println();

        MainMenu menu = new MainMenu(helpdeskSystem.getCurrUser());
        TicketCreationPage newTicket = new TicketCreationPage();
        TechnicianDashboard dashboard = new TechnicianDashboard(helpdeskSystem.getTickets(), helpdeskSystem.getUsers());
        AccountCreationPage newUser = new AccountCreationPage();
        while (true) {
            menu.display();
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Goodbye!");
                    return;
                case "2":
                    Ticket ticket = newTicket.createTicket(helpdeskSystem.getCurrUser());
                    helpdeskSystem.addTicket(ticket);
                    break;
                case "3":
                    if (helpdeskSystem.getCurrUser().getRole() != "admin" && helpdeskSystem.getCurrUser().getRole() != "technician") {
                        System.out.println("Invalid option. Please try again.");
                        break;
                    }
                    dashboard.displayTickets(helpdeskSystem.getCurrUser());
                    break;
                case "4":
                    if (helpdeskSystem.getCurrUser().getRole() != "admin") {
                        System.out.println("Invalid option. Please try again.");
                        break;
                    }
                    User createNewUser = newUser.display(helpdeskSystem.getCurrUser());
                    if (createNewUser != null) helpdeskSystem.addUser(createNewUser);
                    else {
                        System.out.println("User creation failed. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

    }
}
