import java.io.IOException;

public class TestGraph {
	public static void main(String[] args) throws IOException  {
		String[] input = {"AB10","AC3","BC1","CB4","BD2","CE2","CD8","DE7","ED9"};
		String[] vertex = {"A","B","C","D","E"};
		Graph g = new Graph(vertex,input);
		g.dijkstra("A");
	}
}