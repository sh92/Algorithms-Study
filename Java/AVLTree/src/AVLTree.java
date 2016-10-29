/**
 * AVLTree 클래스이다.
 * @author 201202160 이상희 
 * @since  2015-11-04
 * @version 1.0
 */
public class AVLTree {

	private int key, height;
	private AVLTree left, right;
	
	public static final AVLTree NIL= new AVLTree();
	
	public AVLTree(int key){
		this.key=key;
		left  = right = NIL;
		
	}
	/**
	 * AVLTree에 값을 추가하는 메서드이다.
	 * @param key 추가할 키값을 넣는다.
	 * @return 값이 추가되면 True를 반환한다.
	 */
	public boolean add(int key){
		int oldSize=size();
		grow(key);
		return size() > oldSize;
	}
	/**
	 * AVLTree에서 값이 지워지면 true를 반환한다.
	 * @param key key값과 같은 값을 지운다.
	 * @return 값이 지워지면 True를 반환한다.
	 */
	public boolean delete ( int key){
		int oldSize = size();
		decrease(key);
		return size() <  oldSize;
	}
	
	
	/**
	 * AVLTree에서 재귀적으로 실질적으로 지우는 클래스이다.
	 * @param key 지울 노드를 찾기위한 key값 
	 * @return AVLTree반환 
	 */
	private AVLTree decrease(int key) {
	
		if (this == NIL) return this; 	//닐이면 닐 반
		
		//만약 왼쪽 키값이 찾을 키 값과 같고 왼쪽의 노드가 자식을 가지지 않을 떄  
		if(this.left.key  == key && this.left.left==NIL && this.left.left==NIL){
			this.left=NIL;
		//만약 오른쪽 키값이 찾을 키값이 같고 오른 노드가 자식을 가지지 않을 때 
		}else if(this.right.key  == key && this.right.left==NIL && this.right.left==NIL){
			this.right=NIL;
		}else{
			/*찾을 키값이 왼쪽과 오른쪽과의 키값이 같지 않거나 같더라도 왼쪽ㄱ 키값이 NIL이거나 오른쪽 키값이 NIL을 반환 */
			
			
			if(this.key < key){
				//찾을 키값보다 적다면 
				//오른쪽으로 재귀!
				this.right.decrease(key);
			}else if(this.key > key){
				//찾을 키값보다 크다면 
				//왼쪽으로 재귀! 
				this.left.decrease(key);
			}else if(this.left !=NIL  && this.right !=NIL){
				//왼쪽이 NIL이 아니고 오른쪽이 NIL이 아니라면 후속자를 찾아서 올림 
				AVLTree preTree = this; 
				this.key=findInOrderSuccssor(preTree.right, "Min").key; 
				//후속자의 키값을 현재 키값으로 바꾸기 위해 오른쪽 서브트리로부터 최솟값의 키값을 알아냄!
				if(this.key==this.right.key){
				//후속자가 바로 오른쪽에 있는 경우에는 decrease를 할 수 없으므로 직접 삭제!
					this.right=NIL;
				}else{
					this.right=this.right.decrease(this.key);
					//오른쪽의 키값을 이용하여 지워서 오른쪽에 집어넣음
				}
				 
			}else{
				
				if(this.left!=NIL )
				{
					//왼쪽 키값을 현재 키값으로 올림 현재 키값을 지우는 것과 같음.
					this.key=this.left.key;
					this.left=NIL;
				}else if(this.right!=NIL){
					//오른쪽 키값을 현재키값으로 올림 현재 키값을 지우는 것곽 같음.
					this.key=this.right.key;
					this.right=NIL;
				}else{
					//위에서 처리!	그 이유는 this에 NIL을 넣을 수 없으므로!!
					this.key=-1;
					height=-1;
				}
			}
			
			
		}
		//지우고나서 리밸런스한다.
		rebalence();
		//높이는 0부터 시작하므로! 왼쪽 높이와 오른쪽 높이 중 최댓값 반환 
		height=1+ Math.max(left.height, right.height);
		return this;	
	}
	/**
	 * 현재 트리 노드에서 최솟값을 지우는 메서드이다. 
	 * @param _that 현재 트리에서 최솟값을 지우기 위해 넣을 트리이다.
	 * @return 최솟값을 찾아 리턴한다.
	 */
	private AVLTree deleteMin(AVLTree _that) {
		// TODO Auto-generated method stub
		if(_that.left==NIL)
		{
			return _that.right;
		}
		_that.left=deleteMin(_that.left);
		
		return _that;
	}
	/**
	 * 후속자를 찾는 메서드이다. AVLTree tree값을 넣어주고 MIN값을 찾을 것인지, MAX값을 찾을 것인지를 나타내면 된다.
	 * @param _this AVLTree의 트리 형식을 가지는 인자로 후속자를 찾기위한 파라미터이다.
	 * @param _findWhat 이곳에다가 MIN값을 넣을 것인지, MAX값을 넣을 것인지를 적는다.
	 * @return 후속자 노드를 입력한다.
	 */
	private AVLTree findInOrderSuccssor(AVLTree _this, String _findWhat) {
		// TODO Auto-generated method stub
		int key =_this.right.key;
		AVLTree SuccessorNode = _this;
	
		if(_findWhat.equals("Max")){
			//MAX 값을 찾을 찾기 위해 오른쪽 끝까지 감 
			while(SuccessorNode.right!=NIL)
			{
				SuccessorNode=SuccessorNode.right;
				
			}
			return SuccessorNode;
		}
		else if(_findWhat.equals("Min"))
		{
			
			//MIN 값을 찾을 찾기 위해 쪽 끝까지 감 
			while(SuccessorNode.left!=NIL)
			{
				SuccessorNode=SuccessorNode.left;
			}
			return SuccessorNode;
			
		}
		return NIL;
		
	}
	/**
	 * 해당 키에 대한 노드의 값을 추가한다.
	 * @param key 추가할 key값 
	 * @return 추가된 노드값 
	 */
	public AVLTree grow(int key){
		if(this ==NIL) return new AVLTree(key);
		if(key==this.key) return this;
		if(key < this.key) left = left.grow(key);
		else right = right.grow(key);
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
	 * AVLTree 트리 높이 -1로 초기  
	 */
	private AVLTree(){
		left = right =this;
		height = -1;
	}
	/**
	 * AVTree를 초기화 하기위한 생성자 
	 * @param key 추가할 키 값 
	 * @param left 연결되는 왼쪽 서브트리 
	 * @param right 연결되는 오른쪽 서브트리 
	 */
	private AVLTree(int key, AVLTree left, AVLTree right){
		this.key=key;
		this.left=left;
		this.right=right;
		height = 1+ Math.max(left.height, right.height);
		
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
		//현재키, 왼쪽 => 왼쪽, 오른쪽의 왼쪽 -> 오른쪽에 연결  ==> 왼쪽에 연결됨 ! 
		left = new AVLTree(key, left,right.left);
		key = right.key; //현재키는 원래 오른쪽의 키값이 됨! 
		right = right.right; //오른쪽에는 오론쪽의 오른쪽으로 연결! 
	}
	/**
	 * 오른쪽으로 회전 
	 */
	private void rotateRight(){
		//현재키, 왼쪽의 오른쪽 -> 왼쪽 , 오른쪽 -> 오른쪽에 연결
		right = new AVLTree(key,left.right,right); 
		key = left.key; //현재키는 원래 쪽의 키값이 됨! 
		left =left.left; //왼쪽에는 왼쪽의 왼쪽값이 연결되어있다. 
	}
	
	/**
	 * 깊이를 이용하여 재귀적으로 트리를 프린트 하기
	 * @param depth 깊이 
	 */
	public void printTree(int depth){
		if(this!=NIL)
		{
			
			left.printTree(depth+1);
			for(int i =0;i<depth;i++){
				System.out.print("       ");
			}
			System.out.printf("[ %d ]\n",this.key);
			
			right.printTree(depth+1);
			
		}
	}
	
}

