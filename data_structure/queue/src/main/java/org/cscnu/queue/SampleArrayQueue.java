package org.cscnu.queue;

/**
* Array를 이용하여 Queue를 구현하여 ArrayQueue1 과 ArrayQueue2를 구현함
* @author 이상희
* @version 1.0
* @since 2015-04-14
*/
public class SampleArrayQueue {
	public static void main(String[] args){

		//ArrayQueue1
		System.out.println("@@@ ArrayQueue1 Printing @@@ ");
		
		ArrayQueue1 queue1  = new ArrayQueue1();

		queue1.add("Computer Science");
		queue1.add("2015");
		queue1.add("Spring");
		queue1.add("Data Structure");
		queue1.add("Mid Example");


		System.out.println("Queue first : " + queue1.first());

		System.out.println(queue1.remove() + "(size: " + queue1.size() +")");
		System.out.println(queue1.remove() + "(size: " + queue1.size() +")");
		System.out.println(queue1.remove() + "(size: " + queue1.size() +")");
		System.out.println(queue1.remove() + "(size: " + queue1.size() +")");


		queue1.add("Next Wendseday");
		queue1.add("10:00");

		
		System.out.println(queue1.remove() + "(size: " + queue1.size() +")");
		System.out.println(queue1.remove() + "(size: " + queue1.size() +")");
		System.out.println(queue1.remove() + "(size: " + queue1.size() +")");

		//ArrayQueue2
		System.out.println("@@@ ArrayQueue2 Printing @@@ ");
		
		ArrayQueue2 queue2  = new ArrayQueue2();

		queue2.add("A");
		queue2.add("B");
		queue2.add("C");
		queue2.add("D");
		queue2.add("E");


		System.out.println("Queue first : " + queue2.first());

		System.out.println(queue2.remove() + "(size: " + queue2.size() +")");
		System.out.println(queue2.remove() + "(size: " + queue2.size() +")");
		System.out.println(queue2.remove() + "(size: " + queue2.size() +")");
		System.out.println(queue2.remove() + "(size: " + queue2.size() +")");


		queue2.add("F");
		queue2.add("G");

		
		System.out.println(queue2.remove() + "(size: " + queue2.size() +")");
		System.out.println(queue2.remove() + "(size: " + queue2.size() +")");
		System.out.println(queue2.remove() + "(size: " + queue2.size() +")");
	}
}





