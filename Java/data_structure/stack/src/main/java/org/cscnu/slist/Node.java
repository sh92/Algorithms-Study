package org.cscnu.slist;

/**
* LinkedList의 Node를 구현하여 객체로 사용하기 위한 클래스
* @author 이상희
* @version 1.0
* @since 2015-04-03
*/

public class Node{
	
	public Object data = null;
	public Node next= null;

	/** @param data object의 데이터를 Node에 저장함 */
	Node(Object data){
		this.data = data;
	}

	/** @param data,next data와 다음 주소를 저장함 */
	Node(Object data, Node next){
		this.data =data;
		this.next =next;
	}

}
