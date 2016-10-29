package org.cscnu.arrayset;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.BeforeClass;
import org.junit.Test;

/**
* ArraySet 테스터
* @author 이상희
* @version 1.0
* @since 2015-3-18
*/
public class ArraySetTest{
	/**
	* Set은 중복을 허용하지 않고 데이터를 저장하는데 데이터가 제대로 포함되어 있는지 그리고 중복되지 않는 개수가 맞는지 확인한다
	*/
	@Test
	public void testcontains(){

		ArraySet set= new ArraySet();

		String temp1 = "A";
		String temp2 = "B";
		String temp3 = "A";

		set.add(temp1);
		set.add(temp2);
		set.add(temp3);

		assertTrue(set.contains(temp1));
		assertTrue(set.contains(temp2));
		assertTrue(set.contains(temp3));


		assertEquals(2, set.size());
	}

	

}
