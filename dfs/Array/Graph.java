import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;

public class Graph {
	
	private int size;
	private String[] vertices;
	private boolean[][] connected;
	private boolean[] visited;
	
	LinkedList<String> list = new LinkedList<String>();

	public Graph(String[] args) {
		size = args.length;
		vertices = new String[size];
		visited =new boolean[size];
		System.arraycopy(args, 0, vertices, 0, size);
		connected = new boolean[size][size];
	}
	

	

	public void dfs(String first) {
	
		Stack<String> stack = new Stack<String>();
		int v=0;
		
	
		stack.push(first);
		visited[index(first)] = true;
		

		
		while (!stack.isEmpty()) {
			v = index(stack.pop());
			list.add(vertices[v]);
			for (int i = 0; i < size; i++)
				if (connected[v][i] && !visited[i]) {
					visited[i] = true;
					stack.push(vertices[i]);
				}
		}
		
		
		System.out.println("깊이 우선 탐색의 결과입니다.");		
		printList();
	}

	
	
	public void add(String v, String w) {
		int i = index(v), j = index(w);
		connected[i][j] = connected[j][i] = true;
	}


	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{" + vertex(0));
		for (int i = 1; i < size; i++)
			buf.append("," + vertex(i));
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
	
	
	private int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return connected.length;
	}

	private String vertex(int i) {
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for (int j = 0; j < size; j++)
			if (connected[i][j])
				buf.append(vertices[j]);
		return buf + "";
	}
}
