package org.cscnu.arrayset;
import	org.cscnu.temperature.*;
/**
* ArraySet을 사용하여 데이터를 추가하고 지우는 사용자 클래스
* @author 이상희
* @version 1.0
* @since 2015-03-19
*/
public class SampleSet {

	public static void main(String[] args){


		
		ArraySet set= new ArraySet();
		Object object = new Object();

		System.out.print("###########set예제#########\n");
		set.add("충남대학교");
		set.add("이상희");
		set.add("Test");
		set.add("duplicate");
		set.add(1);
		set.add(1);
		set.add(new String("duplicate"));
		

			System.out.print("--");
		for(int i=0;i<set.size();i++){
				System.out.print(" | "+ set.getNext()+" | ");
		}
			System.out.print("--\n");



		object = set.getFirst();
		System.out.printf("-- %d개의 add후 --\n", set.size());
		while(object !=null){
			if(object != null){
//				System.out.println(object);
			}else{
				return ;
			}
			object = set.getNext();
		}	
		set.allPrint();
		


			System.out.print("#########################\n");
		set.add("D");
		set.add(1);
		set.add("E");
		set.add("F");
		set.add("이상희");
		set.add("G");
		set.add(new MyTemperature(100,'C'));

		


		int addSize=0;
		System.out.print("-- ");
			
		object=set.getPrevious();
		
		object=set.getNext();
			
		while(object!=null){
			if(object!=null){
			System.out.print(" | "+object+" | ");
			}else{
				return;
			}

		object=set.getNext();
		addSize++;
		}

		System.out.print("--\n");

		System.out.printf("-- %d개의 add후 --\n",addSize );

		set.allPrint();

		System.out.print("#########################\n");
		int removeNum=0;
		object=set.getFirst();
		System.out.print("-- ");
		for(int i =0;i<7;i++){
			if(set.remove(object)){
				System.out.print(" | "+object+" | ");
			}	
			removeNum++;
			object=set.getFirst();
		}
		System.out.println("--");
		System.out.printf("-- %d개 제거 후 --\n", removeNum);
		set.allPrint();



	}

}

