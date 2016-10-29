package org.cscnu.map;

/**
 * DLLMap을 실행시켜 알파벳 순서대로 값을 집어 넣음
 * @author 이상희
 * @version 1.0
 * @since 2015-5-10
 */
import java.io.*;
import java.util.StringTokenizer;

public class SampleDLLMap{
		/** 
		 * 파일을 파라미터로 받는 생성자 
		 * @param file 파일을 받아 key 값과 value로 그 단어가 있는 줄을 집어넣음
		 */
		public SampleDLLMap(String file){
				Map map = new DLLMap();
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

				System.out.println(map.toString());

				System.out.println("line:" + lineNumber);
				System.out.println("distinct words: " + map.size());

		}
		/** 
		 * 파일을 파리미터로 받음
		 * @param args 명령어에서 argument로 파일이름을 넣어주면 파라미터로 파일을 받음
		 */
		public static void main(String[] args){
				new SampleDLLMap(args[0]);
		}

}
