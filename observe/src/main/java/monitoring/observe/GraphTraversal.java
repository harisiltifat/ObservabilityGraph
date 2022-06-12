package monitoring.observe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import monitoring.exceptions.GraphTraversalException;
import monitoring.graph.Node;

public class GraphTraversal {

	private GraphTraversal() {
		throw new IllegalStateException("Utility class");
	}

	private static void checkGraph(int[][] graph) {
		Objects.requireNonNull(graph);
		if (graph.length == 0)
			throw new GraphTraversalException("Graph map is empty");
	}

	public static int getAverageLatencyABC(int[][] graph) {
		checkGraph(graph);
		int avglatencyAB = graph[0]['B' - 'A'];
		int avglatencyBC = graph['B' - 'A']['C' - 'A'];
		if (avglatencyAB == 0 || avglatencyBC == 0)
			return -1;
		return avglatencyAB + avglatencyBC;
	}

	public static int getAverageLatencyAD(int[][] graph) {
		checkGraph(graph);
		int avglatencyAD = graph[0]['D' - 'A'];
		return avglatencyAD == 0 ? -1 : avglatencyAD;
	}

	public static int getAverageLatencyADC(int[][] graph) {
		checkGraph(graph);
		int avglatencyAD = graph[0]['D' - 'A'];
		int avglatencyDC = graph['D' - 'A']['C' - 'A'];
		if (avglatencyAD == 0 || avglatencyDC == 0)
			return -1;
		return avglatencyAD + avglatencyDC;
	}

	public static int getAverageLatencyAEBCD(int[][] graph) {
		checkGraph(graph);
		int avglatencyAE = graph[0]['E' - 'A'];
		int avglatencyEB = graph['E' - 'A']['B' - 'A'];
		int avglatencyBC = graph['B' - 'A']['C' - 'A'];
		int avglatencyCD = graph['C' - 'A']['D' - 'A'];

		if (avglatencyAE == 0 || avglatencyEB == 0 || avglatencyBC == 0 || avglatencyCD == 0)
			return -1;
		return avglatencyAE + avglatencyEB + avglatencyBC + avglatencyCD;
	}

	public static int getAverageLatencyAED(int[][] graph) {
		checkGraph(graph);
		int avglatencyAD = graph[0]['E' - 'A'];
		int avglatencyDC = graph['E' - 'A']['D' - 'A'];
		if (avglatencyAD == 0 || avglatencyDC == 0)
			return -1;
		return avglatencyAD + avglatencyDC;
	}

	/**
	 * Do a BFS. Increment hops with each level. Count the number
	 * 
	 * @param graph
	 * @return
	 */
	public static int getAverageLatencyCtoC3Hops(int[][] graph) {
		checkGraph(graph);
		// Position of c in graph
		int cpos = 2;
		int hops = 0;
		int numOfTraces = 0;
		List<Node> neighbours = getNeighbours(graph, cpos, hops);
		Queue<Node> queue = new LinkedList<>();
		queue.addAll(neighbours);

		while (!queue.isEmpty()) {
			Node neighbour = queue.poll();

			if (neighbour.getHops() < 4) {
				if (neighbour.getPos() == cpos)
					numOfTraces++;

				neighbours = getNeighbours(graph, neighbour.getPos(), neighbour.getHops());
				queue.addAll(neighbours);
			}
		}
		return numOfTraces;
	}

	private static List<Node> getNeighbours(int[][] graph, int nodePos, int hops) {
		List<Node> lst = new ArrayList<>();
		hops++;
		// Adding all childrens of c
		for (int j = 0; j < graph.length; j++) {
			// Self loop on node cannot be present. If weight is 0, then no connection is
			// present
			if (graph[nodePos][j] == 0)
				continue;
			Node node = new Node(j, hops);
			lst.add(node);
		}
		return lst;
	}

	public static int getAverageLatencyAtoC4Hops(int[][] graph) {
		checkGraph(graph);
		// Position of c in graph
		int startingPos = 0;
		int endingPos = 2;
		int hops = 0;
		int numOfTraces = 0;
		List<Node> neighbours = getNeighbours(graph, startingPos, hops);
		Queue<Node> queue = new LinkedList<>();
		queue.addAll(neighbours);

		while (!queue.isEmpty()) {
			Node neighbour = queue.poll();
			if (neighbour.getHops() == 4) {
				if(neighbour.getPos() == endingPos) {
					numOfTraces++;
				}
				continue;
			}
			neighbours = getNeighbours(graph, neighbour.getPos(), neighbour.getHops());
			queue.addAll(neighbours);
		}
		return numOfTraces;
	}
}
