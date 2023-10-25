import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    signUp(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void signUp(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if (userDatabase.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different one.");
            return;
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        userDatabase.put(username, password);
        System.out.println("Sign up successful!");
    }

    public static void login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if (!userDatabase.containsKey(username)) {
            System.out.println("Username does not exist. Please sign up.");
            return;
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (userDatabase.get(username).equals(password)) {
            System.out.println("Welcome, " + username + "!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}
