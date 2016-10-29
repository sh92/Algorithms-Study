import java.io.*;
import java.util.Random;

public class quickSort {

    public static void main(String[] args) throws IOException {
        new quickSort();
    }

    private  quickSort() throws IOException {
        int lastIndex = 0;
        int array1[]= new int[100001];
        int array2[]= new int[100001];

        lastIndex = inputData(lastIndex, array1, array2);
        quickSort(array1,0,lastIndex-1);
        printArray(array1,lastIndex,"hw03_01_201202160_quick.txt");

        quickSort_withRandom(array2,0,lastIndex-1);
        printArray(array2,lastIndex,"hw03_01_201202160_quickRandom.txt");
    }

    private int inputData(int lastIndex, int[] array1, int[] array2) throws IOException {
        FileInputStream stream = new FileInputStream("data04.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        StreamTokenizer token = new StreamTokenizer(reader);
        while(hasToken(token)){
            if(token.ttype==token.TT_NUMBER){
                int val = (int)token.nval;
                array1[lastIndex]=val;
                array2[lastIndex]=val;
                lastIndex++;
            }
        }
        return lastIndex;
    }

    public int partition(int[] arr, int p, int r){
        int x = arr[r];
        int i = p-1;
        for(int j=p;j<=r-1;j++)
        {
            if(arr[j]<=x){
                i=i+1;
                swap(arr,i,j);
            }
        }
        i=i+1;
        swap(arr,i,r);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private  void printArray(int[] arr,int lastIndex,String filename) throws IOException {
        FileWriter out = new FileWriter(filename, false);
        for(int i=0;i<lastIndex-1;i++){
            System.out.println(arr[i]);
            out.append(String.valueOf(arr[i])+",");
        }
        System.out.println(arr[lastIndex-1]);
        out.append(String.valueOf(arr[lastIndex-1]));
        out.close();
    }

    public int randomizedPartition(int[] arr, int p, int r){
        Random random = new Random();
        int min = p;
        int i = min +random.nextInt(r-p)+1;
        int idx1 = min+random.nextInt(r-p)+1;
        int idx2 = min+random.nextInt(r-p)+1;
        int idx3 = min+random.nextInt(r-p)+1;

        int meanIDX=0;
        if(arr[idx1] < arr[idx2] && arr[idx2] < arr[idx3]){
            meanIDX=idx2;
        }else if(arr[idx3] <= arr[idx2] && arr[idx2] <= arr[idx1]){
            meanIDX=idx2;
        }else if(arr[idx2] <= arr[idx3] && arr[idx3] <= arr[idx1]){
            meanIDX=idx3;
        }else if(arr[idx1] <= arr[idx3] && arr[idx3] <= arr[idx2]){
            meanIDX=idx3;
        }else if(arr[idx2] <= arr[idx1] && arr[idx1] <= arr[idx3]){
            meanIDX=idx1;
        }else if(arr[idx3] <= arr[idx1] && arr[idx1] <= arr[idx2]){
            meanIDX=idx1;
        }
        swap(arr,meanIDX,r);
        return partition(arr,p,r);
    }

    public  void quickSort(int[] arr, int p, int r){
        if(p<r){
            int pivot = partition(arr,p,r);
            quickSort(arr,p,pivot-1);
            quickSort(arr,pivot+1,r);
        }
    }

    public void quickSort_withRandom(int[] arr, int p, int r){
        if(p<r){
            int pivot = randomizedPartition(arr,p,r);
            quickSort(arr,p,pivot-1);
            quickSort(arr,pivot+1,r);
        }
    }

    private static boolean hasToken(StreamTokenizer token) throws IOException {
        return token.nextToken() != StreamTokenizer.TT_EOF;
    }
}

