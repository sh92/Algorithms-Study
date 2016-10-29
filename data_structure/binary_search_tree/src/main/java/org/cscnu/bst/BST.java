package org.cscnu.bst;
import java.util.NoSuchElementException;

/**
* Binary Search Tree
* @author 이상희
* @version 1.0
* @since 2015-06-05
*/
public class BST<Key extends Comparable<Key>, Value> {
	private Node root;


	/**
	* key와 value를 가지는 내부 Node class
	*/
	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private int N;
		
		/** Node 생성자 **/
		public Node(Key key, Value val, int N){
			this.key=key;
			this.val = val;
			this.N = N;
		}

	}

	/**
	* 비었으면 TRUE 
	* @return 비었으면 TRUE
	*/
	public boolean isEmpty(){
		return size() == 0;
	}
	

	/**
	*	root의 size를 반환
	*  @return size
	*/
	public int size(){
		return size(root);
	}

	/**
	*	Node의 size를 반환
	* @return Node 의 size
	* @param x  Node
	*/
	public int size(Node x){
		if(x == null){
			return 0;
		}else{
			return x.N;
		}
	}
	
	/**
	* Key를 포함하고 있으면 TRUE
	* @return Key를 포함하고 있으면 TRUE
	* @param key key가 포함되었는지 확인
	*/
	public boolean contains(Key key){
		return get(key) !=null;
	}



	/**
	* key에대한 값을 반환
	* @return key에대한 값을 반환
	* @param  key value를 얻기위한 key
	*/
	public Value get(Key key){
		return get(root, key);
	}

	/**
	* Node 와 Key를 받아 해당노드의 key에대한 value를 반환
	* @param x  Node value를 얻기위한 노드
	* @param key value를 얻기위한 key
	*/
	private Value get(Node x , Key key){
		if(x ==null){
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp <0){
			return get(x.left, key);
		}else if(cmp >0){
			return get(x.right, key);
		}else{
			return x.val;
		}

	}

	/**
	* 해당 key와 value를 노드에 집어넣음
	* @param key 집어넣을 key
	* @param val 집어넣을 val
	*/
	public void put(Key key, Value val){
		if(val == null){
			delete(key);
			return;
		}
		root = put(root, key, val);
		assert check();
	}
	
	/**
	* 해당 Node의 Key와 value를 받아 key값을 비교하여 순서대로  적절한 위치에 집아넣는다.
	*  @param key key를 이용해 비교하여 위치르 찾음
	* @param val 해당 위치를 찾은 곳에 value를 집어넣음
	* @return Node  node를 집어넣음
	*/
	private Node put(Node x, Key key, Value val){
		if(x ==null){
			return new Node(key, val, 1);
		}
		int cmp = key.compareTo(x.key);
		if( cmp < 0 ){
			x.left = put(x.left, key, val);
		}else if(cmp  > 0 ){
			x.right = put(x.right , key ,val);
		}else{
			x.val= val;
		}
		x.N = 1+size(x.left)+size(x.right);
		return x;
	}
	

	/**
	* 최솟값을 지움(root를 생성자의 파라미터로 다시 넘기고 assert로 check()함수를 이용하여 잘못된 경우 출력한다)
	*/
	public void deleteMin(){ 
		if(isEmpty()){
			throw new NoSuchElementException("Symbol table underflow");
		}
		root = deleteMin(root);
		assert check();
	}
	
	/**
	* 해당 Node의 최솟값을 지움
	* @param x 최솟값을 지울 노드
	* @return  최솟값이 지워진 전체 노드를 반환
	*/
	private Node deleteMin(Node x){
		if(x.left == null){
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.N = size(x.left) +size(x.right) +1;
		return x;
	}


	/**
	* 최대값을 지움(root를 생성자의 파라미터로 다시 넘기고 assert로 check()함수를 이용하여 잘못된 경우 출력한다)
	*/
	public void deleteMax(){
		if(isEmpty()){
			throw new NoSuchElementException("Sysbol table underflow");
		}
		root = deleteMax(root);
		assert check();
	}
	
	/**
	* 최댓값을 지운 노드를 반환
	* @param x 지울 Node를 파라미터로 받음
	* @return  최댓값이 지워진 전체노드
	*/
	private Node deleteMax(Node x){
		if(x.right==null){
			return x.left;
		}
		x.right = deleteMax(x.right);
		x.N  = size(x.left)+size(x.right) +1;
		return x;
	}

	/**
	* 해당 key의 Node를 지움
	* @param key 해당 key의 노드를 지움
	*/
	public void delete(Key key){
		root =delete(root,key);
		assert check();
	}
	
	/**
	* 해당 Node 의 key를 지움
	*  @param key 지울 노드를 찾을 key
	* @retrun 최종적으로 지워진 노드를 반환
	*/
	private Node delete(Node x, Key key){
		if( x == null){
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp < 0) {
			x.left =delete(x.left, key);
		}else if( cmp > 0){
			x.right = delete(x.right, key);
		}else{
				if(x.left ==null){
					return x.right;
				}
				Node t = x;
				x=min(t.right);  // 오른쪽의 후속자를 지워질 노드에 연결
				x.right = deleteMin(t.right); 
				x.left = t.left;

		}
			x.N = size(x.left) + size(x.right) +1;
			return x;
	}
	
	/**
	* 최솟값반환
	* @return 최솟값의 key를 반환
	*/
	public Key min(){
		if(isEmpty()){
			return null;
		}
		return min(root).key;
	}
	
	/**
	* 최솟값반환
	* @param x 최솟값을 반환할 Node
	* @return Node 최솟값을 반환할 노드
	*/
	private Node min(Node x){
		if(x.left ==null){
			return x;
		}else{ 
			return min(x.left);
		}
	}
	

	/**
	* 최댓값의 key를 반환함
	* @return 최댓을 반한활 노드의 key
	*/
	public Key max(){
		if(isEmpty()){
			return null;
		}
		return max(root).key;
	}
	
	/**
	* 최댓값을 반환 
	* @param  x 최댓값을 반환할 노드
	@ @return 최댓값을 반환할 노드
	*/
	private Node max(Node x){
		if(x.right == null){
			return x;
		}else{
			return max(x.right);
		}
	}
	

	/**
	* 주어진 key의 floor값을 반환(즉 주어진 key가 root보다 작다면 왼쪽 서브트리 더크다면 오른쪽 서브트리 하지만 같다면 root의 key)
	* @return 주어진 key의 floor값을 반환(즉 주어진 key가 root보다 작다면 왼쪽 서브트리 더크다면 오른쪽 서브트리 하지만 같다면 root의 key)
	* @param key floor를 적용시킬key
	*/
	public Key floor(Key key){
		Node x =floor(root, key);
		if(x ==null){
			return null;
		}else{
			return x.key;
		}
	}

	/**
	* 주어진 key의 floor값을 반환(즉 주어진 key가 root보다 작다면 왼쪽 서브트리 더크다면 오른쪽 서브트리 하지만 같다면 root의 key)
	* @return 주어진 key의 floor값을 반환(즉 주어진 key가 root보다 작다면 왼쪽 서브트리 더크다면 오른쪽 서브트리 하지만 같다면 root의 key)
	* @param key floor를 적용시킬key
	* @param x floor를 적용시킬 Node
	*/
	private Node floor(Node x, Key key){
		if(x ==null){
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp ==0 )
			return x;
		if(cmp <0)
			return floor(x.left,key);
		Node t = floor(x.right , key);
		if(t !=null)
			return t;
		else
			return x;



	}
	/**
	* 주어진 key의 ceil값을 반환(즉 주어진 key가 root보다 작다면 오른쪽 서브트리 더크다면 왼쪽 서브트리 하지만 같다면 root의 key)
	* @return 주어진 key의 ceil값을 반환(즉 주어진 key가 root보다 작다면 오른쪽 서브트리 더크다면 왼쪽 서브트리 하지만 같다면 root의 key)
	* @param key ceiling을 적용시킬key
	*/
	private Key ceiling(Key key){
		Node x = ceiling(root, key);
		if(x==null)
			return null;
		else
			return x.key;
	}

	/**
	* 주어진 key의 ceil값을 반환(즉 주어진 key가 root보다 작다면 오른쪽 서브트리 더크다면 왼쪽 서브트리 하지만 같다면 root의 key)
	* @return 주어진 key의 ceil값을 반환(즉 주어진 key가 root보다 작다면 오른쪽 서브트리 더크다면 왼쪽 서브트리 하지만 같다면 root의 key)
	* @param key ceiling을 적용시킬key
	* @param ceiling 을 적용시킬 Node
	*/

	private Node ceiling(Node x, 	Key key){
		if( x ==null)
			return null;

		int cmp = key.compareTo(x.key);
		if( cmp==0)
			return x;

		if (cmp < 0){
			Node t = ceiling(x.left, key);
			if(t !=null)
				return t;
			else
				return x;
		}

		return ceiling(x.right, key);
	}


	/**
	* select를 하기 위한 함수
	* @param k rank를 구하기위한 key
	* @return 랭크 k의 key를반환
	*/
	public Key select(int k)	{
		if(k< 0 || k>=size()){
			return null;
		}
		Node x = select(root, k);
		return x.key;
	}

	/**
	* select를 하기 위한 함수  (즉 왼쪽 노드의 사이즈를 이용하여 rank k와 비교함으로써 rank k에대한 key를 반환)
	* @param x 노드의 x
 	* @param k rank를 구하기위한 k 
	* @return 랭크의 key를 반환
	*/
	private Node select(Node x , int k){
		if( x ==null)
			return null;
		int t = size(x.left);
		if(t>k)
			return select(x.left,k);
		else if(t <k)
			return select(x.right, k-t-1);
		else
			return x;

	}

	/**
	* rank를 반환 
	* @param key rank를 찾을 key
	*/
	public int rank(Key key){
		return rank(key,root);
	}


	/**
	* rank를 반환( rank는 만약 key값이 root와 같다면 왼쪽 subtree의 크기를 반환하고 
	* 만약 작다면 왼쪽 subtree의 rank를 반환 그리고 크다면 왼쪽subtree의 크기 root그리고 오른쪽의 rank를 합친 값을 반환)
	* @param key 를 rank를 찾을 key
	* @param x rank를 찾을 노드
	* @return rank를 반환할 key
	*/
	private int rank(Key key, Node x){
		if(x ==null)
			return 0;
		int cmp =key.compareTo(x.key);
		if(cmp <0)
			return rank(key, x.left);
		else if(cmp >0)
			return 1+size(x.left) +rank(key, x.right);
		else
			return size(x.left);

	}

	/**
	* 최솟값과 최댓값의 key쌍을 keys쌍으로 전달 
	* @return for-each 문을 돌릴 수 있는 key들을 queue형태로 반환
	*/
	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key Io, Key hi){
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, Io,hi);
		return queue;
	}

	/**
	* 현재 노드의 Io보다 크고 hi보다 작으면 queue에 집어넣고 Io보다 작으면 왼쪽트리를 hi보다 크면 오른쪽트리를 탐색
	* 즉, 재귀적으로 일어날 떄 key의 크기순대로 queue에 집어넣음 알파벳순으로
	* @param x key를 얻을 노드
	* @param queue key를 quueue에 집어넣음 
	* @param io 최솟값 key
	* @param hi 최댓값 key
	*/
	private void keys(Node x,Queue<Key> queue, Key Io, Key hi){
		if (x==null)
			return ;
		
		int cmpIo =Io.compareTo(x.key);
		int cmphi =hi.compareTo(x.key);
		if(cmpIo<0)
			keys(x.left,queue,Io,hi);

		if(cmpIo <= 0 && cmphi >=0)
			queue.enqueue(x.key);

		if(cmphi >0)
			keys(x.right, queue,Io, hi);
	}
	
	/**
	* 해당 key사이의 rank크기 차이를 이용하여 size를 구함환
	* @param Io 크기를 구하기 위한 작아야 될 키 값
	* @param hi 크기를 구하기 위해 커야할 키 값
	*/ 
	public int size(Key Io, Key hi){
		if(Io.compareTo(hi) > 0)
			return 0;
		if(contains(hi))
			return rank(hi) - rank(Io) +1;
		else
			return rank(hi) - rank(Io);
		
	}

	/**
	* root의 높이를 반환
	* @return root의 높이를 반환
	*/
	public int height(){
		return height(root);
	}

	/**
	* 받은 Node의 높이를 반환, 즉 트리의 높이
	* @return 받은 Node의 높이를 반환
	*/
	private int height(Node x){
		if(x ==null){
			return -1;
		}
		return 1+Math.max(height(x.left) , height(x.right));
	}
	
	/**
	* levelOrder를 구현
	* @return levelorder순서대로 key들을 Iterable 형태로 반환
	*/
	public Iterable<Key> levelOrder(){
		Queue<Key> keys= new Queue<Key>();
		Queue<Node> queue =  new Queue <Node>();
		queue.enqueue(root);
		while(!queue.isEmpty()){
			Node x = queue.dequeue();
			if(x ==null)
				continue;
			keys.enqueue(x.key);
			queue.enqueue(x.left);
			queue.enqueue(x.right);
		}
		return keys;
	}
	/**
	* postOrder를 구현
	* @return postOrder순서대로 key들을 Iterable 형태로 반환
	*/
	public Iterable<Key> postOrder(){
		if(root==null){
			return null;
		}
		Queue<Key> keys =new Queue<Key>();
		Queue<Node> queue = new Queue<Node>();
		postOrder(root,queue,keys);
		return keys;
	}
	/**
	* postOrder순서대로 keys에는 key들을 집언넣음 
	*/
	public void postOrder(Node x,Queue<Node> queue,Queue<Key> keys){
		if(x !=null){
			postOrder(x.left,queue ,keys);
			postOrder(x.right,queue, keys);
			queue.enqueue(x);
			keys.enqueue(x.key);
		}

	}
	/**
	* preOrder를 구현
	* @return preOrder순서대로 key들을 Iterable 형태로 반환
	*/
	public Iterable<Key> preOrder(){
		if(root==null){
			return null;
		}
		Queue<Key> keys =new Queue<Key>();
		Queue<Node> queue = new Queue<Node>();
		preOrder(root,queue,keys);
		return keys;
	}
	/**
	* proeOrder순서대로 keys에는 key들을 집언넣음 
	*/
	public void preOrder(Node x,Queue<Node> queue,Queue<Key> keys){
		if(x !=null){
			queue.enqueue(x);
			keys.enqueue(x.key);
			preOrder(x.left,queue ,keys);
			preOrder(x.right,queue, keys);
		}

	}


	/**
	* BST를 만족시키는지, size가 일관되게 잘 동작하나느지, rank를 잘동작하는지에 대해 check함,조건에 어긋나면 출력함
	* @return BST와 size가 적절한지, rank가 적절한지 판단하여 모두 적절하면 true
	*/
	private boolean check(){
		if(!isBST())
			StdOut.println("Not in symetric order");
		if(!isSizeConsistent())
			StdOut.println("Subtree counts not consistent");
		if(!isRankConsistent())
			StdOut.println("Ranks not consitent");
		return isBST() && isSizeConsistent() && isRankConsistent();

	}

	/**
	* BST가 절자한지 판단
	* @return BST이면 TURE
	*/
	private boolean isBST(){
		return isBST(root, null, null);
	}

	/**
	* 주어진 key가 적당한위치에 있으면 TRUE 재귀로 돌리면서 적당한지 찾음
	* @param x 적절한지 판단할 노드
	* @param min 판달할 최솟값
	* @param max 판단할 최대값
	* @return 적절하다면 TRUE
	*/
	private boolean isBST(Node x, Key min, Key max)	{
		if(x ==null)
			return true;
		if(min != null && x.key.compareTo(min) <= 0)
			return false;
		if(min != null && x.key.compareTo(max) >=0)
			return false;
		if(max !=null && x.key.compareTo(max) >=0)
			return false;

		return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
	}

	
	/**
	* size가 적절한지 판단
	* @return size가 적절하면 TRUE
	*/
	private boolean isSizeConsistent(){
		return isSizeConsistent(root);
	}
	
	/**
	* size가 적절한지 판단 (왼쪽 오른쪽 서브트리가 적절한지 재귀적으로 접근하면서 판단)
	* @return size가 적절하면 TRUE
	*/
	private boolean isSizeConsistent(Node x) {
		if(x ==null)
			return true;

		if(x.N != size(x.left) + size(x.right) +1){
			return false;
		}

		return isSizeConsistent(x.left) && isSizeConsistent(x.right);

	}


	/**
	* rank가 적절한지 판단
	* @return rank가 절절하면 TRUE
	*/
	private boolean isRankConsistent(){
		for( int i=0; i< size(); i++) {
			if(i != rank(select(i))) return false;
		}
		for(Key key: keys()) {
			if(key.compareTo(select(rank(key))) !=0) return false;
		}

		return true;
	}


}
