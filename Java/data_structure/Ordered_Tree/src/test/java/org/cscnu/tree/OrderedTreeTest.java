package org.cscnu.tree;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;
/**
 * OrderedTree테스터
 * @author 이상희
 * @version 1.0
 * @since 2015-5-27
 */
public class OrderedTreeTest{
		/**
		 * OrderedTree에 대한 Test의 내용 
		 */
		@Test
				public void testOrderedTreee(){

						System.out.println("@@@@@@@ OrederedTreeTest를 시작합니다@@@@@@@@@@");

						try{
								OrderedTree tree2,tree1;
								OrderedTree  tree3= new OrderedTree("3");
								OrderedTree  tree4= new OrderedTree("4");

								List listof2  =  new LinkedList();
								listof2.add(tree4);
								tree2= new OrderedTree("2", listof2);

								List listof1  =  new LinkedList();
								listof1.add(tree2);
								listof1.add(tree3);
								tree1= new OrderedTree("1", listof1);



								System.out.println("%%%% %%%% Tree %%%% %%%%");
								OrderedTree.printTree(tree1, 0);
								System.out.println(" ");
//								OrderedTree.printTree(null, 0);
								System.out.println("%%%% Level Order %%%%");
								System.out.print("@Start@");
								OrderedTree.levelOrder(tree1);
								System.out.println("-> @End@");
//								OrderedTree.levelOrder(null);
								System.out.println(" ");
								System.out.println("%%%% Pre Order %%%%");
								System.out.print("@Start@");
								OrderedTree.preOrder(tree1);
								System.out.println("-> @End@");
								OrderedTree.preOrder(null);
								System.out.println(" ");
								System.out.println("%%%% Post Order %%%%");
								System.out.print("@Start@");
								OrderedTree.postOrder(tree1);
								System.out.println("-> @End@");

								System.out.println("null을 넣을 경우 Test");
								OrderedTree.postOrder(null);
								System.out.println(" ");



						}catch(Exception e){
							System.out.println(e.getMessage());
						}

				}
}
