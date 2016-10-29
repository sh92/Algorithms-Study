import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Iterator;

public class Graph {
	
	private int size;
	private String[] vertices;
	private int[][] weight;
	private int[] parent;
	private boolean[] visited;
	private int weightedSum;
	




	PriorityQueue<Edge> pq =new PriorityQueue<>();
	Queue<Edge> q =  new LinkedList();
	
	public Graph() throws IOException
	{

		FileInputStream stream = new FileInputStream("input2");
		InputStreamReader reader = new InputStreamReader(stream);
		StreamTokenizer token =new StreamTokenizer(reader);

		while(token.nextToken() !=StreamTokenizer.TT_EOF){
			switch(token.ttype){
			case StreamTokenizer.TT_NUMBER:
				if(token.lineno() ==1)
				{
					size=(int)token.nval;		
					vertices =new String[size];
					visited =new boolean[size];
					weight= new int[size][size];
					parent = new int[size];
				
					weightedSum=0;
					for(int i =0;i<size;i++){
						
						parent[i]=-1;
						for(int j=0;j<size;j++){
							if(i==j){
								weight[i][j]=0;
							}else{
								weight[i][j]=Integer.MAX_VALUE;
							}
		
						}
					
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
					Edge newEdge = new Edge(index(w1),index(w2),(int)token.nval);
					pq.add(newEdge);
				}
				break;
			}
		}
	}
	
	/**
	 * ������ ũ�罺Į �˰����̴�.
	 */
	public void kruskal(){
		
		
		int edgeCount=0;
		while(edgeCount!=size-1 && !pq.isEmpty()){
			Edge minimumEdge= pq.poll();
			q.add(minimumEdge);
			
			int i =minimumEdge.i;
			int j =minimumEdge.j;
			
			/*System.out.print("#find i:"+find(i));
			System.out.print("  #find j:"+find(j));
			System.out.println();*/
			if(find(i)!=find(j) )
			{
			//	System.out.println("#edge i:"+i +" # j:"+j);
				weightedSum+=weight[i][j];
				weightedunion(collapsingFind(i),collapsingFind(j));
				edgeCount++;
			}
			
		}
		if(edgeCount!=size-1){
			System.out.printf("No spanning tree\n");
		}
			
	}
	
	
	/**
	 * ������ weightedUnion���� �������� �������� ���ϴ� �˰����̴�. ����ġ�� ���� �Ϳ� ū ���� �ָ� �����Ͽ� �������� ���ϴ� �޼����̴�.
	 * @param i i�� i���� �迭�� ���Ѵ�.
	 * @param j j�� j���� �迭�� ���Ѵ�.
	 */
	public void weightedunion(int i , int j){
		if(find(i) < find(j)){
			parent[i]=parent[i]+parent[j];
			parent[j]=i;
		//	System.out.println(j+"�� �θ�� "+i);
		}else{
			parent[j]=parent[i]+parent[j];
			parent[i]=j;
			//System.out.println(i+"�� �θ�� "+j);
		}
	}
	
	
	/**
	 * ������ collapsingFind�̴�. �̰��� Find�f �ҋ� _i�� �θ���� �ϳ��� �ֻ��� �θ�� �����Ͽ� find�� ������ ����Ų��.
	 * @param _i  _i�� �θ���� �ϳ��� �ֻ��� �θ�� �����Ѵ�
	 * @return �ֻ��� �θ��� �ε��� find�� �������
	 */
	public int collapsingFind(int _i){
		int num=_i;
		int RootParent=find(_i);
		while(RootParent!=num){
			
			//System.out.println("Col#:"+num+"�� �θ�� "+RootParent);
			parent[num]=RootParent;
			num=parent[num];
		}
		return RootParent;
	}
	
	
	/**
	 * i�� �θ�� j�� �����Ѵ�.
	 * @param i i�� �ڽ��� �ε����̴�.
	 * @param j j�� �θ��� �ε����̴�.
	 */
	public void union(int i ,int j){
		parent[i]=j;	
	}
	
	
	/**
	 * i�� �θ� ã�µ� i�� �����θ�� �������� ������ �ȴ�.
	 * @param i�� �θ�� i���� �ε����� ���Ѵ�.
	 * @return �θ��� �ε��� ��
	 */
	int find(int i){
		for(;parent[i]>=0;i=parent[i]);
		return i;
	}
	

	/**
	 * ������ ��������Ʈ�� ���� �߰��ϴ� �����̴�. �� ���� �޾Ƽ� ���Ը� �߰��Ѵ�.
	 * @param v index v�� �̿��ϴ� 
	 * @param w index w�� �̿��ϴ�
	 * @param _weight weight�� ���Ը� ��Ÿ����.
	 */
	public void add(String v, String w , int _weight) {
		int i = index(v), j = index(w);
		weight[i][j] = weight[j][i] = _weight;
	}
	


	/**
	 * kruskal �˰��� �� ����� ����Ѵ�.
	 */
	public String toString() {
		if (size == 0)
			return "";
		
		StringBuffer buf = new StringBuffer("{" + vertex(0));
		/*for (int i = 1; i < size; i++)
			buf.append("," + vertex(i));*/
		
		/*for(int k=0; k<size; k++){
			for(int t=0;t<size;t++){
				System.out.printf("%12d",weight[k][t] );
			}
			System.out.println();
		}*/
		
		System.out.println("�ּҺ��: "+weightedSum);
		
		System.out.println("���� Edge:");
		while(!q.isEmpty()){
			Edge _this =q.poll();
			System.out.print(vertices[_this.i]+vertices[_this.j]);
			System.out.print(" ���: "+_this.weight);
			System.out.println();
		}
		
		/*for(int i=0;i<size;i++){
			System.out.print("["+i+"]"+parent[i]);
		}
			System.out.println();*/
		
		
		
		//return buf + "}";
		return "";
		
	}
	
	
	

	private int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return weight.length;
	}


	private String vertex(int i) {
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for (int j = 0; j < size; j++)
			if (weight[i][j] !=Integer.MAX_VALUE)
				buf.append(vertices[j]);
		return buf + "";
	}
}
