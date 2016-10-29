import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class countingInversion {
    public static void main(String[] args) throws IOException {
        new countingInversion();
    }

    public countingInversion() throws IOException {
        int lastIndex=0;
        int array[]= new int[1000001];
        int[] input = inputData(lastIndex, array);
        int inversion_count = sort_and_count(input);
        System.out.println(inversion_count);
    }

    private int sort_and_count(int[] array) {
        if(array.length==1)
            return 0;
        int mid = array.length/2;

        int[] A = new int[mid];

        int remain;
        if(array.length%2==0){
            remain = mid;
        }else{
            remain = mid+1;
        }

        int[] B = new int[remain];
        System.arraycopy(array,0,A,0,mid);
        System.arraycopy(array,mid,B,0,remain);
        int A_count = sort_and_count(A);
        int B_count = sort_and_count(B);
        int[] L = new int[array.length];
        int R = merge_and_count(A,B,L);
        System.arraycopy(L,0,array,0,L.length);
        return A_count+B_count+R;

    }

    private int merge_and_count(int[] A, int[] B, int[] L) {
        int inversion_count =0;
        int indexA = 0;
        int indexB = 0;
        int lengthA  = A.length;
        int lengthB = B.length;
        int indexL = 0;

        while(lengthB!=0 && lengthA!=0){
            if(A[indexA] > B[indexB]){
                inversion_count  += lengthA;
                L[indexL] = B[indexB];
                indexB++;
                lengthB--;
            }else{
                L[indexL] =A[indexA];
                indexA++;
                lengthA--;
            }
            indexL++;
        }
        while (lengthA!=0){
            L[indexL] = A[indexA];
            indexA++;
            lengthA--;
            indexL++;
        }

        while (lengthB!=0){
            L[indexL] = B[indexB];
            indexB++;
            lengthB--;
            indexL++;
        }
        return inversion_count;
    }

    private int[] inputData(int lastIndex, int[] array) throws IOException {

        FileInputStream stream = new FileInputStream("data07_inversion.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        StreamTokenizer token = new StreamTokenizer(reader);
        while(hasToken(token)){
            if(token.ttype==token.TT_NUMBER){
                int val = (int)token.nval;
                array[lastIndex]=val;
                lastIndex++;
            }
        }
        int[] paramArray = new int[lastIndex];
        System.arraycopy(array,0,paramArray,0,lastIndex);
        return paramArray;
    }

    private static boolean hasToken(StreamTokenizer token) throws IOException {
        return token.nextToken() != StreamTokenizer.TT_EOF;
    }
}
