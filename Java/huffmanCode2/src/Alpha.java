/**
 * Alpha는 선택트리와 빈도수 테이블을 구성하기 위한 노드 클래스이다.  
 * @author 이상희 
 * 
 */
public class Alpha {

	int count; //빈도 수 
	char alpha;  //단어 
	Alpha left; 
	Alpha right;  
	
	
	public Alpha( ){
		this.alpha = '\0';
		this.count=0;
	}
	
	public Alpha(char _alpha){
		this.alpha=_alpha;
		this.count=0;
	}
	public Alpha(char _alpha,int _count){
		this.alpha=_alpha;
		this.count=_count;
	}
	
	public Alpha(int _count, char _alpha, Alpha _left, Alpha _right){
		this.alpha=_alpha;
		this.left=_left;
		this.count=_count;
		this.right=_right;
	}

	public String toString(){
		return this.left +" " +this.alpha + " "+this.right;
	}
}
