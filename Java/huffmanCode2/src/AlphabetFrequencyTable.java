/**
 * 알파벳 빈도수 테이블 
 * @author 이상희 
 *
 */
public class AlphabetFrequencyTable {
	     int A = 65;
		 int a =97;
		 Alpha alpha[]= new Alpha[27];

		 public AlphabetFrequencyTable(){
			 char space = ' ';
			 alpha[0]=new Alpha(space);
			 for(int i =1; i<27;i++){
				 char ap=(char) (a+i-1);
				 alpha[i] = new Alpha(ap);
			 }
		 }
		 /**
		  * 알파벳에 대한 문자에 대한 빈도수를 증가시키는 메서드 
		  * @param _alpha 해당 문자 
		  */
		 public void add(char _alpha){
			 if(_alpha==' ')
			 {
				 alpha[0].count++;
				 return;
			 }
			 for(int i=1;i<27;i++)
			 {
				 if((alpha[i].alpha)==(_alpha)){
					 alpha[i].count++;
				 }
			 }
			 
		 }
		 /**
		  * 해당 알파벳 문자에 대한 빈도수를 감소시킴 
		  * @param _alpha 해당 문자 
		  * @return 해당 문자 
		  */
		 public boolean remove(char _alpha){
			 
			 for(int i=0;i<27;i++)
			 {
				 if((alpha[i].alpha)==(_alpha)){
					 if(alpha[i].count==0) break;
					 alpha[i].count--;
					return true;
				 }
			 }
			 return false;
			 
		 }

		 /**
		  * 문자열을 출력하는 메서드 
		  */
		 public String toString(){
			 StringBuffer buf= new StringBuffer();
			 for(int i=0;i<alpha.length;i++)
			 {
				 buf.append("["+alpha[i].alpha + ":" +alpha[i].count+"]"+"\n");
			 }
			 return buf.toString();
		 }
	
}
