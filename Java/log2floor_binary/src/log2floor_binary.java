import java.math.BigInteger;
public class log2floor_binary {

    public static void main(String[] args) {
        new log2floor_binary();
    }
    public log2floor_binary(){
        BigInteger n = new BigInteger("1000000000000000000");
        int k=1;
        int count=1;
        BigInteger two = new BigInteger("2");
        BigInteger[] a = new BigInteger[10000];

        a[0] = BigInteger.valueOf(1);
        while (true) {
            a[k] =two.pow(k);
            if (two.pow(k*2).compareTo(n) > 0)
                break;
            k=k*2;
            count++;
        }
        BigInteger low = a[k];
        BigInteger mid;
        int lowIndex = k;
        int  highIndex= k*2;
        int midIndex,midPlusIndex;
        int diff;
        System.out.println(count);
        while(true){
            count++;
            midIndex = (highIndex+lowIndex)/2;
            diff = (highIndex-lowIndex);
            if(diff<=1){
                break;
            }
            midPlusIndex=diff/2;
            mid = low.multiply(a[midPlusIndex]);
            if(mid.compareTo(n)<0){
                low=mid;
                lowIndex=midIndex;
            }else if (mid.compareTo(n)>0){
                highIndex=midIndex;
            }
        }
        System.out.println("compute count : "+count);
        System.out.println("floor(log(1000000000000000000)/log(2)):"+lowIndex);
    }
}

