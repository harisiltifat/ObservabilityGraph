package monitoring.observe.graphTraversal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;
import monitoring.observe.GraphTraversal;

public class GraphTraversalAtoCShortestTraceTest {

	@Test(expected = NullPointerException.class)
	public void NullGraphTestAED() {
		GraphTraversal.getShortestTraceAtoC(null);
	}

	@Test(expected = GraphTraversalException.class)
	public void EmptyGraphTestAED() {
		GraphTraversal.getShortestTraceAtoC(new int[0][0]);
	}

	// Test direct path A to C
	@Test
	public void graphTestAToCDirect() {
		int[][] graph = { { 0, 0, 5, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int avgLatency = GraphTraversal.getShortestTraceAtoC(graph);
		assertEquals(5, avgLatency);
	}
	
	//There are two paths from A to C. One is A to C and other is A to B to C. Later one is shorter.
	//This test should bring the later path.
	@Test
	public void graphTestAToBtoC() {
		int[][] graph = { { 0, 1, 5, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int avgLatency = GraphTraversal.getShortestTraceAtoC(graph);
		assertEquals(2, avgLatency);
	}
	
	

}
