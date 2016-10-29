
public class SingleLinkedList {

	Node _front;
	
	private int disticntWordCount;
	private static int numberOfOperation;
	private static int numberOfADDOperation;
	
	public SingleLinkedList() {
		// TODO Auto-generated constructor stub
		_front=null;
		disticntWordCount=0;
	}
	public boolean add(String _key){
		
		
		Node tempNode = _front;
		if(tempNode==null)
		{
			_front = new Node(_key);
			disticntWordCount++;
			numberOfADDOperation++;
			return true;
		}else{
			
			while(true){
				
				if(_key.equals(tempNode.key))
				{
				
					tempNode.count++;
					return true;
				}
				if(tempNode.right==null)
				{
				
					tempNode.right=new Node(_key);
					disticntWordCount++;
					return true;
				}
				numberOfADDOperation++;
				tempNode=tempNode.right;
			}
			
		}

		
	}
	public void printList(){
		Node temp = _front;
		System.out.println("["+_front.key+":"+ _front.count+"]");
		temp=temp.right;
		while(temp!=null)
		{
			
			System.out.println("["+temp.key+":"+ temp.count+"]");
			temp=temp.right;
		}
	}
	public int getDisticntWordCount()
	{
		return this.disticntWordCount;
	}
	
	public int SearchKey(String _key){
		Node tempNode = _front;
		numberOfOperation=0;
		if(tempNode==null)
		{
			return 0;
		}else{
			
			while(true){
				
				if(_key.equals(tempNode.key))
				{
					numberOfOperation++;
					return tempNode.count;
				}
				if(tempNode.right==null)
				{
					break;
				}
				numberOfOperation++;
				tempNode=tempNode.right;
			}
			
			return 0;
		}
	}
	public int getNumberOfOperation(){
		return numberOfOperation;
	}
	public int getNumberOfOADDperation(){
		return numberOfADDOperation;
	}
}
