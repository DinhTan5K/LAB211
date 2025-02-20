package Week4.lab2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private List<Person> people = new ArrayList<>();
     View view = new View();

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("*** Information Management ***");
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            System.out.println("3. Person");
            System.out.println("4. Exit");
            System.out.print("You choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Number of teachers u want input: ");
                    int no = sc.nextInt();
                    manageTeachers(no);
                    break;
                case 2:
                    manageStudents();
                    break;
                case 3:
                    managePersons();
                    break;
                case 4:
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void manageTeachers(int no) {
        for(int i = 0 ;  i < no ; i++) {
            String ID = view.getStringInput("ID: ", "\\d{6}");
            String fullname = view.getStringInput("Fullname: ", "[A-Za-z ]+");
            String phoneNumber = view.getStringInput("Phone number: ", "\\d{12}");
            int yearOfBirth = view.getIntInput("Year of birth: ", 1900, Calendar.getInstance().get(Calendar.YEAR) - 1);
            String major = view.getStringInput("Major: ", ".{1,30}");
            int yearInProfession = view.getIntInput("Year in the profession: ", 0, Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth);
            String contractType = view.getStringInput("Contract type (Long/Short): ", "(Long|Short)");
            double salaryCoefficient = view.getDoubleInput("Salary coefficient: ", 0);

            people.add(new Teacher(ID, fullname, phoneNumber, yearOfBirth, major, yearInProfession, contractType, salaryCoefficient));
        }
    }

    private void manageStudents() {
        String ID = view.getStringInput("ID: ", "\\d{6}");
        String fullname = view.getStringInput("Fullname: ", "[A-Za-z ]+");
        String phoneNumber = view.getStringInput("Phone number: ", "\\d{12}");
        int yearOfBirth = view.getIntInput("Year of birth: ", 1900, Calendar.getInstance().get(Calendar.YEAR) - 1);
        String major = view.getStringInput("Major: ", ".{1,30}");
        int yearOfAdmission = view.getIntInput("Year of admission: ", yearOfBirth, Calendar.getInstance().get(Calendar.YEAR));
        int entranceEnglishScore = view.getIntInput("Entrance English score: ", 0, 100);

        people.add(new Student(ID, fullname, phoneNumber, yearOfBirth, major, yearOfAdmission, entranceEnglishScore));
    }

    private void managePersons() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("*** Person Management ***");
            System.out.println("1. Search");
            System.out.println("2. Print all");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) searchPerson();
            else if (choice == 2) printAllPersons();
            else if (choice == 3) break;
        }
    }

    private void searchPerson() {
        System.out.print("Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        boolean found = false;
        for (Person p : people) {
            if (p.getFullname().contains(name)) {
                System.out.println("|   ID   |      Fullname      |  Phone Number   | Year |          Major          |");
                System.out.println("|--------|--------------------|-----------------|------|-------------------------|");
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("Result: not found");
    }

    private void printAllPersons() {
        if (people.isEmpty()) {
            System.out.println("No data available.");
            return;
        }


        System.out.println("|   ID   |      Fullname      |  Phone Number   | Year |          Major          |");
        System.out.println("|--------|--------------------|-----------------|------|-------------------------|");

        people.sort((p1, p2) -> Integer.compare(p2.getYearOfBirth(), p1.getYearOfBirth()));
        for (Person p : people) {
            System.out.println(p);
        }
    }

}

