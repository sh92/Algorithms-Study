
public class Entry {


	int prevIndex;
	int value;
	
	/**
	 * 엔트리 생성자 
	 */
	public Entry(){
		value=Integer.MAX_VALUE;
		prevIndex=-1;
	}
	/**
	 * 엔트리 생성자 
	 * @param _prevIndex 이전 인덱스 
	 */
	public Entry(int _prevIndex){
		value=Integer.MAX_VALUE;
		prevIndex=_prevIndex;
	}
	/**
	 * 이전인덱스와 값을 저장하는 엔트리 객체 
	 * @param _prevIndex 이전인덱스 
	 * @param _value 값 
	 */
	public Entry(int _prevIndex, int _value)
	{
		prevIndex = _prevIndex;
		value = _value;
	}
}
