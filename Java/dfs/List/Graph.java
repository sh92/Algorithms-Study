import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import javax.xml.soap.Node;

public class Graph {

	private int size;
	private String[] vertices;
	private Node []a;
	private LinkedList<String> list = new LinkedList<String>();
	boolean[] visited;
	
	public Graph(String[] args)
	{
		size =args.length;
		a = new Node[size];
		vertices =new String[size];
		visited =new boolean[size];
		
		for(int i =0;i<size;i++){
			vertices[i]=args[i];
		}
	}
	


	
	public void dfs(String first) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[size];

		visited[index(first)] = true;
		stack.push(index(first));
		while (!stack.isEmpty()) {
			list.add(vertices[stack.peek()]);
			for (Node x = a[stack.pop()]; x != null; x = x.next)
				if (!visited[x.to]) {
					visited[x.to] = true;
					stack.push(x.to);
				}
		}
		System.out.println("깊이 우선 탐색의 결과입니다.");	
		printList();
		
	}
		


	
	
	
	public void add(String v, String w)
	{
		

			/*마지막에 추가하는 방식*/
			
			Node last= a[index(v)];
			if(last==null){
				 a[index(v)]=new Node(index(w),null);
			}else{
				while(last.next!=null){
					last= last.next;
				}
				last.next = new Node(index(w),null);
			}
			
			
			
			
			Node last2= a[index(w)];
			if(last2==null){
				a[index(w)]=new Node(index(v),null);
			}else{
				while(last2.next!=null){
					last2= last2.next;
				}
				last2.next = new Node(index(v),null);
			}
		
	
	}

	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{");
		for (int i = 0; i < size; i++) {
			buf.append(vertices[i] + ":");
			for (Node p = a[i]; p != null; p = p.next)
				buf.append(vertices[p.to]);
			buf.append(", ");
		}
		return buf + "}";
	}
	
	
	private void printList(){
		Iterator<String> it = list.iterator();
		System.out.print("{");
		while (it.hasNext()) {
			String cur = it.next();
			System.out.print(cur);
			if(!it.hasNext()) break;
			System.out.print("->");
		}
		System.out.print("}");
	}
	
	private int index(String v){
		for(int i=0;i<size;i++)
		{
			if(vertices[i].equals(v)) return i;
		}
		return a.length;
	}
	
	private class Node{
		
		int to;
		Node next;
		
		Node(int to, Node next )
		{
			this.to = to;
			this.next= next;
		}
		
		
	}

}
