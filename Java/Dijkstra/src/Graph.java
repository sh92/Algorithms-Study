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
	 * �ε����� �̿��Ͽ� �Ÿ��� ����Ѵ�.
	 * @param _index �ε����� �̿��Ͽ� ��������κ����� �Ÿ��� �������� ����Ѵ�.
	 */
	public void printPath(int _index ){
		if(dist[_index]==0){
			System.out.print(vertices[_index] +" : �Ÿ� "+dist[_index]+ " /  ");
			System.out.print("�����");
		}else{
			System.out.print(vertices[_index] +" : �Ÿ� "+dist[_index]+ " /  ");
			printRecursively(_index);
		}
	
		
	}
	/**
	 * �ε����� �̿��Ͽ� �Ÿ��� ��������� ����Ѵ�.
	 * @param _index �ε����� prev �迭�� �̿��Ͽ� ��θ� ����Ѵ�.
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
	 * x�� y�� �Ÿ��� ��ȯ�ϴ� �Լ�
	 * @param x ��������Ʈ ������
	 * @param y ��������Ʈ x�� ���� ����� ���� �� y�� ���� �Ÿ��� ��ȯ�ϱ� ����
	 * @return x�� y������ �Ÿ�
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
	 * ���ͽ�Ʈ�� - �ִ� ��� �˰��� 
	 * @param _firstVertex ù��° �Ķ���ʹ� 
	 */
	public void dijkstra(String _firstVertex){ 
		
		int firstIndex = index(_firstVertex); 
		int u=firstIndex; //ù��° �ε����� �湮�ε����� ����

		
		dist[firstIndex]=0; //ù��° �湮�� �Ÿ� 0 ���� 
		visited[firstIndex]=true; 
		visitedCount++;
		
		while(visitedCount!=size){  //Ż������ :  ��� �湮
			
			for(Node p =a[u];p!=null;p=p.next){ 
				//�湮�� �ε����� �������� ���Ḯ��Ʈ�� ����� ����Ʈ�鿡 ����� ������ �ε����� ������  ����� �Ÿ��� �湮�Ѱͱ����� �Ÿ�+�湮�� ������ ������ �Ÿ��� ���Ͽ� �� ���ٸ� �Ÿ��� �����Ѱ� ���� ���� ���� �ִ´�. ��, �湮����  ���� ������ ���ؼ��� �ش��Ѵ�. 
				if(dist[p.index] > dist[u]+ weight(vertices[u], vertices[p.index]) && !visited[p.index]){
					dist[p.index] = dist[u] + weight(vertices[u], vertices[p.index]);
					prev[p.index]=vertices[u];

				}
				
			}
			
			
			//PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
			minimum=Integer.MAX_VALUE;
			// �켱���� ť�� �̿��Ͽ� �湮���� ���� �͵鿡���ؼ� �Ÿ��� ��� ���� ������� ���� �ּҰŸ��� ������ �ε����� ���� �湮 ��������  ���� �Ѵ�.
			for(int i =0;i<size;i++){
				if(!visited[i]){
					if(minimum>dist[i])
						minimum =dist[i];
						
					//pq.add(dist[i]);
				}
			}
			
			
			//�ּҰŸ��� ������ �ε����� ���� �湮 ��������  ���� �Ѵ�.
			//u = ExtractIndexMinDist((int)pq.poll()); 
			u = ExtractIndexMinDist(minimum); 
			visited[u]=true;
			visitedCount++;
				
		//	printVisited(); //�湮��  �� �迭 ���
	
		}
		
		//System.out.println(this.toString()); 
		
		//��������� ���� ������ Vertex������ �Ÿ��� ���
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
	 * �湮���� ���� ���� �߿� �ּ� �Ÿ��� ������ �Ϳ� ���� �ε����� ������
	 * @param _x �ּҰŸ�
	 * @return �ּҰŸ��� ���� �ε���
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

		/*ó���� �߰��ϴ� ���*/
		
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
