
public class AppController {
	private AppView _appView;
	private int inputArray[][]= {{1,9,11,19,21,31,41,51,61,71},
			{7,17,27,37,47,50,57,60,67,77},
			{2,12,22,29,32,39,42,52,62,72},
			{4,14,24,34,44,54,64,69,74,79},
			{8,18,28,38,48,58,68,70,78,80},
			{5,10,15,20,25,35,45,55,65,75},
			{3,13,23,33,43,49,53,59,63,73},
			{6,16,26,30,36,40,46,56,66,76}}; //입력한 2차원 배열 
	private int collumnMaximum;  //받은 2차원 배열의 열의 수 
	private int rowMaximum; //받은 2차원 배열의 행 의 수
	private int size; //받은 2차원 배열의 크기 
	private int[] resultArray; //결과 값의 배열 
	private int[] findedRowIndex;  //찾은 열의 인덱스 
	private int finalPrevIndex,findedArrayColumnIndex;
	//이전인덱스를 찾을 떄 쓰는 변수 , 그리고 InputArray에서 컬럼인덱스를 찾을 때쓰는 변수 
	private Entry[] entry; //엔트리 
	private int firstLeafIndex; // 첫번째 리프노드 인덱스 
	private int entrySize; // 엔트리의 크기 
	


	/**
	 * AppController의 생성
	 * @param _inputArray 입력받은 2차원 배열 
	 */
	public AppController()
	{
		this._appView = new AppView();
		collumnMaximum=inputArray[0].length; //열의 개수 
		rowMaximum = inputArray.length; // 행의 개수 
		size = collumnMaximum * rowMaximum;
		resultArray =  new int[size];
		findedRowIndex=new int[collumnMaximum]; // 10열 만큼의 크기를 가지는 열인덱스
		
		//입력한 inputArray를 계산하기위해 트리의 사이즈를 구하기!
		for(int i = 1;i<rowMaximum*2;i*=2)
		{
			entrySize+=i;
		}
		//entry 초기화!
		entry= new Entry[entrySize];
		for(int i=0;i<entry.length;i++)
		{
			entry[i]=new Entry(i);
		}
		//첫번째 자식 인덱스를 구하기 
		firstLeafIndex=(entrySize-1)/2;
	}
	/**
	 * AppController를 실행하는 메서드 
	 */
	public void run()
	{
		
		 
		initTree();// 초기 패자 트리구성함
		
		for(int resultIndex=0;resultIndex<size;resultIndex++){
			resultArray[resultIndex]=entry[0].value; // 결과값 집어넣음
			//결과값을 넣은 원래 자리 finalPrevIndex를 구하고, 그 자리에 새로운 값을 UPDATE 
			newDataUpdateToTree();
			//_appView.printEntryTree(entry);
			loserTreeUpdate();//최종인덱스로 패자트리 업데이트 
		}
		//결과 출력!
		_appView.printResult(resultArray);

	}
	/**
	 * 기존에 가장 작은 값을 뺏으면 배열로 부터 새로운 값을 얻어서 기존의 자리에 그 값을 넘겨줌 
	 * @return 이전인덱스를 반환 
	 */
	private void newDataUpdateToTree() {
	
		finalPrevIndex=findPrevIndex(entry); //이전인덱스 가져옴
		findedArrayColumnIndex=finalPrevIndex-firstLeafIndex;  //findedArrayColumnIndex



		if(findedRowIndex[findedArrayColumnIndex]>=collumnMaximum){
			//찾은 배열의 인덱스가 컬럼인덱스의 rowIndex가 collumnMaximum보다  크면 MAX로 초기
			entry[finalPrevIndex].value=Integer.MAX_VALUE; 
		}else{
			if(findedArrayColumnIndex<collumnMaximum)
			{
				entry[finalPrevIndex].value=
						inputArray[findedArrayColumnIndex]
								[findedRowIndex[findedArrayColumnIndex]];
				//최솟값을 찾은자리에 새로운 컬럼의 값 덮어씌움 
				findedRowIndex[findedArrayColumnIndex]++; //사용하고 있는 배열의 row넘버를 늘림 
		
			}
		}
		//System.out.println("entry 업데이트된 값은:"+entry[finalPrevIndex].value);
		
	}



	


	
	/**
	 * 패자트리를 완성하여 값을 업데이트 시켜줌 
	 */
	private void loserTreeUpdate() {

		int findMinIndex=finalPrevIndex;
		while(findMinIndex>0)
		{
			//System.out.println("loserTreeUpdate에 findMinIndex값은  "+findMinIndex);
			if(findMinIndex%2==1) //왼쪽자식이면 
			{
				//자식중 작은값 올림! 
				if(entry[findMinIndex].value<entry[findMinIndex+1].value)
				{
					int ParentIndex = (findMinIndex-1)/2;
					entry[ParentIndex].value=entry[findMinIndex].value;
					entry[ParentIndex].prevIndex =findMinIndex;
				//	System.out.println("loserTreeUpdate에 값 :"
				//+entry[ParentIndex].value+" prev:"+entry[ParentIndex].prevIndex);
				}else{
					int ParentIndex = (findMinIndex-1)/2;
					entry[ParentIndex].value=entry[findMinIndex+1].value;
					entry[ParentIndex].prevIndex =findMinIndex+1;
				//	System.out.println("loserTreeUpdate에 값 :"+entry[ParentIndex].value
				//+" prev:"+entry[ParentIndex].prevIndex);
				}

				findMinIndex=(findMinIndex-1)/2; //부모인덱스로 이동 !
			}else{ //오른쪽자식이면 

				//자식중 작은값 올림! 
				if(entry[findMinIndex].value<entry[findMinIndex-1].value)
				{
					int ParentIndex = (findMinIndex-2)/2;
					entry[ParentIndex].value=entry[findMinIndex].value;
					entry[ParentIndex].prevIndex =findMinIndex;
				}else{
					int ParentIndex = (findMinIndex-2)/2;
					entry[ParentIndex].value=entry[findMinIndex-1].value;
					entry[ParentIndex].prevIndex =findMinIndex-1;
				}
				findMinIndex=(findMinIndex-2)/2; //부모인덱스로 이동 !
			}
		}
	}



