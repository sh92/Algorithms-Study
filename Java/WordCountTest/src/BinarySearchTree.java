
public class BinarySearchTree {

	Node root;
	private int distinctWordCount;
	private int height;
	private static int numberOfOperation;
	private static int numberOfADDOperation;
	
	
	 BinarySearchTree(){
		root=null;
		distinctWordCount=0;
		height=0;
	 }

	 public boolean add(String _key){

		 boolean isAdded=false;
		 if(root==null)
		 {
			 root=new Node(_key);
			 distinctWordCount++;
			 numberOfADDOperation++;
		 }
		 else{
			 isAdded=addRecursively(_key,root);
		 }
		 
		
		 return isAdded;
	 }
	 
	 

	private boolean addRecursively(String _key, Node _temp) {
		// TODO Auto-generated method stub
		boolean PresentKeyisLessor= ((_temp.key).compareTo(_key) <0);
		boolean PresentKeyisMore = ((_temp.key).compareTo(_key) > 0);
		if(_temp.left==null && PresentKeyisMore){
			//현재키가 더 크고 왼쪽이 비었다
			_temp.left=new Node(_key);
			distinctWordCount++;
			numberOfADDOperation++;
			return true;
		}else if(_temp.right==null && PresentKeyisLessor)
		{
			_temp.right=new Node(_key);
			distinctWordCount++;
			numberOfADDOperation++;
			return true;
			
		}else if((_temp.key).equals(_key))
		{
			numberOfADDOperation++;
			_temp.count++;
			return true;
		}else{

			if(PresentKeyisLessor)
			{
				numberOfADDOperation++;
				addRecursively(_key,_temp.right);
			}else{
				numberOfADDOperation++;
				addRecursively(_key,_temp.left);
			}
		}
		return false;
	}
	
	

	public void printTree()
	{
		printTreeRecursively(0,root);
	}
	private void printTreeRecursively(int depth,Node _temp){
		if(_temp!=null)
		{
			
			printTreeRecursively(depth+1 ,_temp.left);
			
			System.out.printf("[ %s : %d ]\n",_temp.key ,_temp.count);
			
			printTreeRecursively(depth+1,_temp.right);
			
		}
	}

	public int getDisticntWordCount() {
		// TODO Auto-generated method stub
		return this.distinctWordCount;
	}
	public int getHeight(){
		if(root==null)
			return -1;
		else
			return getHeightRecursively(root);
	}
	private int getHeightRecursively(Node _temp) {
		// TODO Auto-generated method stub
		if(_temp.right==null && _temp.left==null)
			return 0;
		else if(_temp.right==null)
			return 1+getHeightRecursively(_temp.left);
		else if(_temp.left==null)
			return 1+getHeightRecursively(_temp.right);
		else
			return 1+Math.max(getHeightRecursively(_temp.left), getHeightRecursively(_temp.right));
			
	}
	public int SearchKey(String _key)
	{
		numberOfOperation=0;
		return searchRecursively(_key,root);
	}

	private int searchRecursively(String _key, Node _temp) {
		// TODO Auto-generated method stub
		if(_temp==null)
			return 0;
		if(_temp.key.equals(_key))
		{
			numberOfOperation++;
			return _temp.count;
			
		}else if(_temp.key.compareTo(_key)<0){
			numberOfOperation++;
			return searchRecursively(_key, _temp.right);
		}else{
			numberOfOperation++;
			return searchRecursively(_key, _temp.left);
		}
	}
	public int getNumberOfOperation(){
		return numberOfOperation;
	}
	public int getNumberOfADDOperation(){
		return numberOfADDOperation;
	}
}
