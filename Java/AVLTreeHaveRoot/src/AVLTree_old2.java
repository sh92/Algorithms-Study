
public class AVLTree_old2 {


	private static AVLNode root;
	public  final static AVLNode NIL = AVLNode.NIL;
	private int distinctWordCount;


	int size;

	AVLTree_old2(){
		root =NIL;
		distinctWordCount=0;
	}

	public boolean add(String _key){
		int oldSize=size();
		if( root ==NIL)
		{
			System.out.println("addRoot");
			root=new AVLNode(_key);
			
		}else{
			grow(_key,root);
		}

		return size()>oldSize;
	}

	private AVLNode grow(String _key,AVLNode _that){ 
		if(_that==NIL)
			return new AVLNode(_key);
		if(_that.key!=null){
			boolean PresentKeyisLessor= ((_that.key).compareTo(_key) <0);
			boolean PresentKeyisMore = ((_that.key).compareTo(_key) > 0);

			if((_that.key).equals(_key))
			{
				_that.count++;
				System.out.println("equal");
			}else if(_that.left==NIL && PresentKeyisMore){
				//현재키가 더 크고 왼쪽이 비었다
				_that.left=new AVLNode(_key);
				distinctWordCount++;
				System.out.println("leftMore");
			}else if(_that.right==NIL && PresentKeyisLessor)
			{
				_that.right=new AVLNode(_key);
				distinctWordCount++;	
				System.out.println("righhtMore");
			}else{
				if(PresentKeyisLessor)
				{
					System.out.println("right!");
					_that.right=grow(_key,_that.right);
				}else{
					System.out.println("left!");
					_that.left=grow(_key,_that.left);
				}
			}
			rebalence(_that);
			_that.height=1+ Math.max(_that.left.height, _that.right.height);
			System.out.println("####"+_that.height+"####");
		}
		return _that;

	}

	private void rebalence(AVLNode _that){
		
		if(_that.right.height > _that.left.height+1){
			//오른쪽이 왼쪽보다 높이가 1보다 더 크게 차이가 나는데, 
			//더 큰 오른쪽에서 왼쪽의 높이가 오른쪽의 높이보다 더 크다면, 오른쪽노드 기준으로 오른쪽으로 회전!
			if(_that.right.left.height > _that.right.right.height)
				rotateRight(_that.right); // 복합회전 
			//왼쪽 회전 
			rotateLeft(_that);
		}
		else if(_that.left.height > _that.right.height+1){
			//왼쪽이 오른쪽 높이보다 1보다 더 크게 차이가 나는데,
			//더 큰  왼쪽에서 오른쪽의 높이가 왼쪽보다 높이보다 더 크다면, 왼쪽노드를 기준으로 왼쪽으로 회전 !
			if(_that.left.right.height > _that.left.left.height)
				rotateLeft(_that.left); // 복합회전 
			rotateRight(_that);
			//오른쪽 회전 
		}
	}

	/**
	 * 왼쪽으로 회전 
	 */
	private void rotateLeft(AVLNode _that){
		//현재키, 왼쪽 => 왼쪽, 오른쪽의 왼쪽 -> 오른쪽에 연결  ==> 왼쪽에 연결됨 ! 
		_that.left = new AVLNode(_that.key, _that.left,_that.right.left,_that.count);
		_that.key = _that.right.key; //현재키는 원래 오른쪽의 키값이 됨! 
		_that.count= _that.right.count;
		_that.right = _that.right.right; //오른쪽에는 오론쪽의 오른쪽으로 연결! 
	}
	/**
	 * 오른쪽으로 회전 
	 */
	private void rotateRight(AVLNode _that){
		//현재키, 왼쪽의 오른쪽 -> 왼쪽 , 오른쪽 -> 오른쪽에 연결
		if(_that.key!=null)
		{
			_that.right = new AVLNode(_that.key, _that.left, _that.right.right,_that.count); 
			_that.key = _that.left.key; //현재키는 원래 쪽의 키값이 됨! 
			_that.count=_that.left.count;
			_that.left = _that.left.left; //왼쪽에는 왼쪽의 왼쪽값이 연결되어있다. 
		}
	}
	public int size()
	{
		return size;
	}
	public void printTree()
	{
		printTreeRecursively(0,root);
	}
	private void printTreeRecursively(int depth,AVLNode _temp){
		if(_temp!=null)
		{
			printTreeRecursively(depth+1 ,_temp.left);
			System.out.printf("[ %s : %d ]\n",_temp.key ,_temp.count);
			printTreeRecursively(depth+1,_temp.right);	
		}
	}


}

