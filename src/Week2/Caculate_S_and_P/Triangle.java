package Week2.Caculate_S_and_P;

public class Triangle extends  Shape {
    private double sideA , sideB , sideC;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }


    public double getPerimeter (){
        return sideA + sideB + sideC;
    }

    public double getArea (){
        double p =getPerimeter() / 2 ;
        return Math.sqrt( p * ( p - sideA )*( p - sideB )*( p - sideC ));

    }
    public void printResult (){
        System.out.println("Side A: "+getSideA());
        System.out.println("Side B: "+getSideB());
        System.out.println("Side C: "+getSideC());
    }

}
