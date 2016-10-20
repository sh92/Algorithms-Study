/**
* Created by withGod on 10/17/16.
*/
public class ArrayQueue {

    private int front;
    private int rear;
    private int maxSize;
    private Line[] queueArray;

    public ArrayQueue(int maxSize){
        this.front = 0;
        this.rear = -1;
        this.maxSize = maxSize;
        this.queueArray = new Line[maxSize];
    }

    public boolean empty(){
        return (front == rear+1);
    }

    public boolean full(){
        return (rear == maxSize-1);
    }

    public void insert(Line item){
        if(full()) throw new ArrayIndexOutOfBoundsException();
        queueArray[++rear] = item;
    }

    public Line peek(){
        if(empty()) throw new ArrayIndexOutOfBoundsException();
        return queueArray[front];
    }

    public Line remove(){
        Line item = peek();
        front++;
        return item;
    }

}
