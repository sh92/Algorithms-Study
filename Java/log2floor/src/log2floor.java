import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by withGod on 10/7/16.
 */
public class log2floor {

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        System.out.println("정수 입력");
        int n= scan.nextInt();
        new log2floor(n);
    }
    public log2floor(int n){

        int k=0;
        while(true){
            k++;
            if(Math.pow(2,k)>n)
                break;
        }
        System.out.println("floor(log(n)/log(2))="+(k-1));

/*
        double low = Math.pow(2,k-1);
        double high = Math.pow(2,k);
        double mid;
        int cnt=0;
        while(true){
            mid = (low+high)/2;
            if(mid == n) {
                break;
            }else if(mid < n) {
                low = mid;
            }else{
                high = mid;
            }
        }
        System.out.println(mid);*/
    }
}
