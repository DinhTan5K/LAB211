package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);

    public int getInt()
    {


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

    public double getDouble()
    {


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
    public String getString()
    {
        String s = sc.nextLine();
        return s;
    }

    public char getChar()
    {
        char c = (char) sc.nextShort();
        return c;
//        while(true)
//        {
//            String s = sc.nextLine();
//            if(!checkBlank(s) && s.length() == 1)
//            {
//                c = s.charAt(0);
//                return c;
//            }
//            else return ' ';
//        }
    }
    public boolean checkBlank(String s)
    {
        return s.trim().isEmpty();
    }
}
