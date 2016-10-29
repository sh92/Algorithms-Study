package org.cscnu.stack;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
* SListStack 테스터
* @author 이상희
* @version 1.0
* @since 2015-04-09
*/
public class SListStackTest{
	/**
	* SListStackTest가 잘작동하는지 확인하는 Tester 
	*/
	private SListStack stack= new SListStack();
	@Test
	public void testSListStack(){
		System.out.println("########SListStack Test를 시작합니다.########");


		Object temp1 = "가가";
		Object temp2 = "나나"; 
		Object temp3 = "다다"; 
		Object temp4 = "라라"; 
		
		assertTrue(stack.isEmpty());

		//Stack에 값을 추가한다.
		System.out.println("4개를 추가");
		stack.push(temp1);
		stack.push(temp2);
		stack.push(temp3);
		stack.push(temp4);





		//stack의 함수 size(), peek(),pop()이 잘 작동하는지 확인해본다.
		assertEquals(4, stack.size());
		assertEquals(temp4 , stack.pop());
		assertEquals(temp3 , stack.peek());
		assertEquals(temp3 , stack.pop());
		assertEquals(temp2 , stack.pop());
		assertEquals(1, stack.size());



	}

}
