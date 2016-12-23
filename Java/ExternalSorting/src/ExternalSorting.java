
public class ExternalSorting {

	public static void main(String[] args) {
		int inputArray[][] = {{1,9,11,19,21,31,41,51,61,71},
				{7,17,27,37,47,50,57,60,67,77},
				{2,12,22,29,32,39,42,52,62,72},
				{4,14,24,34,44,54,64,69,74,79},
				{8,18,28,38,48,58,68,70,78,80},
				{5,10,15,20,25,35,45,55,65,75},
				{3,13,23,33,43,49,53,59,63,73},
				{6,16,26,30,36,40,46,56,66,76}};

		int collumnMaximum=inputArray[0].length; //10 열 
		int rowMaximum = inputArray.length; //8 행 
		int size= inputArray.length*inputArray[0].length;//80
		int resultArray[] =  new int[size];
		
		int findedRowIndex[]=new int[collumnMaximum]; // 10열 만큼의 크기를 가지는 열인덱스 
		int finalPrevIndex,findedArrayColumnIndex; //이전인덱스를 찾을 떄 쓰는 변수 , 그리고 InputArray에서 컬럼인덱스를 찾을 때쓰는 변수 
		
		Entry[] entry= new Entry[15];
		for(int i=0;i<entry.length;i++)
		{
			entry[i]=new Entry(i);
		}


		InsertDataToLeaf(inputArray, entry, findedRowIndex); //[1 단계] 일단 리프노드에 전부다 데이터 넣음 
		initTree(entry);// 초기 [2단계] 패자 트리구성함
		//printEntryTree(entry);





		//System.out.println("result:"+resultArray[0]);
		//System.out.println("prevIndex:"+finalPrevIndex);



		for(int resultIndex=0;resultIndex<size;resultIndex++){

			resultArray[resultIndex]=entry[0].value; // 결과값 집어넣음
			//[3단계 ]결과값을 넣은 원래 자리 finalPrevIndex를 구하고, 그 자리에 새로운 값을 UPDATE 
			finalPrevIndex = newDataUpdateToTree(inputArray, collumnMaximum, findedRowIndex, entry);
			//printEntryTree(entry);
			loserTreeUpdate(entry, finalPrevIndex);//최종인덱스로 패자트리 업데이트 
		}


		//결과 출력!
		System.out.println("결과 값은 다음과 같습니다.");
		printResult(resultArray);


	}



	private static int newDataUpdateToTree(int[][] inputArray, int collumnMaximum, int[] findedRowIndex,
			Entry[] entry) {
		int finalPrevIndex;
		int findedArrayColumnIndex;
		finalPrevIndex=findPrevIndex(entry); //이전인덱스 가져옴
		findedArrayColumnIndex=finalPrevIndex-7;  //findedArrayColumnIndex
		//System.out.println("result:"+resultArray[resultIndex]);
		//System.out.println("findedColumnIndex:"+findedArrayColumnIndex+" findPrevIndex:"+finalPrevIndex+" findLowIndex"+findedRowIndex[findedArrayColumnIndex]);

		if(findedRowIndex[findedArrayColumnIndex]>=collumnMaximum){
			//찾은 배열의 인덱스가 컬럼인덱스의 rowIndex가 collumnMaximum보다  크면 MAX로 초기
			entry[finalPrevIndex].value=Integer.MAX_VALUE; 
		}else{
			entry[finalPrevIndex].value=inputArray[findedArrayColumnIndex][findedRowIndex[findedArrayColumnIndex]];
			//최솟값을 찾은자리에 새로운 컬럼의 값 덮어씌움 
			findedRowIndex[findedArrayColumnIndex]++; //사용하고 있는 배열의 row넘버를 늘림 
		}
		//System.out.println("entry 업데이트된 값은:"+entry[finalPrevIndex].value);
		return finalPrevIndex;
	}



	/**
	 * 결과를 출력 
	 * @param resultArray
	 */
	private static void printResult(int[] resultArray) {
		System.out.print("[");
		for(int i =0;i<resultArray.length;i++){
			System.out.print(resultArray[i]);
			if(i<resultArray.length-1)
				System.out.print(",");
		}
		System.out.println("]");
	}



	private static void printEntryTree(Entry[] entry) {
		System.out.print("[");
		for(int i =0;i<entry.length;i++){
			if(i>=(entry.length-1)/2)
				System.out.print("//");
			System.out.print("("+entry[i].value+","+entry[i].prevIndex+")");

		}
		System.out.println("]");
	}



