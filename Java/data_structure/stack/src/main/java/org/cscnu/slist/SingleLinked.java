package org.cscnu.slist;
/**
* SingleLinked List의 구현하기 위한 interface
* @author 이상희
* @version 1.0
* @see SingleLinkedList
* @since 2015-04-03
*/
public interface SingleLinked {

	/** @param data data를 첫번째 위치에 추가 저장함*/
	public boolean insertFirst(Object data);
	/** @param data data를 마지막 위치에 추가 저장함*/
	public boolean insertLast(Object data);
	/** @param position data를 position 위치에 추가 저장함*/
	public boolean insert(Object data, int position);

	/** @return boolean 첫번째 데이터를 지우면 TRUE를 반환*/
	public boolean removeFirst();
	/** @return boolean 마지막 데이터를 지우면 TRUE를 반환*/
	public boolean removeLast();
	/** @return boolean position 위치의  데이터를 지우면 TRUE를 반환*/
	public boolean remove(int position);

	/** @return Node 첫번째  위치의 Node를 반환*/
	public Node getFirst();
	/** @return Size Node의 크기를 반환*/
	public int getSize();
	/* Node의 모든 값을 출력*/
	public void printAll();
	/** @return Node position 위치의 Node를 반환*/
	public Node getNode(int position);

	/** @return int : data를 집어 넣으면 그 data와 같은 값을 가지는 노드의 위치를 반환*/
	public int search(Object data);
}
