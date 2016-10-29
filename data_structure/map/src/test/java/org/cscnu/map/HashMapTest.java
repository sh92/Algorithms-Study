package org.cscnu.map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
* HashMap 테스터
* @author 이상희
* @version 1.0
* @since 2015-5-10
*/
public class HashMapTest{
	/**
	* HashMap에 대한 Test의 내용 
	*/
	@Test
	public void testHashMap(){
		System.out.println("@@@@@@@ HashMapTest 를 시작합니다@@@@@@@@@@");

		HashMap hm= new HashMap();
		


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

		
		hm.put(key1, value1);
		hm.put(key2, value2);
		hm.put(key3, value3);
		hm.put(key4, value4);
		hm.put(key5, value5);
		hm.put(key6, value6);
		hm.put(key7, value7);
		hm.put(key8, value8);


		System.out.println(key1+" : " +hm.get(key1));
		System.out.println(key2+" : " +hm.get(key2));
		System.out.println("key3로 get할때 "+key3+" : " +hm.get(key3));
		System.out.println("key4로 get할때 "+key4+" : " +hm.get(key4));
		System.out.println(key5+" : " +hm.get(key5));
		System.out.println(key6+" : " +hm.get(key6));
		System.out.println("key7으로 get할때 "+key7+" : " +hm.get(key7));
		System.out.println("key8으로 get할때 "+key8+" : " +hm.get(key8));
	

		assertEquals(key3, key7); //실제 key3와 key7은 같은 주소를 가리킴
		assertEquals(key4, key8); //실제 key4dhk key8은 같은 주소를 가리킴
		assertEquals(hm.get(key3) , hm.get(key7));
		assertEquals(hm.get(key4) , hm.get(key8));

		System.out.println("\n\ntoStinrg()으로 전부출력!!!!");
		System.out.println(hm.toString());



	}

}
