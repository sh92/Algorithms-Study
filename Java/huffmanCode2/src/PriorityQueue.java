/**
 * 최솟값을 가져오기 위해 우선순위 큐를 사용하여 최솟값에 대해 값 
 * @author 이상희 
 *
 */
public class PriorityQueue {

	private Alpha[] a;
	private int usedHeapSize;
	
	public PriorityQueue(){
		 a = new Alpha[26];
		 usedHeapSize=0;
	}
	public boolean isEmpty(){
		return usedHeapSize ==0;
	}
	
	public void sort()
	{
		for(int i =(usedHeapSize-1)/2; i>=0;i--)
		{
			minHeapify(a,i,usedHeapSize);
		}
		for(int j = usedHeapSize-1; j>0;j--)
		{
			swap(a,0,j);
			minHeapify(a,0,j);
		}
	}
	private void swap(Alpha[] a, int i, int j) {
		Alpha temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	private void minHeapify(Alpha[] a, int i, int n) {
		Alpha ai = a[i];
		while( i < n/2)
		{
			int j =2*i+1;
			if(j+1 < n && a[j+1].count > a[j].count)
				++j;
			if(a[j].count <=ai.count) break;
			a[i] = a[j];
			i=j;
		}
		a[i] = ai;
	}
	
	public boolean add(Alpha _alpha ){
		if(usedHeapSize >=a.length)
			return false;
		a[usedHeapSize++] = _alpha;
		sort();
		return true;
	}
	public boolean addTable(AlphabetFrequencyTable _alphabetFrequency ){
		for(int i =0; i<a.length;i++)
		{
			if(_alphabetFrequency.alpha[i].count!=0){
				a[usedHeapSize]=_alphabetFrequency.alpha[i];
				usedHeapSize++;
			}
		}
		sort();
		
		return true;
		
	}
	public Alpha remove(){
		Alpha miniMunAlpha =a[0];
		a[0] = a[usedHeapSize-1];
		usedHeapSize--;
		sort();
		return miniMunAlpha;
	}
	
	public String toString(){
		StringBuffer buf = new StringBuffer();
		for(int i =0; i<usedHeapSize;i++){
			buf.append("["+a[i].alpha + ":" +a[i].count+"]");
		}
		return buf.toString();
	}
	public int getUsedHeapSize(){
		return usedHeapSize;
	}
}
