package Lab2;

import java.sql.SQLOutput;

public class Recursion {
    public static int getSn1(int n) {
        if (n == 1) return 1;
        else if (n > 1) {
            return (int) (Math.pow(-1, n + 1) * n + getSn1(n - 1));
        }
        return 0;
    }

    public static int getSn2(int n) {
        if (n == 1) return 1;
        else if (n > 1) {
            return factorial(n) + getSn2(n - 1);
        }
        return 0;
    }

    public static int factorial(int n) {
        if (n == 1) return 1;
        else if (n > 1) {
            return n * factorial(n - 1);
        }
        return 1;
    }

    public static int getSn3(int n) {
        if (n == 1) return 1;
        else if (n > 1) {
            return (int) Math.pow(n, 2) + getSn3(n - 1);
        }
        return 0;
    }

    public static double getSn4(int n) {
        if (n == 1) return 1;
        else if (n > 1) {
            return (1 / sn4Help(n)) + getSn4(n - 1);
        }
        return 0;
    }

    public static double sn4Help(int n) {
        if (n == 1) return 1;
        else if (n > 1) {
            return (2 * n + sn4Help(n - 1));
        }
        return 0;
    }

    //lab 1.2
    public static int getFibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n > 1) {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
        return 0;
    }

    public static void printFibonacci(int n) {
        if (n == 0) System.out.print("0 ");
        else if (n == 1) {
            printFibonacci(n - 1);
            System.out.print("1 ");
        } else if (n > 1) {
            printFibonacci(n - 1);
            System.out.print(getFibonacci(n) + " ");
        }
    }



    public static void main(String[] args) {
//        System.out.println(getSn1(4));
//        System.out.println(getSn2(4));
//        System.out.println(getSn3(4));
//        System.out.println(getSn4(3));
        printFibonacci(20);
    }
}
