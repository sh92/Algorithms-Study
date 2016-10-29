import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class GraphTest {

	
	Graph g = null;
	
	
	@Test
	public void testGraph() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testTopologicalSort() {
		try {
			g= new Graph();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.topologicalSort();
		fail("Not yet implemented");
	}


	@Test
	public void testToString() {
		try {
			g= new Graph();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.toString();
		fail("Not yet implemented");
	}

}
