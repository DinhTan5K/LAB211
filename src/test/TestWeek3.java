package test;

import Week3.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestWeek3 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();

        int option;
        do {
            option = menu.menu();
            if (option == 5) {
                System.out.println("Exiting...");
                break;
            }
            System.out.print("Size array: ");
            int size = sc.nextInt();
            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(10);
            }

            System.out.println("The array: " + Arrays.toString(arr));

            switch (option) {
                case 1 -> {
                    BubbleSort bubbleSort = new BubbleSort(size);
                    bubbleSort.sort(arr);
                }
                case 2 -> {
                    QuickSort quickSort = new QuickSort(size);
                    quickSort.sort(arr);
                }
                case 3 -> {
                    Arrays.sort(arr);
                    System.out.println("Sorted array: " + Arrays.toString(arr));

                    BinarySearch binarySearch = new BinarySearch(size);
                    System.out.print("Target you want to search: ");
                    int target = sc.nextInt();
                    int index = binarySearch.search(arr, target);

                    System.out.println(index == -1 ? "Target not found" : "Found at index: " + index);
                }
                case 4 -> {
                    Stack stack = new Stack();
                    stack.push(arr[0]);
                    stack.push(arr[1]);

                    System.out.print("Value in stack: ");
                    stack.get();

                    stack.pop();
                    System.out.print("Value after pop: ");
                    stack.get();

                    System.out.println(stack.top() == -1 ? "Stack is empty" : "Stack Top: " + stack.top());
                }
            }
            System.out.println("=====================");
        } while (true);
    }
}
