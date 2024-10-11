package Lab2;

public class Fibonacci {
    //get the nth value of the Fibonacci series
    public static int getFibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n > 1) {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
        return 0;
    }
    // This method is used to display a Fibonaccci series based on
    //the parameter n. Ex. n=10 ==> 0 1 1 2 3 5 8 13 21 34
    public static void printFibonacci(int n) {
        if (n == 0) System.out.print("0 ");
        else if (n >= 1) {
            printFibonacci(n - 1);
            System.out.print(getFibonacci(n) + " ");
        }
    }

    public static void main(String[] args) {
        System.out.print("Fib(n) = ");
        printFibonacci(10);
    }
}