	private static void loserTreeUpdate(Entry[] _entry, int _initIndex) {

		int findMinIndex=_initIndex;
		while(findMinIndex>0)
		{
			//System.out.println("loserTreeUpdate에 findMinIndex값은  "+findMinIndex);
			if(findMinIndex%2==1) //왼쪽자식이면 
			{
				//자식중 작은값 올림! 
				if(_entry[findMinIndex].value<_entry[findMinIndex+1].value)
				{
					int ParentIndex = (findMinIndex-1)/2;
					_entry[ParentIndex].value=_entry[findMinIndex].value;
					_entry[ParentIndex].prevIndex =findMinIndex;
				//	System.out.println("loserTreeUpdate에 값 :"+_entry[ParentIndex].value+" prev:"+_entry[ParentIndex].prevIndex);
				}else{
					int ParentIndex = (findMinIndex-1)/2;
					_entry[ParentIndex].value=_entry[findMinIndex+1].value;
					_entry[ParentIndex].prevIndex =findMinIndex+1;
				//	System.out.println("loserTreeUpdate에 값 :"+_entry[ParentIndex].value+" prev:"+_entry[ParentIndex].prevIndex);
				}

				findMinIndex=(findMinIndex-1)/2; //부모인덱스로 이동 !
			}else{ //오른쪽자식이면 

				//자식중 작은값 올림! 
				if(_entry[findMinIndex].value<_entry[findMinIndex-1].value)
				{
					int ParentIndex = (findMinIndex-2)/2;
					_entry[ParentIndex].value=_entry[findMinIndex].value;
					_entry[ParentIndex].prevIndex =findMinIndex;
				}else{
					int ParentIndex = (findMinIndex-2)/2;
					_entry[ParentIndex].value=_entry[findMinIndex-1].value;
					_entry[ParentIndex].prevIndex =findMinIndex-1;
				}
				findMinIndex=(findMinIndex-2)/2; //부모인덱스로 이동 !
			}
		}
	}



	private static void initTree(Entry[] _entry) {

		int divide=0; //트리를 레벨별로 나누기 위해서 만든 인덱
		for(int startOfLevel=7;startOfLevel>0;){			
			LoserTreeProcess(_entry,startOfLevel,divide);
			//startOFLevel은 각레벨의 첫번쨰자식 
			//부모로!
			if(startOfLevel%2==1)
			{
				startOfLevel=(startOfLevel-1)/2;
			}else{
				startOfLevel=(startOfLevel-2)/2;
			}
			divide++;
		} 
	}

	private static int findPrevIndex(Entry[] _entry) {
		int findIndex=_entry[0].prevIndex;
		while(findIndex<(_entry.length/2))
		{
		//	System.out.println("findIndex :"+findIndex + " prevIndex: "+_entry[findIndex].prevIndex);
			findIndex=_entry[findIndex].prevIndex;
		}
		return findIndex;
	}

	private static void LoserTreeProcess(Entry[] _entry, int _initVlaue,int _diviede) {
		//Loser
		//System.out.println("LoserInit: "+_initVlaue);
		int firstParentIndex=_entry.length;
		for(int i =0;i<_diviede;i++)
			firstParentIndex=firstParentIndex/2;

		//System.out.println("firstPrentIndex: "+firstParentIndex);

		for(int k =_initVlaue;k<firstParentIndex;k=k+2)
		{
			int leftParentIndex =(k-1)/2;
			int rightParentIndex =  (k-2)/2;
			if(rightParentIndex<0)
				break;

			if(_entry[k].value<_entry[k+1].value)
			{
				_entry[leftParentIndex].value=_entry[k].value;
				//System.out.println("left Child Index :"+k);
				_entry[leftParentIndex].prevIndex = k;
			}else{
				_entry[leftParentIndex].value=_entry[k+1].value;
				//System.out.println("right Child Index :"+(k+1));
				_entry[leftParentIndex].prevIndex = (k+1);
			}


		}
	}

	private static void InsertDataToLeaf(int[][] _inputArray, Entry[] _entry, int[] _findedRowIndex) {

		int leafIndex=7;
		for(int i =0; i<_inputArray.length;i++)
		{
			//System.out.println("InsertDataToLeaf : entry["+leafIndex+"] ="+_inputArray[i][0]);

			_entry[leafIndex].value = _inputArray[i][0];
			_findedRowIndex[i]++;//값을 집어넣었으니 해당 행의 열인덱스 증가 

			leafIndex++;
		}
	}
}
