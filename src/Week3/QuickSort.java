package Week3;

import java.util.Arrays;

public class QuickSort {
    private int size;

    public QuickSort(int size) {
        this.size = size;
    }


    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        devicePart(arr, 0, arr.length - 1);
        System.out.println("Array after sort : "+Arrays.toString(arr));
    }



    private  void devicePart(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }


        int pivot = arr[end];
        int leftPoint = start;
        int rightPoint = end ;


        while (leftPoint < rightPoint) {

            while (leftPoint < rightPoint && arr[leftPoint] <= pivot) {
                leftPoint++;
            }


            while (leftPoint < rightPoint && arr[rightPoint] >= pivot) {
                rightPoint--;
            }


                swap(arr, leftPoint, rightPoint);

        }
        swap(arr, leftPoint, end);

        devicePart(arr, start, leftPoint - 1);
        devicePart(arr, leftPoint + 1, end);
    }

    private void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}