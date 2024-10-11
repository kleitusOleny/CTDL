package Lab2;

public class Task2 {
    //Task 2.1
    //This method to use print the Pyramid with char X
    public static void drawPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            addSpace(n - i + 1);
            drawRowPyramid(2 * i - 1);
        }
        return;
    }
    //use to generate the row of pyramid
    public static void drawRowPyramid(int n) {
        if (n == 1) System.out.println("X");
        else if (n > 1) {
            System.out.print("X");
            drawRowPyramid(n - 1);
        }
        return;
    }

    //Task2.2
    //Use to print pyramid with number of row
    public static void drawNumberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            addSpace(n - i + 1);
            drawRowNumberPyramid(i, i);
        }
        return;
    }
    //use to generate the row of pyramid
    public static void drawRowNumberPyramid(int n, int i) {
        if (n == 1) System.out.println(i);
        else if (n > 1) {
            System.out.print(i + " ");
            drawRowNumberPyramid(n - 1, i);
        }
        return;
    }

    //uss to add space before draw row of pyramid
    public static void addSpace(int n) {
        if (n >= 1) {
            System.out.print(" ");
            addSpace(n - 1);
        }
        return;
    }
    public static void main(String[] args) {
        drawPyramid(5);
        drawNumberPyramid(5);
    }
}
