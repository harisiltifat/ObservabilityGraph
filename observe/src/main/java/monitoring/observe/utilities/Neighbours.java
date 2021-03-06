package monitoring.observe.utilities;

import java.util.ArrayList;
import java.util.List;

import monitoring.exceptions.GraphTraversalException;
import monitoring.tracking.NodeTrack;

public class Neighbours {
	
	private Neighbours() {
		throw new IllegalStateException("Utility class");
	}
	/**
	 * Get neighbours of a node. While getting Neighbours, a Node object is used to save the position of the neighbour
	 * ,total number of hops and total average latency required to reach that neighbour from source.
	 * @param graph
	 * @param nodePos
	 * @param hops
	 * @param avgLatency
	 * @return
	 */
	public static List<NodeTrack> getNeighbours(int[][] graph, int nodePos, int hops, int avgLatency) {
		if(graph==null)
			throw new GraphTraversalException("Graph is null. Method getNeighbours can't be executed.");
		return getMyNeighbours(graph, nodePos, hops, avgLatency);
	}
	
	/**
	 * Get neighbours of a node. While getting Neighbours, a Node object is used to save the position of the neighbour
	 * ,total number of hops required to reach that neighbour from source.
	 * @param graph
	 * @param nodePos
	 * @param hops
	 * @param avgLatency
	 * @return
	 */
	public static List<NodeTrack> getNeighbours(int[][] graph, int nodePos, int hops) {
		if(graph==null)
			throw new GraphTraversalException("Graph is null. Method getNeighbours can't be executed.");
		return getMyNeighbours(graph, nodePos, hops, 0);
	}

	private static List<NodeTrack> getMyNeighbours(int[][] graph, int nodePos, int hops, int avgLatency) {
		List<NodeTrack> lst = new ArrayList<>();
		hops++;
		// Adding all childrens of c
		for (int j = 0; j < graph.length; j++) {
			// Self loop on node cannot be present. If weight is 0, then no connection is
			// present
			if (graph[nodePos][j] == 0)
				continue;
			
			NodeTrack node = new NodeTrack(j, hops, avgLatency + graph[nodePos][j]);
			lst.add(node);
		}
		return lst;
	}
}
