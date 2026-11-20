import java.util.LinkedList;
import java.util.Scanner;

class Customer {
    int tokenNumber;
    String name;
    String serviceType;

    Customer(int tokenNumber, String name, String serviceType) {
        this.tokenNumber = tokenNumber;
        this.name = name;
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Token #" + tokenNumber + " | Name: " + name + " | Service: " + serviceType;
    }
}

public class Main {
    static LinkedList<Customer> queue = new LinkedList<>();
    static int nextToken = 101;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SMART QUEUE MANAGEMENT SYSTEM ===");
            System.out.println("1. Generate Token");
            System.out.println("2. Call Next Customer");
            System.out.println("3. Display Queue");
            System.out.println("4. Search Token");
            System.out.println("5. Skip Customer");
            System.out.println("6. Show Waiting Count");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number (1-7).");
                continue;
            }

            switch (choice) {
                case 1:
                    generateToken(sc);
                    break;
                case 2:
                    callNextCustomer();
                    break;
                case 3:
                    displayQueue();
                    break;
                case 4:
                    searchToken(sc);
                    break;
                case 5:
                    skipCustomer();
                    break;
                case 6:
                    showWaitingCount();
                    break;
                case 7:
                    System.out.println("Exiting Smart Queue Management System. Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 7.");
            }
        }
    }

    // 1. Generate Token
    static void generateToken(Scanner sc) {
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Service Type (e.g., Inquiry, Billing, Support): ");
        String service = sc.nextLine().trim();

        if (name.isEmpty() || service.isEmpty()) {
            System.out.println("Error: Name and Service Type cannot be empty.");
            return;
        }

        Customer newCustomer = new Customer(nextToken++, name, service);
        queue.addLast(newCustomer);
        System.out.println("Token Generated Successfully -> " + newCustomer);
    }

    // 2. Call Next Customer
    static void callNextCustomer() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty! No customers waiting.");
            return;
        }
        Customer next = queue.removeFirst();
        System.out.println("Now Serving -> " + next);
    }

    // 3. Display Queue
    static void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is currently empty.");
            return;
        }
        System.out.println("\n--- Current Waiting Queue ---");
        int position = 1;
        for (Customer c : queue) {
            System.out.println(position++ + ". " + c);
        }
    }

    // 4. Search Token
    static void searchToken(Scanner sc) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        try {
            System.out.print("Enter Token Number to search: ");
            int token = Integer.parseInt(sc.nextLine().trim());

            int position = 1;
            for (Customer c : queue) {
                if (c.tokenNumber == token) {
                    System.out.println("Found at Position " + position + " -> " + c);
                    return;
                }
                position++;
            }
            System.out.println("Token #" + token + " not found in the active queue.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid numeric token number.");
        }
    }

    // 5. Skip Customer (Moves front customer to the back of the queue)
    static void skipCustomer() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty! No customer to skip.");
            return;
        }
        if (queue.size() == 1) {
            System.out.println("Only one customer in queue (" + queue.peek() + "). Cannot skip.");
            return;
        }
        Customer skipped = queue.removeFirst();
        queue.addLast(skipped);
        System.out.println("Skipped Customer (Moved to end of queue) -> " + skipped);
    }

    // 6. Show Waiting Count
    static void showWaitingCount() {
        System.out.println("Total Customers Waiting in Queue: " + queue.size());
    }
}