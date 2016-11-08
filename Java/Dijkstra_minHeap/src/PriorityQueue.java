public interface PriorityQueue {
    public void insert(Node value);
    public Node min();
    public boolean empty();
    public void delete(int x);
    public Node extract_min();
    public int size();
    public void add(Node node);
    public void buildHeap(int i, int size);

}
