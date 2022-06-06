package monitoring.observe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import monitoring.exceptions.ReadGraphException;
import monitoring.graph.Node;

public class GraphReader {
	
	private Map<Character, Node> mapNodes;
	GraphReader(String path){
		Objects.requireNonNull(path);
		List<String> lst=null;
		try {
			lst=Files.readAllLines(Paths.get(path));
		} catch (IOException ex) {
			throw new ReadGraphException("Graph cannot be read."+ex.getMessage());
		}
		readGraph(lst);
	}
	
	/**
	 * Traverse the Graph and creates a corresponding HashMap. HashMap contains each node
	 * of the graph.
	 * @param lst of input as a graph
	 */
	private void readGraph(List<String> lst) {
		if(lst.size()>1)
			throw new ReadGraphException("No two graphs can in the same file can be processed");
		
		String graphString=lst.get(0);
		String[] graphPaths=graphString.split(",");
		mapNodes = new LinkedHashMap<>();
		
		for(String str:graphPaths) {
			str=str.trim();
			if(str.length()<3 || Character.isDigit(str.charAt(0)) || Character.isDigit(str.charAt(1))) {
				throw new ReadGraphException("Invalid graph: Check the input");
			}
			
			int weight;
			try {
				weight=Integer.parseInt(str.substring(2));
			}catch(NumberFormatException ex) {
				throw new ReadGraphException("Invalid graph:"+ex.getMessage());
			}
			
			Node startNode=mapNodes.getOrDefault(str.charAt(0), new Node(str.charAt(0)));
			Node endNode=mapNodes.getOrDefault(str.charAt(1), new Node(str.charAt(1)));
			startNode.addLinkNode(endNode, weight);
			mapNodes.put(str.charAt(0), startNode);
			mapNodes.put(str.charAt(1), endNode);
			
		}
		
	}
	
	public Map<Character, Node> getGraph() {
		return mapNodes;
	}
}
