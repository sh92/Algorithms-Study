package org.cscnu.queue;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
* ArrayQueue1 테스터
* @author 이상희
* @version 1.0
* @since 2015-4-05
*/
public class ArrayQueue1Test{
	/**
	* ArrayQueue에 대한 Test의 내용 (Arraycopy를 이용)
	*/
	@Test
	public void testArrayQueue1(){
		System.out.println("@@@@@@@ArrayQueue1Test를 시작합니다@@@@@@@@@@");

		ArrayQueue1 aq= new ArrayQueue1();
		
		Object temp1="가가";
		Object temp2="나나";
		Object temp3="다다";
		Object temp4="라라";
		Object temp5="마마";
		Object temp6="바바";



		/* 4개 추가 함*/
		System.out.println("4개 추가후");
		aq.add(temp1);
		aq.add(temp2);
		aq.add(temp3);
		aq.add(temp4);

		assertEquals(temp1, aq.first());
		assertEquals(temp1, aq.remove());
		assertEquals(temp2, aq.first());
		assertEquals(3, aq.size());



	}

}
