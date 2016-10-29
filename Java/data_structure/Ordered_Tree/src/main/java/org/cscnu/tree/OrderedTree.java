package org.cscnu.tree;

import java.util.*;
import java.lang.IllegalStateException;
/**
 * 순서가 있는 Tree 구현
 * @author 이상희
 * @version 1.0
 * @since 2015-05-27
 */
public class OrderedTree {

		private Object root;
		private List subtrees;
		private int size;

		/**
		 * OrederedTree 생성자
		 */
		public OrderedTree(){
		}

		/**
		 * OrederedTree 생성자 (개수 1개짜리 root만 가지는 tree)
		 * @param root 현재 트리에서 root자리에 데이터를 가짐
		 */
		public OrderedTree(Object root){
				this.root = root;
				subtrees = new LinkedList();
				size =1;
		}

		/**
		 * OrederedTree 생성자
		 * @param root 현재 트리에서 root자리에 데이터를 가짐
		 * @param trees trees를 List로 받아 iterator로 접근하여 OrderedTree의 종류이면 현재의 객체의 subtrees로 추가한다.
		 */
		public OrderedTree(Object root, List trees){
				this(root);
				for(Iterator it = trees.iterator(); it.hasNext();){
						Object object = it.next();
						if(object instanceof OrderedTree){
								OrderedTree tree = (OrderedTree) object;
								subtrees.add(tree);
								size +=tree.size();
						}
				}
		}

		/**
		 * OrderedTree를 preOrder방식의 순서대로  depth만큼 탭하여 출력 
		 * @param tree 파라미터로 받은 경우 이 부분이 각 트리의  루트 부분의 주소값
		 * @param depth 각각 받은 tree의 깊이 
		 */
		public static void printTree(OrderedTree tree, int depth){

				for(int i =0; i<depth; i++){
						System.out.print("\t");
				}
				if(tree == null){
						throw new IllegalStateException("printTree에서 tree가 null입니다.");
				}else{

						System.out.println(tree.root);

						for(Iterator it = tree.subtrees.iterator(); it.hasNext();){
								OrderedTree temp=(OrderedTree) it.next();
								printTree(temp, depth+1);
						}
				}

		}
		/**
		 * OrderedTree를 postOrder방식의 순서대로  출력 
		 * @param tree 파라미터로 받은 경우 이 부분이 각 트리의  루트 부분의 주소값
		 */
		public static void postOrder(OrderedTree tree){

				if(tree == null){
						throw new IllegalStateException("postOrder에서  Tree가 null입니다.");
				}else{
						for(Iterator it = tree.subtrees.iterator() ; it.hasNext();){
								OrderedTree temp = (OrderedTree) it.next();
								postOrder(temp);
						}	

						System.out.print(" -> " + tree.root );
				}
		}
		/**
		 * OrderedTree를 preOrder방식의 순서대로  출력
		 * @param tree 파라미터로 받은 경우 이 부분이 각 트리의  루트 부분의 주소값
		 */
		public static void preOrder(OrderedTree tree){
				if(tree == null){
						throw new IllegalStateException("preOrder에서 Tree가 null입니다.");
				}else{
						System.out.print( " -> " + tree.root);
						for(Iterator it = tree.subtrees.iterator() ; it.hasNext();){
								OrderedTree temp = (OrderedTree) it.next();
								preOrder(temp);
						}
				}
		}
		/**
		 * OrderedTree를 levelOrder방식의 순서대로  출력
		 * @param tree 파라미터로 받은 경우 이 부분이 각 트리의  루트 부분의 주소값
		 */
		public static void levelOrder(OrderedTree tree){
				if(tree == null){
						throw new IllegalStateException("levelOrder에서 tree가 null입니다.");
				}else{
						Queue queue = new LinkedList();	
						queue.add(tree);

						while(!queue.isEmpty()){

								OrderedTree x=(OrderedTree)queue.remove();

								System.out.print( " -> " + x.root);

								Iterator it = x.subtrees.iterator();	
								while(it.hasNext()){
										OrderedTree temp = (OrderedTree) it.next();
										queue.add(temp);
								}

						}
				}

		}	
		/**
		 * OrderedTree의 크기를 반환하는 함수
		 * @return 크기를 반환
		 */
		public int size(){
				return size;
		}

}
