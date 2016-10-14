public class Node implements Comparable {
    private int key;
    private String value;
    public Node(int key, String value) {
        this.key=key;
        this.value=value;
    }
    @Override
    public int compareTo(Object o) {
        int x = (int) o;
        if(this.key > x)
            return 1;
        else if(this.key < x)
            return -1;
        return 0;
    }
    public String getValue(){
        return this.value;
    }

    public void setKey(int key) {
        this.key = key;
    }
    public int getKey(){
        return this.key;
    }
}
