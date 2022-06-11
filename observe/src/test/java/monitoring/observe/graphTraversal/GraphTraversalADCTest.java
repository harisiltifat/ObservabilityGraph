package monitoring.observe.graphTraversal;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;
import monitoring.observe.GraphTraversal;

public class GraphTraversalADCTest {

	@Test(expected = NullPointerException.class)
	public void NullGraphTestADC() {
		GraphTraversal.getAverageLatencyADC(null);
	}

	@Test(expected = GraphTraversalException.class)
	public void EmptyGraphTestADC() {
		GraphTraversal.getAverageLatencyADC(new int[0][0]);
	}

	// Test when only AD path is present.
	@Test
	public void graphTestADCWithAD() {
		int[][] graph = { { 0, 0, 0, 5, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyADC(graph);
		assertTrue(latency == -1);
	}

	// Test when only EB path is present.
	@Test
	public void graphTestADCwitchDC() {
		int[][] graph = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 6, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyADC(graph);
		assertTrue(latency == -1);
	}


	
	// Test with valid graph where ADC path is present
	@Test
	public void graphTestADCValid() {
		int[][] graph = { { 0, 0, 0, 4, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 4, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyADC(graph);
		assertTrue(latency == 8);
	}
}
