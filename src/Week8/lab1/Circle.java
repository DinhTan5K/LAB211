package Week8.lab1;

public class Circle extends TwoDimensional {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    public String toString() {
        return "Circle : " +
                "Radius = " + radius;
    }
}
