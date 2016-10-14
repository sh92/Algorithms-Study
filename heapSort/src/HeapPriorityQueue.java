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
		if( size == a.length ) {
			resize();
		}
		int i = size++;
		while (i > 0) {
			int j = i;
			i = (i-1)/2;
			if( a[i].compareTo(x.getKey()) >= 0 ) {
				a[j]=x;
				return;
			}
			a[j]=a[i];
		}
		a[i]=x;
	}

	public Node max() {
		if( size == 0 ) {
			throw new java.util.NoSuchElementException();
		}
		return a[0];
	}

	@Override
	public void delete(int x) {
		System.out.println(a[x].getKey());
		for(int i=x;i<size-1;i++){
			a[i]=a[i+1];
		}
		size--;
		heapify(x,size);
	}

	public Node extract_max() {
		Node max = max();
		a[0]=a[--size];
		heapify(0, size);
		return max;
	}
    
	public int size() {
		return size;
	}

	public String toString() {
		if( size == 0 ) {
			return "";
		}
		StringBuffer buf = new StringBuffer("\n");
		for (int i = 0; i < size; i++) {
			buf.append(a[i].getKey()+", " + a[i].getValue()+"\n");
		}
		buf.append("------------------------------------\n");
		buf.append("1.작업추가 2.최대값 3.최대 우선순위 작업처리\n");
		buf.append("4.원소 키값 증가 5.작업제거 6.종료\n");
		buf.append("------------------------------------\n");
		return buf.toString();
	}

	public void increase_key(int x,int k){
		if(a[x].compareTo(k)==-1){
			a[x].setKey(k);
			buildHeap(0,size);
			return;
		}
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
			if(j+1<n && a[j+1].compareTo(a[j].getKey())>0)++j;
			if(a[j].compareTo(ai.getKey())<=0)break;
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
