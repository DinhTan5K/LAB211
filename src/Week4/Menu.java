package Week4;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public int menu(){
        System.out.println("====Menu====");
        System.out.println("1.Manage students.");
        System.out.println("2.Input and display student and teacher information");
        System.out.print("Option: ");
        return sc.nextInt();
    }
}
