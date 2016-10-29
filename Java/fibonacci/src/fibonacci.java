import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;

public class fibonacci {
    static BigInteger zero = new BigInteger("0");
    static BigInteger one = new BigInteger("1");
    static BigInteger two = new BigInteger("2");

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("방법");
        System.out.println("1 : Recursion");
        System.out.println("2 : Array");
        System.out.println("3 : Recursive squaring");
        System.out.println("-------------------------------------------------------------");
        int way = scan.nextInt();
        System.out.println("-------------------------------------------------------------");
        int n = 90;
        switch (way){
            case 1:
                for(int i =0;i<=n;i++){
                    double start = System.nanoTime();
                    BigInteger result = fib(i);
                    double end = System.nanoTime();
                    System.out.printf("f<%2d> = %30d",i, result);
                    double seconds = (end-start)/1000000000;
                    System.out.println("\t\t\t" + new DecimalFormat("#.##########").format(seconds) + " secs");

                    if(i%10==9)
                        System.out.println("-------------------------------------------------------------");
                }
                break;
            case 2:
                BigInteger[] a= new BigInteger[n+1];
                for(int i =0;i<=n;i++) {
                    fib2(i,a);
                    if(i%10==9)
                        System.out.println("-------------------------------------------------------------");
                }
                break;
            case 3:
                Matrix A = new Matrix(2,2);
                for(int i =0;i<=n;i++){
                    A.setRecursiveMatrix();
                    double start = System.nanoTime();
                    BigInteger result3 = fib3(i,A);
                    double end = System.nanoTime();
                    System.out.printf("f<%2d> = %30d",i, result3);
                    double seconds = (end-start)/1000000000;
                    System.out.println("\t\t\t" + new DecimalFormat("#.##########").format(seconds) + " secs");
                    if(i%10==9)
                        System.out.println("-------------------------------------------------------------");
                }
        }
    }

    private static BigInteger fib(int n) {
        if(n==0)
            return zero;
        if(n==1)
            return one;
        if(n==2)
            return two;
        BigInteger result = fib(n-1).add(fib(n-2));
        return result;
    }

    private static BigInteger fib2(int n, BigInteger[] a) {
        if(n==0)
            return zero;
        if(n==1)
            return one;
        if(n==2)
            return two;

        a[0]=zero;
        a[1]=one;
        double sum=0;
        for(int i=2;i<=n;i++){
            double start = System.nanoTime();
            a[i]=a[i-1].add(a[i-2]);
            double end = System.nanoTime();
            double seconds = (end-start)/1000000000;
            sum+=seconds;
        }
        System.out.printf("f<%2d> = %30d",n, a[n]);
        System.out.println("\t\t\t" + new DecimalFormat("#.##########").format(sum) + " secs");

        return a[n];
    }

    private static BigInteger fib3(int n,Matrix A) {
        if(n==0)
            return zero;
        if(n==1)
            return one;
        if(n==2)
            return two;
        Matrix result = pow(A,n);
        BigInteger[][] matrix = result.getMatrix();
        return matrix[0][1];
    }

    private static Matrix pow(Matrix A, int n) {
        if(n==1)
            return A;
        if(n%2==0)
            return pow(A,n/2).multiply(pow(A,n/2));
        else
            return pow(A,(n-1)/2).multiply(pow(A,(n-1)/2)).multiply(A);
    }

}
