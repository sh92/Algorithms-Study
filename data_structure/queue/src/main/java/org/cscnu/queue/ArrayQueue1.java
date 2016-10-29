package org.cscnu.queue;
import java.lang.IllegalStateException;
/**
* Array를 이용하여 Queue를 구현`(ArrayCopy를 이용)
* @author 이상희
* @version 1.0
* @since 2015-04-14
*/
public class ArrayQueue1 implements Queue {
	private static final int MAXQUEUE  = 1000;
	private Object[] obj = new Object[MAXQUEUE];
	private int size =0;
	private int front =0, rear= 0;
	
	/**
	* Array를 이용하여 Queue를 구현하여 데이터를 넣음
	*/
	public void add(Object object){
		if(size >=MAXQUEUE){
			System.out.println("The queue is Full");
		}else{
			obj[rear] = object;
			rear++;
			size++;
			return ;
		}

	}
	
	/**
	* Array를 이용하여 Queue의 첫번째 들어간 값을 반환
	*/
	public Object first(){
		if(size == 0) {
			throw new IllegalStateException("The queue is empty");
		}else{
			return obj[front];
		}

	}

	/**
	* Array를 이용하여 Queue의 가장 첫번째 들어간 값을 지움 (Arraycopy를 이용하여 재일 처음 것을 지우고 둘째 칸 부터 한칸씩 땡김
	*/
	public Object remove() { 
		if(size ==0) {
			throw new IllegalStateException("The queue is empty");
		}else {
			Object temp = obj[front];
			size--;
			System.arraycopy(obj ,1 ,obj, 0,size);
			rear--;

			return temp;
		}
	}

	public int size(){
		return size;
	}


}
