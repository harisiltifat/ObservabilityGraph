package monitoring.observe;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;

public class GraphTraversalTest {

	@Test(expected=NullPointerException.class)
	public void NullGraphTest() {
		GraphTraversal.getAverageLatencyABC(null);
		
	}
	
	@Test(expected=GraphTraversalException.class)
	public void EmptyGraphTest() {
		GraphTraversal.getAverageLatencyABC(new int[0][0]);
	}
}
