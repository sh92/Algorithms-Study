import java.io.IOException;
import java.util.Scanner;

public class Kruskal {

	public static void main(String[] args) throws IOException  {
		Graph g = new Graph();
		System.out.println("Kruskal 알고리즘 결과");
		g.kruskal();
		System.out.println(g.toString());
	}
}
