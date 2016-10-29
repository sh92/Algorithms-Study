package org.cscnu.map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
* DLLMap 테스터
* @author 이상희
* @version 1.0
* @since 2015-5-10
*/
public class DLLMapTest{
	/**
	* DLLMap에 대한 Test의 내용 
	*/
	@Test
	public void testDLLMap(){
		System.out.println("@@@@@@@ DLLMapTest를 시작합니다@@@@@@@@@@");

		DLLMap dm= new DLLMap();
		


		String key1 = "CC";
		String key2 = "AA";
		String key3 = "B";
		String key4 = "C";
		String key5 = "A";
		String key6 = "BB";

		String key7 = "B";
		String key8 = "C";


		String value1 = "key1 -> "+key1 + "\'s value ";
		String value2 = "key2 -> "+key2 + "\'s value ";
		String value3 = "key3 -> "+key3 + "\'s value ";
		String value4 = "key4 -> "+key4 + "\'s value ";
		String value5 = "key5 -> "+key5 + "\'s value ";
		String value6 = "key6 -> "+key6 + "\'s value ";

		String value7 = "key3==key7 : value3->value7(중복키로 값 변형) = " + key7 + "\'s value ";
		String value8 = "key4==key8 : value4->value8(중복키로 값 변형) = " + key8 + "\'s value ";

		/* 8개 추가 함*/
		System.out.println("8개 추가후");

		
		dm.put(key1, value1);
		dm.put(key2, value2);
		dm.put(key3, value3);
		dm.put(key4, value4);
		dm.put(key5, value5);
		dm.put(key6, value6);
		dm.put(key7, value7);
		dm.put(key8, value8);


		System.out.println(key1+" : " +dm.get(key1));
		System.out.println(key2+" : " +dm.get(key2));
		System.out.println("key3로 get할때 "+key3+" : " +dm.get(key3));
		System.out.println("key4로 get할때 "+key4+" : " +dm.get(key4));
		System.out.println(key5+" : " +dm.get(key5));
		System.out.println(key6+" : " +dm.get(key6));
		System.out.println("key7으로 get할때 "+key7+" : " +dm.get(key7));
		System.out.println("key8으로 get할때 "+key8+" : " +dm.get(key8));
	

		assertEquals(key3, key7); //실제 key3와 key7은 같은 주소를 가리킴
		assertEquals(key4, key8); //실제 key4dhk key8은 같은 주소를 가리킴
		assertEquals(dm.get(key3) , dm.get(key7));
		assertEquals(dm.get(key4) , dm.get(key8));

		System.out.println("\n\ntoStinrg()으로 전부출력!!!!");
		System.out.println(dm.toString());



	}

}
