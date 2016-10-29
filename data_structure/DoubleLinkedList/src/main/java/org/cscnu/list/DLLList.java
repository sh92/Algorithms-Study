package org.cscnu.list;
import java.util.*;
import java.lang.IllegalStateException;
/**
* Double Linekd List 를 이용하여 List를 구현
* @author 이상희
* @version 1.0
* @since 2015-05-21
*/
public class DLLList extends AbstractList { 

		private int size=0;
		private Node start= null;

		/** 생성자*/
		public DLLList(){
		}

		/**첫번째 자리에 원소에 집어넣음
		* @return 첫번째에 추가되면 true
		*  @param data 주어진 데이터를 처음에 넣음
		*/ 	
		private boolean addFirst(Object data){
				if(start ==null){
						start =new Node(data);
						size++;
						return true;
				}else{
						start = new Node(data, start,start.prev);
						start.next.prev=start;
						size++;
						return true;
				}
		}
		
		/** 마지막 자리에 원소를 집어넣음
		* return 마지막에 추가되면 TRUE
		* @param data 주어진 데이터를 마지막에 추가
		*/
		private boolean addLast(Object data){
				if(start == null){
						start=new Node(data);
						size++;
						return true;
				}else{
						Node temp = start;
						while(temp.next != null){
								temp = temp.next;
						}
						temp.next = new Node(data,null,temp);
						size++;
						return true;
				}
		}

		/** 주어진 데이터를 마지막 위치에 집어넣음 
		* @param data 데이터를 마지막위치에 추가
		* @return 추가되면 TRUE
		*/
		public boolean  add(Object data){
				
				return addLast(data);

		}

		/** 주어진 데이터를 해당 위치에 집어넣음
		* @param data 주어진 데이터를 해당위치에 집어넣음
		* @param position 데이터를 넣을 위치(첫번째 0부터 시작)
		*/
		public void add(int position , Object data){
				if(position <0 || position> size){
						throw new IllegalStateException("추가할 위치가 0보다 작거나 현재 크기보다 더 큽니다.");
				}
				boolean isAdd=false;

				if(position < 1) {
						isAdd=addFirst(data);
				}else if(position==2 && start.next==null){
						start.next= new Node(data);
						size++;
				}else{

						Node temp =start, betemp=start;
						for(int i=0;i<position; i++){
								if(temp.next != null){
										betemp=temp;
										temp=temp.next;
								}else{
										isAdd=addLast(data);
								}
						}
						if(isAdd==false){
							betemp.next= new Node(data,temp,betemp);
							temp.prev = betemp.next;
							size++;
						}	
				}
		}



		/** 해당 위치의 데이터를 가져옴
		* @param position 데이터를 가져올 위치
		* @return 해당위치의 데이터
		*/
		public Object get(int position) {
				if( position < 0 || position > size) {
						throw new IllegalStateException("가져오려는 위치가 0보다 작거나 현재의 크기보다 큽니다."); 
				}
				Node temp = start;

				for(int i=0;i<position;i++){
						temp = temp.next;	
				}


				return temp.data;
		}


		/** 해당위치의 데이터를 지움
		* @param position 데이터를 지울 위치
		* @return 지워진 데이터
		*/
		public Object remove(int position) {
				if( position < 0 || position > size) {
						throw new IllegalStateException("삭제할 위치가 0보다 작거나 현재크기보다 큽니다"); 
				}
				if(start == null){
						return null;
				}
				Node temp = start;
				Node betemp = start;
				Node deletedNode=null;
				for(int i =0; i< position; i++){
						betemp = temp;
						temp = temp.next;
				}

				deletedNode = temp;


				if(temp.prev==null){
						start =null;
						size--;
						return deletedNode.data;
				}
				if(temp.next ==null){
						betemp.next =null;
						temp.prev=null;
						size--;
						return deletedNode.data;
				}

				betemp.next = temp.next;
				temp.next.prev = betemp;

				temp.next=null;
				temp.prev=null;
				size--;
				return deletedNode.data;
		}


		/** 데이터가 포함되는지 탐색
		* @param data 포함되어있는지 확인할 데이터
		* @return 포함되어있으면 TRUE
		*/
		public boolean contains(Object data){
			Node temp = start;
			while(temp!=null){
				if(temp.data.equals(data)){
					return true;
				}
				temp = temp.next;
			}
			return false;
		}

		/** 해당위치에 데이터를 바꿈
		* @param data 바꿀 데이터
		* @param position 바꿀 위치
		* @return 바뀌기 전의 데이터
		*/
		public Object set(int position , Object data) {
				if(position < 0 || position > size) {
						throw new IllegalStateException("바꿀위치가 0보다 작거나 현재크기보다 큽니다"); 
				}
				Node temp = start;
				Node betemp = start;

				for(int i=0; i<position ;i++){
						betemp= temp;
						temp = temp.next;
				}

				Object oldData = temp.data;
				temp.data = data;

				return oldData;
		}


		/** 리스트의 사이즈
		* @return size
		*/
		public int size() {
				return size;
		}

		/** Itreater를 직접구현
		* @return Iterator
		*/
		public Iterator iterator(){
				return new MyIterator(start);
		}

		/** Iterator를 직접 구현한 MyIterator
		* @param Object DLL List 의 움직이면서 반환하는 첫번째 노드
		* @author 이상희
		* @version 1.0
		* @since 2015-05-21
		*/
		private static class MyIterator implements Iterator<Object>{
				private Node point;

				public MyIterator(Node front){
						point = front;
				}

				public boolean hasNext(){

						if(point == null){
								return false;
						}else if(point.next==null){
								return false;
						}else{
								return true;
						}

				}

				public Object next() {
						Object tempData = point.data;
						point = point.next;

						return tempData;
				}
				public void remove(){
				}	
		}
		
		/** toStinrg을 직접구현
		* iterator로 DLLList의 모든 것을 출력
		*/
		public String toString(){
			StringBuffer buf= new StringBuffer();
			Iterator it=this.iterator();
			
			buf.append("[");
			while(it.hasNext()){
				buf.append(it.next()+", ");
			}
			
			buf.append(it.next()+", ");
			buf.delete(buf.length()-2,buf.length());

			buf.append("]");

			return buf.toString();
		}
	

}

