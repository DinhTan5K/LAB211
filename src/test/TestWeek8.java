package test;

import Week8.lab2.*;
import java.util.List;
import java.util.Scanner;

public class TestWeek8 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
//        Shapes[] shapes = {
//                new Circle(5),
//                new Square(4),
//                new Triangle(3, 6),
//                new Sphere(3),
//                new Cube(2),
//                new Tetrahedron(3)
//
//        };
//        for (Shapes shape : shapes) {
//            System.out.println(shape);
//            System.out.println(shape.getType());
//            if (shape instanceof TwoDimensional) {
//                System.out.println("Area " + "= " + ((TwoDimensional) shape).calculateArea());
//            } else if (shape instanceof ThreeDimensional) {
//                System.out.printf("Surface Area: %.3f%n", ((ThreeDimensional) shape).getArea());
//                System.out.printf("Volume: %.3f%n", ((ThreeDimensional) shape).getVolume());
//            }
//            System.out.println("----------------------");
//
//        }
        int option;
        ManageEastAsiaCountries m = new ManageEastAsiaCountries();

        do {
            System.out.print("option: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {

                case 1 -> {
                    System.out.println("Enter code of country: ");
                    String code = sc.nextLine().toUpperCase();

                    System.out.println("Enter name of country: ");
                    String name = sc.nextLine().toUpperCase();

                    System.out.println("Enter total Area: ");
                    float area = sc.nextFloat();

                    sc.nextLine();

                    System.out.println("Enter terrain of country: ");
                    String terrain = sc.nextLine();

                    EastAsiaCountries country = new EastAsiaCountries(code, name, area, terrain);
                    List<Exception> exc = m.addCountry(country);
                    if (!exc.isEmpty()) {
                        for (Exception e : exc) {
                            System.out.println(e);
                        }
                    } else {
                        System.out.println("Added completely");
                    }
                }
                case 2 -> {
                    EastAsiaCountries display = m.getRecentlyEnteredInformation();
                    if (display == null) {
                        System.out.println("No countries have been entered.");
                    } else {
                        System.out.printf("%-5s %-10s %-12s %-10s%n", "ID", "Name", "Total Area", "Terrain");
                        System.out.printf("%-5s %-10s %-12.1f %-10s%n",
                                display.getCountryCode(),
                                display.getCountryName(),
                                display.getTotalArea(),
                                display.getCountryTerrain());

                    }
                }
                case 3 ->{
                    System.out.println("name: ");
                    String name = sc.nextLine().toUpperCase();
                    EastAsiaCountries[] search =  m.searchInformationByName(name);
                    if(search == null){
                        System.out.println("NULL");
                    } else {
                        System.out.printf("%-5s %-10s %-12s %-10s%n", "ID", "Name", "Total Area", "Terrain");
                        for(EastAsiaCountries s : search){

                            System.out.printf("%-5s %-10s %-12.1f %-10s%n",
                                    s.getCountryCode(),
                                    s.getCountryName(),
                                    s.getTotalArea(),
                                    s.getCountryTerrain());
                        }
                    }
                }
                case 4 ->{
                    List<EastAsiaCountries> su = m.sortInformationByAscendingOrder();
                    System.out.printf("%-5s %-10s %-12s %-10s%n", "ID", "Name", "Total Area", "Terrain");
                    for(EastAsiaCountries s : su){

                        System.out.printf("%-5s %-10s %-12.1f %-10s%n",
                                s.getCountryCode(),
                                s.getCountryName(),
                                s.getTotalArea(),
                                s.getCountryTerrain());
                    }

                }
            }
        } while (option < 3);

    }
}