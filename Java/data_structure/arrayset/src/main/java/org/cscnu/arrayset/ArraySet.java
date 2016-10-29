package org.cscnu.arrayset;

/**
* Array 를 이용하여 Set을 구현하기 위해 함수를 정의한  클래스
* @author 이상희
* @version 1.0
* @since 2015-03-19
*/
public class ArraySet implements Set{

	private Object[] objects = new Object[1000];

	private int size,i;


	public boolean contains(Object object){
		for(int i=0; i<size ;i++){
		//	if(objects[i]==object){
			if(objects[i].equals(object)){
				return true;
			}
		
		}

		return false;
		
	}

	public void add(Object object){
		if(contains(object)){
			System.out.println(" 중복 되어 'equals'로 add되지 않은 것(밑의 내용) :"+object);
			//System.out.println(" 중복 되어 '=='로 add되지 않은 것(밑의 내용) :"+object);
		}else{
		objects[size++] = object;
		}
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
	public	void allPrint(){
		System.out.println("Set의 전체 내용을 뿌려줌니다.");
		for(int i =0;i<size;i++){
			System.out.println( "["+i+"]"+objects[i] );
		}

	}
	public boolean remove(Object object) {
		for(int i=0; i<size; i++) {
			if(objects[i].equals(object)){
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
