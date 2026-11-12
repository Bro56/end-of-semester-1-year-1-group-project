import java.util.Arrays;

class Worker {
    private String name;
    private String role;
    private String contact;
    private double salary;

    public Worker(String name, String role, String contact, double salary) {
        this.name = name;
        this.role = role;
        this.contact = contact;
        this.salary = salary;
    }

    // Getters and Setters for updating details
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    // --- OVERLOADED METHOD 1: Cash Payment (Default) ---
    public String paySalary(double amount) {
        return "Paid UGX " + amount + " in CASH to " + name + " (" + role + ").";
    }

    // --- OVERLOADED METHOD 2: Specified Payment Method (Cash, Mobile Money, Bank) ---
    public String paySalary(double amount, String paymentMethod) {
        return "Paid UGX " + amount + " via " + paymentMethod.toUpperCase() + " to " + name + " (" + role + ").";
    }

    // --- OVERLOADED METHOD 3: Specified Method with Account/Phone details ---
    public String paySalary(double amount, String paymentMethod, String accountDetails) {
        return "Paid UGX " + amount + " via " + paymentMethod.toUpperCase() + 
               " (" + accountDetails + ") to " + name + " (" + role + ").";
    }
}

public class WorkersManager {
    private Worker[] workers = new Worker[100];
    private int workerCount = 0;

    public boolean addWorker(Worker worker) {
        if (workerCount < workers.length) {
            workers[workerCount++] = worker;
            return true;
        }
        return false;
    }

    public Worker[] getWorker() {
        return Arrays.copyOf(workers, workerCount);
    }

    public int getWorkerCount() {
        return workerCount;
    }

    public Worker getWorkerByName(String name) {
        for (int i = 0; i < workerCount; i++) {
            if (workers[i].getName().equalsIgnoreCase(name)) {
                return workers[i];
            }
        }
        return null;
    }
}