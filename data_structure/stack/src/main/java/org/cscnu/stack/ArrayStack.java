package org.cscnu.stack;
import java.lang.IllegalStateException;

/**
* 다음은 Array를 이용하여 Stack을 구현한 클래스이다. 
* @author 이상희
* @version 1.0
* @since 2015-04-09
*/
public class ArrayStack implements Stack{
	private Object[] a;
	private int size;

	/**
	* 생성자로 크기를 받음
	* @param capacity 생성자로 크기
	*/
	public ArrayStack(int capacity) {
		a=new Object[capacity];
	}

	/**
	* stack이 비었으면 True를 반환하는 함수
	* @return stack이 비었으면 True를 반환
	*/

	public boolean isEmpty(){
		return (size==0);
	}

	public Object peek(){
		try{
			if(size==0) {
				throw new IllegalStateException("stack is empty");
			}
			return a[size-1];
		}catch(Exception e){
			System.out.println("스택이 비어서 peek() 할 수 없습니다");
			return "스택이 비어있음";
		}
	}

	public Object pop() {
		try{
			if(size == 0) {
				throw new IllegalStateException("stack is empty");
			}	
			Object object = a[--size];
			return object;
		}catch(Exception e){
			System.out.println("스택이 비어서 pop() 할 수 없습니다");
			return "스택이 비어있음";
		}
	}

	public void push(Object object){
		if(size ==a.length){
			resize();
		}
		a[size++] = object;
	}

	public int size() {
		return size;
	}
	


	/**
	* 배열이기 때문에 크기를 재조정해야 할 때 쓰는 함수
	*/
	private void resize() { 
		Object[]aa =a;
		a =  new Object[2*aa.length];
		System.arraycopy(aa,0,a,0,size);
	}

}
