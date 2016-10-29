package org.cscnu.stack;

import org.cscnu.slist.*;
import org.cscnu.stack.PostFix;
/**
* 중위표기법을 후위표기법으로 바꾸기 위해 Stack을 이용하여 보여주는 메인 클래스
* @author 이상희
* @version 1.0
* @since 2015-04-09
*/

public class Sample {
	public static void main(String[] args) { 
		String one ="6/2-3+4*2", two ="a*(b+c)*d";
		String three ="(2+4)*5", four = "(6-2)*(5+4)";
		String five ="(a/(b-c+d))*(e-a)*c", six="a/b-c+d*e-a*c";
		System.out.print("one: "+one+" -> ");
		toPostFix(one);
		System.out.print("two: "+two+" -> ");
		toPostFix(two);
		System.out.print("three: "+three+" -> ");
		toPostFix(three);
		System.out.print("four: "+four+" -> ");
		toPostFix(four);
		System.out.print("five: "+five+" -> ");
		toPostFix(five);
		System.out.print("six: "+six+" -> ");
		toPostFix(six);
	}
	/**
	* infix 형태를 받아 postfix형태로 바꿔주는 static 메서드를 이용하는 함수
	*@param _in 중위 표기식의 데이터를 받음 
	*/
	public static void toPostFix(String _in){
		PostFix.toPostFix(_in);
	}
}
