package org.cscnu.map;
/**
* HashMap을 이용하여 실행하는 클래스로 파일을 파라미터로 받아 단어마다 개수를 셈
* @author 이상희
* @version 1.0
* @since 2015-05-10
*/
import java.io.*;
import java.util.StringTokenizer;

public class SampleHashMap{
	/**
	* 파일을 파라미터로 받는 생성자 
	* @param file 파일을 받아 key 값과 value로 그 단어가 있는 줄을 집어넣음
	*/
	public SampleHashMap(String file){
		Map map = new HashMap();
		int lineNumber = 0;
		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			while(line != null) {
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
				while(parser.hasMoreTokens()){
					String word = parser.nextToken().toUpperCase();
					String list =map.get(word);
					if(list == null){
						map.put(word, ""+lineNumber);
					}else{
						map.put(word,  list+","+ lineNumber);
					}
				}

				System.out.println(lineNumber + ":\t" +line);
				line =in.readLine();
			}
			in.close();
		}catch(IOException e){
			System.out.println(e);
		}

		System.out.println(map);
		
		System.out.println("line:" + lineNumber);
		System.out.println("distinct words: " + map.size());

	}
	/**
	* 파일을 파리미터로 받음
	* @param args 명령어에서 argument로 파일이름을 넣어주면 파라미터로 파일을 받음
	*/
	public static void main(String[] args){
		new SampleHashMap(args[0]);
	}

}
