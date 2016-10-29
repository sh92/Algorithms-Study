package org.cscnu.tree;
import java.util.*;
/**
 * OrderedTree 를 실행할 SampleHW 클래스 
 * @author 이상희
 * @version 1.0
 * @since 2015-05-27
 */
public class SampleHW{
		public static void main(String[] args){
				OrderedTree tree8, tree5 , tree4, tree1 , tree6, tree10, tree16;
				OrderedTree tree9 = new OrderedTree("9");
				OrderedTree tree14= new OrderedTree("14");
				OrderedTree tree13= new OrderedTree("13");
				OrderedTree tree15= new OrderedTree("15");
				OrderedTree tree7 = new OrderedTree("7");
				OrderedTree tree11= new OrderedTree("11");
				OrderedTree tree2 = new OrderedTree("2");
				OrderedTree tree3 = new OrderedTree("3");
				OrderedTree tree12= new OrderedTree("12");

				List subtreesOf5 = new LinkedList();
				subtreesOf5.add(tree9);
				tree5 = new OrderedTree("5", subtreesOf5);

				List subtreesOf6 = new LinkedList();
				subtreesOf6.add(tree15);
				subtreesOf6.add(tree7);
				tree6 = new OrderedTree("6", subtreesOf6);


				List subtreesOf16 = new LinkedList();
				subtreesOf16.add(tree3);
				subtreesOf16.add(tree12);
				tree16 = new OrderedTree("16", subtreesOf16);

				List subtreesOf10 = new LinkedList();
				subtreesOf10.add(tree11);
				subtreesOf10.add(tree16);
				subtreesOf10.add(tree2);
				tree10 = new OrderedTree("10", subtreesOf10);

				List subtreesOf4 = new LinkedList();
				subtreesOf4.add(tree6);
				subtreesOf4.add(tree10);
				tree4 = new OrderedTree("4", subtreesOf4);



				List subtreesOf1 = new LinkedList();
				subtreesOf1.add(tree14);
				subtreesOf1.add(tree13);
				tree1 = new OrderedTree("1", subtreesOf1);


				List subtreesOf8 = new LinkedList();
				subtreesOf8.add(tree5);
				subtreesOf8.add(tree4);
				subtreesOf8.add(tree1);
				tree8 = new OrderedTree("8", subtreesOf8);


				try{
						System.out.println("%%%% %%%% Tree %%%% %%%%");
						OrderedTree.printTree(tree8, 0);
						System.out.println(" ");
						System.out.println("%%%% Level Order %%%%");
						System.out.print("@Start@");
						OrderedTree.levelOrder(tree8);
						System.out.println("-> @End@");
						System.out.println(" ");
						System.out.println("%%%% Pre Order %%%%");
						System.out.print("@Start@");
						OrderedTree.preOrder(tree8);
						System.out.println("-> @End@");
						System.out.println(" ");
						System.out.println("%%%% Post Order %%%%");
						System.out.print("@Start@");
						OrderedTree.postOrder(tree8);
						System.out.println("-> @End@");
						System.out.println(" ");

				}catch(Exception e){
						System.out.println(e.getMessage());
				}
		}

}
