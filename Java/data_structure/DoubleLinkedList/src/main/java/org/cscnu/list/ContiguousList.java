package org.cscnu.list;

import java.util.*;

public class ContiguousList extends AbstractList { 
	private static final int INITIAL_LENGTH = 100;
		private Object[] objects;
		private int size;
		public ContiguousList(){
			this(INITIAL_LENGTH);
		}
		public ContiguousList(int capacity){
			objects = new Object[capacity];
		}

		public ContiguousList(Collection collection) {
			int n = collection.size();
			objects = new Object[2*n];
			Object[] a = collection.toArray();
			System.arraycopy(a, 0,objects,0,n);
		}
		public void add(int i , Object object){
			 if(i <0 || i> size){
		 		throw new ArrayIndexOutOfBoundsException();
			}
			if(size == objects.length) {
				resize();
			}
			System.arraycopy(objects, i , objects ,i+1, size-i);
			objects[i] = object;
			++size;
		}

	public Object get(int i) {
		if( i < 0 || i >=size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return objects[i];
	}
	public Object remove(int i) {
		if( i < 0 || i >=size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Object object = objects[i];
		System.arraycopy(objects , i+1 , objects,i, size-i-1);
		objects[--size] =  null;
		return object;
	}


	public Object set(int i , Object object) {
		if(i < 0 || i >=size) {
			throw new ArrayIndexOutOfBoundsException();
		}

		Object oldObject = objects[i];
		objects[i] = object;
		return oldObject;
	}

	public int size() {
		return size;
	}

	public void resize() {
		Object[] temp = new Object[2*objects.length];
		System.arraycopy(objects, 0, temp, 0, size);
		objects = temp;
	}


}

