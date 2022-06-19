package monitoring.observe.graphTraversal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;
import monitoring.observe.GraphTraversal;

public class GraphTraversalAtoC4HopsTest {

	@Test(expected = NullPointerException.class)
	public void NullGraphTestAED() {
		GraphTraversal.getAverageLatencyAtoC4Hops(null);
	}

	@Test(expected = GraphTraversalException.class)
	public void EmptyGraphTestAED() {
		GraphTraversal.getAverageLatencyAtoC4Hops(new int[0][0]);
	}

	// Test Path A to C (ABDEC) with exactly 4 hops.
	@Test
	public void graphTestABDEC() {
		int[][] graph = { { 0, 1, 0, 0, 0 }, { 0, 0, 0, 2, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 5 },
				{ 0, 0, 1, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyAtoC4Hops(graph);
		assertEquals(1, latency);
	}

	// Test Path A to C (ABCDC) with exactly 4 hops.
	@Test
	public void graphTestABCDC() {
		int[][] graph = { { 0, 1, 0, 0, 0 }, { 0, 0, 3, 0, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyAtoC4Hops(graph);
		assertEquals(1, latency);
	}

	// Test Path A to C (ACBDC) with exactly 4 hops.
	@Test
	public void graphTestACBDC() {
		int[][] graph = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 7, 0 }, { 0, 2, 0, 0, 0 }, { 0, 0, 8, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyAtoC4Hops(graph);
		assertEquals(1, latency);
	}

	// Test more paths from A to C (ABDEC, ABCDC and ABCBC)with exactly 4 hops.
	@Test
	public void graphTestSeveralPaths() {
		int[][] graph = { { 0, 3, 0, 0, 0 }, { 0, 0, 5, 7, 0 }, { 0, 2, 0, 2, 0 }, { 0, 0, 1, 0, 7 },
				{ 0, 0, 5, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyAtoC4Hops(graph);
		assertEquals(3, latency);
	}

}
