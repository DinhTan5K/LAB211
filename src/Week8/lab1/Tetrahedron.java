package Week8.lab1;

public class Tetrahedron extends ThreeDimensional{

    private double edge;

    public Tetrahedron(double edge) {
        this.edge = edge;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * edge * edge;
    }

    @Override
    public double getVolume() {
        return (Math.pow(edge, 3) / (6 * Math.sqrt(2)));
    }

    public String toString() {
        return "Tetrahedron : " +
                "Edge = " + edge;
    }
}
