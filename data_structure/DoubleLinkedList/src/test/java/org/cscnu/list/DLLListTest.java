package org.cscnu.list;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;
/**
* DLLList 테스터
* @author 이상희
* @version 1.0
* @since 2015-5-21
*/
public class DLLListTest{
	/**
	* DLLList에 대한 Test의 내용 
	*/
	@Test
	public void testDLLList(){


		System.out.println("@@@@@@@ DLLListTest를 시작합니다@@@@@@@@@@");

		java.util.List num  = new DLLList();


		String key1 = "[1]";
		String key2 = "[2]";
		String key3 = "[3]";
		String key4 = "[4]";
		String key5 = "[5]";
		String key6 = "[6]";
		String key7 = "[7]";
		String key8 = "[8]";

		String key9 = "[9]";
		String key0 = "[zero]";
		String key100 = "[100]";
		String key_1= "[minus 1]";
		String keySet= "[set]";


		/* 9개 추가 함*/

		num.add(key1);		
		num.add(key2);		
		num.add(key3);		
		num.add(key4);		
		num.add(key5);		
		num.add(key6);		
		num.add(key7);		
		num.add(key8);		
		num.add(8,key9);//여기서 구현한 리스트는 0부터 시작
	//	num.add(-1,key1); 0보다 작으면 예외		
	//	num.add(100,key1); 리스트의 크기보다 크면 에러

		System.out.println("9개 추가후");
		System.out.println("현재 크기: "+num.size());

		assertEquals(num.get(2), num.remove(2));  //3번째 값 같은지 비교하고 삭제
		System.out.println("1개 제거후");
		System.out.println("현재 크기: "+num.size());


	
		num.add(0,key0);		
		System.out.println("1개 추가후");
		System.out.println("현재 크기: "+num.size());
		assertEquals(num.set(0,keySet), key0); 
		
		Iterator it = num.iterator();

		if(it.hasNext()){
			assertEquals(it.next() , keySet); 
		}
		if(it.hasNext()){
			assertEquals(it.next() , key1); 
		}

		System.out.println("\n\ntoStinrg()으로 전부출력!!!!");
		System.out.println(num.toString());
	}

}
