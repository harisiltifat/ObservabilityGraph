package monitoring.observe.utilities;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;

public class DijistraTest {
	@Test(expected = GraphTraversalException.class)
	public void NullGraphTest() {
		Dijikstra.shortestPath(null,1,4);
	}
}
