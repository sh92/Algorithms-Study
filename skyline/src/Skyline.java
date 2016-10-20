/**
 * Created by withGod on 10/17/16.
 */
public class Skyline {
    ArrayQueue queue = new ArrayQueue(100000);

    int size;

    public Skyline(){
        size=0;
    }

    public void append(int l, int h) {
        Line L =new Line(l,h);
        queue.insert(L);
        size++;
    }

    public int count() {
        return size;
    }

    public Line First() {
        return queue.peek();
    }


    public void removeFirst() {
        size--;
        queue.remove();
    }

    public ArrayQueue getLineList() {
        return queue;
    }
}
