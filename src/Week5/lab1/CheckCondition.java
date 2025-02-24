package Week5.lab1;

import java.util.Scanner;

public class CheckCondition {
    private Scanner sc = new Scanner(System.in);
    public String checkEmpty(String message,String regex){
        String input;
        while (true) {
            System.out.print(message);
            input = sc.nextLine();
            if (input.matches(regex)) return input;
            System.out.println("Data input is invalid");
        }
    }
}
