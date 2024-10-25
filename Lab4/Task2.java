package Lab4;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class Task2 {
    public static void mergeSort(int[] arr) {
        if (arr.length == 1) {
            return;
        } else {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort(left);
            mergeSort(right);
            merge(left, right, arr);
        }
    }

    public static void merge(int[] arr1, int[] arr2, int[] arr) {
        int count = 0;
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[count++] = arr1[i++];
            } else {
                arr[count++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr[count++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr[count++] = arr2[j++];
        }

    }

    ///QuickSort
    public static void quickSort(int[] arr) {
        helpQuickSort(arr, 0, arr.length - 1);
    }

    public static void helpQuickSort(int[] arr, int left, int right) {
        if (arr.length > 2) {
            int pivot = getPivotMedianOfThree(arr);
            int[] lower = getLowerArray(arr, pivot);
            int[] upper = getUpperArray(arr, pivot);

            quickSort(lower);
            quickSort(upper);

            mergeQuickSort(arr, lower, upper, pivot);
        }
    }

    private static int[] getLowerArray(int[] arr, int pivot) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pivot) {
                list.add(arr[i]);
            }
        }
        int[] lower = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            lower[i] = list.get(i);
        }
        return lower;
    }

    private static int[] getUpperArray(int[] arr, int pivot) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > pivot) {
                list.add(arr[i]);
            }
        }
        int[] upper = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            upper[i] = list.get(i);
        }
        return upper;
    }

    public static void mergeQuickSort(int[] arr, int[] low, int[] high, int pivot) {
        int index = 0;
        int lowIndex = 0;
        int highIndex = 0;
        for (int i = 0; i < low.length; i++) {
            arr[index++] = low[i];
        }
        arr[index++] = pivot;
        for (int i = 0; i <= high.length; i++) {
            arr[index++] = high[i];
        }
    }

    //get Pivot for quicksort
    //get median, 1 7 3 -> 3
    public static int getPivotMedianOfThree(int[] array) {
        int low = array[0], high = array[array.length - 1];
        int mid = array[(array.length) / 2];
        if (low > high) {
            if (low > mid) {
                return low;
            } else if (high > mid) {
                return high;
            } else return mid;
        } else {
            if (low > mid) {
                return low;
            } else if (high < mid) {
                return high;
            } else return mid;
        }
    }

    //get first element, 1 7 3 ->1
    public static int getPivotFirst(int[] array) {
        return array[0];
    }
    //get last element, 1 7 3 ->3
    public static int getPivotLast(int[] array) {
        return array[array.length - 1];
    }
    //get random element
    public static int getPivotRandom(int[] array) {
        Random random = new Random();
        return array[random.nextInt(array.length - 1)];
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //Test Time
        //Task 3.2
        long sum = 0;
        int[] randomArray = getArray(1000);
        long startTime = System.currentTimeMillis();
        quickSort(randomArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Program Took :" + (endTime - startTime) + " ms");

    }
    //Task 3.1
    public static int[] getArray(int len) {
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}
