package Lab5;

import java.util.Arrays;

public class Task1 {
    public static int[][] add(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) return null;
        int[][] result = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    
    public static int[][] subtract(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) return null;
        int[][] result = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }
    
    public static int[][] multiply(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            return null;
        }
        int row = a.length;
        int col = b[0].length;
        int[][] result = new int[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = multiArray(a[i], getCol(b, j));
            }
        }
        return result;
    }
    
    public static int multiArray(int[] a, int[] b) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }
    
    public static int[] getCol(int[][] arr, int n) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i][n];
        }
        return result;
    }
    
    public static int[][]transpose(int[][] a) {
        int[][]result = new int[a[0].length][a.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = a[j][i];
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = {{1, 2}, {4, 5}, {7, 8}};
//        System.out.println(Arrays.deepToString(add(a, b)));
//        System.out.println(Arrays.deepToString(subtract(a, b)));
        int[][] arr1 ={{1,2,3},
                        {4,5,6}};
        int[][] arr2 ={{1,2,3},
                {3,4,5},
                {6,7,8}};
        
//        System.out.println(Arrays.deepToString(multiply(arr1, arr2)));
        System.out.println(Arrays.deepToString(transpose(arr1)));
    }
}
