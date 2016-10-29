package org.cscnu.queue;
/**
* DoubleLinkedLIst 를 이용하여 만든 Queue를 구현하여 실행하는 Sample페이지
* @author 이상희
* @version 1.0
* @since 2015-04-14
*/
public class SampleDLLQueue{
	public static void main(String[] args){

		//DLLQueue
		System.out.println("@@@ DLLQueue Printing @@@ ");
		
		DLLQueue queue1  = new DLLQueue();

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
		System.out.println(queue1.remove() + "(size: " + queue1.size() +")");

	}
}





