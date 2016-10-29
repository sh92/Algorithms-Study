package org.cscnu.bst;
/**
* Binary Search Tree 실행하는 페이지
* @author 이상희
* @version 1.0
* @since 2015-06-05
*/
public class SampleBST {
	public static void main(String[] args){
		BST<String , Integer> st = new BST<String, Integer>();
		for(int i =0; !StdIn.isEmpty(); i++){
			String key =StdIn.readString();
			st.put(key,i);
		}
		
		StdOut.println("@@@@@ @@@@@ Level Order @@@@@ @@@@@");
		for(String s : st.levelOrder()){
			StdOut.println(s + " " + st.get(s));
		}

		StdOut.println();
		StdOut.println("@@@@@ @@@@@ Pre Order @@@@@ @@@@@");
		for(String s : st.preOrder()){
			StdOut.println(s + " " + st.get(s));
		}
		StdOut.println();
		StdOut.println("@@@@@ @@@@@ Post Order @@@@@ @@@@@");
		for(String s : st.postOrder()){
			StdOut.println(s + " " + st.get(s));
		}

		StdOut.println();
		StdOut.println("@@@@@ @@@@@ Keys @@@@@ @@@@@");
		for(String s : st.keys()){
			StdOut.println(s + " " + st.get(s));
		}
		

	}
}

