/**
 * AVLTree 클래스이다.
 * @author 201202160 이상희 
 * @since  2015-11-04
 * @version 1.0
 */
public class AVLTree {

	private int height, count;
	private String key;
	private AVLTree left, right;
	private static int distinctWordCount;
	private static int numberOfOperation;
	private static int numberOfADDOperation;
	
	
	public static final AVLTree NIL= new AVLTree();
	
	
	/**
	 * AVLTree 트리 높이 -1로 초기  
	 */
	private AVLTree(){
		left = right =NIL;
		height = -1;
	}
	/**
	 * AVLTree초기
	 * @param key key!
	 */
	public AVLTree(String _key){
		key=_key;
		left  = right = NIL;
		count=1;
		distinctWordCount++;
	}
	/**
	 * AVTree를 초기화 하기위한 생성자 
	 * @param key 추가할 키 값 
	 * @param left 연결되는 왼쪽 서브트리 
	 * @param right 연결되는 오른쪽 서브트리 
	 */
	private AVLTree(String _key, AVLTree _left, AVLTree _right, int _count){
		key=_key;
		left=_left;
		right=_right;
		count=_count;
		height = 1+ Math.max(left.height, right.height);
		
	}
	/**
	 * AVLTree에 값을 추가하는 메서드이다.
	 * @param key 추가할 키값을 넣는다.
	 * @return 값이 추가되면 True를 반환한다.
	 */
	public boolean add(String key){
		int oldSize=size();
		grow(key);
		return size() > oldSize;
	}

	/**
	 * 해당 키에 대한 노드의 값을 추가한다.
	 * @param key 추가할 key값 
	 * @return 
	 * @return 추가된 노드값 
	 */
	public AVLTree grow(String key){
		if(this ==NIL || this.key==null)
		{
			numberOfADDOperation++;
			//System.out.println(this.key);
			return new AVLTree(key);
		}else if(key.equals(this.key)) 
		{
			numberOfADDOperation++;
			//System.out.println("equal");
			this.count++;
		}
		else if(key.compareTo(this.key) <0 )
		{
			numberOfADDOperation++;
			//System.out.println("left");
			left = left.grow(key);
		}
		else
		{
			numberOfADDOperation++;
			//System.out.println("right");
			right = right.grow(key);
		}
		rebalence();
		height=1+ Math.max(left.height, right.height);
		return this;
		
	}
	
	/**
	 * 해당 트리에 대한 사이
	 * @return 왼쪽 길이와 오른쪽 길이에 대하여 +1 한다 
	 */
	public int size()
	{
		if(this == NIL) return 0;
		return 1+left.size()+ right.size();
	}
	
	/**
	 * 감소하는 방식으로 출력하는 방식 
	 */
	public String toString()
	{
		if(this == NIL) return "";
		return right +" " + key + " "+ left;
	
	}
	

	
	/**
	 * 모든 서브트리에 대해 오른쪽 높이와 왼쪽 높이의 차가 1이하가 되도록하기 위한 것, 즉 Balence factor가 1이하로 줄이기 위함 
	 */
	private void rebalence(){
		if(right.height > left.height+1){
			//오른쪽이 왼쪽보다 높이가 1보다 더 크게 차이가 나는데, 
			//더 큰 오른쪽에서 왼쪽의 높이가 오른쪽의 높이보다 더 크다면, 오른쪽노드 기준으로 오른쪽으로 회전!
			if(right.left.height > right.right.height)
				right.rotateRight(); // 복합회전 
			//왼쪽 회전 
			rotateLeft();
		}
		else if(left.height > right.height+1){
			//왼쪽이 오른쪽 높이보다 1보다 더 크게 차이가 나는데,
			//더 큰  왼쪽에서 오른쪽의 높이가 왼쪽보다 높이보다 더 크다면, 왼쪽노드를 기준으로 왼쪽으로 회전 !
			if(left.right.height > left.left.height)
				left.rotateLeft(); // 복합회전 
			rotateRight();
			//오른쪽 회전 
		}
	}
	
	/**
	 * 왼쪽으로 회전 
	 */
	private void rotateLeft(){
		numberOfOperation++;
		//현재키, 왼쪽 => 왼쪽, 오른쪽의 왼쪽 -> 오른쪽에 연결  ==> 왼쪽에 연결됨 ! 
		left = new AVLTree(key, left,right.left, count);
		key = right.key; //현재키는 원래 오른쪽의 키값이 됨! 
		count= right.count;
		right = right.right; //오른쪽에는 오론쪽의 오른쪽으로 연결! 
	}
	/**
	 * 오른쪽으로 회전 
	 */
	private void rotateRight(){
		numberOfOperation++;
		//현재키, 왼쪽의 오른쪽 -> 왼쪽 , 오른쪽 -> 오른쪽에 연결
		right = new AVLTree(key,left.right,right,count); 
		key = left.key; //현재키는 원래 쪽의 키값이 됨! 
		count = left.count;
		left =left.left; //왼쪽에는 왼쪽의 왼쪽값이 연결되어있다. 
	}
	
	public void printTree(){
		printTree(0);
	}
	/**
	 * 깊이를 이용하여 재귀적으로 트리를 프린트 하기
	 * @param depth 깊이 
	 */
	public void printTree(int depth){
		if(this!=NIL)
		{
			
			left.printTree(depth+1);
			
			System.out.printf("[ %s  : %d ] \n",this.key, this.count);
			
			right.printTree(depth+1);
			
		}
	}
	public int getHeight()
	{
		return height;
	}
	public int getDisticntWordCount() {
		// TODO Auto-generated method stub
		return distinctWordCount;
	}
	public int SearchKey(String _key) {
		// TODO Auto-generated method stub
		numberOfOperation=0;
		return searchRecursively(_key);
	}
	
	private int searchRecursively(String _key) {
		// TODO Auto-generated method stub
		if(this==NIL)
			return 0;
		if(this.key.equals(_key))
		{
			numberOfOperation++;
			return this.count;
		}else if(this.key.compareTo(_key)<0){
			numberOfOperation++;
			return right.searchRecursively(_key);
		}else{
			numberOfOperation++;
			return left.searchRecursively(_key);
		}
	}
	public int getNumberOfOperation()
	{
		return numberOfOperation;
	}
	public int getNumberOfADDOperation()
	{
		return numberOfADDOperation;
	}
}

