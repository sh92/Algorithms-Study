package org.cscnu.map;

/**
* Map의 ADT를 구현한 interface
* @author 이상희
* @version 1.0
* @since 2015-5-10
* @see DLLMap
* @see HashMap
* @see ArrayMap
*/
public interface Map{
	/** key를 가지고 값을 불러옴
	* @param key 값을 불러올 key
	* @return String value 값
	*/
	public String get(String key);
	/**
	* key와 value를 받아 집어넣음, 해당 key값에 값이 들어있으면 값을 지우고 새로 씀
	* @param key 저장할 key
	* @param value 저장할 value
	* @return 이전의 key에 대한 값이 존재한다면 그 값을 리턴, 아니면 null
	*/
	public String put(String key, String value);
	/**
	* map의 크기를 반환 
	* @return map의 크기를 반환
	*/
	public int size();
	/**
	* map의 전체 내용을 반환
	* @return map의 전체 내용을 반환
	*/
	public String toString();
}
