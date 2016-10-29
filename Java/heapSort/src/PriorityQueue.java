interface PriorityQueue {
	public void insert(Node value);
	public Node max();
	public void delete(int x);
	public Node extract_max();
	public int size();
	public void increase_key(int x, int key);
	public void add(Node node);
	public void buildHeap(int i, int size);
}
