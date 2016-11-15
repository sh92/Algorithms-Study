public class HeapPriorityQueue implements PriorityQueue {
    private static final int CAPACITY = 50;
    private Node[] a;
    private int size;

    public HeapPriorityQueue() {
        this(CAPACITY);
    }

    public HeapPriorityQueue(int capacity) {
        a = new Node[capacity];
    }

    public void insert(Node o) {
        Node x = o;
        if(size<0){
            a[++size-1] = x;
            return;
        }
        if( size == a.length ) {
            resize();
        }
        a[++size-1] = x;
        int current = size-1;
        while( a[(current)/2].compareTo(a[current])>0){
            Node temp = a[(current)/2];
            a[(current)/2] = a[(current)];
            a[(current)]=temp;
            current = (current)/2;
        }

    }

    public Node min() {
        if( size == 0 ) {
            throw new java.util.NoSuchElementException();
        }
        return a[0];
    }

    @Override
    public boolean empty() {
        return size==0;
    }

    @Override
    public void delete(int x) {
        System.out.println(a[x].getDist());
        for(int i=x;i<size-1;i++){
            a[i]=a[i+1];
        }
        size--;
        heapify(x,size);
    }

    public Node extract_min() {
        Node min = min();
        a[0]=a[--size];
        heapify(0, size);
        return min;
    }

    public int size() {
        return size;
    }

    @Override
    public void add(Node node) {
        a[size++]=node;
    }

    @Override
    public void buildHeap(int i, int n) {
        if(i>=n/2)return;
        buildHeap(2*i+1,n);
        buildHeap(2*i+2,n);
        heapify(i,n);
    }


    private void heapify(int i, int n) {
        Node ai = a[i];
        a[i]=ai;
        while(i<n/2){
            int j = 2*i+1;
            if(j+1<n && a[j+1].compareTo(a[j])<0)++j;
            if(a[j].compareTo(ai)>=0)break;
            a[i]=a[j];
            i=j;
        }
        a[i]=ai;
    }

    private void resize() {
        Node[] aa = new Node[2*a.length];
        System.arraycopy(a, 0, aa, 0, a.length);
        a = aa;
    }
}