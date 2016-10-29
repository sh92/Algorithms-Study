package org.cscnu.dlist;

/**
* DoubleLinkedList를 구현하기 위한 클래스
* @author 이상희
* @version 1.0
* @since 2015-04-14
* @see DoubleLinkedList
*/
public interface DoubleLinked {
	/**
	* 해당 위치에 데이터를 넣음
	*@param position data를 넣을 위치
	*@param data 넣을 data
	*@return 들어간다면 TRUE를 반환
	*/
	public boolean insert(Object data, int position);

	/**
	* 처음위지에 데이터를 넣음
	* @param data 넣을 data
	* @return 들어간다면 TRUE를 받음
	*/
	public boolean insertFirst(Object data);

	/**
	* 마지막위지에 데이터를 넣음
	* @param data 넣을 data
	* @return 들어간다면 TRUE를 받음
	*/
	public boolean insertLast(Object data);

	/**
	* 해당 데이터가 어디있는지 position을 반환
	* @param data 를 넣으면 position을 반환
	* @return position을 반환
	*/
	public int search(Object data);

	/**
	* 해당 위치의 데이터를 지움
	* @param position 데이터를 지울 위치
	* @return 데이터를 지우면 true
	*/
	public boolean remove(int position);

	/**
	* 처음위치의 데이터를 지움
	* @return 데이터를 지우면 true
	*/
	public boolean removeFirst();

	/**
	* 마지막 위치의 데이터를 지움
	* @return 데이터를 지우면 true
	*/
	public boolean removeLast();

	/**
	* 첫번째 위치의 노드를  반환
	* @return 첫번째 위치의 노드를 반환
	*/
	public Node getFirst();

	/**
	* 마지막 위치의 노드를  반환
	* @return 마지막 위치의 노드를 반환
	*/
	public Node getLast();

	/**
	* 해당 위치의 노드를  반환
	* @return 해당위치의 반환할 노드  
	*/
	public Node getNode(int position);


	/**
	* 노드의 크기를 반환 
	* @return 해당위치의 노드의 크기를 반환
	*/
	public int getSize();

	/**
	* 노드의 값을 모두 출력
	*/
	public void printAll();

}
