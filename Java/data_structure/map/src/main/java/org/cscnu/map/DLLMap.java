package org.cscnu.map;
/**
* double Linked List를 이용하여 Map을 구현함
* @author 이상희
* @version 1.0
* @since 2015-5-10
*/
import org.cscnu.dlist.*;
public class DLLMap implements Map{

	DoubleLinkedList list = new DoubleLinkedList();


	public String get(String key){
	
		Node temp;
		temp = list.getFirst();
		while(temp!=null){
			if(((Entry3)temp.data).key.equals(key)){
				return ((Entry3)temp.data).value;
			}
			temp = temp.next;
		}
		return null;
	}


	public String put(String key, String value){

		Node temp;
		Node betemp;
		temp = list.getFirst();
		int i =1;
		while(temp!=null){
			if(((Entry3)temp.data).key.equals(key)){
				((Entry3)temp.data).setValue(value);
				return ((Entry3)temp.data).toString();
			}
			if(((Entry3)temp.data).key.compareTo(key) >  0){
				if(temp.prev==null){
					Entry3 entry = new Entry3(key,value);
					list.insertFirst(entry);
					return null;
				}else{
					Entry3 entry = new Entry3(key,value);
					list.insert(entry,i); 
					return null;
				}
					
			}
			i++;
			betemp=temp;
			temp = temp.next;
		}
		Entry3 entry = new Entry3(key,value);
		list.insertLast(entry);
		return null; 
	}


	public int size(){

		return list.getSize();
	}

	public String toString(){
		StringBuffer buf  = new StringBuffer();
		Node temp;
		temp = list.getFirst();

		while(temp != null){

			buf.append(((Entry3)temp.data).key+" : "+ ((Entry3)temp.data).value +"\n");
			temp =temp.next;
		}

		return buf.toString();
	}
}

