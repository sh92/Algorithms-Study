package org.cscnu.map;

/**
* Hash를 이용하여 Map을 구현한 클래스
* @author 이상희
* @version 1.0
* @since 2015-5-10
*/

public class HashMap implements Map{
	private static final int INITIAL_LENGTH=8192;
	private Entry2[] a = new Entry2[INITIAL_LENGTH];
	private int size;

	public String get(String key){
		if(a[Math.abs(key.hashCode()%INITIAL_LENGTH)] !=null){
			return a[Math.abs(key.hashCode()%INITIAL_LENGTH)].value;
		}
		return null;
	}

	public String put(String key, String value){

			int findkey = Math.abs(key.hashCode()%INITIAL_LENGTH);

			if(a[findkey]!=null){
				return a[findkey].setValue(value);
			}
		a[findkey] = new Entry2(key, value);
		size++;
		return null;
	}
	
	/**
	* 크기가 작은것을 키움
	*/
	public void resize() {
		Entry2[] aa = new Entry2[2*a.length];
		System.arraycopy(a,0,aa,0,a.length);
		a=aa;
	}

	public int size() { 
		return size;
	}

	public String toString(){
		StringBuffer buf = new StringBuffer();
		for(int i =0;i<INITIAL_LENGTH;i++){
			if(a[i] !=null){
				buf.append(a[i] + "\n");
			}
		}
		return buf.toString();
	}

}
