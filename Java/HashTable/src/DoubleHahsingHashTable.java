class DoubleHahsingHashTable {
	private Entry[] entries ;
	private int size;
	private int used;
	private float loadFactor;
	private  Entry NILL=new Entry(null,null);
	private int collisionCount;
	
	
	public DoubleHahsingHashTable(int _capacity, float _loadFactor){
		entries=new Entry[_capacity];
		this.loadFactor=_loadFactor;
	}
	public DoubleHahsingHashTable(int _capacity){
		this(_capacity, 0.75F);
	}
	
	
	public Object get(Object _key) {
		// TODO Auto-generated method stub
	
		int h1 = hash(_key);
		int h2 = hash2(_key);
		for(int i=0;i<entries.length;i++){
			int j = nextProbeDouble(h1,h2,i);
			Entry entry =entries[j];
			if(entry==null) break;
			if(entry == NILL) break;
			if(entry.key.equals(_key)) return entry.value;
		}
		return entries[hash(_key)].value;
	}


	public Object put(Object _key, Object _value) {
		// TODO Auto-generated method stub
		
		System.out.print(size+1+". "+_key+"  ");
		if(used > loadFactor*entries.length) rehash();
		int h1 = hash(_key);
		int h2= hash2(_key);
		
		
		for(int i =0; i<entries.length;i++){
			//int j = nextProbe(h, i);
			int j =nextProbeDouble(h1,h2,i);
			System.out.print("->"+j );
			Entry entry = entries[j];
			if(entry == null ){
				entries[j]= new Entry(_key, _value);
				++size;
				++used;
				System.out.println();
				return null;
			}
			if(entry == NILL) continue;
			if(entry.key.equals(_key))
			{
				Object oldValue= entry.value;
				entries[j].value=_value;
				System.out.println();
				return oldValue;
			}
			collisionCount++;		
		}
		System.out.println();
		return null;
	}

	private int nextProbeDouble(int h1, int h2, int i) {
		// TODO Auto-generated method stub
		return (h1+h2*i) % entries.length;
	}
	public Object remove(Object _key) {
		// TODO Auto-generated method stub
		
		int h1 = hash(_key);
		int h2 = hash2(_key);
		for(int i=0;i<entries.length;i++){
			int j = nextProbeDouble(h1,h2,i);
			Entry entry= entries[j];
			
			
			if(entries[j]==null) break;
			if(entries[i]==NILL)  continue;
			if(entries[j].key.equals(_key)){
				Object oldvalue=entry.value;
				entries[j]=NILL;
				--size;
				return oldvalue;
			}
			
		}
		return null;
	}

	
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private class Entry
	{
		Object key, value;
		Entry(Object _key, Object _value){
			this.key =_key;
			this.value=_value;
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

	

}
