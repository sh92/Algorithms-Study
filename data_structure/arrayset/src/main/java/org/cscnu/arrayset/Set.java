package org.cscnu.arrayset;
/**
* Set과 관련된 인터페이스 
* @author 이상희
* @version 1.0
* @since 2015-03-19
*/
public interface Set{

	/**
	* @param object : Set에 데이터를 추가함
	*/
	public void add(Object object);
	/** @return  boolean : Set에 데이터가 포함되어있으면 True를 반환*/
	public boolean contains(Object object);

	/** @return  Object : Set에 포함된 첫번째 데이터를 반환*/
	public Object getFirst();


	/** @return  boolean : Set에 포함된 현재위치의 데이터를 반환하고 다음으로 넘김*/
	public Object getNext();

	/** @return  boolean : Set에 포함된 이전 위치로 옮기고 다음 위치 반환 */
	public Object getPrevious();

	/**  현재 Set에 포함된 데이터를 모두 출력*/
	public void allPrint();


	/** @return  boolean : Set에 데이터가 포함되어있으면 True를 반환하고 데이터를 제거함*/
	public boolean remove(Object object);

	/** @return  int : Set에 포함된 데이터의 개수를 반환*/
	public int size();

	}

