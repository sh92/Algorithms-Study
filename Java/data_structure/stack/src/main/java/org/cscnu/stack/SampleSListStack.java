package org.cscnu.stack;
/**
* SListStack을 사용하는  Sample Page
* @author 이상희
* @version 1.0
* @since 2015-04-09
*/
public class SampleSListStack{
	public static void main(String[] args) {
		Stack crates = new SListStack();

		crates.push("당근");
		crates.push("오렌지");
		crates.push("건포도");
		crates.push("피클");
		crates.push("바나나");

		System.out.println("crates.size():"+crates.size()+"\tcrates.peek(): "+crates.peek());
		System.out.println("crates.pop():"+crates.pop());
		System.out.println("crares.pop():"+crates.pop());
		System.out.println("crares.pop():"+crates.pop());
		System.out.println("crates.size():"+crates.size()+"\tcrates.peek(): "+crates.peek());

		crates.push("호두");
		crates.push("마다카미아");
		System.out.println("crates.size():"+crates.size()+"\tcrates.peek(): "+crates.peek());
		System.out.println("crares.pop():"+crates.pop());
		System.out.println("crares.pop():"+crates.pop());
		System.out.println("crares.pop():"+crates.pop());
		System.out.println("crares.pop():"+crates.pop());
		System.out.println("crares.pop():"+crates.pop());
	}

}
		

