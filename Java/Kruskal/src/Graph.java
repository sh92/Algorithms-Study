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
	 * 다음은 크루스칼 알고리즘이다.
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
	 * 다음은 weightedUnion으로 두집합의 합집합을 구하는 알고리즘이다. 가중치가 작은 것에 큰 것의 붑모를 연결하여 합집합을 구하는 메서드이다.
	 * @param i i는 i번쨰 배열을 말한다.
	 * @param j j는 j번쨰 배열을 말한다.
	 */
	public void weightedunion(int i , int j){
		if(find(i) < find(j)){
			parent[i]=parent[i]+parent[j];
			parent[j]=i;
		//	System.out.println(j+"의 부모는 "+i);
		}else{
			parent[j]=parent[i]+parent[j];
			parent[i]=j;
			//System.out.println(i+"의 부모는 "+j);
		}
	}
	
	
	/**
	 * 다음은 collapsingFind이다. 이것은 Find릃 할떄 _i의 부모들을 하나씩 최상위 부모로 연결하여 find의 성능을 향상시킨다.
	 * @param _i  _i의 부모들을 하나씩 최상위 부모로 연결한다
	 * @return 최상위 부모의 인덱스 find한 최종결과
	 */
	public int collapsingFind(int _i){
		int num=_i;
		int RootParent=find(_i);
		while(RootParent!=num){
			
			//System.out.println("Col#:"+num+"의 부모는 "+RootParent);
			parent[num]=RootParent;
			num=parent[num];
		}
		return RootParent;
	}
	
	
	/**
	 * i의 부모는 j로 설정한다.
	 * @param i i는 자식의 인덱스이다.
	 * @param j j는 부모의 인덱스이다.
	 */
	public void union(int i ,int j){
		parent[i]=j;	
	}
	
	
	/**
	 * i의 부모를 찾는데 i의 최종부모는 음수값을 가지게 된다.
	 * @param i의 부모는 i번제 인덱스를 말한다.
	 * @return 부모의 인덱스 값
	 */
	int find(int i){
		for(;parent[i]>=0;i=parent[i]);
		return i;
	}
	

	/**
	 * 다음은 인접리스트에 갑을 추가하는 과정이다. 그 값을 받아서 무게를 추가한다.
	 * @param v index v를 이용하는 
	 * @param w index w를 이용하는
	 * @param _weight weight는 무게를 나타낸다.
	 */
	public void add(String v, String w , int _weight) {
		int i = index(v), j = index(w);
		weight[i][j] = weight[j][i] = _weight;
	}
	


	/**
	 * kruskal 알고리즘 의 결과를 출력한다.
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
		
		System.out.println("최소비용: "+weightedSum);
		
		System.out.println("사용된 Edge:");
		while(!q.isEmpty()){
			Edge _this =q.poll();
			System.out.print(vertices[_this.i]+vertices[_this.j]);
			System.out.print(" 비용: "+_this.weight);
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
