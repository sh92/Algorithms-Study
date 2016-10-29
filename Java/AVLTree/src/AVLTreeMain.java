
public class AVLTreeMain {

	public static void main(String[] args) {
		System.out.println("추가 순서 : 3 -> 5 -> 1 -> 8 -> 6 -> 2 -> 11 -> 4 -> 10 -> 9 -> 7");
		System.out.println("삭제 순서 : 3 -> 5 -> 1 -> 8 -> 6");
		
		AVLTree tree = new AVLTree(3);
		System.out.println("######################################################################");
		System.out.println("[3추가 후] 감소 순:"+tree.toString()); 
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
				

		tree.add(5);
		System.out.println("######################################################################");
		System.out.println("[5추가 후] 감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
				
		tree.add(1);
		System.out.println("######################################################################");
		System.out.println("[1추가 후] 감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		tree.add(8);
		System.out.println("######################################################################");
		System.out.println("[8추가 후]  감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		tree.add(6);
		System.out.println("######################################################################");
		System.out.println("[6추가 후] 감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		tree.add(2);
		System.out.println("######################################################################");
		System.out.println("[2추가 후] 감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		tree.add(11);
		System.out.println("######################################################################");
		System.out.println("[11추가 후]  감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		tree.add(4);
		System.out.println("######################################################################");		
		System.out.println("[4추가 후]  감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		tree.add(10);
		System.out.println("######################################################################");
		System.out.println("[10추가 후]  감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		tree.add(9);
		System.out.println("######################################################################");
		System.out.println("[9추가 후]  감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		tree.add(7);
		System.out.println("######################################################################");
		System.out.println("[7추가 후] 감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		
		tree.delete(3);
		System.out.println("######################################################################");
		System.out.println("[3삭제 후]  감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		tree.delete(5);
		System.out.println("######################################################################");
		System.out.println("[5삭제 후]  감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		tree.delete(1);
		System.out.println("######################################################################");
		System.out.println("[1삭제 후]  감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		tree.delete(8);
		System.out.println("######################################################################");
		System.out.println("[8삭제 후]  감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		tree.delete(6);
		System.out.println("######################################################################");
		System.out.println("[6삭제 후]  감소 순:"+tree.toString());
		System.out.println("######################################################################");
		tree.printTree(0);
		System.out.println();
		
		
	}
}
