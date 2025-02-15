package Week3;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public int menu(){
        System.out.println("1.BubleSort");
        System.out.println("2.QuickSort");
        System.out.println("3.BinarySearch");
        System.out.println("4.Stack");
        System.out.print("Option: ");
        return sc.nextInt();
    }
}
