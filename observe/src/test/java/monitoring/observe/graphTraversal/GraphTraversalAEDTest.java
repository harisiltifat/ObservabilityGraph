package monitoring.observe.graphTraversal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;
import monitoring.observe.GraphTraversal;

public class GraphTraversalAEDTest {

	@Test(expected = NullPointerException.class)
	public void NullGraphTestAED() {
		GraphTraversal.getAverageLatencyAED(null);
	}

	@Test(expected = GraphTraversalException.class)
	public void EmptyGraphTestAED() {
		GraphTraversal.getAverageLatencyAED(new int[0][0]);
	}

	// Test when only AE path is present.
	@Test
	public void graphTestAEDWithAE() {
		int[][] graph = { { 0, 0, 0, 0, 5 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyAED(graph);
		assertEquals(-1, latency);
	}

	// Test when only ED path is present.
	@Test
	public void graphTestAEDwitchED() {
		int[][] graph = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 6, 0, 0 },
				{ 0, 0, 0, 1, 0 } };
		int latency = GraphTraversal.getAverageLatencyAED(graph);
		assertEquals(-1, latency);
	}


	
	// Test with valid graph where AED path is present
	@Test
	public void graphTestAEDValid() {
		int[][] graph = { { 0, 0, 0, 0, 5 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 } };
		int latency = GraphTraversal.getAverageLatencyAED(graph);
		assertEquals(6, latency);
	}
}
