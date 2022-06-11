package monitoring.observe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import monitoring.exceptions.ReadGraphException;
import monitoring.graph.Node;

public class GraphReader {
	
	int[][] graph;
	GraphReader(String path){
		Objects.requireNonNull(path);
		List<String> lst=null;
		try {
			lst=Files.readAllLines(Paths.get(path));
		} catch (IOException ex) {
			throw new ReadGraphException("Graph cannot be read."+ex.getMessage());
		}
		
		if(lst.isEmpty())
			throw new ReadGraphException("Graph is empty.");
		
		readGraph(lst);
	}
	
	/**
	 * Traverse the Graph and creates a two dimensional array of the graph. 0 in the array means
	 * there is no connection between two nodes
	 * @param lst of input as a graph
	 */
	private void readGraph(List<String> lst) {
		if(lst.size()>1)
			throw new ReadGraphException("No two graphs can in the same file can be processed");
		
		String graphString=lst.get(0);
		String[] graphPaths=graphString.split(",");
		Set<Character> nodeCount=new HashSet<>();
		
		//Identifying unique nodes and put them into a hash set for later getting the count of total nodes.
		for(String str:graphPaths) {
			str=str.trim();
			if(str.length()<3 || Character.isDigit(str.charAt(0)) || Character.isDigit(str.charAt(1))) {
				throw new ReadGraphException("Invalid graph: Check the input");
			}
			nodeCount.add(str.charAt(0));
			nodeCount.add(str.charAt(1));
		}
		
		graph=new int[nodeCount.size()][nodeCount.size()];
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
			int source=str.charAt(0)-'A';
			int destination=str.charAt(1)-'A';
			graph[source][destination]=weight;
		}
		

	}
	
	public int[][] getGraph() {
		return graph;
	}
}
