package monitoring.observe;

import java.util.Objects;

import monitoring.exceptions.GraphTraversalException;

public class GraphTraversal {
	
	private GraphTraversal() {
		throw new IllegalStateException("Utility class");
	}
	
	private static void checkGraph(int[][] graph) {
		Objects.requireNonNull(graph);
		if(graph.length==0)
			throw new GraphTraversalException("Graph map is empty");
	}
	
	public static int getAverageLatencyABC(int[][] graph) {
		checkGraph(graph);
		int avglatencyAB=graph[0]['B'-'A'];
		int avglatencyBC = graph['B'-'A']['C'-'A'];
		if(avglatencyAB==0 || avglatencyBC==0)
			return -1;
		return avglatencyAB + avglatencyBC;
	}

}
