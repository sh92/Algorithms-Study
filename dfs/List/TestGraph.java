
public class TestGraph {

	public static void main(String[] args) {
		Graph g =new Graph(new String[]{"SE","UK","DE","FR","CZ","CH","AT","IT"});
		
		
		System.out.println(g);
		g.add("SE", "UK");
		g.add("SE", "DE");
		g.add("UK", "FR");
		g.add("DE", "FR");
		g.add("DE", "IT");
		g.add("DE", "CZ");
		g.add("CH", "FR");
		g.add("CH", "IT");
		g.add("CH", "AT");
		//System.out.println(g.toString());
		g.dfs("SE");
		
		
	}
}
