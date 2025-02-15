package Week4.lab2;

import java.util.Scanner;

class View {
    private Scanner sc = new Scanner(System.in);

    public String getStringInput(String message, String regex) {
        String input;
        while (true) {
            System.out.print(message);
            input = sc.nextLine();
            if (input.matches(regex)) return input;
            System.out.println("Data input is invalid");
        }
    }

    public int getIntInput(String message, int min, int max) {
        int input;
        while (true) {
            System.out.print(message);
            input = sc.nextInt();
            sc.nextLine();
            if (input >= min && input <= max) return input;
            System.out.println("Data input is invalid");
        }
    }

    public double getDoubleInput(String message, double min) {
        double input;
        while (true) {
            System.out.print(message);
            input = sc.nextDouble();
            sc.nextLine();
            if (input >= min) return input;
            System.out.println("Data input is invalid");
        }
    }
}

