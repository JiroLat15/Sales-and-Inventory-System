import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class SalesAndInventoryClass {
    
    static ArrayList<String> inventory = new ArrayList<String>();
    static ArrayList<Double> prices = new ArrayList<Double>();
    static ArrayList<Integer> quantities = new ArrayList<Integer>();

    static ArrayList<String> inventorySales = new ArrayList<String>();
    static ArrayList<Double> pricesSales = new ArrayList<Double>();
    static ArrayList<Integer> quantitiesSales = new ArrayList<Integer>();

    static Scanner scanner = new Scanner(System.in);

    public static void addItem() throws IOException, InterruptedException {

        clearScreen();
        System.out.println("----------------------------------");
        System.out.println("---Adding Item to the Inventory---");
        System.out.println("----------------------------------");

        System.out.print("\nEnter the item name: ");
        String item = scanner.next();
        System.out.print("Enter the item price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter the item quantity: ");
        int quantity = scanner.nextInt();
        inventory.add(item);
        prices.add(price);
        quantities.add(quantity);

        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println("-----Item added to inventory.-----");
        System.out.println("----------------------------------");

        System.out.print("\nPress Enter to return to the main menu...");
        scanner.nextLine();
        scanner.nextLine(); // Wait for user to press Enter
    }

    public static void removeItem() throws IOException, InterruptedException {

        clearScreen();
        System.out.println("--------------------------------------");
        System.out.println("---Removing Item from the Inventory---");
        System.out.println("--------------------------------------");

        System.out.print("\nEnter the item name to remove: ");
        String item = scanner.next();
        int index = inventory.indexOf(item);


        if (index == -1) {

            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("-----Item not found in inventory.-----");
            System.out.println("--------------------------------------");

            System.out.print("\nPress Enter to return to the main menu...");
            scanner.nextLine();
            scanner.nextLine(); // Wait for user to press Enter

        } else {

            inventory.remove(index);
            prices.remove(index);
            quantities.remove(index);

            System.out.println("");
            System.out.println("--------------------------------------");
            System.out.println("-----Item removed from inventory.-----");
            System.out.println("--------------------------------------");

            System.out.print("\nPress Enter to return to the main menu...");
            scanner.nextLine();
            scanner.nextLine(); // Wait for user to press Enter
        }
    }

    public static void searchItem() throws IOException, InterruptedException {

        clearScreen();
        System.out.println("-------------------------------------------");
        System.out.println("----Searching for the Item in Inventory----");
        System.out.println("-------------------------------------------\n");

        System.out.print("Enter the item name to search: ");
        String item = scanner.next();
        int index = inventory.indexOf(item);


        if (index == -1) {
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println("--------Item not found in inventory.-------");
            System.out.println("-------------------------------------------");

            System.out.print("\nPress Enter to return to the main menu...");
            scanner.nextLine();
            scanner.nextLine(); // Wait for user to press Enter

        } else {

            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println("<---------Item found in inventory--------->");

            System.out.println();
            System.out.println("Item name: " + inventory.get(index));
            System.out.println("Item price: " + prices.get(index));
            System.out.println("Item quantity: " + quantities.get(index));
            System.out.println();

            System.out.println("-------------------------------------------");
            System.out.println("<--------------End of Print.-------------->");
            System.out.println("-------------------------------------------");

            System.out.print("\nPress Enter to return to the main menu...");
            scanner.nextLine();
            scanner.nextLine(); // Wait for user to press Enter
        }
    }

    public static void displayInventory() throws IOException, InterruptedException {

        clearScreen();
        if (inventory.size() == 0) {
            
            clearScreen();
            System.out.println("-------------------------------------------");
            System.out.println("-----Displaying All Items in Inventory-----");
            System.out.println("-------------------------------------------\n");

            System.out.println("0 Items in Inventory...\n");
            
            System.out.println("-------------------------------------------");
            System.out.println("------------Inventory is empty.------------");
            System.out.println("-------------------------------------------");

            System.out.print("\nPress Enter to return to the main menu...");
            // scanner.nextLine();
            scanner.nextLine(); // Wait for user to press Enter

        } else {

            clearScreen();
            System.out.println("-------------------------------------------");
            System.out.println("<----Displaying All Items in Inventory---->");
            System.out.println();
                            
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println("Item name: " + inventory.get(i));
                System.out.println("Item price: " + prices.get(i));
                System.out.println("Item quantity: " + quantities.get(i));
                System.out.println();

            }

            System.out.println("<--------------End of Print.-------------->");
            System.out.println("-------------------------------------------");

            System.out.print("\nPress Enter to return to the main menu...");
            //scanner.nextLine();
            scanner.nextLine(); // Wait for user to press Enter
        }
    }

    public static void makeSale() throws IOException, InterruptedException {

        clearScreen();
        System.out.println("----------------------------------------");
        System.out.println("---------------Make a Sale--------------");
        System.out.println("----------------------------------------");
    
        System.out.print("\nEnter the item name to sell: ");
        String item = scanner.next();
        int index = inventory.indexOf(item);
    

        if (index == -1) {
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("------Item not found in inventory.------");
            System.out.println("----------------------------------------");
    
            System.out.print("\nPress Enter to return to the main menu...");
            scanner.nextLine();
            scanner.nextLine(); // Wait for user to press Enter
        } 
        
        else {

            System.out.print("Enter the quantity to sell: ");
            int quantity = scanner.nextInt();
            System.out.println();
                    
            if (quantity > quantities.get(index)) {

                System.out.println("\nNot enough " + item + " in stock to complete sale.");

                System.out.print("\nPress Enter to return to the main menu...");
                scanner.nextLine();
                scanner.nextLine(); // Wait for user to press Enter
            } 
            
            else {
                double totalCost = prices.get(index) * quantity;
    
                // update inventory
                int newQuantity = quantities.get(index) - quantity;
                quantities.set(index, newQuantity);
    
                // print receipt
                System.out.println("----------------------------------------");
                System.out.println("<----------------Receipt--------------->");
    
                System.out.println();
                System.out.println("Item name: " + item);
                System.out.println("Item price: " + prices.get(index));
                System.out.println("Quantity sold: " + quantity);
                System.out.println("Total cost: " + totalCost);
                System.out.println();
                inventorySales.add(item);
                pricesSales.add(totalCost);
                quantitiesSales.add(quantity);
                

                System.out.println("<------------End of Receipt.----------->");
                System.out.println("----------------------------------------");
    
                System.out.print("\nPress Enter to return to the main menu...");
                scanner.nextLine();
                scanner.nextLine(); // Wait for user to press Enter
            }
        } 
    }

    public static void displaySalesHistory() throws IOException, InterruptedException {
        
        clearScreen();
        System.out.println("----------------------------------------------------------");
        System.out.println("<---------------------Sales History---------------------->\n");
        
        double totalPrice = 0.0;
        if (pricesSales != null && !pricesSales.isEmpty()) {
            System.out.printf("%-25s%-20s%-15s\n", "Product", "Price", "No. of Items\n");

        for (int i = 0; i < pricesSales.size(); i++) {

                double price = pricesSales.get(i);
                int quantity = quantitiesSales.get(i);

                System.out.printf("%-25s%-20s%d\n", inventorySales.get(i), price, quantity);
                totalPrice += price * quantity;
            }
        }

        else {
            System.out.println("                 No sales history found.");
        }

        System.out.println("\n\nTotal Price: " + totalPrice);

        System.out.println("\n<---------------------End of History--------------------->");
        System.out.println("----------------------------------------------------------");
        System.out.println();
        System.out.print("Press Enter to return to the main menu...");
        //scanner.nextLine();
        scanner.nextLine();
    }

    public static void clearScreen() throws IOException, InterruptedException {

        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
        } 
        
        else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
