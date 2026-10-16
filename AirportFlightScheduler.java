
import java.util.Scanner;

class Flight {
    int flightNumber;
    String airlineName;
    String source;
    String destination;
    String departureTime;
    String status;

    void display() {
        System.out.println("\nFlight Number: " + flightNumber);
        System.out.println("Airline Name: " + airlineName);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Status: " + status);
        System.out.println("--------------------------------");
    }
}

public class AirportFlightScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Flight[] flights = new Flight[10];
        int count = 0;
        int choice;

        do {
            System.out.println("\n===== AIRPORT FLIGHT BOARD =====");
            System.out.println("1. Add Flight");
            System.out.println("2. View All Flights");
            System.out.println("3. Search Flight");
            System.out.println("4. Update Flight Status");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (count < flights.length) {
                        Flight f = new Flight();

                        System.out.print("Enter Flight Number: ");
                        f.flightNumber = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Airline Name: ");
                        f.airlineName = sc.nextLine();

                        System.out.print("Enter Source: ");
                        f.source = sc.nextLine();

                        System.out.print("Enter Destination: ");
                        f.destination = sc.nextLine();

                        System.out.print("Enter Departure Time: ");
                        f.departureTime = sc.nextLine();

                        System.out.print("Enter Status (On Time/Delayed/Cancelled): ");
                        f.status = sc.nextLine();

                        flights[count] = f;
                        count++;

                        System.out.println("Flight added successfully!");
                    } else {
                        System.out.println("Flight board is full!");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No flights available.");
                    } else {
                        System.out.println("\n===== FLIGHT DETAILS =====");
                        for (int i = 0; i < count; i++) {
                            flights[i].display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Flight Number to search: ");
                    int number = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (flights[i].flightNumber == number) {
                            flights[i].display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Flight not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Flight Number: ");
                    int updateNumber = sc.nextInt();
                    sc.nextLine();
                    boolean updated = false;

                    for (int i = 0; i < count; i++) {
                        if (flights[i].flightNumber == updateNumber) {
                            System.out.print("Enter New Status: ");
                            flights[i].status = sc.nextLine();
                            System.out.println("Flight status updated!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Flight not found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Airport Flight Scheduler!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
