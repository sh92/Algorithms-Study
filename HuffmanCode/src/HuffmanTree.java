import java.util.Stack;
/**
 * 허프만 트리를 구성하 클래스이다. 
 * @author 이상희 
 *
 */
public class HuffmanTree {

	Alpha root;
	private int size;
	private int height;
	private PriorityQueue priorityQueue;

	public HuffmanTree() {
		root = null;
		size = 0;
		height = 0;
	}

	/**
	 * 허프만 트리의 생성자 
	 * @param _priorityQueue
	 */
	public HuffmanTree(PriorityQueue _priorityQueue) {
		priorityQueue = _priorityQueue;
		
		if (!priorityQueue.isEmpty()) {

			for (int i = 1; priorityQueue.getUsedHeapSize() > 1; i++) {
				
				Alpha newNode = new Alpha();
				newNode.left = priorityQueue.remove();
				// 우선순위큐 queue에서 우선 순위가 높은 원소 삭제해서 리턴
				newNode.right = priorityQueue.remove();
				//System.out.println(newNode);
				newNode.count = newNode.left.count + newNode.right.count;
				priorityQueue.add(newNode); // 우선순위큐 queue에 새로 생성된 트리 newNode 를 삽입
			//	System.out.println(priorityQueue.toString());
			}
			root = priorityQueue.remove();
		}
	
	}
	
	/**
	 * 인코딩하는 메서드 
	 * @param _findAlphabet 주어진 문자 
	 * @return 주어진 문자를 인코딩해서 리턴함 
	 */
	public String encodeFromTree(char _findAlphabet){
		StringBuffer buf = new StringBuffer();
		Stack stack = new Stack();
		findedEnCodingToString(_findAlphabet,root,stack);
		while(!stack.isEmpty())
		{
			buf.append(stack.pop());
		}
		return buf.toString(); 
	}

	/**
	 * 인코딩된 스트링을 찾음 
	 * @param _findAlphabet 인코딩할 문자 값 
	 * @param _findVal 찾을 노드 값 
	 * @param _reusltStack 인코딩된 값을 저장할 스택 
	 * @return
	 */
	private boolean findedEnCodingToString(char _findAlphabet, Alpha _findVal , Stack _reusltStack) {
		if(_findVal.alpha==_findAlphabet){
			return true;
		}else{
			boolean leftReult=false,rightResult=false;
			if( _findVal.left !=null){
				
				leftReult = findedEnCodingToString( _findAlphabet,  _findVal.left ,  _reusltStack);
				if(leftReult){
					_reusltStack.push("0");
					return true;
				}
			}
			if( _findVal.right !=null){
				
				rightResult = findedEnCodingToString( _findAlphabet,  _findVal.right ,  _reusltStack);
				if(rightResult){
					_reusltStack.push("1");
					return true;
				}
			}
			
			return  false;
		}
	}
	

	/**
	 * 출력하기 위한 메서드 
	 */
	public void printTree(){
		printTreeRecursively(0,root);
	}
	
	/**
	 * 디코딩을 하기 위한 메서드 
	 * @param _encoded 인코딩된 값 
	 * @return 디코딩된 값 
	 */
	public String decodeFromTree(String _encoded){
		StringBuffer buf = new StringBuffer();
		
		int start=0;
		int end=1;
		while(end<_encoded.length()+1)
		{
			
			if(findedDeCodingToChar(_encoded.substring(start, end),root,buf)){
				start=end;
			}
			end++;
		}
			
		return buf.toString(); 
	}
	/**
	 * 인코딩된 문자를 노드를 찾아 디코딩된 결과를 만들어줌 
	 * @param _encoded 인코딩된 문자열 
	 * @param _findVal 찾을 문자에 대한 노드 
	 * @param _reusltBuffer 결과를 저장하는 버퍼 
	 * @return 인코딩된 값을 찾지 못하면 false를 리턴 찾으면 true 리턴 
	 */
	private boolean findedDeCodingToChar(String _encoded, Alpha _findVal, StringBuffer _reusltBuffer) {
		// TODO Auto-generated method stub
		if(encodeFromTree(_findVal.alpha).equals(_encoded)){
			_reusltBuffer.append(_findVal.alpha);
			return true;
		}else{
			boolean leftReult=false,rightResult=false;
			if( _findVal.left !=null){
				
				leftReult = findedDeCodingToChar( _encoded,  _findVal.left,_reusltBuffer);
				if(leftReult){
					return true;
				}
			}
			if( _findVal.right !=null){
				
				rightResult = findedDeCodingToChar( _encoded,  _findVal.right ,  _reusltBuffer);
				if(rightResult){
					
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 깊이를 이용하여 재귀적으로 트리를 프린트 하기
	 * @param depth 깊이 
	 */
	public void printTreeRecursively(int depth,Alpha _this){
		if(_this!=null)
		{
			printTreeRecursively(depth+1,_this.left);
			for(int i =0;i<depth;i++){
				//System.out.print("       ");
			}
			if(_this.alpha!='\0')
				System.out.printf("[%s:%s:%d]\n",_this.alpha,encodeFromTree(_this.alpha), _this.count);
			
			printTreeRecursively(depth+1,_this.right);
			
		}
	}

}
