package Week2.Caculate_S_and_P;

public class Circle extends Shape{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPerimeter (){
        return 2 * Math.PI * radius;

    }

    public double getArea (){
        return Math.PI * Math.pow(radius , 2);

    }
    public void printResult (){
        System.out.println("Radius: "+getRadius());
    }

}
