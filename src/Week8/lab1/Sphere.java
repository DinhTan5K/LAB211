package Week8.lab1;

public class Sphere extends ThreeDimensional {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea (){
        return 4 * Math.PI * radius * radius;
    }
    @Override
    public double getVolume (){
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public String toString() {
        return "Sphere : " +
                "Radius = " + radius;
    }

}
