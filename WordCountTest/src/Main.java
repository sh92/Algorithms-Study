import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public Main(String file){
 
		boolean isFirstAVL=true;
		
		AVLTree avltree = null;
		SingleLinkedList slist = new SingleLinkedList();
		BinarySearchTree bst =new BinarySearchTree();
		DoubleHahsingHashTable dbh = new DoubleHahsingHashTable(1000, 0.8F);
		long start,end, elapsed;
		double TimeSumOfSLL=0.000,TimeSumOfBST=0.000, TimeSumOfDBH=0.000, TimeSumOfAVL=0.000;
		int lineNumber = 0;
		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			start = System.nanoTime();
			while(line != null){
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
				while(parser.hasMoreTokens()){
					
					String word = parser.nextToken().toUpperCase();
					
					start = System.nanoTime();
					slist.add(word);
					end = System.nanoTime();
					TimeSumOfSLL+=(double)(end-start);
					
					
					start = System.nanoTime();
					bst.add(word);
					end = System.nanoTime();
					TimeSumOfBST+=(double)(end-start);
					
					start = System.nanoTime();
					if(isFirstAVL){
						avltree =new AVLTree(word);
						isFirstAVL=false;
					}else{
						avltree.add(word);
					}
					end = System.nanoTime();
					TimeSumOfAVL+=(double)(end-start);

					
					start = System.nanoTime();
					dbh.put(word);
					end = System.nanoTime();
					TimeSumOfDBH+=(double)(end-start);
					
		
				}
				System.out.println(lineNumber + ":\t"+line);
				line = in.readLine();
			}
			in.close();
		}catch(IOException e){System.out.println(e);}
		System.out.println("싱글링크드리스트 삽입 걸린시간: "+TimeSumOfSLL/(double)(1000000));
		System.out.println("바이너리서치트리  삽입 걸린시간: "+TimeSumOfBST/(double)(1000000));
		System.out.println("AVLTree 삽입 걸린시간: "+TimeSumOfAVL/(double)(1000000));
		System.out.println("이중해싱 삽입 걸린시간: "+TimeSumOfDBH/(double)(1000000));
		
		System.out.println("lines: " + lineNumber);
		
		System.out.println("###############[싱글링크드 리스트 ]####################");
		start = System.nanoTime();
		slist.printList();
		end  = System.nanoTime();
		
		System.out.println("distinct words: " + slist.getDisticntWordCount());
		System.out.println("전체 출력 걸린시간: "+(end-start)/(double)(1000000));
		start = System.nanoTime();
		System.out.println("WHEREVER 단어 서치 count: " +slist.SearchKey("WHEREVER"));
		end  = System.nanoTime();
		System.out.println("WHEREVER 단어 서치 걸린시간: "+(end-start)/(double)(1000000));
		System.out.println("WHEREVER 단어 서치 걸린 Operation : "+slist.getNumberOfOperation());
		
		System.out.println("###############[바이너리 서치트리]####################");
		System.out.println();
		start = System.nanoTime();
		bst.printTree();
		end = System.nanoTime();
		System.out.println("전체 출력 걸린시간 :"+(end-start)/(double)(1000000));
		System.out.println("높이: "+ bst.getHeight());
		System.out.println("distinct words: " + bst.getDisticntWordCount());
		start = System.nanoTime();
		System.out.println("WHEREVER 단어 서치 count: " +bst.SearchKey("WHEREVER"));
		end  = System.nanoTime();
		System.out.println("WHEREVER 단어 서치 걸린시간: "+(end-start)/(double)(1000000));
		System.out.println("WHEREVER 단어 서치 걸린 Operation : "+bst.getNumberOfOperation());
		

		System.out.println("###############[AVLTree]####################");
		start =System.nanoTime();
		avltree.printTree();
		end = System.nanoTime();
		System.out.println("전체 출력 걸린시간 : "+(end-start)/(double)(1000000));
		System.out.println("높이: "+ avltree.getHeight());
		System.out.println("distinct words: " + avltree.getDisticntWordCount());
		
		start = System.nanoTime();
		System.out.println("WHEREVER 단어 서치 count: " +avltree.SearchKey("WHEREVER"));
		end  = System.nanoTime();
		System.out.println("WHEREVER 단어 서치 걸린시간: "+(end-start)/(double)(1000000));
		System.out.println("WHEREVER 단어 서치 걸린 Operation : "+avltree.getNumberOfOperation());
		
		System.out.println("###############[Double Hashing Hash Table]####################");
		start =System.nanoTime();
		dbh.printHashTable();
		end = System.nanoTime();
		System.out.println("전체 출력 걸린시간: "+ (end-start)/(double)(1000000));
		System.out.println("distinct words: " + dbh.getDisticntWordCount());
		
		
		start = System.nanoTime();
		System.out.println("WHEREVER 단어 서치 count: " +dbh.get("WHEREVER"));
		end  = System.nanoTime();
		System.out.println("WHEREVER 단어 서치 걸린시간: "+(end-start)/(double)(1000000));
		System.out.println("WHEREVER 단어 서치 걸린 Operation : "+dbh.getNumberOfOperation());
		
	
		System.out.println("ADD성능 비교 ");
		System.out.println("SingleLinkedList ADD걸린 Operation:"+slist.getNumberOfOADDperation());
		System.out.println("Binary Search Tree ADD걸린 Operation:"+bst.getNumberOfADDOperation());
		System.out.println("AVL Tree ADD걸린 Operation:"+avltree.getNumberOfADDOperation());
		System.out.println("Double Hashing HashTable ADD걸린 Operation:"+dbh.getNumberOfADDOperation());
	}
	
	public static void main(String[] args){
		new Main("example.txt");
	}
}
