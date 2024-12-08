package Lab1_Task1;

public class MyArray {
    private int[] array;
    public MyArray(int[] array){
        this.array = array;
    }
    //Task 1.1
    //Method mirror that outputs the contents of an array in a
    //reverse order like a mirror
    //Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
    public int[] mirror(){
        int size = this.array.length;
        if(size == 0){
            return null;
        }
        int[] result = new int[size*2];
        for (int i = 0; i < size; i++) {
            result[i] = result[result.length - 1 - i] = this.array[i];
        }
        return result;
    }

    // removes all duplicate elements from an array and returns a
    // new array
    //Input: 1 3 5 1 3 7 9 8
    //Output: 1 3 5 7 9 8
    public int[] removeDuplicates(){
        int max = 0;
        for (int i = 0; i < this.array.length - 1; i++) {
            if(array[i] < array[i+1]){
                max = array[i+1];
            }
        }
        int[]tmp = new int[max+1];
        int countLen = 0;
        for (int i = 0; i < this.array.length; i++) {
            tmp[array[i]]++;
        }
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] == 1){
                countLen++;
            }
        }
        int[] result = new int[countLen];
        int index = 0;
        for(int i = 0; i < tmp.length; i++){
            if(tmp[i] == 1){
                result[index++] = i;
            }
        }
        return result;
    }

    // Check whether a given array is sorted.
    // Input: 10 11 12 13 14 16 17 19 20
    // Output: true
    public boolean isSorted(){
        for (int i = 0; i < this.array.length - 1; i++) {
            if(this.array[i]==this.array[i+1]){continue;}
            if(this.array[i]>this.array[i+1]){
                for(int j = i+1; j < this.array.length; j++){
                    if(this.array[j] < this.array[i]){
                        return false;
                    }
                }
            }
            if(this.array[i] < this.array[i+1]){
                for(int j = i+1; j < this.array.length; j++){
                    if(this.array[j] < this.array[i]){
                        return false;
                    }
                }
            }
        }
        return true;
        }

        //Task 1.2
        // determine missing values from a sorted array.
        // Input: 10 11 12 13 14 16 17 19 20
        // Output: 15 18
        public int[] getMissingValues(){
            int countMissing = 0;
            for (int i = 0; i < this.array.length - 1; i++) {
                if(Math.abs(this.array[i]-this.array[i+1]) > 1){
                    countMissing += Math.abs(this.array[i]-this.array[i+1]) -1;
                }
            }
            int[]result = new int[countMissing];
            for (int i = this.array.length - 1; i > 1; i--) {
                if(Math.abs(this.array[i] - this.array[i-1]) > 1){
                    result[countMissing-- -1] = (this.array[i] + this.array[i-1])/2;
                }
            }
            return result;
        }

        // Fill missing data by the minimal average of its k
        //neighbors
        // Input:       10 11 12 -1 14 16 17 19 20
        // Output(k=3): 10 11 12 12 14 16 17 19 20
        public int[] fillMissingValues(int k){
            int sum = 0;
            int index = -1;
            int size = this.array.length;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == -1) {
                    index = i;
                }
            }
            int countLeft = (k%2 > 0 ? k/2 +1 : k/2), countRight = k - countLeft;
            if (index == array.length) {
                countLeft = k;
                countRight = 0;
            }
            if (index == 0) {
                countRight = k;
                countLeft = 0;
            }
            if (k/2 > index && index < size/2) {
                countLeft = index;
                countRight = k - countLeft;
            }
            if (k/2 > (size - index - 1) && index > size/2) {
                countRight = size - index - 1;
                countLeft = k - countRight;
            }
            for(int l = index-countLeft; l < index; l++){
                sum += array[l];
            }
            for(int r = index+1; r <= index+countRight; r++) {
                sum += array[r];
            }

            array[index] = sum/k;
            return this.array;
        }

        public static void main(String[] args) {
            MyArray myArray1 = new MyArray(new int[]{1,2,3});
            MyArray myArray2 = new MyArray(new int[]{1,3,5,1,3,7,8,9});
            MyArray myArray3 = new MyArray(new int[]{10,11,12,13,14,16,17,19,20});
            MyArray myArray4 = new MyArray(new int[]{10,11,12,-1,14,16,17,19,20});
            printArray(myArray1.mirror());
            printArray(myArray2.removeDuplicates());
            System.out.println(myArray3.isSorted());
            printArray(myArray3.getMissingValues());
            printArray(myArray4.fillMissingValues(3));

        }

        public static void printArray(int[]array){
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

