package org.cscnu.map;

/**
* ArrayMap의 key와 value를 저장하여 객체로 사용하기  위한 클래스
* @author 이상희
* @version 1.0
* @since 2015-5-10
*/

public class Entry{
	String key, value;
	

	/**
	* key와 value를 저장하는 생성자
	* @param key 저장할 key
	* @param value 저장할 value
	*/
	public Entry(String key, String value){
		this.key =  key;
		this.value = value;
	}

	/**
	* value를 받으면 이전의 가지고 있는 객체를 반환하고 받은 객체를 현재의 객체로 만듬
	* @param value 새로저장할 value
	* @return oldValue 
	*/
	public String setValue(String value){
		String oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	/**
	* key와 value 쌍을 반환
	* @return key : value
	*/
	public String toString(){
		return key + ":" + value;
	}
}
