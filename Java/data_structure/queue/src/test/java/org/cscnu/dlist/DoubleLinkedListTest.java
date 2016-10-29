package org.cscnu.dlist;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
* DoubleLinkedList 테스터
* @author 이상희
* @version 1.0
* @since 2015-4-05
*/
public class DoubleLinkedListTest{
	/**
	* DoubleLinkedList를 테스트하는 페이지로 데이터를 집어넣고 제거하는 Test페이지 
	*/
	@Test
	public void testDoubleLinkedList(){
		System.out.println("@@@@@@@DoubleLinkedList 를 시작합니다@@@@@@@@@@");

		DoubleLinkedList list= new DoubleLinkedList();
		Node start=null;
		
		Object temp1="가가";
		Object temp2="나나";
		Object temp3="다다";
		Object temp4="라라";
		Object temp5="마마";
		Object temp6="바바";



		/* 4개 추가 함*/
		list.printAll();
		System.out.println("4개 추가후");
		list.insert(temp3,1);
		list.insert(temp2,2);
		list.insert(temp1,3);
		list.insert(temp4,4);

		list.insertLast(temp5);
		list.insertFirst(temp6);
		list.printAll();

		/*4개의 값의 위치가 동일한지  확인함*/
		assertEquals(3, list.search(temp2));
		assertEquals(2, list.search(temp3));
		assertEquals(1, list.search(temp6));
		assertEquals(4, list.search(temp1));
		assertEquals(5, list.search(temp4));
		assertEquals(6, list.search(temp5));


		/*몇개 제거후 동일한지에 대한 Test*/
		System.out.println("#########가가 제거후##########");
		list.remove(list.search(temp1));
		list.printAll();
		System.out.println("#########라라 제거후##########");
		list.remove(list.search(temp4));
		list.printAll();



	}

}
