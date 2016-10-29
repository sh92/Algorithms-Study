package org.cscnu.stack;
import java.lang.IllegalStateException;
import org.cscnu.slist.*;
/**
* Stack을 구현하는 클래스 
* @author 이상희
* @version 1.0
* @since 2015-04-09
*/
public class SListStack implements Stack{ 
	private int size;
	private SingleLinkedList list = new SingleLinkedList();
	

	/**
	* stack의 값이 비었으면 TRUE를 반환하는 함수
	* @return boolean stack이 비었으면 TRUE를 반환
	*/
	public boolean isEmpty(){
		return (list.getSize()==0);
	}

	public Object peek(){
		try{
			if(list.getSize()==0) {
				throw new IllegalStateException("stack is empty");
			}

			return list.getFirst().data;
		}catch(Exception e){
			System.out.println("스택 비어서 peek()할 수 없습니다");
			return "스택이 비어있음";
		}

	}

	public Object pop() {
		try{
			if(list.getSize()== 0) {
				throw new IllegalStateException("stack is empty");
			}
		
			Object object=this.peek();
			list.removeFirst();
			return object;
		}catch(Exception e){
				System.out.println("스택은 비어서 pop()할 수 없습니다.");
			return "스택이 비어있음";
		}
	}

	public void push(Object object){
		list.insertFirst(object);
	}

	/**
	* size를 반환하는 함수
	* @return int stack의 크기를 반환
	*/
	public int size() {
		return list.getSize();
	}

}
