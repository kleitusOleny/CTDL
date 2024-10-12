package Lab3;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    // To find the index of the target in the array. If the target
    // is not found in the array, then the method returns -1.
    // Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
    // Output: 3
    public int iterativeLinearSearch(int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // To find the index of the target in the array. If the target
    // is not found in the array, then the method returns -1.
    // Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
    // Output: -1
    public int recursiveLinearSearch(int target) {
        if (array.length == 0) return -1;
        else {
            return helpRecursiveLinearSearch(target, 0);
        }
    }

    public int helpRecursiveLinearSearch(int target, int step) {
        if (step == array.length) {
            return -1;
        } else if (array[step] == target) return step;
        else {
            return helpRecursiveLinearSearch(target, step + 1);
        }
    }

    // To find the index of the target in the sorted array. If the
    //target is not found in the array, then the method returns -1.
    public int iterativeBinarySearch(int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // To find the index of the target in the sorted array. If the
    //target is not found in the array, then the method returns -1.
    public int recursiveBinarySearch(int target) {
        if (array.length == 0) return -1;
        else {
            return helpRecursiveBinarySearch(target, 0, array.length - 1);
        }
    }

    private int helpRecursiveBinarySearch(int target, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                return helpRecursiveBinarySearch(target, low, mid - 1);
            } else {
                return helpRecursiveBinarySearch(target, mid + 1, high);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {12, 10, 9, 45, 2, 10, 10, 45};
        MyArray myArray = new MyArray(array);
//        System.out.println("Iterative LinearSearch: " + myArray.iterativeLinearSearch(45));
//        System.out.println("Recursive LinearSearch: " + myArray.recursiveLinearSearch(45));

        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 9, 10};
        MyArray myArray2 = new MyArray(array2);
//        System.out.println("Iterative BinarySearch: " + myArray2.iterativeBinarySearch(4));
        System.out.println("Recursive BinarySearch: " + myArray2.recursiveBinarySearch(4));
    }
}
