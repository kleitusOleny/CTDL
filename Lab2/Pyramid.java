package Lab2;

public class Pyramid {
    public static void drawPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int k = n - i; k > 0; k--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    public static void drawPyramidNumber(int n) {
        for (int i = 1; i <= n; i++) {
            for (int k = n - i; k > 0; k--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        drawPyramid(4);
        drawPyramidNumber(9);
    }
}
