package org.cscnu.slist;

public class SingleLinkedList implements SingleLinked{

	/**
	* @author 이상희
	* @since 2015-04-05
	* @version 1.0
	*/
	private Node start =null;
	private int size=0;

	public boolean insertFirst(Object data){
		if(start ==null){
			start =new Node(data);
			size++;
			return true;
		}else{
			start = new Node(data, start);
			size++;
			return true;
		}
	}

	public boolean insertLast(Object data){
		if(start == null){
			start=new Node(data);
			size++;
			return true;
		}else{
			Node temp = start;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = new Node(data);
			size++;
			return true;
		}
	}
	
	public boolean removeFirst(){
		if(start ==null){
			return false;
		}else if(size ==  1){
			start =null;
			size--;
			return true;
		}else{
			start = start.next;
			size--;
			return true;
		}
	}

	public boolean removeLast(){
		if(start == null) {
			return false;
		} else if(size==1){
			start = null;
			size--;
			return true;
		} else {
			Node temp = start, betmap =start;
			while(temp.next != null){
				betmap =temp;
				temp = temp.next;
			}
			betmap.next = null;
			size--;
			return true;
		}
	}

	public Node getFirst(){
		return start;
	}

	public int getSize(){
		return size;
	}
	public Node getNode(int position){
		Node temp =start;
		int i=1;
		while(i<position){
			temp=temp.next;
			i++;
		}
		return  temp;
	}
	public void printAll(){
		Node temp = start;
		int i =1;
		System.out.println("%% List 출력(size: "+ size +") %%");
		while(temp != null){
			System.out.println("[" + i + "]" + temp.data+ "(next: " + temp.next +")");
			temp = temp.next;
			i++;
		}
	}
	public boolean insert(Object data, int position)
	{
		
		if(position <= 1) {
			insertFirst(data);
			return true;
		}else if(position==2 && start.next==null){
			start.next= new Node(data);
			size++;
			return true;
		}else{

			Node temp =start, betemp=start;
			for(int i=1;i<position; i++){
				if(temp.next != null){
					betemp=temp;
					temp=temp.next;
				}else{
					insertLast(data);
					return true;
				}
			}
			betemp.next= new Node(data,temp);
			size++;
			return true;
		}
	}
	public int search(Object data){
		Node temp = start,bitemp =start;
		int position=1;
		while(temp.next!=null){
		
			if((temp.data).equals(data)){
				return position;
			}else{
				bitemp=temp;
				temp =temp.next;
				position++;
			}
		}
		if(temp!=null){
			return position;
		}
		System.out.println("해당 data는 존재하지 않습니다.");
		return -1;
	}
	public boolean remove(int position){
		Node temp = start,betemp = start;
		if(start==null){
			return false;
		}else if(position<2){
			if(start.next==null){
				start=null;
				size=0;
				return true;
			}else{
				start=temp.next;
				temp=start;
				betemp=start;
				size--;
				return true;
			}
		}else{
			int i=1;
			while(i<position){
				if(temp.next==null){
					return false;
				}
				betemp=temp;
				temp=temp.next;
				i++;
			}
			betemp.next=temp.next;
			temp.next=null;
			size--;
			return true;
		}
	}

}
