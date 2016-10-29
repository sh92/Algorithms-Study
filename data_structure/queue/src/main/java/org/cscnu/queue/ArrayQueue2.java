package org.cscnu.queue;

import java.lang.IllegalStateException;
/**
* Array를 이용하여 Queue 를 구현(MAXQUEUE를 구현하여 그것을 이용해서 나머지를 구함)
* @author 이상희
* @version 1.0
* @since  2015-04-14
*/

public class ArrayQueue2 implements Queue{
	private static final int MAXQUEUE = 1000;

	private Object[] obj = new Object[MAXQUEUE];
	private int size = 0;
	private int front=0, rear=0;

	/**
	* Array를 이용하여 Queue를 구현하는데 MAXQUEUE의 나머지를 이용하여 뒤에서부터 채움
	*/
	public void add(Object object) { 
		if(size >= MAXQUEUE ){
			System.out.println("the queue is full");
		}else{
			obj[rear] = object;
			rear = (rear+1)%MAXQUEUE;
			size++;
			return;
		}
	}

	/**
	* 첫번째 값을 가져옴, 즉 가장먼저 넣은 값을 가져옴
	*/
	public Object first() {
		if(size ==0){
			throw new IllegalStateException("The queue is empty ");
		}else{
			return obj[front];
		}
	}


	/**
	* 큐에 있는 데이터를 지움
	*/
	public Object remove(){
		if(size==0) { 
			throw new IllegalStateException("The queue is empty");
		}else{
			Object temp = obj[front];
			front = (front+1)%MAXQUEUE;
			size--;
			return temp;
		}
	}

	/**
	* 크기를 반환
	*/
	public int size() {
		return size;
	}

}
