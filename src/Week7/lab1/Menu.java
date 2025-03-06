package Week7.lab1;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public int menuLab(){
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
        return sc.nextInt();
    }
}
