package org.cscnu.map;

/**
* Array를 이용하여 key와 value를 저장하는 map클래스
* @author 이상희
* @version 1.0
* @since 2015-05-10
*/

public class ArrayMap implements Map{
	private static final int INITIAL_LENGTH=10;
	private Entry[] a = new Entry[INITIAL_LENGTH];
	private int size;

	public String get(String key){
		for(int i =0; i<size;i++){
			if(a[i].key.equals(key)){
				return a[i].value;
			}
		}
		return null;
	}

	public String put(String key, String value){
		for(int i =0; i<size;i++) { 
			if(a[i].key.equals(key)){
				return a[i].setValue(value);
			}
		}
		if(size == a.length){
			resize();
		}
		a[size++] = new Entry(key, value);
		return null;
	}
	/**
	* Array의 크기가 적어서 크기를 키움
	*/
	public void resize() {
		Entry[] aa = new Entry[2*a.length];
		System.arraycopy(a,0,aa,0,a.length);
		a=aa;
	}

	public int size() { 
		return size;
	}

	public String toString(){
		StringBuffer buf = new StringBuffer();
		for(int i =0;i<size;i++){
			buf.append(a[i] + "\n");
		}
		return buf.toString();
	}

}
