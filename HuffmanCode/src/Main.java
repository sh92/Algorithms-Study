import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Main class이다. 
 * @author 이상희 
 *
 */
public class Main {
	private HuffmanTree huffman ;
	private AlphabetFrequencyTable aphabetFrequencyTable;
	private PriorityQueue priorityQueue; 
	
	public static void main(String[] args) {
		new Main("book.txt");
	}
	
	public Main(String file){
		aphabetFrequencyTable = new AlphabetFrequencyTable();
		 priorityQueue = new PriorityQueue();
		 StringBuffer deletedTokenString =new StringBuffer();

		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			while(line != null){
			StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!\"");
				while(parser.hasMoreTokens()){
					String word = parser.nextToken().toUpperCase();
					for(int i =0; i<word.length();i++)
					{
						aphabetFrequencyTable.add(word.charAt(i));
						deletedTokenString.append(word.charAt(i));
					}
					
					
				}
				line = in.readLine();
			}
			in.close();
			printHuffman(deletedTokenString);
			
		}catch(IOException e){
			System.out.println(e);
		}
			
		

	}
	/**
	 * 메인 메서드에서 출력을 하기 위한 메서드 
	 * @param deletedTokenString 토큰별로 잘라내어서 합친 문자열 값 
	 */
	private void printHuffman(StringBuffer deletedTokenString) {
		//	System.out.println(aphabetFrequencyTable.toString());
			priorityQueue.addTable(aphabetFrequencyTable);
		//	System.out.println(priorityQueue.toString());
			huffman = new HuffmanTree(priorityQueue);
			//System.out.println(priorityQueue.toString());
			
			System.out.println("허프만 트리의 데이터 \n[알파벳:인코딩:빈도수]");
			huffman.printTree();
			
			//System.out.println(priorityQueue.remove().count);
			
			System.out.println("\n토큰만 지운 데이터 ");
			System.out.println(deletedTokenString.toString());
			
			StringBuffer encodedStringData = new StringBuffer();
			StringBuffer encodedStringData2 = new StringBuffer();
			for(int i =0;i<deletedTokenString.length();i++){
				encodedStringData.append(huffman.encodeFromTree(deletedTokenString.charAt(i)));
				encodedStringData2.append(huffman.encodeFromTree(deletedTokenString.charAt(i))+"|");
				//System.out.print(huffman.encodeFromTree(deletedTokenString.charAt(i))+" | ");
			}
			System.out.println("\n인코딩 데이터");
			System.out.println(encodedStringData.toString());
			System.out.println("\n인코딩 글자를 | 로 구분 ");
			System.out.println(encodedStringData2.toString());
			System.out.println("\n인코딩으로 부터 디코딩된 데이터 ");
			System.out.println(huffman.decodeFromTree(encodedStringData.toString()));
	}

}
