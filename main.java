import java.util.HashMap;
import java.util.Scanner;

public class LoginSystem {

    // Store username and password
    static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n==== LOGIN AUTHENTICATION SYSTEM ====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    register(sc);
                    break;

                case 2:
                    login(sc);
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Registration Method
    public static void register(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            return;
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        users.put(username, password);
        System.out.println("Registration successful!");
    }

    // Login Method
    public static void login(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful!");
            securedPage(username);
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    // Secured Page
    public static void securedPage(String username) {
        System.out.println("\n===== SECURED PAGE =====");
        System.out.println("Welcome, " + username + "!");
        System.out.println("You have successfully accessed the secured page.");
    }
}