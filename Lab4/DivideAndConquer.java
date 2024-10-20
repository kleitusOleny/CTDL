package Lab4;

import java.util.Arrays;

public class DivideAndConquer {
    public static void mergeSort(int[] arr) {
        if (arr.length == 1) {return;}
        else{
            int mid = arr.length/2;
            int[] left = new int[mid];
            int[] right = new int[arr.length-mid +1];
            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, arr.length - mid);
            mergeSort(left);mergeSort(right);
            arr = merge(left,right);
        }
    }

    public static int[] merge(int[] arr1, int[]arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int count = 0;
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[count++] = arr1[i++];
            }else{
                result[count++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            result[count++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[count++] = arr2[j++];
        }

        return result;
    }

    static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int partitionIndex = partition(array, lowIndex, highIndex);

            quickSort(array, lowIndex, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, highIndex);
        }
    }

    static int partition(int[] array, int lowIndex, int highIndex) {
        int pivot = array[highIndex];
        int i = (lowIndex - 1);

        for (int j = lowIndex; j < highIndex; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, highIndex);
        return (i + 1);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    public static void main(String[] args) {
        int[] arr1 = {85,24,63,45,17,31,96,50};
//        mergeSort(arr1);
//        System.out.println(Arrays.toString(arr1));

        int[]arr2 = {1,4,7};
        int[]arr3 ={2,5,6,8};
//        System.out.println(Arrays.toString(merge(arr3,arr2)));
        quickSort(arr1,0,arr1.length-1);
        System.out.println(Arrays.toString(arr1));
    }
}
