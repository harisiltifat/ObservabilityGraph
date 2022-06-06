package monitoring.observe;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

import monitoring.exceptions.GraphTraversalException;
import monitoring.graph.Node;

public class GraphTraversal {
	private int avgLatencyABC;
	
	public GraphTraversal(Map<Character, Node> mapGraph) {
		Objects.requireNonNull(mapGraph);
		if(mapGraph.size()==0)
			throw new GraphTraversalException("Graph map is empty");
		
		traverseGraph(mapGraph);
	}
	
	/**
	 * Traverste the graph in Breadth first fashion. Once the node is visited, it wouldn't be
	 * traversed again
	 * @param mapGraph
	 */
	private void traverseGraph(Map<Character, Node> mapGraph) {
		Node startingNode=null;
		for(Character key:mapGraph.keySet()) {
			startingNode=mapGraph.get(key);
		}
		
		Queue<Node> queue=new LinkedList<>();
		Set<Node> visited=new HashSet<>();
		queue.add(startingNode);
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			for(Entry<Node, Integer> entry:node.getLinkedNodes().entrySet()) {
				
			}
		}
		
		
	}

}
