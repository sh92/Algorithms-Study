package org.cscnu.queue;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
* DoubleLinkedTest 테스터
* @author 이상희
* @version 1.0
* @since 2015-4-05
*/
public class DLLQueueTest{
	/**
	* DoubleLinkedLIst 로 구현한 Queue를 테스트하기위한 Test 
	*/
	@Test
	public void testDLLQueue(){
		System.out.println("@@@@@@@DLLQueueTest를 시작합니다@@@@@@@@@@");

		DLLQueue dll= new DLLQueue();
		
		Object temp1="가가";
		Object temp2="나나";
		Object temp3="다다";
		Object temp4="라라";
		Object temp5="마마";
		Object temp6="바바";



		/* 4개 추가 함*/
		System.out.println("4개 추가후");
		dll.add(temp1);
		dll.add(temp2);
		dll.add(temp3);
		dll.add(temp4);

		assertEquals(temp1, dll.first());
		assertEquals(temp1, dll.remove());
		assertEquals(temp2, dll.first());
		assertEquals(3, dll.size());



	}

}
