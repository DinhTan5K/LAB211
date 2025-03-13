package Week7.lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class FruitController {
    private ArrayList<Fruit> fruits = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int id = 0;

    public void addFruit() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Origin: ");
        String origin = scanner.nextLine();
        fruits.add(new Fruit(++id, name, origin, quantity, price));

        String choose;
        do {
            System.out.print("Do you want to add now (Y/N): ");
            choose = scanner.next();
            if (choose.equalsIgnoreCase("Y")) {
                scanner.nextLine();
                addFruit();
            } else if (choose.equalsIgnoreCase("N")) {
                showFruits();
                break;
            }
        } while (!choose.equalsIgnoreCase("Y") && !choose.equalsIgnoreCase("N"));
    }

    public void showFruits() {
        System.out.printf("%-5s | %-10s | %-10s | %-10s | %-10s\n", "Item", "Fruit Name", "Quantity", "Price", "Origin");
        for (Fruit f : fruits) {
            System.out.println(f);
        }
    }

    public void shopping() {
        ArrayList<Order> currentShoppingCart = new ArrayList<>();
        while (true) {
            Fruit fruit = null;
            System.out.print("Select Fruit by Number of Item: ");
            int choice = scanner.nextInt();

            for (Fruit f : fruits) {
                if (choice == f.getFruitId()) {
                    System.out.println("You chose: " + f.getFruitName());
                      fruit = f;
                    break;
                }
            }

            if (fruit == null) {
                System.out.println("Invalid selection. Try again.");
                continue;
            }

            int quantity;
            do {
                System.out.print("Please input quantity: ");
                quantity = scanner.nextInt();

                if (quantity <= 0) {
                    System.out.println("Quantity must be greater than 0.");
                } else if (quantity > fruit.getQuantity()) {
                    System.out.println("Not enough stock available.");
                }
            } while (quantity <= 0 || quantity > fruit.getQuantity());

            double amount = quantity * fruit.getPrice();
            fruit.setQuantity(fruit.getQuantity() - quantity);

            currentShoppingCart.add(new Order(++id, fruit.getFruitName(), fruit.getOrigin(), quantity, fruit.getPrice(), "", amount));

            String choose;
            do {
                System.out.print("Do you want to order another fruit? (Y/N): ");
                choose = scanner.next();
                if (choose.equalsIgnoreCase("N")) {
                    checkOut(currentShoppingCart);
                    return;
                }
            } while (!choose.equalsIgnoreCase("Y") && !choose.equalsIgnoreCase("N"));
        }
    }

    void checkOut(ArrayList<Order> currentShoppingCart) {
        scanner.nextLine();
        System.out.print("Input your name: ");
        String customerName = scanner.nextLine();

        double totalAmount = 0;
        System.out.println("\nCustomer: " + customerName);
        System.out.printf("%-10s | %-10s | %-10s | %-10s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : currentShoppingCart) {
            totalAmount += order.getAmount();
            System.out.printf("%-10s | %-10d | %-10.2f | %-10.2f\n",
                    order.getFruitName(), order.getQuantity(), order.getPrice(), order.getAmount());
            order.setName(customerName);
        }
        System.out.println("Total: " + totalAmount + "$\n");

        orders.addAll(currentShoppingCart);
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        System.out.println("\nAll Orders:");
        System.out.println("------------------------------------");
        String currentCustomer = "";
        double totalAmount = 0;
        for (Order o : orders) {
            if (!o.getName().equals(currentCustomer)) {
                if (!currentCustomer.isEmpty()) {
                    System.out.println("Total: " + totalAmount + "$");
                    System.out.println("------------------------------------");
                }
                currentCustomer = o.getName();
                totalAmount = 0;
                System.out.println("Customer: " + currentCustomer);
                System.out.printf("%-10s | %-10s | %-10s | %-10s\n", "Product", "Quantity", "Price", "Amount");
            }
            System.out.printf("%-10s | %-10d | %-10.2f | %-10.2f\n",
                    o.getFruitName(), o.getQuantity(), o.getPrice(), o.getAmount());
            totalAmount += o.getAmount();
        }
        System.out.println("Total: " + totalAmount + "$");
    }
}
