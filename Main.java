import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            ShoppingOperations operations = new ShoppingOperations();
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Shopping List Menu ---");
                System.out.println("1. Add Item");
                System.out.println("2. View All Items");
                System.out.println("3. Update Item");
                System.out.println("4. Delete Item");
                System.out.println("5. Mark Item as Purchased");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter item name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        operations.addItem(new Item(name, quantity));
                        break;
                    case 2:
                        System.out.println("All Items:");
                        operations.getItems().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Enter Item ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new quantity: ");
                        int newQuantity = scanner.nextInt();
                        operations.updateItem(updateId, newName, newQuantity);
                        break;
                    case 4:
                        System.out.print("Enter Item ID to delete: ");
                        int deleteId = scanner.nextInt();
                        operations.deleteItem(deleteId);
                        break;
                    case 5:
                        System.out.print("Enter Item ID to mark as purchased: ");
                        int purchaseId = scanner.nextInt();
                        operations.markAsPurchased(purchaseId);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
