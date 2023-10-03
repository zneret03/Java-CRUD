import java.util.Scanner;

public class Main {

   private static String[][] userCredentials = new String[10][2];
   private static int userCount = 0;
   private static final int MAX_USERS = 10;

  private static void registerUser(Scanner scanner) {
        System.out.println("\nUser Registration:");

        if (userCount < MAX_USERS) {
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();

            // Check if the username is already taken
            if (isUsernameTaken(username)) {
                System.out.println("Username already exists. Please choose another one.");
            } else {
                userCredentials[userCount][0] = username;
                userCredentials[userCount][1] = password;
                userCount++;
                System.out.println("Registration successful.");
            }
        } else {
            System.out.println("Maximum number of users reached.");
        }
    }

 private static void loginUser(Scanner scanner) {
        System.out.println("\nUser Login:");

        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        for (int i = 0; i < userCount; i++) {
            if (userCredentials[i][0].equals(username) && userCredentials[i][1].equals(password)) {
                System.out.println("Login successful!");
                return;
            }
        }

        System.out.println("Login failed. Please check your username and password.");
    }

    private static boolean isUsernameTaken(String username) {
        for (int i = 0; i < userCount; i++) {
            if (userCredentials[i][0].equals(username)) {
                return true;
            }
        }
        return false;
    }

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Login and Register System!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (userCount < MAX_USERS) {
                        registerUser(scanner);
                    } else {
                        System.out.println("Maximum number of users reached.");
                    }
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
  } 
}
