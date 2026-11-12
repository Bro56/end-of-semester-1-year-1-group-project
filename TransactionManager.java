// Simple data structure class to hold individual transaction info
class TransactionRecord {
    String date;
    String type;
    String category;
    String details;
    double amount;

    public TransactionRecord(String date, String type, String category, String details, double amount) {
        this.date = date;
        this.type = type;
        this.category = category;
        this.details = details;
        this.amount = amount;
    }
}

public class TransactionManager {
    // Plain Java array with a fixed maximum capacity of 100 transactions
    private TransactionRecord[] transactionArray = new TransactionRecord[1000];
    private int currentIndex = 0; // Tracks how many items are currently in the array

    private double totalIncome = 0.0;
    private double totalExpenses = 0.0;

    // Adds a transaction into the array and updates running totals
    public boolean addTransaction(String date, String type, String category, String details, double amount) {
        if (currentIndex >= transactionArray.length) {
            return false; // Array is full
        }

        // Store the record in the array at the current index
        transactionArray[currentIndex] = new TransactionRecord(date, type, category, details, amount);

        // Update financial summaries based on type
        if (type.contains("Income")) {
            totalIncome += amount;
        } else {
            totalExpenses += amount;
        }

        currentIndex++; // Move index forward for the next entry
        return true;
    }

    public TransactionRecord[] getTransactionArray() {
        return transactionArray;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public double getNetProfit() {
        return totalIncome - totalExpenses;
    }
}

