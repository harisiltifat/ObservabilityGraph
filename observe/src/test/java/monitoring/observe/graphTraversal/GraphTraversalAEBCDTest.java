package monitoring.observe.graphTraversal;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;
import monitoring.observe.GraphTraversal;

public class GraphTraversalAEBCDTest {

	@Test(expected = NullPointerException.class)
	public void NullGraphTestAEBCD() {
		GraphTraversal.getAverageLatencyAEBCD(null);
	}

	@Test(expected = GraphTraversalException.class)
	public void EmptyGraphTestAEBCD() {
		GraphTraversal.getAverageLatencyAEBCD(new int[0][0]);
	}

	// Test when only AE path is present.
	@Test
	public void graphTestAEBCDWithAE() {
		int[][] graph = { { 0, 0, 0, 0, 5 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyAEBCD(graph);
		assertTrue(latency == -1);
	}

	// Test when only EB path is present.
	@Test
	public void graphTestAEBCDwitchEB() {
		int[][] graph = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyAEBCD(graph);
		assertTrue(latency == -1);
	}

	// Test when only BC path is present.
	@Test
	public void graphTestAEBCDwithBC() {
		int[][] graph = { { 0, 0, 0, 0, 0 }, { 0, 0, 6, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyAEBCD(graph);
		assertTrue(latency == -1);
	}

	// Test when only BC path is present.
	@Test
	public void graphTestAEBCDwithCD() {
		int[][] graph = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 10, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyAEBCD(graph);
		assertTrue(latency == -1);
	}

	// Test with valid graph where AEBCD path is present
	@Test
	public void graphTestAEBCDValid() {
		int[][] graph = { { 0, 0, 0, 0, 5 }, { 0, 0, 2, 0, 0 }, { 0, 0, 0, 100, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 3, 0, 0, 0 } };
		int latency = GraphTraversal.getAverageLatencyAEBCD(graph);
		assertTrue(latency == 110);
	}
}
