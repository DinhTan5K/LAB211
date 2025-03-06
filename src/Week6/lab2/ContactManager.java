package Week6.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ContactManager {
    private static List<Contact> contacts = new ArrayList<>();
    private static int nextId = 1;

    public void addContact(Scanner scanner) {
        System.out.println("-------- Add a Contact --------");
        System.out.print("Enter Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter Group: ");
        String group = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        String phone;

        while (true) {
            System.out.print("Enter Phone: ");
            phone = scanner.nextLine();
            if (isValidPhone(phone)) {
                break;
            } else {
                System.out.println("Please input Phone flow\n" +
                        "• 1234567890\n" +
                        "• 123-456-7890\n" +
                        "• 123-456-7890 x1234\n" +
                        "• 123-456-7890 ext1234\n" +
                        "• 123.456.7890\n" +
                        "• 123 456 7890");
            }
        }

        contacts.add(new Contact(nextId++, fullName, group, address, phone));
        System.out.println("Contact added successfully!");
    }

    public void displayAll() {
        System.out.println("---------------------------- Display all Contact ----------------------------");
        System.out.printf("| %-2s | %-20s | %-10s | %-10s | %-10s | %-15s | %-15s |\n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void deleteContact(Scanner scanner) {
        System.out.println("-------- Delete a Contact --------");
        System.out.print("Enter ID: ");

        if (!scanner.hasNextInt()) {
            System.out.println("ID is digit");
            scanner.next();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contacts.remove(contact);
                System.out.println("Successful");
                return;
            }
        }
        System.out.println("No found contact");
    }

   public boolean isValidPhone(String phone) {
        String regex = "^(\\d{10}|\\d{3}[-.\\s]\\d{3}[-.\\s]\\d{4}(\\s?(x|ext)\\d{4})?)$";
        return Pattern.matches(regex, phone);
    }
}