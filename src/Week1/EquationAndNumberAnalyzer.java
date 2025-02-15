package Week1;

import java.util.ArrayList;
import java.util.List;

public class EquationAndNumberAnalyzer {
    private float a, b, c;


    public EquationAndNumberAnalyzer() {

    }

    public EquationAndNumberAnalyzer(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public EquationAndNumberAnalyzer(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    public Float checkin(String floatString) {
        try {
            return Float.parseFloat(floatString);
        } catch (NumberFormatException e) {
            System.err.println(e);
            return Float.NaN;
        }
    }


    public boolean isOdd(float number) {
        return number % 2 != 0;
    }

    public boolean isEven(float number) {
        return number % 2 == 0;
    }

    public boolean isPerfectSquare(float number) {
        if (number < 0) return false;
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    public List<Float> calculateEquation(String a, String b) {
        this.a = checkin(a);
        this.b = checkin(b);
        if(!Float.isNaN(this.a) && !Float.isNaN(this.b)) {
            List<Float> solution = new ArrayList<>();
            if (this.a == 0) {
                if (this.b != 0) {
                    return null;
                } else {
                    return solution;
                }
            } else {
                float x = (this.b * -1) / this.a;
                solution.add(x);
                return solution;
            }
        }
        return null;
    }

    public List<Float> calculateQuadraticEquation(String a , String b , String c) {
        this.a = checkin(a);
        this.b = checkin(b);
        this.c = checkin(c);
        if(!Float.isNaN(this.a) && !Float.isNaN(this.b) && !Float.isNaN(this.c)) {
            List<Float> solutions = new ArrayList<>();
            float discriminant = this.b * this.b - 4 * this.a * this.c;

            if (discriminant < 0) {
                return null;
            } else if (discriminant == 0) {
                solutions.add(-this.b / (2 * this.a));
            } else {
                solutions.add((float) ((-this.b + Math.sqrt(discriminant)) / (2 * this.a)));
                solutions.add((float) ((-this.b - Math.sqrt(discriminant)) / (2 * this.a)));
            }

            return solutions;
        } else {
            return null;
        }
    }

    public void checkNumbers(float a, float b, float c) {
        System.out.print("Odd Number(s): ");
        if (!Float.isNaN(a) && isOdd(a)) System.out.print(a + ", ");
        if (!Float.isNaN(b) && isOdd(b)) System.out.print(b + ", ");
        if (!Float.isNaN(c) && isOdd(c)) System.out.print(c + " ");
        System.out.println();

        System.out.print("Number is Even: ");
        if (!Float.isNaN(a) && isEven(a)) System.out.print(a + ", ");
        if (!Float.isNaN(b) && isEven(b)) System.out.print(b + ", ");
        if (!Float.isNaN(c) && isEven(c)) System.out.print(c + " ");
        System.out.println();

        System.out.print("Number is Perfect Square: ");
        if (!Float.isNaN(a) && isPerfectSquare(a)) System.out.print(a + ", ");
        if (!Float.isNaN(b) && isPerfectSquare(b)) System.out.print(b + ", ");
        if (!Float.isNaN(c) && isPerfectSquare(c)) System.out.print(c + " ");
        System.out.println();
    }

    public void checkNumber(float a, float b) {
        System.out.print("Odd Number(s): ");
        if (!Float.isNaN(a) && isOdd(a)) System.out.print(a + ", ");
        if (!Float.isNaN(b) && isOdd(b)) System.out.print(b + ", ");

        System.out.println();

        System.out.print("Number is Even: ");
        if (!Float.isNaN(a) && isEven(a)) System.out.print(a + ", ");
        if (!Float.isNaN(b) && isEven(b)) System.out.print(b + ", ");

        System.out.println();

        System.out.print("Number is Perfect Square: ");
        if (!Float.isNaN(a) && isPerfectSquare(a)) System.out.print(a + ", ");
        if (!Float.isNaN(b) && isPerfectSquare(b)) System.out.print(b + ", ");

        System.out.println();
    }

}