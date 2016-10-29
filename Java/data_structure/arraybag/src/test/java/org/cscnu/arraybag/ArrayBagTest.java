package org.cscnu.arraybag;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.BeforeClass;
import org.junit.Test;

/**
* ArrayBag 테스터
* @author 이상희
* @version 1.0
* @since 2015-3-18
*/
public class ArrayBagTest{
	/**
	* 값을 bag에 저장하고 bag에 포함되어있는지 확인하는 Test
	*/
	@Test
	public void testcontains(){

		ArrayBag bag= new ArrayBag();

		String temp1 = "A";
		String temp2 = "B";
		String temp3 = "A";

		bag.add(temp1);
		bag.add(temp2);

		assertTrue(bag.contains(temp1));
		assertTrue(bag.contains(temp2));
		assertFalse(bag.contains(temp3));

		assertEquals(3,bag.size());
	}

	

}
