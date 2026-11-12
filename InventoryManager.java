import java.util.Scanner;

class Inventory {
    String itemName;
    double quantity;
    String unit;
    double reorderLevel;
    String storageLocation;

    public Inventory(String itemName, double quantity, String unit, double reorderLevel, String storageLocation) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.unit = unit;
        this.reorderLevel = reorderLevel;
        this.storageLocation = storageLocation;

    }

    public void addStock(double amount) {
        this.quantity += amount;
    }

    public boolean useStock(double amount) {
        if (this.quantity >= amount) {
            this.quantity -= amount;
            return true;
        } else {
            return false; // Not enough stock available
        }
    }
}

public class InventoryManager {
    private Inventory[] items = new Inventory[1000];
    private int currentIndex = 0; // Tracks how many items are currently in the array

    public void inputInventory(Scanner scanner) {
        System.out.println("\n =======FARM INVENTORY INPUT======== ");
        System.out.println("Enter the following details for the inventory item and type done when your finished:");

        while(currentIndex < items.length) {
            System.out.print("Enter item name (or type 'done' to finish): ");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter quantity: ");
            double quantity = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter unit: ");
            String unit = scanner.nextLine();
            System.out.print("Enter reorder level: ");
            double reorderLevel = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter storage location: ");
            String storageLocation = scanner.nextLine();

            items[currentIndex] = new Inventory(itemName, quantity, unit, reorderLevel, storageLocation);
            currentIndex++;
        }
    }

    public Inventory[] getItems() {
        return items;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void displayInventory() {
        System.out.println("\n===========Current Inventory===========");
        if (currentIndex == 0) {
            System.out.println("No inventory items available.");
            
        }
        for (int i = 0; i < currentIndex; i++) {
            Inventory item = items[i];
            System.out.println("Item " + (i + 1) + ": " + item.itemName);
            System.out.println("Quantity: " + item.quantity + " " + item.unit);
            System.out.println("Reorder Level: " + item.reorderLevel);
            System.out.println("Storage Location: " + item.storageLocation);
            System.out.println("----------------------------------------");
        }
    }
}
