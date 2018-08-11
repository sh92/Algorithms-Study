import java.io.IOException;
import java.util.Scanner;

public class TestGraph {
	public static void main(String[] args) throws IOException  {
		Graph g = new Graph();
		System.out.println("A,B,C,D,E,F,G,H,I,J 총 10개의 정점(Vertex)가 있습니다. 출발점을 입력해주세요");
		Scanner scanner = new Scanner(System.in);
		 String sentence = scanner.nextLine();
		g.dijkstra(sentence);
	}
}
