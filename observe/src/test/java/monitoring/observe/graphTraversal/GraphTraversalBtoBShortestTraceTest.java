package monitoring.observe.graphTraversal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;
import monitoring.observe.GraphTraversal;

public class GraphTraversalBtoBShortestTraceTest {

	@Test(expected = NullPointerException.class)
	public void NullGraphTestAED() {
		GraphTraversal.getShortestTraceBtoB(null);
	}

	@Test(expected = GraphTraversalException.class)
	public void EmptyGraphTestAED() {
		GraphTraversal.getShortestTraceBtoB(new int[0][0]);
	}

	// Test path BAB
	@Test
	public void graphTestBToBDirect() {
		int[][] graph = { { 0, 2, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int avgLatency = GraphTraversal.getShortestTraceBtoB(graph);
		assertEquals(3, avgLatency);
	}
	

}
