package org.cscnu.arraybag;
import org.cscnu.temperature.*;
/**
* Bag를 이용하여 데이터를 추가하고 지우는 사용자페이지
* @author 이상희
* @version 1.0
* @since 2015-03-19
*/
public class SampleBag {

	public static void main(String[] args){


		
		ArrayBag bag = new ArrayBag();
		Object object = new Object();
		

		/**
		* bag에 데이터를 add
		*/
		bag.add(new String("A"));
		bag.add("B");
		bag.add(1);
		bag.add('C');
		bag.add("A");
		bag.add(1);
		bag.add(1);
		bag.add(1);
		bag.add(100);
		bag.add(new MyTemperature(30,'C'));
		
		


		/**
		*  bag add한것을 출력
		*/
			System.out.print("###########bag 예제#########\n");
			System.out.print("--");


		for(int i=0;i<bag.size();i++){
				System.out.print(" | "+bag.getNext()+" | ");
		}
			System.out.print("--\n");



		object = bag.getFirst();
		System.out.printf("-- %d개의 add후 --\n", bag.size());


		/**
		* bag의 내용 전체 출력
		*/
		int num=0;

		while(object !=null){
			
			if(object != null){
				System.out.println("["+num+"]"+object);
				num++;
			}else{
				return ;
			}
			object = bag.getNext();
		}	
		


		/**
		*추가로 add
		*/
		bag.add("D");
		bag.add(1);
		bag.add("E");
		bag.add("F");
		bag.add("A");
		bag.add("G");
		


		int addSize=0;
		System.out.print("-- ");
			
		
		/**
		* 위에서 getNext의 값이 null일 때 빠져나오므로 object의 시작위치를 한칸 전으로 보내고 다시 앞으로 보내줘야함 
		*/
		object=bag.getPrevious();
		object=bag.getNext();
			
		/**
		* 추가된 데이터를 보여줌
		*/
		while(object!=null){
			if(object!=null){
			System.out.print(" | "+object+" | ");
			}else{
				return;
			}

		object=bag.getNext();
		addSize++;
		}

		System.out.print("--\n");

		System.out.printf("-- %d개의 add후 --\n",addSize );
		
		/**
		* 전체 데이터를 보여줌
		*/
		num=0;
		object = bag.getFirst();
		while(object !=null){
			if(object != null){
				System.out.println("["+num+"]"+object);
				num++;
			}else{
				return ;
			}
			object = bag.getNext();
		}	

		/**
		* 제거된 데이터를 보여줌
		*/
		int removeNum=0;

		object=bag.getFirst();

		System.out.printf("제거전 %d 개\n",bag.size());	
		System.out.print("-- ");
		for(int i =0;i<7;i++){
			if(bag.remove(object)){
				System.out.print(" | "+object+" | ");
			}	
			removeNum++;
			object=bag.getFirst();
		}
		System.out.print("--\n");
		System.out.printf("-- %d개 제거 후 --\n", removeNum);
		System.out.printf("제거후 %d 개\n",bag.size());	




	
		/**
		* 전체 데이터를 보여줌
		*/
		object = bag.getFirst();
		num=0;
		while(object !=null){
			if(object != null){
				System.out.println("["+num+"]"+object);
				num++;
			}else{
				return ;
			}
			object = bag.getNext();
		}	

	}

}

