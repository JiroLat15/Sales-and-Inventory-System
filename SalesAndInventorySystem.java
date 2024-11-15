import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class SalesAndInventorySystem {

    static ArrayList<String> inventory = new ArrayList<String>();
    static ArrayList<Double> prices = new ArrayList<Double>();
    static ArrayList<Integer> quantities = new ArrayList<Integer>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        SalesAndInventoryClass inventoryClass = new SalesAndInventoryClass();
        
        while (true) {

            inventoryClass.clearScreen();
            System.out.println("================================================");
            System.out.println("===Welcome to the Sales and Inventory System!===");
            System.out.println("================================================\n");

            System.out.println("1. Add an item to the inventory");
            System.out.println("2. Remove an item from the inventory");
            System.out.println("3. Search for an item in the inventory");
            System.out.println("4. Display the inventory");
            System.out.println("5. Make a sale");
            System.out.println("6. History Sale Book");
            System.out.println("7. Exit the program");

            System.out.print("\nEnter your option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    inventoryClass.addItem();
                    break;
                case 2:
                    inventoryClass.removeItem();
                    break;
                case 3:
                    inventoryClass.searchItem();
                    break;
                case 4:
                    inventoryClass.displayInventory();
                    break;
                case 5:
                    inventoryClass.makeSale();
                    break;
                case 6:
                    inventoryClass.displaySalesHistory();
                    break;
                case 7:
                    inventoryClass.clearScreen();
                    System.out.println("Shutting Down...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
