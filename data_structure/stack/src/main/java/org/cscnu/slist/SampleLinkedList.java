package org.cscnu.slist;
/**
* SampleLinkedList 페이지로 데이터를 추가하고 제거
* @version 1.0
* @since 2015-03-31
*/
public class SampleLinkedList {
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		
		list.insert("A", 0);
		list.printAll();
		list.insert("B", 2);
		list.printAll();
		list.insert("C", 2);
		list.printAll();
		list.insert("D", 2);
		list.printAll();
		list.insert("E", 5);
		list.printAll();

		list.remove(list.search("C"));
		list.printAll();
		list.remove(1);
		list.printAll();
		list.remove(2);
		list.printAll();
		list.remove(2);
		list.printAll();
		list.remove(2);
		list.printAll();
		list.remove(2);
		list.printAll();
		list.removeLast();
		list.printAll();
		list.removeFirst();
		list.printAll();

		list.insertFirst(147);
		list.printAll();
		list.insertLast(369);
		list.printAll();
		list.insertFirst(789);
		list.printAll();
		list.insertLast(321);
		list.printAll();
		list.insert(852, 3);
		list.printAll();
		list.insert(258, 3);
		list.printAll();

		System.out.println("최종 크기: " + list.getSize());
		System.out.println("4번째 노드 데이터: " + list.getNode(4).data);
		System.out.println("852의 위치: " + list.search(852));

		SingleLinkedList list2 = new SingleLinkedList();

		list2.insertFirst("Yellowcard");
		list2.printAll();
		list2.insertFirst("Hoobastank");
		list2.printAll();
		list2.insertLast("Nightwish");
		list2.printAll();
		list2.insertLast("Good Charlotte");
		list2.printAll();
		
		System.out.println("insert후 크기: " + list2.getSize());
		list2.printAll();

		list2.removeFirst();
		list2.printAll();
		list2.removeLast();
		list2.printAll();
		list2.removeFirst();
		list2.printAll();
		list2.removeLast();
		list2.printAll();

		System.out.println("remove후 크기: " + list2.getSize());
	}
}
