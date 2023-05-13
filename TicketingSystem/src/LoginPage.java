import java.util.Scanner;

public class LoginPage {
    private Scanner scanner;

    public LoginPage() {
        scanner = new Scanner(System.in);
    }

    public User login(User[] users) {
        System.out.println("Helpdesk Ticketing System");
        System.out.println("-------------------------");

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Welcome, " + user.getName() + "!");
                return user;
            }
        }

        System.out.println("Invalid username or password. Please try again.");
        return null;
    }
}
