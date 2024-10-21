package Lab4;

import java.util.Arrays;


public class SortingAlgorithms {
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
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
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

//    public static void quickSort (int[] arr, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int key = (left+right)/2;
//        int pivot = partition(arr,left,right,key);
//
//
//        quickSort(arr,left,pivot-1);
//        quickSort(arr,pivot,right);
//    }
//
//
//
//
//    // pivot is center
//    private static int partition(int[] arr, int left, int right, int key) {
//        int iL = left;
//        int iR = right;
//
//        while (iL < iR) {
//            System.out.println(key);
//            while (arr[iL] < arr[key]) {
//            swap(arr, iL, iR);
//                iL++;
//                iR++;
//            }
//
//
//            if (iL < iR) {
//                int temp = arr[iL];
//                arr[iL] = arr[iR];
//                arr[iR] = temp;
//                iL++;
//                iR--;
//            }
//
//        }
//        // dieu kien de chon
////		      if (left < iR)
////		          partition(arr,left,iR);
////		      if (right > iL)
////		          partition(arr,right,iL);
//        return iL;
//    }
//    static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }



    public static void main(String[] args) {
        long sum = 0;
        int[] randomArray = DivideAndConquer.generateArray(500000);
        long startTime = System.currentTimeMillis();
        bubbleSort(randomArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Program Took: " + (endTime - startTime) + " ms");

    }
}
