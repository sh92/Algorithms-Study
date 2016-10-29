package org.cscnu.list;

/**
* DoubleLinkedList를 구현하기 위한 Node
* @author 이상희
* @version 1.0
* @since 2015-04-14
*/
public class Node {
	public Object data =null;
	public Node next = null;
	public Node prev  = null;

	/**
	* 데이터만 들어갈 때
	* @param data 데이터만 들어갈때 쓰는 Node
	*/
	Node(Object data) {
		this.data = data;
	}

	/**
	* @param data 데이터를 집어넣음
	* @param next 다음 값을 집어넣음
	* @param prev 이전값을 집어넣음
	*/
	Node(Object data, Node next, Node prev){
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
}
	
