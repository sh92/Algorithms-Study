package org.cscnu.list;

import java.util.*;

public class SampleContiguousList { 
	public static void main(String[] args){
		java.util.List g8 = new ContiguousList();
		g8.add("CA");
		g8.add("DE");
		g8.add("FR");
		g8.add("GB");
		g8.add("IT");
		g8.add("RU");
		g8.add("US");
		System.out.println(g8);

		g8.add(5, "JP");
		System.out.println(g8);

		System.out.println("g8.size(): " +g8.size());
		System.out.println("g8.contains(\"JP\"): " +g8.contains("JP"));
		System.out.println("g8.contains.(\"CN\"): " +g8.contains("CN"));
		System.out.println("g8.get(3): " + g8.get(3));
		System.out.println("g8.subList(3,6): " + g8.subList(3,6));

		g8.remove(6);
		System.out.println(g8);

		System.out.println("g8.set(0, \"CN\"): " + g8.set(0,"CN"));

		Iterator it = g8.iterator();

		System.out.println(g8);
		System.out.println("it.next() : " + it.next());
		System.out.println("it.next() : " + it.next());
		System.out.println("it.next() : " + it.next());
		System.out.println("it.next() : " + it.next());
		System.out.println("it.next() : " + it.next());
		System.out.println("it.next() : " + it.next());
		System.out.println("it.next() : " + it.next());
		System.out.println("it.hasNext() : " + it.hasNext());

	}
}
	
