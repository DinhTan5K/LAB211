package Week6;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    public int menuLab1() {
        System.out.println("========= Worker Management =========");
        System.out.println("1. Add Worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
        System.out.print("You choose: ");
        return sc.nextInt();
    }
    public int menuLab(){
        System.out.println("1.Worker Management");
        System.out.println("2.Contact Management");
        System.out.println("3.Exit");
        System.out.print("You choose: ");
        return sc.nextInt();
    }
//    public int menuLab2() {}
}
