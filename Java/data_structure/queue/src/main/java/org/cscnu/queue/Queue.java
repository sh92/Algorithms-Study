package org.cscnu.queue;
/**
* Queue를 구현하는 interface
* @author 이상희
* @version 1.0
* @since 2015-04-14
* @see DLLQueue 
*/
public interface Queue{
	/**
	* @param object Queue에 데이터를 집어넣음
	*/
	public void add(Object object);
	
	/**
	* @return 첫번째 값을 반환, 즉 첫번째 넣었던 값이 나옴
	*/
	public Object first();

	/**
	* @return 첫번째 값을 지움
	*/
	public Object remove();

	/**
	* @return Queue의 size를 반환
	*/
	public int size();
}
