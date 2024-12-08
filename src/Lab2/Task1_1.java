package Lab2;

public class Task1_1 {
    // S(n)=1-2+3-4+...+ ((-1)^(n+1) ).n , n>0
    public static int getSn1(int n) {
        if (n == 1) return 1;
        else if (n > 1) {
            return (int) (Math.pow(-1, n + 1) * n + getSn1(n - 1));
        }
        return 0;
    }
    // S(n)=1+1.2+1.2.3+...+1.2.3...n, n>0
    public static int getSn2(int n) {
        if (n == 1) return 1;
        else if (n > 1) {
            return factorial(n) + getSn2(n - 1);
        }
        return 0;
    }
    //Total factorial
    public static int factorial(int n) {
        if (n == 1) return 1;
        else if (n > 1) {
            return n * factorial(n - 1);
        }
        return 1;
    }
    // S(n)=1^2+2^2+3^2+....+n^2 , n>0
    public static int getSn3(int n) {
        if (n == 1) return 1;
        else if (n > 1) {
            return (int) Math.pow(n, 2) + getSn3(n - 1);
        }
        return 0;
    }
    // S(n)=1+1/2+1/(2.4)+1/(2.4.6)+...+1/(2.4.6.2n), n>=0
    public static double getSn4(int n) {
        if (n > 0) {
            return  (1/(Math.pow(2,n-1) * factorial(n - 1))) + getSn4(n - 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("S1(n) = " + getSn1(4));
        System.out.println("S2(n) = " + getSn2(4));
        System.out.println("S3(n) = " + getSn3(4));
        System.out.println("S4(n) = " + getSn4(4));
    }
}
