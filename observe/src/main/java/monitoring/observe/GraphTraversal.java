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
	
	public static int getAverageLatencyAD(int[][] graph) {
		checkGraph(graph);
		int avglatencyAD=graph[0]['D'-'A'];
		return avglatencyAD == 0 ? -1 : avglatencyAD;
	}
	
	public static int getAverageLatencyADC(int[][] graph) {
		checkGraph(graph);
		int avglatencyAD=graph[0]['D'-'A'];
		int avglatencyDC = graph['D'-'A']['C'-'A'];
		if(avglatencyAD==0 || avglatencyDC==0)
			return -1;
		return avglatencyAD + avglatencyDC;
	}
	
	
	public static int getAverageLatencyAEBCD(int[][] graph) {
		checkGraph(graph);
		int avglatencyAE=graph[0]['E'-'A'];
		int avglatencyEB = graph['E'-'A']['B'-'A'];
		int avglatencyBC = graph['B'-'A']['C'-'A'];
		int avglatencyCD = graph['C'-'A']['D'-'A'];
		
		if(avglatencyAE==0 || avglatencyEB==0 || avglatencyBC==0 || avglatencyCD==0)
			return -1;
		return avglatencyAE + avglatencyEB + avglatencyBC + avglatencyCD;
	}
	
	public static int getAverageLatencyAED(int[][] graph) {
		checkGraph(graph);
		int avglatencyAD=graph[0]['E'-'A'];
		int avglatencyDC = graph['E'-'A']['D'-'A'];
		if(avglatencyAD==0 || avglatencyDC==0)
			return -1;
		return avglatencyAD + avglatencyDC;
	}
	

}
