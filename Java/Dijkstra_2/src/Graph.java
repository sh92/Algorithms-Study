import java.io.*;

public class Graph {

	private int size;
	private String[] vertexString;
	private Node []a;
	private boolean[] visited;
	private int[][] dist;
	private int visitedCount;
	private int[] count;
	private PriorityQueue Q;

	Graph(String[] input_vertex, String[] input) throws IOException
	{

		size=input_vertex.length;
		visitedCount=0;
		Q= new HeapPriorityQueue(size);
		a = new Node[size];
		vertexString = input_vertex;
		visited =new boolean[size];
		dist = new int[size][size];
		count = new int[size];
		for(int i =0;i<size;i++){
			count[i]=0;
			for(int j=0;j<size;j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i =0;i<input.length;i++){
			String source = input[i].substring(0,1);
			String destination =input[i].substring(1,2);
			Integer distance = Integer.valueOf(input[i].substring(2));
			saveWeight(source, destination, distance.intValue());
		}

	}

	public void dijkstra(String _firstVertex) {

		int firstIndex = index(_firstVertex);
		int u = firstIndex; //첫번째 인덱스를 방문인덱스로 설정
		int u_dist;
		Node u_node;
		Node d[] = new Node[size];
		for(int i=0;i<size;i++){
			d[i] = new Node(i,null,Integer.MAX_VALUE);
		}

		//첫번째 방문점 거리 0 설정
		dist[u][count[u]] = 0;
		d[u].setDist(0);

		for(int i=0;i<size;i++){
			Q.insert(d[i]);
		}

		while (!Q.empty()) {
			u_node = Q.extract_min();
			u = u_node.getIndex();
			if(visited[u])
				continue;
			u_dist = u_node.getDist();
			visited[u] = true;
			visitedCount++;
			if(visitedCount<5) {
				for (int i = 0; i < size; i++) {
					dist[i][visitedCount] = dist[i][visitedCount - 1];
				}
			}

			System.out.println("_________________________________________________________");
			System.out.println();
			System.out.println("S["+u+"] : d["+vertexString[u]+"] = "+dist[u][count[u]]);
			System.out.println("---------------------------------------------------------");

			int i =0;
			PriorityQueue backup= new HeapPriorityQueue();
			while(!Q.empty()){
				Node vNode=Q.extract_min();
				int v = vNode.getIndex();
				int v_dist = vNode.getDist();
				System.out.print("Q["+i+"] : d["+vertexString[v]+"] = " + v_dist);
				if(weight(u,v)==-1) {
					i++;
					backup.insert(vNode);
					System.out.println();
					continue;
				}

				if (v_dist > u_dist + weight(u, v)) {
					count[v] = visitedCount;
					dist[v][count[v]] = u_dist + weight(u, v);
					System.out.print(" -> d[" + vertexString[v] + "] = " + dist[v][count[v]]);
					d[v] = new Node(v, null, dist[v][count[v]]);
					backup.insert(d[v]);
				}else{
					backup.insert(vNode);
				}
				i++;
				System.out.println();
			}
			Q=backup;
		}

		showTables();

	}

	private void showTables() {
		System.out.println();
		System.out.println();
		System.out.println("========================[표]===========================");
		System.out.println();

		for(int i =0;i<size;i++)
			System.out.printf("%10s ",vertexString[i]);
		System.out.println();
		for(int i=0;i<size;i++){
			for (int j =0;j<size;j++){
				System.out.printf("%10d ",dist[j][i]);
			}
			System.out.println("");
		}
	}

	public void saveWeight(String v, String w, int weight) {
		/*처음에 추가하는 방식*/
		Node vNode = a[index(v)];
		if (vNode == null) {
			a[index(v)] = new Node(index(w), null, weight);
//			System.out.printf("(v,w):(%s,%s)\n", v, w);
		} else {
			vNode.setNext(new Node(index(w), vNode.getNext(), weight));
//			System.out.printf("(v,w):(%s,%s)\n", v, w);
		}
	}
	public int weight(int i ,int j){
		Node p = a[i];
		while(p !=null){
			if(p.getIndex()==j){
				return p.getDist();
			}
			p=p.getNext();
		}
		return -1;
	}


	private int index(String v){
		for(int i=0;i<size;i++)
		{
			if(vertexString[i].equals(v)) return i;
		}
		return -1;
	}

}
