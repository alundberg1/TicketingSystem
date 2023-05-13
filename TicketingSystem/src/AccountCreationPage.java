import java.util.Scanner;

public class AccountCreationPage {
    private Scanner scanner;

    public AccountCreationPage() {
        scanner = new Scanner(System.in);
    }

    public User display(User admin) {
        if (!admin.getRole().equals("admin")) {
            System.out.println("Access denied. Only users with the role 'admin' can access this page.");
            return null;
        }

        System.out.println("Account Creation Page");
        System.out.println("----------------------");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter role: ");
        String role = scanner.nextLine();

        User user = new User(firstName, lastName, email, password, role);

        // Save the new user to the database or user repository

        System.out.println("Account created successfully!");
        return user;
    }
}

