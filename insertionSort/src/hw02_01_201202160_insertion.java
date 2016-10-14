import java.io.*;
public class hw02_01_201202160_insertion {
    private static int lastIndex = 0;
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("hw02_dataset/data02.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        StreamTokenizer token = new StreamTokenizer(reader);
        double array[]= new double[10000001];

        while(hasToken(token)){
            if(token.ttype==token.TT_NUMBER){
                array[lastIndex]=token.nval;
                lastIndex++;
            }
        }
        long start = System.currentTimeMillis();
        insertionSort(array);
        long end = System.currentTimeMillis();

        printArray(array);
        System.out.println((end-start)+" milliseconds");

    }
    private static void insertionSort(double[] array) {
        int len = lastIndex;
        if(len <1)
            return ;
        for(int j=1;j<lastIndex;j++){
            double key =  array[j];
            int i = j-1;
            while(i >-1 && array[i]> key)
            {
                array[i+1] =array[i];
                i=i-1;
            }
            array[i+1]=key;
        }
    }
    private static void printArray(double[] array) throws IOException {
        FileWriter out = new FileWriter("hw02_01_201202160_insertion.txt", false);
        for(int i=0;i<lastIndex;i++){
            System.out.println(array[i]);
            out.append(String.valueOf(array[i])+"\n");
        }
        out.close();
    }
    private static boolean hasToken(StreamTokenizer token) throws IOException {
        return token.nextToken() != StreamTokenizer.TT_EOF;
    }
}
