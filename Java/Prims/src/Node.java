public class Node implements Comparable {
    private int index;
    private Node next;
    private int dist;
    private int edge;

    public Node(int index, Node next, int dist) {
        this.index =index;
        this.next=next;
        this.dist=dist;
    }
    @Override
    public int compareTo(Object o) {
        Node x  = (Node)o;

        if(this.dist > x.getDist())
            return 1;
        else if(this.dist < x.getDist())
            return -1;
        return 0;
    }
    public int getDist(){
        return this.dist;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex(){
        return this.index;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public void setEdge(int edge) {
        this.edge = edge;
    }
    public int getEdge() {
        return edge;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}