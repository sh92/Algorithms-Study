import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Vector;

public class Graph {

	private int size;
	private String[] vertices;
	private Node []a;
	private boolean[] visited;
	private int[] dist;
	private String[] prev;
	private int visitedCount;
	int start,end;
	Vector<Integer> stack;
	private int minimum;
	
	Graph() throws IOException
	{

		FileInputStream stream = new FileInputStream("input");
		InputStreamReader reader = new InputStreamReader(stream);
		StreamTokenizer token =new StreamTokenizer(reader);

		while(token.nextToken() !=StreamTokenizer.TT_EOF){
			switch(token.ttype){
			case StreamTokenizer.TT_NUMBER:
				if(token.lineno() ==1)
				{
					size=(int)token.nval;
					visitedCount=0;
					a = new Node[size];
					vertices =new String[size];
					visited =new boolean[size];
					dist = new int[size];
					prev = new String[size];
					for(int i =0;i<size;i++){
						dist[i]=Integer.MAX_VALUE;
						prev[i]=null;
					
					}
				
				}
				
				break;

			case StreamTokenizer.TT_WORD:
				if(token.lineno() <size+2 && token.lineno() >1){
					int num = token.lineno()-2;
					vertices[num]=token.sval;
				}else{
					String w1 = token.sval;
					token.nextToken();
					String w2 = token.sval;
					token.nextToken();
					add(w1, w2, (int)token.nval);
				}
				break;
			}
		}
	}
	



	/**
	 * 인덱스를 이용하여 거리를 출력한다.
	 * @param _index 인덱스를 이용하여 출발점으로부터의 거리와 정점들을 출력한다.
	 */
	public void printPath(int _index ){
		if(dist[_index]==0){
			System.out.print(vertices[_index] +" : 거리 "+dist[_index]+ " /  ");
			System.out.print("출발점");
		}else{
			System.out.print(vertices[_index] +" : 거리 "+dist[_index]+ " /  ");
			printRecursively(_index);
		}
	
		
	}
	/**
	 * 인덱스를 이용하여 거리를 재귀적으로 출력한다.
	 * @param _index 인덱스와 prev 배열을 이용하여 경로를 출력한다.
	 */
	public void printRecursively(int _index)
	{
		if(dist[_index]==0){
			System.out.print(vertices[_index]);
		}else{
			
			System.out.print(vertices[_index]+" <- ");
			printRecursively(index(prev[_index]));
		}
		
	}
	/**
	 * x와 y의 거리를 반환하는 함수
	 * @param x 인접리스트 시작점
	 * @param y 인접리스트 x로 부터 연결된 노드들 중 y에 대한 거리를 반환하기 위함
	 * @return x와 y사이의 거리
	 */
	public int weight(String x,String y){
		Node p = a[index(x)];
		while(p !=null){
			if(p.index==index(y)){
				return p.weight;
			}
			p=p.next;
		}
		return -1;
	}

	/**
	 * 다익스트라 - 최단 경로 알고리즘 
	 * @param _firstVertex 첫번째 파라미터는 
	 */
	public void dijkstra(String _firstVertex){ 
		
		int firstIndex = index(_firstVertex); 
		int u=firstIndex; //첫번째 인덱스를 방문인덱스로 설정

		
		dist[firstIndex]=0; //첫번째 방문점 거리 0 설정 
		visited[firstIndex]=true; 
		visitedCount++;
		
		while(visitedCount!=size){  //탈출조건 :  모두 방문
			
			for(Node p =a[u];p!=null;p=p.next){ 
				//방문한 인덱스를 기준으로 연결리스트에 연결된 리스트들에 연결된 노드들의 인덱스를 가지고  저장된 거리와 방문한것까지의 거리+방문한 것으로 부터의 거리를 비교하여 더 적다면 거리를 갱신한고 이전 값을 집어 넣는다. 단, 방문하지  않은 정점에 대해서만 해당한다. 
				if(dist[p.index] > dist[u]+ weight(vertices[u], vertices[p.index]) && !visited[p.index]){
					dist[p.index] = dist[u] + weight(vertices[u], vertices[p.index]);
					prev[p.index]=vertices[u];

				}
				
			}
			
			
			//PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
			minimum=Integer.MAX_VALUE;
			// 우선순위 큐를 이용하여 방문하지 않은 것들에대해서 거리를 모두 구해 집어넣은 다음 최소거리를 가지는 인덱스를 다음 방문 정점으로  설정 한다.
			for(int i =0;i<size;i++){
				if(!visited[i]){
					if(minimum>dist[i])
						minimum =dist[i];
						
					//pq.add(dist[i]);
				}
			}
			
			
			//최소거리를 가지는 인덱스를 다음 방문 정점으로  설정 한다.
			//u = ExtractIndexMinDist((int)pq.poll()); 
			u = ExtractIndexMinDist(minimum); 
			visited[u]=true;
			visitedCount++;
				
		//	printVisited(); //방문한  것 배열 출력
	
		}
		
		//System.out.println(this.toString()); 
		
		//출발점으로 부터 각각의 Vertex까지의 거리를 출력
		for(int i =0;i<size;i++){
			printPath(i);
			System.out.println();
		}
		
		
		

	}
	
	public void printVisited(){
		for(int i=0;i<size;i++){
			System.out.print("<"+i+" : "+ visited[i] +" >");
		}
		System.out.println();
	}
	
	/**
	 * 방문하지 않은 값들 중에 최소 거리를 가지는 것에 대한 인덱스를 가져옴
	 * @param _x 최소거리
	 * @return 최소거리에 대한 인덱스
	 */
	public int ExtractIndexMinDist(int  _x){
		for(int i=0;i<size;i++){
			if(dist[i] == _x && !visited[i]){
				return i;
			}
		}
		return -1;
	}


	public void add(String v, String w, int weight)
	{

		/*처음에 추가하는 방식*/
		
		Node first1= a[index(v)];
		if(first1==null){
			a[index(v)]=new Node(index(w),null,weight);
		}else{
			first1.next = new Node(index(w), first1.next , weight);
		}
		
		Node first2= a[index(w)];
		if(first2==null){
			a[index(w)]=new Node(index(v),null,weight);
		}else{
			first2.next=new Node(index(v), first2.next ,weight);
		}


	}

	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{");
		for (int i = 0; i < size; i++) {
			buf.append(vertices[i] + ":");
			for (Node p = a[i]; p != null; p = p.next)
				buf.append("<"+vertices[p.index]+","+p.weight+">");
			buf.append(", ");
		}
		return buf + "}";
	}


	private int index(String v){
		for(int i=0;i<size;i++)
		{
			if(vertices[i].equals(v)) return i;
		}
		return a.length;
	}

	private class Node{

		int index;
		Node next;
		int weight;

		public Node(int index, Node next ,int weight)
		{
			this.index = index;
			this.next= next;
			this.weight=weight;
		}

	}
}