	/**
	 * 트리의 리프에 값을 집어넣고 패자트리를 이용하여 최솟값을 가져옴 
	 */
	private void initTree() {
		InsertDataToLeaf(); //[1 단계] 일단 리프노드에 전부다 데이터 넣음
		int divide=0; //트리를 레벨별로 나누기 위해서 만든 인덱
		for(int startOfLevel=firstLeafIndex;startOfLevel>0;){			
			LoserTreeProcess(startOfLevel,divide);
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

	/**
	 * 루트에서 최솟값이 나왔을 때 어느 리프에서 왔는지 인덱스를 가져옴 
	 * @param entry 트리를 구성하는 엔트리 
	 * @return 루트에서 최솟값이 나왔을 때 어느 리프에서 왔는지에 대한  인덱스
	 */
	private int findPrevIndex(Entry[] entry) {
		int findIndex=entry[0].prevIndex;
		while(findIndex<(entry.length/2))
		{
		//	System.out.println("findIndex :"+findIndex + " prevIndex: "+entry[findIndex].prevIndex);
			findIndex=entry[findIndex].prevIndex;
		}
		return findIndex;
	}

	/**
	 * 패자트리를 진행하여 최솟값을 가져오는 메서
	 * @param _levelStartValue 레벨별로 나누기 위한 각레벨
	 * @param _diviede 레벨을 찾기위해 나눈 레벨 
	 */
	private void LoserTreeProcess(int _levelStartValue,int _diviede) {
		
		//System.out.println("LoserInit: "+_levelStartValue);
		int firstParentIndex=entry.length;
		for(int i =0;i<_diviede;i++)
			firstParentIndex=firstParentIndex/2;

		//System.out.println("firstPrentIndex: "+firstParentIndex);

		for(int k =_levelStartValue;k<firstParentIndex;k=k+2)
		{
			int leftParentIndex =(k-1)/2;
			int rightParentIndex =  (k-2)/2;
			if(rightParentIndex<0)
				break;

			if(entry[k].value<entry[k+1].value)
			{
				entry[leftParentIndex].value=entry[k].value;
				//System.out.println("left Child Index :"+k);
				entry[leftParentIndex].prevIndex = k;
			}else{
				entry[leftParentIndex].value=entry[k+1].value;
				//System.out.println("right Child Index :"+(k+1));
				entry[leftParentIndex].prevIndex = (k+1);
			}


		}
	}

	/**
	 * 처음에 트리의 리프에 배열의 각각의 데이터를 집어넣음 
	 * @param _findedRowIndex 2차원배열에서 어디까지 넣었는지 알기 위한 배열 
	 */
	private void InsertDataToLeaf( ) {

		int leafIndex=firstLeafIndex;
		for(int i =0; i<rowMaximum;i++)
		{
			//System.out.println("InsertDataToLeaf : entry["+leafIndex+"] ="+inputArray[i][0]);

			entry[leafIndex].value =inputArray[i][0];
			findedRowIndex[i]++;//값을 집어넣었으니 해당 행의 열인덱스 증가 

			leafIndex++;
		}
	}

	
}
