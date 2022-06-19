package monitoring.observe.graphTraversal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;
import monitoring.observe.GraphTraversal;

public class GraphTraversalADTest {

	@Test(expected = NullPointerException.class)
	public void NullGraphTestAEBCD() {
		GraphTraversal.getAverageLatencyAD(null);
	}

	@Test(expected = GraphTraversalException.class)
	public void EmptyGraphTestAEBCD() {
		GraphTraversal.getAverageLatencyAD(new int[0][0]);
	}

	// Test AD is not present
	@Test
	public void graphTestAD() {
		int[][] graph = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyAD(graph);
		assertEquals(-1, latency);
	}

	
	// Test with valid graph where AD path is present
	@Test
	public void graphTestADValid() {
		int[][] graph = { { 0, 0, 0, 6, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyAD(graph);
		assertEquals(6, latency);
	}
}
