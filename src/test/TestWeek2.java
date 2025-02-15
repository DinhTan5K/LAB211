package test;


import Week2.*;
import Week2.Caculate_S_and_P.*;
import Week2.Matrix.Matrix;


import java.util.InputMismatchException;
import java.util.Scanner;


public class TestWeek2 {


    public static int[][] inputMatrix(int num) {
        System.out.print("Enter number of rows for matrix " + num + ": ");
        int rows = getInt();
        System.out.print("Enter number of columns for matrix " + num + ": ");
        int columns = getInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter Matrix "+num+" at [" + (i+1) + "][" + (j+1) + "]: ");
                matrix[i][j] = getInt();
            }
        }
        return matrix;
    }
    public static void matrixCalculator() {

        boolean check=true;
        while (check) {
            System.out.println("Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = getInt();
            switch (choice) {
                case 1:

                    Matrix m = new Matrix(inputMatrix(1));
                    Matrix m1 = new Matrix(inputMatrix(2));
                    Matrix result = m.additionMatrix(m1);
                    System.out.println("Result:");
                    m.printMatrix();
                    System.out.println("+");
                    m1.printMatrix();
                    System.out.println("=");
                    result.printMatrix();
                    break;
                case 2:
                    m = new Matrix(inputMatrix(1));
                    m1 = new Matrix(inputMatrix(2));
                    result = m.subtractionMatrix(m1);
                    m.printMatrix();

                    System.out.println("-");
                    m1.printMatrix();

                    System.out.println("=");

                    result.printMatrix();
                    break;
                case 3:
                    m = new Matrix(inputMatrix(1));
                    m1 = new Matrix(inputMatrix(2));
                    result = m.multiplicationMatrix(m1);
                    m.printMatrix();
                    System.out.println("*");
                    m1.printMatrix();
                    System.out.println("=");
                    result.printMatrix();
                    break;
                case 4:
                    check=false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static int getInt()
    {
        Scanner sc = new Scanner(System.in);


        int k;
        while(true)
        {
            try
            {
                k = sc.nextInt();
                sc.nextLine();
                return k;
            }catch(InputMismatchException e)
            {
                System.out.println("Wrong format");
                sc.nextLine();

            }
        }

    }

    public static double getDouble()
    {
        Scanner sc = new Scanner(System.in);


        double k;
        while(true)
        {
            try
            {
                k = sc.nextDouble();
                sc.nextLine();
                return k;
            }catch(InputMismatchException e)
            {
                System.out.println("Wrong format");
                sc.nextLine();

            }
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculate calculate = new Calculate();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Circle circle = new Circle();

        Menu menu = new Menu();
        int optionMenu;
        do{
            optionMenu = menu.menu();
            switch (optionMenu){
                case 1 ->{
                    int option;
                    do {
                        option = menu.menuBMI();
                        switch (option) {
                            case 1 -> {
                                System.out.println("----- Normal Calculator -----");
                                System.out.print("Enter number: ");
                                double num1 = getDouble();
                                calculate.setMemory(num1);

                                while (true) {

                                    System.out.print("Enter Operator : ");
                                    String operator = sc.next();


                                    if (operator.equals("=")) {
                                        System.out.println("Result: " + calculate.getMemory());
                                        break;
                                    }


                                    if (!operator.matches("[+\\-*/^]")) {
                                        System.out.println("Please input (+, -, *, /, ^)");
                                        continue;
                                    }


                                    System.out.print("Enter number: ");
                                    double num2 = getDouble();

                                    try {

                                        double result = calculate.calculate(calculate.getMemory(), num2, operator);
                                        calculate.setMemory(result);
                                        System.out.println("Memory: " + result);
                                    } catch (ArithmeticException | IllegalArgumentException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                sc.nextLine();
                            }
                            case 2 -> {
                                System.out.println("----- BMI Calculator -----");
                                double weight ;
                                double height ;

                                while (true) {
                                    try {
                                        System.out.print("Enter Weight (kg): ");
                                        weight = Double.parseDouble(sc.nextLine());
                                        if (weight <= 0) {
                                            continue;
                                        }
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("BMI is digit");
                                    }
                                }

                                while (true) {
                                    try {
                                        System.out.print("Enter Height (cm): ");
                                        height = Double.parseDouble(sc.nextLine());
                                        if (height <= 0) {
                                            continue;
                                        }
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("BMI is digit");
                                    }
                                }

                                height = height / 100;


                                String bmiStatus = calculate.bmiCaculate(weight, height);
                                System.out.print("BMI Number: " + calculate.getMemory());
                                System.out.println();
                                System.out.println("BMI Status: " + bmiStatus);

                            }
                        }
                    } while (option < 3);

                }
                case 2 ->{
                    System.out.println("=====Calculator Shape Program=====");
                    System.out.print("Please input side width of Rectangle: ");
                    rectangle.setWidth(getDouble());
                    System.out.print("Please input length of Rectangle: ");
                    rectangle.setLength(getDouble());
                    System.out.print("Please input radius of Circle: ");
                    circle.setRadius(getDouble());
                    System.out.print("Please input side A of Triangle: ");
                    triangle.setSideA(getDouble());
                    System.out.print("Please input side B of Triangle: ");
                    triangle.setSideB(getDouble());
                    System.out.print("Please input side C of Triangle: ");
                    triangle.setSideC(getDouble());

                    System.out.println("-----Rectangle-----");
                    rectangle.printResult();
                    System.out.println("Area: "+rectangle.getArea());
                    System.out.println("Perimeter: "+rectangle.getPerimeter());
                    System.out.println("-----Circle-----");
                    circle.printResult();
                    System.out.println("Area: "+circle.getArea());
                    System.out.println("Perimeter: "+circle.getPerimeter());
                    System.out.println("-----Triangle-----");
                    triangle.printResult();
                    System.out.println("Area: "+triangle.getArea());
                    System.out.println("Perimeter: "+triangle.getPerimeter());
                }
                case 3 ->{
                    matrixCalculator();
                }
            }
        }while (optionMenu < 4);

    }

}
