package org.cscnu.arraybag;

/**
* Array를 이용하여 Bag를 만들어 함수를 정의한 클래스
* @autor 이상희
* @version 1.0
* @since 2015-03-19
*/
public class ArrayBag implements Bag{

	private Object[] objects = new Object[1000];

	private int size,i;

	public boolean contains(Object object){
		for(int i=0; i<size ;i++){
			if(objects[i]==object){
				return true;
			}
		}
		return false;
	}

	public void add(Object object){
				
				objects[size++] = object;
	}
	public Object getFirst() {
		i=0;
		return objects[i++];
	}
	public Object getNext(){
		return  objects[i++];
	}
	public Object getPrevious(){
		return objects[--i];
	}
	public boolean remove(Object object) {
		for(int i=0; i<size; i++) {
			if(objects[i]==object){
				System.arraycopy(objects , i+1, objects, i, size-i-1);
				objects[--size]=null;
			return true;
			}
		}
		return false;
	}

	public int size() {
		return size;
	}
}
