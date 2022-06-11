package monitoring.observe.graphTraversal;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;
import monitoring.observe.GraphTraversal;

public class GraphTraversalABCTest {

	@Test(expected = NullPointerException.class)
	public void NullGraphTestABC() {
		GraphTraversal.getAverageLatencyABC(null);
	}

	@Test(expected = GraphTraversalException.class)
	public void EmptyGraphTestABC() {
		GraphTraversal.getAverageLatencyABC(new int[0][0]);
	}

	// Test when only no path is present.
	@Test
	public void graphTestABCWithNoPath() {
		int[][] graph = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyABC(graph);
		assertTrue(latency == -1);
	}

	// Test when only AB path is present.
	@Test
	public void graphTestABCWithAB() {
		int[][] graph = { { 0, 3, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyABC(graph);
		assertTrue(latency == -1);
	}

	// Test when only BC path is present.
	@Test
	public void graphTestABCWithBC() {
		int[][] graph = { { 0, 0, 0, 0, 0 }, { 0, 0, 5, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyABC(graph);
		assertTrue(latency == -1);
	}

	// Test when only BC path is present.
	@Test
	public void graphTestABCValid() {
		int[][] graph = { { 0, 5, 0, 0, 0 }, { 0, 0, 5, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyABC(graph);
		assertTrue(latency == 10);
	}

}
