/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class LinearSearch {

    private int [] arr;

    public LinearSearch() {
    }
    
    
    public LinearSearch(int size) {
        this.arr = new int[size];
    }


    public int[] generateRandomArray(int size){
        arr = new int[size];
        Random rand = new Random();
        Arrays.setAll(arr, i -> rand.nextInt(size));
        return arr;
    }

    public void showArray(){
        System.out.print("The array: "+Arrays.toString(arr)+" ");
        System.out.println(" ");
    }
    
    public void search(int size , int y){
        generateRandomArray(size);
        showArray();
        boolean found = false;
        for(int i = 0; i < size; i++){
           //edit
            if(arr[i] == y){
                System.out.println("Found index " + y + " at " + ": "+i);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Not found");
        }
    }
}
