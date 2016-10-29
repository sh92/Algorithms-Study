

import java.awt.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;

import javax.xml.soap.Node;

public class Graph {

	private int size; //크기
	private String[] vertices; //정점
	private Node []adjencyList; //인접리스트
	private int visitedCount; //방문한 노드 개수
	private int[] indegree; //각 정점의 indegree 값
	private int[] grades; //각 정점의 학년
	private int[] gradeCount; //학년별 과목개수
	private int presentGrade; //현재 학년 임시로 사용할 변수
	Stack<Integer> stack; //스택


	/**
	 * 다음은 file을 스트림으로 받아와서 Graph를 형성한다.
	 * @throws IOException
	 */
	public  Graph() throws IOException
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
					adjencyList = new Node[size];
					vertices =new String[size];
					gradeCount = new int[4];

					grades = new int[size];
					indegree = new int[size];
					for(int i=0;i<4;i++){
						gradeCount[i]=0;
					}
					for(int i =0;i<size;i++){
						grades[i]=0;
						indegree[i]=0;
					}
					visitedCount=0;
					presentGrade=1;
					stack=new Stack<Integer>();
				}else{



				}
				break;

			case StreamTokenizer.TT_WORD:
				if(token.lineno() <size+2 && token.lineno() >1){
					int num = token.lineno()-2;
					vertices[num]=token.sval;
					token.nextToken();
					int grade = (int)token.nval;
					grades[num]=grade;


					gradeCountInitialization(grade);

				}else{
					String _from = token.sval;
					token.nextToken();
					String _to = token.sval;
					add(_from,_to);
				}
				break;
			}
		}
	}


	
	/**
	 *  topologicalSorting 함수이다.
	 */
	public void topologicalSort(){

		boolean isNotAllVisited= visitedCount!=size;
		while(isNotAllVisited){
			indegree0pushStack();
			popAndPrint();
			isNotAllVisited= visitedCount!=size;
		}
		
		if(isNotAllVisited){
			System.out.println("이수체계도 실패!");
		}
	}

	
	

	/**
	 * 다음은 학년별과목 개수를 세기 위한 함수이다.
	 * @param grade 학년
	 */
	private void gradeCountInitialization(int grade) {
		switch (grade) {
		case 1:
			gradeCount[0]++;
			break;
		case 2:
			gradeCount[1]++;
			break;
		case 3:
			gradeCount[2]++;
			break;
		case 4:
			gradeCount[3]++;
			break;
		default:
			break;
		}
	}





	/**
	 * 다음은 indegree가 0인 것을 스택이 집어 넣는 함수이다.
	 */
	private void indegree0pushStack() {
		
		for(int i =0;i<size;i++){
			if(indegree[i]==0){
				/* grade 적용 시작 */
				if(presentGrade==grades[i]){
					gradeCount[presentGrade-1]--;
				/* grade 적용  끝 */
					
					
					stack.push(i);
					indegree[i]--;
					
					
					//System.out.println(vertices[i]+" 삽입");

				/* grade 적용 시작 */
				}
				/* grade 적용  끝 */
			}
		}
		
		
		/* grade 적용 시작 */
		boolean isPresentGradeCountisZero = gradeCount[presentGrade-1]==0;
		if(isPresentGradeCountisZero){
			//System.out.println(presentGrade+" 1상승");
			presentGrade++;
		}
		/* grade 적용  끝 */

	}




	/**
	 * 다음은 stack으로 부터 indegree0인 것을 빼서 출력한다.
	 */
	private void popAndPrint() {


		while(!stack.isEmpty()){
			int x = stack.pop();
			System.out.print(vertices[x]);
			for(Node p=adjencyList[x]; p!=null; p=p.next){
				indegree[p.index]--;
				//System.out.print("#"+vertices[p.index] +" 갑소"+"in:"+indegree[p.index] +" ");
			}
			visitedCount++;
			boolean isNotAllvisited=visitedCount!=size;
			
			if(isNotAllvisited){
				System.out.print(" -> ");
			}
		}
	}





	/**
	 * 방향그래프를 구현하기 위해 인접리스트를 구현한다.
	 * @param _from 시작점
	 * @param _to 도착점
	 */
	public void add(String _from, String _to)
	{


		/*처음에 추가하는 방식*/

		Node temp= adjencyList[index(_from)];
		if(temp==null){
			adjencyList[index(_from)]=new Node(index(_to),null);
			indegree[index(_to)]++;
		}else{
			temp.next = new Node(index(_to), temp.next );
			indegree[index(_to)]++;
		}




	}

	/**
	 * 다음은 해당 과목의 이름과 학년 그리고 indegree값을 나타내어 반환한다.
	 * @return 다음은 해당 과목의 이름과 학년 그리고 indegree값을 나타내어 반환한다.
	 */
	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{\n");
		for (int i = 0; i < size; i++) {
			buf.append("in:"+indegree[i]+" "+grades[i]+"학년 "+"과목: "+vertices[i] + ":");
			for (Node p = adjencyList[i]; p != null; p = p.next)
				buf.append("<"+vertices[p.index]+">");
			buf.append("\n");
		}
		return buf + "}";
	}




	/**
	 * 다음은 정점의 인덱스를 알려준다.
	 * @param _vertex vertex 스트링 값
	 * @return vertex의 인덱스 값
	 */
	private int index(String _vertex){
		for(int i=0;i<size;i++)
		{
			if(vertices[i].equals(_vertex)) return i;
		}
		return adjencyList.length;
	}

	/**
	 * 인접리스트를  구현하기 위한 노드
	 * @author SH
	 */
	private class Node{

		int index;
		Node next;

		public Node(int _index, Node _next)
		{
			this.index = _index;
			this.next= _next;
	
		}

	}

}


