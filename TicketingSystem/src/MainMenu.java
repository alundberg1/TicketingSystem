public class MainMenu {
    private User currentUser;

    public MainMenu(User currentUser) {
        this.currentUser = currentUser;
    }

    public void display() {
        System.out.println("Welcome to the Help Desk Ticketing System!");
        System.out.println("--------------------------------------------------");
        System.out.println("Current User: " + currentUser.getName() + " (Role: " + currentUser.getRole() + ")");
        System.out.println("--------------------------------------------------");

        if (currentUser.getRole().equals("admin")) {
            System.out.println("Please choose an option:");
            System.out.println("1. Quit");
            System.out.println("2. Submit Ticket");
            System.out.println("3. View Tickets");
            System.out.println("4. Create New User");
        } else if (currentUser.getRole().equals("technician")) {
            System.out.println("Please choose an option:");
            System.out.println("1. Quit");
            System.out.println("2. Submit Ticket");
            System.out.println("3. View Tickets");
        } else {
            System.out.println("Please choose an option:");
            System.out.println("1. Quit");
            System.out.println("2. Submit Ticket");
        }
    }
}

