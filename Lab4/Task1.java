package Lab4;

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
                if (arr[i] > arr[i + 1]) {
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
        //Task 3.2
        int[] randomArray = Task2.getArray(500000);
        long startTime = System.currentTimeMillis();
        bubbleSort(randomArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Program Took: " + (endTime - startTime) + " ms");

    }
}
