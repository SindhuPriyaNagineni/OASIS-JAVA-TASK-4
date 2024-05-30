package sindhu1;
import java.util.Scanner;

public class OnlineExaminationSystem {
    static Scanner scanner = new Scanner(System.in);
    static String username;
    static String password;
    static boolean isLoggedIn = false;
    static int remainingTime = 600; // 10 minutes in seconds
    static boolean isSessionClosed = false;

    public static void main(String[] args) {
        while (true) {
            if (!isLoggedIn) {
                login();
            } else {
                System.out.println("1. Update Profile");
                System.out.println("2. Update Password");
                System.out.println("3. Start Exam");
                System.out.println("4. Logout");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        updateProfile();
                        break;
                    case 2:
                        updatePassword();
                        break;
                    case 3:
                        startExam();
                        break;
                    case 4:
                        logout();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void login() {
        System.out.println("Enter username:");
        username = scanner.nextLine();
        System.out.println("Enter password:");
        password = scanner.nextLine();

        // Dummy authentication, replace with your actual authentication logic
        if (username.equals("admin") && password.equals("password")) {
            isLoggedIn = true;
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void updateProfile() {
        // Implement profile update logic here
        System.out.println("Profile updated successfully.");
    }

    private static void updatePassword() {
        // Implement password update logic here
        System.out.println("Password updated successfully.");
    }

    private static void startExam() {
        System.out.println("Exam started. Timer set to 10 minutes.");
        long startTime = System.currentTimeMillis();

        while (true) {
            long currentTime = System.currentTimeMillis();
            int elapsedTime = (int) ((currentTime - startTime) / 1000);
            remainingTime = 600 - elapsedTime;

            if (remainingTime <= 0) {
                System.out.println("Time's up! Auto-submitting exam.");
                break;
            }

            System.out.println("Time remaining: " + remainingTime + " seconds");

            // Add logic to select answers for MCQs, if needed

            // Simulate some delay for processing
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Exam submitted successfully.");
    }

    private static void logout() {
        isLoggedIn = false;
        isSessionClosed = true;
        System.out.println("Logout successful.");
    }
}
