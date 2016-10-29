package org.cscnu.arraybag;
/**
* Bag를 구현하기위한 인터페이스 
* @author 이상희
* @version 1.0
* @since 2015-03-19
* @see ArrayBag
*/
public interface Bag {

	/** @param object bag에 데이터를 추가함 */
	public void add(Object object);
	/** @return boolean:  저장되어 있으면 True */
	public boolean contains(Object object);

 
	/** @return object :bag object의 첫번째 값을 반환*/	
	public Object getFirst();


	/** @return object :bag 의 값을 반환하고 다음위치로  넘김*/	
	public Object getNext();
	/** @return object :bag 의 이전 위치로 가서 값을 반환*/	
	public Object getPrevious();

	/** @return boolean :bag에 같은 값이 있으면 TRUE를 반환하고   값을 지움 */	
	public boolean remove(Object object);

	/** @return size :bag의 개수를 반환*/	
	public int size();

	}

