
public class Entry {


	int prevIndex;
	int value;
	
	public Entry(){
		value=Integer.MAX_VALUE;
		prevIndex=-1;
	}
	public Entry(int _currentIndex){
		value=_currentIndex;
		prevIndex=-1;
	}
	public Entry(int _currentIndex, int _prevIndex, int _value)
	{
		prevIndex = _prevIndex;
		int value = _value;
	}
}
