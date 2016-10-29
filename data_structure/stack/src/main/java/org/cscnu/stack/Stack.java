package org.cscnu.stack;

/**
*Stack을 만들기 위한 interface
*@author 이상희
*@version 1.0
*@since 2015-04-08
*@see	SListStack 
*/
public interface Stack {

	/**
	* stack의 가장 윗부분의 데이터를 보여는 함수
	* @return stack의 가장 윗부분의 데이터
	*/
	public Object peek();

	/**
	* stack의 가장 윗부분의 데이터를 반환하고 지우는 함수
	* @return stack의 가장 윗부분의 데이터
	*/
	public Object pop();
	/**
	* stack에 object라는 데이터를 집어넣는 함수
	* @param object stack에 object라는 데이터
	*/
	public void push(Object object);

	/**
	* stack의 크기를 반환하는 함수
	* @return stack의 크기를 반환
	*/
	public int size();
}
