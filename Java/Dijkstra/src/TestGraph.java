import java.io.IOException;
import java.util.Scanner;

public class TestGraph {
	public static void main(String[] args) throws IOException  {
		Graph g = new Graph();
		System.out.println("A,B,C,D,E,F,G,H,I,J �� 10���� ����(Vertex)�� �ֽ��ϴ�. ������� �Է����ּ���");
		Scanner scanner = new Scanner(System.in);
		 String sentence = scanner.nextLine();
		g.dijkstra(sentence);
	}
}
