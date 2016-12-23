
public class AVLNode {
	public static final AVLNode NIL = new AVLNode();
	String key;
	int count;
	AVLNode right;
	AVLNode left;
	int height;
	
	
	AVLNode(){
		this.right=NIL;
		this.left=NIL;
		this.count=0;
		this.height=-1;
	}
	AVLNode(String _key){
		this.key=_key;
		this.right=NIL;
		this.left=NIL;
		this.count=1;
		this.height=0;
	}
	AVLNode(String _key,AVLNode _left,AVLNode _right, int _count )
	{
		this.key=_key;
		this.left=_left;
		this.right =_right;
		this.count=_count;
		this.height = 1+Math.max(_left.height, _right.height);
	}
	
}
