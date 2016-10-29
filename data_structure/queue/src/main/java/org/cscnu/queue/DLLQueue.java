package org.cscnu.queue;
import java.lang.IllegalStateException;
import org.cscnu.dlist.*;
/**
* DoubleLinkedList를 이용하여 Queue를 구현함
* @author 이상희
* @version 1.0
* @since 2015-04-14
*/
public class DLLQueue implements Queue {
	private static final int MAXQUEUE = 1000;

	private DoubleLinkedList dll =new DoubleLinkedList();
	
	/**
	* @param  object doubleLinkedList를 이용하여 add를 함
	*/
	public void add(Object object){
		if(dll.getSize()>MAXQUEUE){
			System.out.println("The queue is Full");
		}else{
			dll.insertLast(object);
			return ;
		}

	}
	/**
	* @return object doubleLinkedList를 이용하여 queue를 구현함
	*/
	public Object first(){
		if(dll.getSize()== 0) {
			throw new IllegalStateException("The queue is empty");
		}else{
			return dll.getFirst().data;
		}

	}

	/**
	* @return object doubleLinkedLIst를 이용하여 remove를 구현
	*/
	public Object remove() { 
		if(dll.getSize()==0) {
			throw new IllegalStateException("The queue is empty");
		}else {
			Object temp =first();
			dll.removeFirst();
			return temp;
		}
	}
	public int size(){
		return dll.getSize();
	}


}
