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

	// Test if path from B to C is not present
	@Test
	public void graphTestBToBNotPresent() {
		int[][] graph = { { 0, 0, 4, 0, 0 }, { 1, 0, 0, 0, 0 }, { 5, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int avgLatency = GraphTraversal.getShortestTraceBtoB(graph);
		assertEquals(0, avgLatency);
	}

	// Test path BAB
	@Test
	public void graphTestBToBDirect() {
		int[][] graph = { { 0, 2, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int avgLatency = GraphTraversal.getShortestTraceBtoB(graph);
		assertEquals(3, avgLatency);
	}

	// Test path BAB and BCDB. BCDB is the shortest path. This test is to check the
	// if the length do not
	// play any role in bringing the correct path.
	@Test
	public void graphTestBAB_BCDB() {
		int[][] graph = { { 0, 2, 0, 0, 0 }, { 10, 0, 4, 0, 0 }, { 0, 0, 0, 5, 0 }, { 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int avgLatency = GraphTraversal.getShortestTraceBtoB(graph);
		assertEquals(10, avgLatency);
	}

}
