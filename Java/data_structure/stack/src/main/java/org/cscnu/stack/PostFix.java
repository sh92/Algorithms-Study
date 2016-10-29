package org.cscnu.stack;
import java.io.*;
import org.cscnu.slist.*;
/**
* infix(중위표기법)을 postfix(후위표기법)으로 변환기 위한 클래스
* @author 이상희
* @version 1.0
* @since 2015-04-09 
*/
public class PostFix {
	private static char[] temp;
	private static char[] token;
	private static  StringBuffer output =new StringBuffer();
	private static SListStack stack = new SListStack();
	
	
	/**
	* 스택에 들어가는 토큰에 대하여 우선순위를 매기는 함수
	* @return 스택에 들어있는 토큰에 대하여 우선순위
	* @param ch stack에 들어갈 토큰인자
	*/
	public static int instackPrecedence(char ch)
	{
		
		if(ch=='(')
			return 2;
		if(ch==')')
			return 1;
		if(ch=='/' || ch=='*' || ch =='%')
			return 4;
		if(ch =='+' || ch =='-')
			return 3;
		if(ch ==' ')
			return -1;
		return 0;
	}
	/**
	* token에 들어있는 것들에 대하여 우선순위를 매기는 함수
	* @return token에 들어 있는 것들에 대하여 우선순위를 매김
	* @param ch stack에 들어갈 토큰인자
	*/
	public static int incomingPrecedence(char ch)
	{

		if(ch=='(')
			return 5;
		if(ch==')')
			return 1;
		if(ch=='/' || ch=='*' || ch=='%')
			return 4;
		if(ch =='+' || ch =='-')
			return 3;
		if(ch ==' ')
			return -1;
		return 0;
	}
	/**
	* 후위표기식으로 하기위한 메서드로 문자를 token형식으로 만든후 우선순위에 따라 재배치 한후 괄호를 제거하였다.
	* @param _infix postfix로 변환하기 전의 infix방식의 파라미터
	*/
	public static void toPostFix(String _infix)
	{	
		String result="";
		token= stringToToken(_infix);	
		result=moveOperater(token);
		result=parentheseRemove(result);
		System.out.println(result);
	}

	/**
	* 문자열을 token char 형 배열으로 바꾸기 위한 함수
	* @param _infix 문자열을 token char형 배열형태로 집어넣기 위해 문자열 파라미터를 받음
	* @return char형 배열로 token으로 사용
	*/
	public static char[] stringToToken(String _infix){
		temp= _infix.toCharArray();
		return temp;
	}
	/**
	* 문자에 있는 괄호를 제거하는 함수
	* @param _this 문자에 있는 괄호를 제거하기위해 문자를 받음
	* @return 문자에 있는 괄호를 제거한 것을 반환
	*/
	public static String parentheseRemove(String _this){
		_this=_this.replaceAll("\\)","");	
		_this=_this.replaceAll("\\(","");	
		return _this;
	}
	/**
	* 중위 표기식을 후위표기식으로 바꿈
	* @param _token char형 배열 형태로 token을 받아 우선순위에 따라 후위표기방식으로 변형함
	* @return 후위표기식으로 된 것을 String형태로 반환
	*/
	public static String moveOperater(char[] _token){
		output=new StringBuffer();
		for(int i =0;i<_token.length;i++){	
			if(incomingPrecedence(_token[i])==0){ //token이 숫자면
				output.append(token[i]);
			}else if(stack.size() ==0){//stack의 size가 0이면..
				stack.push(token[i]);
			}else{

				if(instackPrecedence((char)stack.peek()) < incomingPrecedence(_token[i])){ 
				//stack의 top에 있는 것의 우선순위  크기가 현재의 token보다 작을 경우
					stack.push(token[i]);
				}else if(instackPrecedence((char)stack.peek()) > incomingPrecedence(_token[i])){
				//stack의 top에 있는 것의 우선순위 크기가 현재의 token보다 클 경우
					
						while(instackPrecedence((char)stack.peek()) >= incomingPrecedence(_token[i])){
							output.append(stack.pop());		
							if(stack.isEmpty())
								break;
						}
							stack.push(_token[i]);
				}else{
				//stack의 top에 있는 것의 우선순위의 크기가 현재의 token의 크기랑 같을  경우
					output.append(stack.pop());
					stack.push(_token[i]);
				}
			}
		}
			while(!stack.isEmpty()){ //stack이 비어있지 않다면 모두 out에 pop()
				output.append(stack.pop()); 
			}
		return	output.toString(); 
	}
}
