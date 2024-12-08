package Lab2;

public class PascalTriangle {
    // This method is used to display a Pascal triangle based on the parameter n.
    // Where n represents the number of rows
    public static void printPascalTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            int[] pascalTriangleRow = getPascalTriangle(i);
            for (int k = n-i + 1; k > 0; k--) {
                System.out.print("\t");
            }
            for (int j = 0; j < pascalTriangleRow.length; j++) {
                System.out.print(pascalTriangleRow[j] + "\t\t");
            }
            System.out.println();
        }
    }
    // get the nth row.
    //For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
    public static int[] getPascalTriangle(int n) {
        if(n == 1){
            return new int[]{1};
        } else if (n == 2) {
            return new int[]{1, 1};
        }else if(n > 2){
            return generateNextRow(getPascalTriangle(n-1));
        }
        return null;
    }
    // generate the next row based on the previous row
    //Ex. prevRow = {1} ==> nextRow = {1, 1}
    //Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
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
