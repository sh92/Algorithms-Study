import java.io.*;

/**
 * Created by withGod on 9/10/16.
 */
public class hw02_01_201202160_3way_merge {

    private static int lastIndex = 0;
    private static double  array[]= new double[10000001];
    private static double  helper[]= new double[10000001];
    private static int cnt=0;
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("hw02_dataset/data02.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        StreamTokenizer token = new StreamTokenizer(reader);


        while(hasToken(token)){
            if(token.ttype==token.TT_NUMBER){
                array[lastIndex]=token.nval;
                lastIndex++;
            }
        }
        long start = System.currentTimeMillis();
        merge_sort3(0,lastIndex-1);
        long end = System.currentTimeMillis();

        printArray(array);

        System.out.println((end-start)+" milliseconds");
    }

    private static void merge_sort3(int low,int high) {
        if(low<high){
            int c1 = low + (high-low)/3;
            int c2 = low + ((high-low)/3)*2;

            merge_sort3(low,c1);
            merge_sort3(c1+1,c2);
            merge_sort3(c2+1,high);
            merge3(low,c1,c2,high);
        }
    }

    private static void merge3(int low, int c1, int c2, int high) {
        cnt++;
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }
        int i = low;
        int j = c1 + 1;
        int k = c2 + 1;
        int t = low;

        boolean isFinished_c1 = false;
        boolean isFinished_c2 = false;
        boolean isFinished_c3 = false;


        while (true){
            if(i>c1){
                isFinished_c1=true;
                break;
            }
            if(j>c2){
                isFinished_c2=true;
                break;
            }
            if(k>high){
                isFinished_c3=true;
                break;
            }


            if(helper[i] <= helper[j]){
                if(helper[i] <= helper[k]){
                    // i < j && i < k
                    array[t] = helper[i];
                    i++;
                }else{
                    //k<=i<=j
                    array[t] = helper[k];
                    k++;
                }
            }else{
                // i > j && > j <=k
                if(helper[j] <= helper[k]){
                    array[t] = helper[j];
                    j++;
                }else{
                    // k
                    array[t] = helper[k];
                    k++;
                }
            }
            t++;
        }


        while (true){
            if (isFinished_c1) {
                if(j>c2)
                    break;
                if(k>high)
                    break;
                if (helper[j] <= helper[k]) {
                    array[t] = helper[j];
                    j++;
                } else {
                    array[t] = helper[k];
                    k++;
                }
                t++;
            } else if (isFinished_c2) {
                if(i>c1)
                    break;
                if(k>high)
                    break;
                if (helper[i] <= helper[k]) {
                    array[t] = helper[i];
                    i++;
                } else {
                    array[t] = helper[k];
                    k++;
                }
                t++;
            } else if (isFinished_c3) {
                if(i>c1)
                    break;
                if(j>c2)
                    break;
                if (helper[i] <= helper[j]) {
                    array[t] = helper[i];
                    i++;
                } else {
                    array[t] = helper[j];
                    j++;
                }
                t++;
            }
        }


        while (i <= c1) {
            array[t] = helper[i];
            t++;
            i++;
        }


        while (j <= c2) {
            array[t] = helper[j];
            t++;
            j++;
        }


    }


    private static void printArray(double[] array) throws IOException {
        FileWriter out = new FileWriter("hw02_01_201202160_3way_merge.txt", false);
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


