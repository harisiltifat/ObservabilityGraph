package monitoring.observe;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;

public class GraphTraversalTest {

	@Test(expected=NullPointerException.class)
	public void NullGraphTestABC() {
		GraphTraversal.getAverageLatencyABC(null);
	}
	
	@Test(expected=GraphTraversalException.class)
	public void EmptyGraphTestABC() {
		GraphTraversal.getAverageLatencyABC(new int[0][0]);
	}
	
	@Test(expected=NullPointerException.class)
	public void NullGraphTestAD() {
		GraphTraversal.getAverageLatencyAD(null);
	}
	
	@Test(expected=GraphTraversalException.class)
	public void EmptyGraphTestAD() {
		GraphTraversal.getAverageLatencyAD(new int[0][0]);
	}
	
	@Test(expected=NullPointerException.class)
	public void NullGraphTestADC() {
		GraphTraversal.getAverageLatencyADC(null);
	}
	
	@Test(expected=GraphTraversalException.class)
	public void EmptyGraphTestADC() {
		GraphTraversal.getAverageLatencyADC(new int[0][0]);
	}
}
