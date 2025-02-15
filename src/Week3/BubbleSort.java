package Week3;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    private  int size;

    public BubbleSort(int size) {
        this.size = size;
    }

    public void sort(int[] arr) {
        boolean swapped ;
        for (int i = 0; i < arr.length - 1  ; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
        System.out.println("Array after sort : "+Arrays.toString(arr)+ " ");
    }

}
