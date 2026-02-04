import java.util.Scanner;

// Base Vehicle class
abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public abstract double calculateRentalCost(int days);

    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

// Car class
class Car extends Vehicle {
    private int numDoors;

    public Car(String make, String model, int year, int numDoors) {
        super(make, model, year);
        this.numDoors = numDoors;
    }

    @Override
    public double calculateRentalCost(int days) {
        double baseRate = 50.0;
        return baseRate * days;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n[Car Details]");
        super.displayInfo();
        System.out.println("Number of Doors: " + numDoors);
    }
}

// SUV class
class SUV extends Vehicle {
    private boolean fourWheelDrive;

    public SUV(String make, String model, int year, boolean fourWheelDrive) {
        super(make, model, year);
        this.fourWheelDrive = fourWheelDrive;
    }

    @Override
    public double calculateRentalCost(int days) {
        double baseRate = 80.0;
        if (fourWheelDrive)
            baseRate += 20;
        return baseRate * days;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n[SUV Details]");
        super.displayInfo();
        System.out.println("Four-Wheel Drive: " + (fourWheelDrive ? "Yes" : "No"));
    }
}

// Truck class
class Truck extends Vehicle {
    private double cargoCapacity;

    public Truck(String make, String model, int year, double cargoCapacity) {
        super(make, model, year);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        double baseRate = 100.0;
        double extra = cargoCapacity * 10;
        return (baseRate + extra) * days;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n[Truck Details]");
        super.displayInfo();
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
    }
}

// Customer/Login handling
class Customer {
    private String username;
    private String password;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in); // Use Scanner only
        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Enter username: ");
            String inputUser = scanner.nextLine();

            System.out.print("Enter password: ");
            String inputPass = scanner.nextLine();

            if (inputUser.equals(username) && inputPass.equals(password)) {
                System.out.println("Login successful!");
                return true;
            } else {
                attempts++;
                System.out.println("Incorrect username or password. Attempts left: " + (3 - attempts));
            }
        }

        System.out.println("Maximum login attempts reached. Exiting...");
        return false;
    }
}

// Main class
public class CarRentalSystem {
    public static void main(String[] args) {
        // Create a customer with username/password
        Customer customer = new Customer("Remo", "pass123");

        // Login
        if (!customer.login()) {
            return; // Exit if login fails
        }

        // Create vehicles
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("Toyota", "Corolla", 2022, 4);
        vehicles[1] = new SUV("Jeep", "Wrangler", 2023, true);
        vehicles[2] = new Truck("Volvo", "FH16", 2021, 15);

        System.out.println("\n=== Vehicle Rental System ===");

        // Display vehicle info and rental cost
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println("Rental Cost for 5 days: $" + v.calculateRentalCost(5));
            System.out.println("----------------------------");
        }
    }
}
