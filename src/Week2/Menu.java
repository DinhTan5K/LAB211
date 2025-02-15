package Week2;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public int menuBMI(){
        System.out.println("========= Calculator Program =========");
        System.out.println("1.Normal Calculator");
        System.out.println("2.BMI Calculator");
        System.out.println("3.Exit");
        System.out.print("Option: ");
        return sc.nextInt();
    }

    public int menu(){
        System.out.println("1.Develop a computer program");
        System.out.println("2.Create a program to calculate perimeter and area");
        System.out.println("3.Matrix");
        System.out.println("4.Exit");
        System.out.print("Option: ");
        return sc.nextInt();
    }
}
