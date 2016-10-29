import java.io.IOException;
import java.util.Scanner;

public class TestGraph {

	public static void main(String[] args) throws IOException {

		
		Graph g = new Graph();

		//System.out.println(g.toString());
		g.topologicalSort();
	}
}
