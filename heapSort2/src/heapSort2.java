/*  Output:
{33,88,77,52,66,73,75,44,48,42}
{88,66,77,52,42,73,75,44,48,33}
{33,88,77,52,66,73,75,44,48,42}
{88,66,77,52,33,73,75,44,48,42}
{33,88,77,52,66,73,75,44,48,22}
{88,66,77,52,33,73,75,44,48,22}
*/

public class heapSort2 {


    int[] a = {33,88,77,52,66,73,75,44,48,42};

    void sort(int[] a){
        for(int i = (a.length-1)/2;i>=0;i--){
            heapify(a,i,a.length);
        }
        for(int j =a.length-1;j>0;j--){
            swap(a,0,j);
            heapify(a,0,j);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp  = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void buildHeap(int[] a, int i, int n){
        if(i>=n/2)return;
        buildHeap(a,2*i+1,n);
        buildHeap(a,2*i+2,n);
        heapify(a,i,n);
    }


    public heapSort2() {

        print(a);
        buildHeap(a,0,a.length);
        print(a);
        sort(a);
        print(a);
//
//        int n = a.length;
//        int[] aa = new int[n];
//        System.arraycopy(a, 0, aa, 0, n);
//
//        print(a);
//        heapify(a, 0, n);
//        print(a);
//
//        System.arraycopy(aa, 0, a, 0, n);
//        print(a);
//        heapify(a, 0, n-1);
//        print(a);
//
//        System.arraycopy(aa, 0, a, 0, n);
//        a[n-1] = 22;
//        print(a);
//        heapify(a, 0, n);
//        print(a);
    }

    void heapify(int[] a, int i, int n) {
        int ai = a[i];
        while(i<n/2){
            // a[j] is ai's left child
            int j = 2*i+1;
            // a[j] is ai's larger child
            // a[j] is not out of order

            if(j+1<n && a[j+1] > a[j] )
                j++;

            if(a[j] <= ai)
                break;
            // promote a[j]
            a[i] = a[j];
            // move down to the next level
            i=j;
        }
        // a[i] is not a leaf
        a[i] = ai;
    }

    public static void print(int[] a) {
        System.out.print("{"+a[0]);
        for( int i=1; i<a.length; i++ ) {
            System.out.print(","+a[i]);
        }
        System.out.println("}");
    }

    public static void main(String[] args) {

        new heapSort2();
    }
}
