class DoubleHahsingHashTable {
	private Entry[] entries ;
	private int size;
	private int used;
	private float loadFactor;
	private  Entry NILL=new Entry();
	private int collisionCount;
	private StringBuffer buf;
	private static int numberOfOperation;
	private static int numberOfADDOperation;
	
	
	public DoubleHahsingHashTable(int _capacity, float _loadFactor){
		entries=new Entry[_capacity];
		this.loadFactor=_loadFactor;
		buf =new StringBuffer();
	}
	public DoubleHahsingHashTable(int _capacity){
		this(_capacity, 0.75F);
	}
	
	
	public Object get(Object _key) {
		// TODO Auto-generated method stub
		numberOfOperation=0;
		int h1 = hash(_key);
		int h2 = hash2(_key);
		for(int i=0;i<entries.length;i++){
			numberOfOperation++;
			int j = nextProbeDouble(h1,h2,i);
			Entry entry =entries[j];
			if(entry==null) break;
			if(entry == NILL) break;
			if(entry.key.equals(_key)) return entry.count;
		}
		return entries[hash(_key)].count;
	}


	
	public Object put(Object _key) {
		// TODO Auto-generated method stub
		
		if(used > loadFactor*entries.length) rehash();
		int h1 = hash(_key);
		int h2= hash2(_key);
		
		
		for(int i =0; i<entries.length;i++){
			int j =nextProbeDouble(h1,h2,i);
			Entry entry = entries[j];
			if(entry == null ){
				entries[j]= new Entry(_key);
				++size;
				++used;
				numberOfADDOperation++;
				return null;
			}
			if(entry == NILL) continue;
			if(entry.key.equals(_key))
			{
				Object oldValue= entry.count;
				entries[j].count++;
				numberOfADDOperation++;
				return oldValue;
			}
			collisionCount++;		
		}
		return null;
	}

	private int nextProbeDouble(int h1, int h2, int i) {
		// TODO Auto-generated method stub
		return (h1+h2*i) % entries.length;
	}
	

	
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private class Entry
	{
		Object key;
		int count;
		Entry(){
			this.key=null;
			this.count=0;
		}
		Entry(Object _key){
			this.key =_key;
			this.count=1;
		}
	}
	private int hash(Object _key){
		if(_key==null) throw new IllegalStateException();
		return (_key.hashCode() & 0x7fffffff) % entries.length;
	}
	private int hash2(Object _key){
		if(_key==null) throw new IllegalStateException();
		return 1+(_key.hashCode() & 0x7fffffff) % (entries.length-1);
	}
	private int nextProbe(int h,int i){
		
		return (h+i*i)%entries.length;
	}
	private void rehash(){
		Entry[] oldEntries = entries;
		entries = new Entry[2*oldEntries.length+1];
		for(int k =0; k< oldEntries.length;k++){
			Entry entry = oldEntries[k];
			if(entry ==null || entry==null) continue;
			int h = hash(entry.key);
			for(int i=0;i<entries.length;i++){
				int j = nextProbe(h, i);
				if(entries[j]==null){
					entries[j]=entry;
					break;
				}
			}
		}
		used=size;
	}
	public int getCollisionCount() {
		return collisionCount;
	}

	public void printHashTable(){
		for(int i =0;i<entries.length;i++){
			if(entries[i]==null)
				continue;
			System.out.println("[ "+entries[i].key+" : "+entries[i].count+" ] ");	
		}	
	}
	public int getDisticntWordCount() {
		// TODO Auto-generated method stub
		return used;// 원래는 used-삭제된 원소!
	}
	public int getNumberOfOperation()
	{
		return numberOfOperation;
	}
	public int getNumberOfADDOperation()
	{
		return numberOfADDOperation;
	}

}
