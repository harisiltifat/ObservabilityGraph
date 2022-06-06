package monitoring.observe;

import java.util.HashMap;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;
import monitoring.graph.Node;

public class GraphTraversalTest {

	@Test(expected=NullPointerException.class)
	public void NullGraphTest() {
		new GraphTraversal(null);
	}
	
	
	
	@Test(expected=GraphTraversalException.class)
	public void EmptyGraphTest() {
		new GraphTraversal(new HashMap<Character, Node>());
	}
}
