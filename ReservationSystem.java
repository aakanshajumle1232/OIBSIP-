
package reservationsystem;

import java.util.Scanner;

public class ReservationSystem {
    private static String loginId = "admin";
    private static String password = "password";
    private static boolean loggedIn = false;
    private static int pnrCount = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Login Form
        System.out.println("===== Online Reservation System =====");
        System.out.print("Enter Login ID: ");
        String enteredLoginId = scanner.nextLine();
        System.out.print("Enter Password: ");
        String enteredPassword = scanner.nextLine();
        if (login(enteredLoginId, enteredPassword)) {
            System.out.println("Login successful!\n");
            loggedIn = true;
        } else {
            System.out.println("Invalid login credentials. Exiting...");
            return;
        }

        // Reservation System
        if (loggedIn) {
            System.out.println("===== Reservation Form =====");
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter train number: ");
            String trainNumber = scanner.nextLine();
            System.out.print("Enter class type: ");
            String classType = scanner.nextLine();
            System.out.print("Enter date of journey: ");
            String dateOfJourney = scanner.nextLine();
            System.out.print("Enter departure location: ");
            String departureLocation = scanner.nextLine();
            System.out.print("Enter destination: ");
            String destination = scanner.nextLine();
            
            // Generate PNR
            String pnr = generatePNR();
            
            // Perform insert operation or store the data in the database
            
            System.out.println("\nReservation successful!");
            System.out.println("PNR: " + pnr);
        }

        // Cancellation Form
        if (loggedIn) {
            System.out.println("\n===== Cancellation Form =====");
            System.out.print("Enter PNR number: ");
            String pnrToCancel = scanner.nextLine();
            
            // Fetch reservation details from the database using the provided PNR number
            
            System.out.println("\nReservation details for PNR " + pnrToCancel + ":");
            // Display the reservation details
            
            System.out.print("\nDo you want to confirm the cancellation? (Y/N): ");
            String confirmCancel = scanner.nextLine();
            if (confirmCancel.equalsIgnoreCase("Y")) {
                // Perform cancellation operation in the database
                
                System.out.println("Cancellation confirmed for PNR " + pnrToCancel);
            } else {
                System.out.println("Cancellation not confirmed. Exiting...");
            }
        }
        
        scanner.close();
    }

    private static boolean login(String enteredLoginId, String enteredPassword) {
        return enteredLoginId.equals(loginId) && enteredPassword.equals(password);
    }
    
    private static String generatePNR() {
        return "PNR" + pnrCount++;
    }
}
