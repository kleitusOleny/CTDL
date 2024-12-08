package Lab4;

import java.util.Random;

public class TestTime {
    public static int[] getArray(int len) {
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;

    }

    public static void main(String[] args) {
        long sum = 0;
        int[] randomArray = getArray(500000);
        long startTime = System.currentTimeMillis();
        Task2.quickSort(randomArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Program Took :" + (endTime - startTime) + " ms");
    }
}
