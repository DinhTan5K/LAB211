package test;

import Week8.lab1.*;
import Week8.lab1.Shapes;
import Week8.lab1.Square;
import Week8.lab1.Triangle;


public class TestWeek8 {
    public static void main(String[] args) {
        Shapes[] shapes = {
                new Circle(5),
                new Square(4),
                new Triangle(3, 6),
                new Sphere(3),
                new Cube(2),
                new Tetrahedron(3)

        };
        for (Shapes shape : shapes) {
            System.out.println(shape);
            System.out.println(shape.getType());
            if (shape instanceof TwoDimensional) {
                System.out.println("Area " + "= " + ((TwoDimensional) shape).calculateArea());
            } else if (shape instanceof ThreeDimensional) {
                System.out.printf("Surface Area: %.3f%n", ((ThreeDimensional) shape).getArea());
                System.out.printf("Volume: %.3f%n", ((ThreeDimensional) shape).getVolume());
            }
            System.out.println("----------------------");

        }
    }
}