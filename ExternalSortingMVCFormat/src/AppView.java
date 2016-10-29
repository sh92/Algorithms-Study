


public class AppView {
		
	/**
	 * AppView 생성자 
	 */
	public AppView()
	{
	
	}
	
	/**
	 * 결과를 출력 
	 * @param resultArray 결과를 출력하기 위한 배열 
	 */
	public void printResult(int[] resultArray) {
		System.out.println("External Sorting된 결과는 다음과 같습니다.");
		
		for(int i =0;i<resultArray.length;i++){
			System.out.printf("[ %2d ]",resultArray[i]);
			if(((i+1)%10) ==0)
				System.out.println("");
		}
		
	}



	/**
	 * Entry를 출력하는 메서드 
	 * @param entry 엔트리 배열 
	 */
	public void printEntryTree(Entry[] entry) {
		System.out.print("[");
		for(int i =0;i<entry.length;i++){
			if(i>=(entry.length-1)/2)
				System.out.print("/leaf/");
			System.out.printf("(%d , %d)", entry[i].value,entry[i].prevIndex);

		}
		System.out.println("]");
	}
}
