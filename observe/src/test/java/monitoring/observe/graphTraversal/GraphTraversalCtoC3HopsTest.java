package monitoring.observe.graphTraversal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;
import monitoring.observe.GraphTraversal;

public class GraphTraversalCtoC3HopsTest {

	@Test(expected = NullPointerException.class)
	public void NullGraphTestAED() {
		GraphTraversal.getAverageLatencyCtoC3Hops(null);
	}

	@Test(expected = GraphTraversalException.class)
	public void EmptyGraphTestAED() {
		GraphTraversal.getAverageLatencyCtoC3Hops(new int[0][0]);
	}

	// Test Path C to C with 2 hops.
	@Test
	public void graphTestCtoCWith2hops() {
		int[][] graph = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyCtoC3Hops(graph);
		assertEquals(1, latency);
	}

	// Test Path C to C with 3 hops.
	@Test
	public void graphTestCtoCWith3hops() {
		int[][] graph = { { 0, 3, 0, 0, 0 }, { 0, 0, 2, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyCtoC3Hops(graph);
		assertEquals(1, latency);
	}

	// Test Path C to C with 4 hops.
	@Test
	public void graphTestCtoCWith4hops() {
		int[][] graph = { { 0, 3, 0, 0, 0 }, { 0, 0, 0, 5, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyCtoC3Hops(graph);
		assertEquals(0, latency);
	}
}
