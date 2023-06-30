import java.util.Scanner;

public class OnlineReservationSystem {
    private static String loggedInUser = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== ONLINE RESERVATION SYSTEM =====");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    System.out.println("Thank you for using the Online Reservation System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.println("===== LOGIN FORM =====");
        System.out.print("Enter your login id: ");
        String loginId = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if loginId and password are valid (you can implement your own
        // validation logic here)
        if (isValidLogin(loginId, password)) {
            loggedInUser = loginId;
            System.out.println("Login successful. Welcome, " + loggedInUser + "!");
            showMainMenu(scanner);
        } else {
            System.out.println("Invalid login credentials. Please try again.");
        }
    }

    private static boolean isValidLogin(String loginId, String password) {
        // Add your validation logic here
        // This is just a dummy check, you should implement your own logic to validate
        // the login credentials
        return loginId.equals("admin") && password.equals("password");
    }

    private static void showMainMenu(Scanner scanner) {
        while (true) {
            System.out.println("===== MAIN MENU =====");
            System.out.println("1. Reservation");
            System.out.println("2. Cancellation");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    reservation(scanner);
                    break;
                case 2:
                    cancellation(scanner);
                    break;
                case 3:
                    System.out.println("Logout successful. Goodbye, " + loggedInUser + "!");
                    loggedInUser = null;
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void reservation(Scanner scanner) {
        if (loggedInUser != null) {
            System.out.println("===== RESERVATION FORM =====");
            // Implement your reservation logic here
            System.out.println("Reservation successful.");
        } else {
            System.out.println("Please login first to access the reservation form.");
        }
    }

    private static void cancellation(Scanner scanner) {
        if (loggedInUser != null) {
            System.out.println("===== CANCELLATION FORM =====");
            System.out.print("Enter your PNR number: ");
            String pnrNumber = scanner.nextLine();

            // Implement your cancellation logic here
            System.out.println("Cancellation successful.");
        } else {
            System.out.println("Please login first to access the cancellation form.");
        }
    }
}
