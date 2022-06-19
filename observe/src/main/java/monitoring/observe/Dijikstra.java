package monitoring.observe;

import java.util.List;
import java.util.PriorityQueue;

import monitoring.exceptions.GraphTraversalException;
import monitoring.tracking.NodeTrack;

public class Dijikstra {
	
	private Dijikstra() {
		throw new IllegalStateException("Utility class");
	}

	// Function that implements Dijkstra's single source shortest path
	// algorithm for a graph represented using Priority Queue. Worst case Time
	// complexity O(E + VlogV). Where E is the total number of edges and V is the total number of vertexes. 
	protected static int shortestPath(int graph[][], int src, int dest) {
		if(graph==null)
			throw new GraphTraversalException("Graph is null. Dijikstra can't be executed.");
		
		PriorityQueue<NodeTrack> queue = new PriorityQueue<>((x, y) -> x.getAvgLatency() - y.getAvgLatency());

		//Distance array that represents shortest distance from source to each vertex.
		int dist[] = new int[graph.length];


		// Initialize all distances as INFINITE
		for (int i = 0; i < graph.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		List<NodeTrack> neighbours = Neighbours.getNeighbours(graph, src, 0, 0);
		
		//Updating distance array of neighbours of source vertex
		for(NodeTrack neighboursNode:neighbours) {
			dist[neighboursNode.getPos()]=neighboursNode.getAvgLatency();
		}
		queue.addAll(neighbours);

		while (!queue.isEmpty()) {
			NodeTrack node = queue.poll();
			//destination Node found with shortest distance.
			if(node.getPos()==dest) {
				return node.getAvgLatency();
			}
			neighbours=Neighbours.getNeighbours(graph, node.getPos(), 0, node.getAvgLatency());
			
			//Add neighbour into queue as a node if the distance to reach it is less than the previously
			//calculated distance.
			for(NodeTrack neighboursNode:neighbours) {
				if(neighboursNode.getAvgLatency() < dist[neighboursNode.getPos()]) {
					dist[neighboursNode.getPos()]=neighboursNode.getAvgLatency();
					queue.add(neighboursNode);
				}
			}
		}
		// It means no shortest path is present
		if (dist[dest] == Integer.MAX_VALUE)
			return 0;

		return dist[dest];
	}

}
