package Lab4;

import junit.framework.TestCase;

import java.util.Random;

public class TestSort extends TestCase {
    final int[]arr = generateArray(1000000);
    public void testBubbleSort() {
        SortingAlgorithms.bubbleSort(arr);
    }
    public void testSelectionSort() {
        SortingAlgorithms.selectionSort(arr);
    }

    public void testInsertionSort() {
        SortingAlgorithms.insertionSort(arr);
    }

    public void testQuickSort() {
        DivideAndConquer.quickSort(arr,0,arr.length-1);
    }
    public static int[] generateArray(int len) {
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}
