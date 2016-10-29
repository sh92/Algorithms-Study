

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

	private int size; //ũ��
	private String[] vertices; //����
	private Node []adjencyList; //��������Ʈ
	private int visitedCount; //�湮�� ��� ����
	private int[] indegree; //�� ������ indegree ��
	private int[] grades; //�� ������ �г�
	private int[] gradeCount; //�г⺰ ���񰳼�
	private int presentGrade; //���� �г� �ӽ÷� ����� ����
	Stack<Integer> stack; //����


	/**
	 * ������ file�� ��Ʈ������ �޾ƿͼ� Graph�� �����Ѵ�.
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
	 *  topologicalSorting �Լ��̴�.
	 */
	public void topologicalSort(){

		boolean isNotAllVisited= visitedCount!=size;
		while(isNotAllVisited){
			indegree0pushStack();
			popAndPrint();
			isNotAllVisited= visitedCount!=size;
		}
		
		if(isNotAllVisited){
			System.out.println("�̼�ü�赵 ����!");
		}
	}

	
	

	/**
	 * ������ �г⺰���� ������ ���� ���� �Լ��̴�.
	 * @param grade �г�
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
	 * ������ indegree�� 0�� ���� ������ ���� �ִ� �Լ��̴�.
	 */
	private void indegree0pushStack() {
		
		for(int i =0;i<size;i++){
			if(indegree[i]==0){
				/* grade ���� ���� */
				if(presentGrade==grades[i]){
					gradeCount[presentGrade-1]--;
				/* grade ����  �� */
					
					
					stack.push(i);
					indegree[i]--;
					
					
					//System.out.println(vertices[i]+" ����");

				/* grade ���� ���� */
				}
				/* grade ����  �� */
			}
		}
		
		
		/* grade ���� ���� */
		boolean isPresentGradeCountisZero = gradeCount[presentGrade-1]==0;
		if(isPresentGradeCountisZero){
			//System.out.println(presentGrade+" 1���");
			presentGrade++;
		}
		/* grade ����  �� */

	}




	/**
	 * ������ stack���� ���� indegree0�� ���� ���� ����Ѵ�.
	 */
	private void popAndPrint() {


		while(!stack.isEmpty()){
			int x = stack.pop();
			System.out.print(vertices[x]);
			for(Node p=adjencyList[x]; p!=null; p=p.next){
				indegree[p.index]--;
				//System.out.print("#"+vertices[p.index] +" ����"+"in:"+indegree[p.index] +" ");
			}
			visitedCount++;
			boolean isNotAllvisited=visitedCount!=size;
			
			if(isNotAllvisited){
				System.out.print(" -> ");
			}
		}
	}





	/**
	 * ����׷����� �����ϱ� ���� ��������Ʈ�� �����Ѵ�.
	 * @param _from ������
	 * @param _to ������
	 */
	public void add(String _from, String _to)
	{


		/*ó���� �߰��ϴ� ���*/

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
	 * ������ �ش� ������ �̸��� �г� �׸��� indegree���� ��Ÿ���� ��ȯ�Ѵ�.
	 * @return ������ �ش� ������ �̸��� �г� �׸��� indegree���� ��Ÿ���� ��ȯ�Ѵ�.
	 */
	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{\n");
		for (int i = 0; i < size; i++) {
			buf.append("in:"+indegree[i]+" "+grades[i]+"�г� "+"����: "+vertices[i] + ":");
			for (Node p = adjencyList[i]; p != null; p = p.next)
				buf.append("<"+vertices[p.index]+">");
			buf.append("\n");
		}
		return buf + "}";
	}




	/**
	 * ������ ������ �ε����� �˷��ش�.
	 * @param _vertex vertex ��Ʈ�� ��
	 * @return vertex�� �ε��� ��
	 */
	private int index(String _vertex){
		for(int i=0;i<size;i++)
		{
			if(vertices[i].equals(_vertex)) return i;
		}
		return adjencyList.length;
	}

	/**
	 * ��������Ʈ��  �����ϱ� ���� ���
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


