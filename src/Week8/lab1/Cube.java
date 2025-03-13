package Week8.lab1;

public class Cube extends ThreeDimensional {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }

    @Override
    public double getVolume() {
        return side * side * side ;

    }
    public String toString() {
        return "Cube : " +
                "Side = " + side;
    }

}
