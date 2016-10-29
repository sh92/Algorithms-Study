package org.cscnu.stack;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
* Postfix 테스터
* @author 이상희
* @version 1.0
* @since 2015-04-09
*/
public class PostFixTest{
	/**
	* Postfix 가 잘 작동하는지 확인하는 Tester 
	*/
	@Test
	public void testPostFix(){
		System.out.println("########PostFix Test를 시작합니다.########");


		String temp1 = "9-2*3+4/2";
		String  temp2 = "(3-2)+1"; 
		String  temp3 = "(4-3)*2+3-(4-3)*2";	
		

		//Stack에 값을 추가한다.
		System.out.println("3개를 추가");
		

		int temp_no1=PostFix.incomingPrecedence('('); // 우선순위 5예상
		int temp_no2=PostFix.instackPrecedence('('); // 우선순위 2예상
		int temp_no3=PostFix.instackPrecedence(' '); // 우선순위 -1예상


		assertEquals(5, temp_no1);
		assertEquals(2, temp_no2);
		assertEquals(-1, temp_no3);


		char[] temp_token1=PostFix.stringToToken(temp1);
		
		System.out.println("후위표기식 변환하기전:"+temp3);
		System.out.println("[변환 후]");
		PostFix.toPostFix(temp3);

		System.out.println("괄호제거전:"+temp2);
		temp2=PostFix.parentheseRemove(temp2);
		System.out.println("괄호제거후:"+temp2);

		assertEquals("3-2+1", temp2);



	}

}
