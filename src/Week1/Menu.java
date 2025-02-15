/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Menu {
    Scanner sc = new Scanner(System.in);
    public int menu(){
        System.out.println("1.Linear Search");
        System.out.println("2.Count words and chars");
        System.out.println("3.Convert Base Num");
        System.out.println("4.Equation And Number Analyzer");
        System.out.println("5.Exit");
        System.out.print("Option: ");
        return sc.nextInt();
    }
    public int menuAnalyzer(){
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
        return sc.nextInt();
    }
}
