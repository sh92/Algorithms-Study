import java.io.*;

/**
 * Created by withGod on 9/10/16.
 */
public class hw02_01_201202160_merge {

    private static int lastIndex = 0;
    private static double  array[]= new double[10000001];
    private static double  helper[]= new double[10000001];
    private static int cnt=0;
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("hw02_dataset/hw02_uk.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        StreamTokenizer token = new StreamTokenizer(reader);


        while(hasToken(token)){
            if(token.ttype==token.TT_NUMBER){
                array[lastIndex]=token.nval;
                lastIndex++;
            }
        }
        long start = System.currentTimeMillis();
        merge_sort(0,lastIndex-1);
        long end = System.currentTimeMillis();

        printArray(array);

        System.out.println((end-start)+" milliseconds");
    }

    private static void merge_sort(int low, int high)
    {
        if(low < high){
            int mid = low + (high - low)/2;
            merge_sort(low,mid);
            merge_sort(mid+1,high);
            merge(low,mid,high);
        }
    }


    private static void merge(int low, int mid, int high) {
        cnt++;
        for(int i=low;i<=high;i++){
            helper[i] =  array[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <=mid && j <=high){
            if(helper[i] <= helper[j]){
                array[k] = helper[i];
                i++;
            }else{
                array[k]  = helper[j];
                j++;
            }
            k++;
        }

        while(i <= mid)
        {
            array[k] = helper[i];
            k++;
            i++;
        }

    }

    private static void printArray(double[] array) throws IOException {
        FileWriter out = new FileWriter("hw02_01_201202160_merge.txt", false);
        for(int i=0;i<lastIndex;i++){
            System.out.println(array[i]);
            out.append(String.valueOf(array[i])+"\n");
        }
        System.out.println(cnt);
        out.append(cnt+"\n");
        out.close();
    }

    private static boolean hasToken(StreamTokenizer token) throws IOException {
        return token.nextToken() != StreamTokenizer.TT_EOF;
    }

}


