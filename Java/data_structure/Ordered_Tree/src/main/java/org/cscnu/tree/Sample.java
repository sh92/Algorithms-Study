package org.cscnu.tree;
import java.util.*;
/**
 * OrderedTree를 실행하는 Sample page
 * @author 이상희
 * @version 1.0
 * @since 2015-05-27
 */
public class Sample{
		public static void main(String[] args){
				OrderedTree treeA , treeB, treeD;
				OrderedTree treeC = new OrderedTree("C");
				OrderedTree treeE   = new OrderedTree("E");
				OrderedTree treeF = new OrderedTree("F");
				OrderedTree treeG = new OrderedTree("G");

				List subtreesOfB = new LinkedList();
				subtreesOfB.add(treeE);
				subtreesOfB.add(treeF);
				treeB = new OrderedTree("B", subtreesOfB);

				List subtreesOfD = new LinkedList();
				subtreesOfD.add(treeG);
				treeD = new OrderedTree("D", subtreesOfD);

				List subtreesOfA = new LinkedList();
				subtreesOfA.add(treeB);
				subtreesOfA.add(treeC);
				subtreesOfA.add(treeD);
				treeA = new OrderedTree("A", subtreesOfA);


				try{
						System.out.println("%%%% %%%% Tree %%%% %%%%");
						OrderedTree.printTree(treeA, 0);
						System.out.println(" ");
						System.out.println("%%%% Level Order %%%%");
						System.out.print("@Start@");
						OrderedTree.levelOrder(treeA);
						System.out.println("-> @End@");
						System.out.println(" ");
						System.out.println("%%%% Pre Order %%%%");
						System.out.print("@Start@");
						OrderedTree.preOrder(treeA);
						System.out.println("-> @End@");
						System.out.println(" ");
						System.out.println("%%%% Post Order %%%%");
						System.out.print("@Start@");
						OrderedTree.postOrder(treeA);
						System.out.println("-> @End@");
						System.out.println(" ");
				}catch(Exception e){
						System.out.println(e.getMessage());
				}
		}

}
