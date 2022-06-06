package monitoring.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    Map<Node, Integer> mapLinkedNodes=new HashMap<>();
    Map<List<Node>, Integer> reachingPaths= new HashMap<>();
    Character name;

	public Node(Character name){
		this.name=name;
	}
	//A given connection will never appear more than once and for a given
	//connection the starting and ending service will not be the same service.
	public void addLinkNode(Node endNode, int weight) {
		mapLinkedNodes.put(endNode, weight);
	}
	
	public Map<Node, Integer> getLinkedNodes(){
		return mapLinkedNodes;
	}
	
	
	
	
}
