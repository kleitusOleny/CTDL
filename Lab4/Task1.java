package Lab4;

import java.util.Arrays;

public class Task1 {
    public static void selectionSort(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            int minIndex = k;
            for (int i = k; i < arr.length; i++) {
                if (arr[i] > arr[minIndex]) {
                    minIndex = i;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[k];
            arr[k] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length - k - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            int current = arr[k];
            int currentIndex = k;
            while (currentIndex > 0 && current > arr[currentIndex - 1]) {
                arr[currentIndex] = arr[currentIndex - 1];
                currentIndex--;
            }
            arr[currentIndex] = current;
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {85,24,63,45,17,31,96,50};
        selectionSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {85,24,63,45,17,31,96,50};
        bubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {85,24,63,45,17,31,96,50};
        insertionSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
