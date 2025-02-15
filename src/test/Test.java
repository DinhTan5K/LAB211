/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;
import Week1.*;

import java.util.List;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        int option ;
        do {
             option = menu.menu();
            switch (option) {
                case 1 -> {
                    System.out.print("Enter size of array: ");
                    int size = sc.nextInt();
                    System.out.print("Enter search value: ");
                    int num = sc.nextInt();

                    LinearSearch linearSearch = new LinearSearch();
                    linearSearch.search(size, num);
                    sc.nextLine();
                }
                case 2 ->{

                    System.out.print("Enter content: ");
                    String content = sc.nextLine();
                    System.out.println(content);
                    WAC_Count count = new WAC_Count(content);
                    System.out.println(count.countWords());
                    System.out.println(count.countChar());
                }
                case 3 ->{
                    ConvertBaseNum convertBase = new ConvertBaseNum();
                    convertBase.menu();
                    int options = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter NUM: ");
                    String num = sc.nextLine();
                    System.out.println("=============");
                    System.out.println("CONVERT TO -> ");
                    convertBase.menu();
                    int optionConvert = sc.nextInt();
                    convertBase.convertNum(options,optionConvert,num);
                    sc.nextLine();
                }
                case 4 ->{
                    EquationAndNumberAnalyzer analyzer = new EquationAndNumberAnalyzer();
                    int optionAnazly;
                        do{
                            optionAnazly = menu.menuAnalyzer();
                            switch (optionAnazly){
                                case 1 ->{
                                    System.out.print("Enter A: ");
                                    String a = sc.nextLine();
                                    System.out.print("Enter B: ");
                                    String b = sc.nextLine();
                                    List<Float> solutions = analyzer.calculateEquation(a, b);
                                    if (solutions == null) {
                                        System.out.println("vo nghiem");
                                    } else if (solutions.isEmpty()) {
                                        System.out.println("vo so nghiem");
                                    } else {
                                        System.out.print("Solution: x = " + solutions);
                                        System.out.println();
                                    }
                                    analyzer.checkNumber(analyzer.getA(), analyzer.getB());
                                }

                                case 2 ->{
                                    System.out.print("Enter A: ");
                                    String a = sc.nextLine();
                                    System.out.print("Enter B: ");
                                    String b = sc.nextLine();
                                    System.out.print("Enter C: ");
                                    String c = sc.nextLine();

                                    List<Float> solution = analyzer.calculateQuadraticEquation(a, b, c);
                                    if (solution == null) {
                                        System.out.println("vo nghiem");
                                    } else if (solution.size() == 1) {
                                        System.out.println("nghiem kep: " + solution);
                                    } else {
                                        System.out.print("Solution: x1 = " + solution.getFirst() + " and x2 = " + solution.getLast());
                                        System.out.println();
                                    }
                                    analyzer.checkNumbers(analyzer.getA(), analyzer.getB(), analyzer.getC());

                                }
                            }
                        }while(optionAnazly < 2);
                }
            }

        } while(option < 5);

    }

}
