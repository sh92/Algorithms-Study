
public class Node {

	String key;
	int count;
	Node right;
	Node left;
	
	Node(){
		this.right=null;
		this.left=null;
		count=0;
	}
	Node(String _key){
		this.key=_key;
		this.right=null;
		this.left=null;
		this.count=1;
	}
	Node(String _key,int _count,Node _left,Node _right )
	{
		this.key=_key;
		this.count=_count;
		this.left=_left;
		this.right =_right;
	}
}
