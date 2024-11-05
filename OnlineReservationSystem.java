import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class OnlineReservationSystem {
    private Map<String, String> users = new HashMap<>();
    private Map<String, Reservation> reservations = new HashMap<>();

    public OnlineReservationSystem() {
        // Adding some sample users (username, password)
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    // Login form
    public boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    // Reservation form
    public void makeReservation(String pnr, String trainNumber, String trainName, String from, String to, String date, String classType) {
        Reservation reservation = new Reservation(pnr, trainNumber, trainName, from, to, date, classType);
        reservations.put(pnr, reservation);
        System.out.println("Reservation made successfully.");
    }

    // Cancellation form
    public void cancelReservation(String pnr) {
        if (reservations.containsKey(pnr)) {
            reservations.remove(pnr);
            System.out.println("Reservation cancelled successfully.");
        } else {
            System.out.println("No reservation found with this PNR.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OnlineReservationSystem system = new OnlineReservationSystem();

        System.out.println("Welcome to the Online Reservation System");
        
        // Login
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (system.login(username, password)) {
            System.out.println("Login successful!");
            boolean running = true;
            
            while (running) {
                System.out.println("\nMenu:");
                System.out.println("1. Make a Reservation");
                System.out.println("2. Cancel a Reservation");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Reservation form input
                        System.out.print("Enter PNR: ");
                        String pnr = scanner.nextLine();
                        System.out.print("Enter Train Number: ");
                        String trainNumber = scanner.nextLine();
                        System.out.print("Enter Train Name: ");
                        String trainName = scanner.nextLine();
                        System.out.print("Enter From (place): ");
                        String from = scanner.nextLine();
                        System.out.print("Enter To (destination): ");
                        String to = scanner.nextLine();
                        System.out.print("Enter Date of Journey: ");
                        String date = scanner.nextLine();
                        System.out.print("Enter Class Type: ");
                        String classType = scanner.nextLine();

                        system.makeReservation(pnr, trainNumber, trainName, from, to, date, classType);
                        break;
                        
                    case 2:
                        // Cancellation form input
                        System.out.print("Enter PNR to cancel: ");
                        pnr = scanner.nextLine();
                        system.cancelReservation(pnr);
                        break;
                        
                    case 3:
                        running = false;
                        System.out.println("Exiting system.");
                        break;
                        
                    default:
                        System.out.println("Invalid option. Try again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid username or password.");
        }
        
        scanner.close();
    }
}

class Reservation {
    private String pnr;
    private String trainNumber;
    private String trainName;
    private String from;
    private String to;
    private String date;
    private String classType;

    public Reservation(String pnr, String trainNumber, String trainName, String from, String to, String date, String classType) {
        this.pnr = pnr;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.from = from;
        this.to = to;
        this.date = date;
        this.classType = classType;
    }

    @Override
    public String toString() {
        return "PNR: " + pnr + ", Train: " + trainNumber + " - " + trainName + ", From: " + from + ", To: " + to +
               ", Date: " + date + ", Class: " + classType;
    }
}