package Lab2;

public class PascalTriangle {
    public static void printPascalTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            int[] pascalTriangleRow = getPascalTriAngle(i);
            for (int k = n-i + 1; k > 0; k--) {
                System.out.print("\t");
            }
            for (int j = 0; j < pascalTriangleRow.length; j++) {
                System.out.print(pascalTriangleRow[j] + "\t\t");
            }
            System.out.println();
        }
    }

    public static int[] getPascalTriAngle(int n) {
        if(n == 1){
            return new int[]{1};
        } else if (n == 2) {
            return new int[]{1, 1};
        }else if(n > 2){
            return generateNextRow(getPascalTriAngle(n-1));
        }
        return null;
    }

    public static int[] generateNextRow(int[]prevRow) {
        int[] nextRow = new int[prevRow.length + 1];
        nextRow[0] = nextRow[nextRow.length -1] = 1;
        for (int i = 1; i < nextRow.length-1; i++) {
                nextRow[i] = prevRow[i] + prevRow[i-1];
        }
        return nextRow;
    }

    public static void main(String[] args) {
        printPascalTriangle(10);
    }
}
