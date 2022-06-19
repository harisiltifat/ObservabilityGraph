package monitoring.observe.graphTraversal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;
import monitoring.observe.GraphTraversal;

public class GraphTraversalCtoC30LatencyTest {

	@Test(expected = NullPointerException.class)
	public void NullGraphTestAED() {
		GraphTraversal.getTracesCtoC3Hops(null);
	}

	@Test(expected = GraphTraversalException.class)
	public void EmptyGraphTestAED() {
		GraphTraversal.getTracesCtoC30Latency(new int[0][0]);
	}

	// Test Path C to C (CAC)
	@Test
	public void graphTestCtoCWith1loop() {
		int[][] graph = { { 0, 0, 15, 0, 0 }, { 0, 0, 0, 0, 0 }, { 14, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getTracesCtoC30Latency(graph);
		assertEquals(1, latency);
	}

	// Test Path C to C (CAC, CACBC, CBC, CBCAC, CBCBC, CBCBCBC)
	@Test
	public void graphTestCtoCWith2loop() {
		int[][] graph = { { 0, 0, 10, 0, 0 }, { 0, 0, 5, 0, 0 }, { 10, 3, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int latency = GraphTraversal.getTracesCtoC30Latency(graph);
		assertEquals(6, latency);
	}
	
	// Test Path C to C (CABC, CABABC)
	@Test
	public void graphTestCtoCWithABloop() {
			int[][] graph = { { 0, 5, 0, 0, 0 }, { 5, 0, 4, 0, 0 }, { 10, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0 } };
			int latency = GraphTraversal.getTracesCtoC30Latency(graph);
			assertEquals(2, latency);
	}
}
