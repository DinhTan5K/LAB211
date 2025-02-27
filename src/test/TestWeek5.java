package test;
import java.math.BigInteger;
import java.util.Scanner;
import Week5.lab1.CourseController;
import Week5.lab2.ReservationController;
import Week5.lab3.LargerNumber;

public class TestWeek5 {
    public static void main(String[] args) {
        CourseController controller = new CourseController();
        ReservationController reservationController = new ReservationController();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> {
                int choice;
                do {
                    System.out.println("*** Course Management ***");
                    System.out.println("1. Add online course/ offline course");
                    System.out.println("2. Update course");
                    System.out.println("3. Delete course");
                    System.out.println("4. Print all / online course / offline course");
                    System.out.println("5. Search information base on course name");
                    System.out.println("6. Exit");
                    System.out.print("You choose: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1 -> controller.addCourse();
                        case 2 -> controller.updateCourse();
                        case 3 -> controller.deleteCourse();
                        case 4 -> {
                            System.out.println("1.Print all / 2.online course / 3.offline course");
                            int options = scanner.nextInt();
                            switch (options) {
                                case 1 -> controller.printAllCourses();
                                case 2 -> controller.printOnlineCourses();
                                case 3 -> controller.printOfflineCourses();
                            }
                        }
                        case 5 -> controller.searchCourse();
                        case 6 -> System.out.println("BYE AND SEE YOU NEXT TIME");
                        default -> System.out.println("Invalid choice, try again!");
                    }
                } while (choice != 6);
            }
            case 2 -> {
                reservationController.start();
            }
            case 3 ->{


                    System.out.print("Num1: ");
                    String num1 = scanner.next();
                    System.out.print("Num2: ");
                    String num2 = scanner.next();

                    LargerNumber largerNumber = new LargerNumber(num1, num2);
                System.out.println(largerNumber.addLarge());



            }
        }
    }

    }

