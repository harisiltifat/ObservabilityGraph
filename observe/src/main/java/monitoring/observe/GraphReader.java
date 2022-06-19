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

import monitoring.exceptions.GraphReadException;
import monitoring.tracking.NodeTrack;

public class GraphReader {
	
	//Only A to E Microservices will be entertained
	int[][] graph = new int[5][5];
	public GraphReader(String path){
		Objects.requireNonNull(path);
		List<String> lst=null;
		try {
			lst=Files.readAllLines(Paths.get(path));
		} catch (IOException ex) {
			throw new GraphReadException("Graph cannot be read."+ex.getMessage());
		}
		
		if(lst.isEmpty())
			throw new GraphReadException("Graph is empty.");
		
		readGraph(lst);
	}
	
	/**
	 * Traverse the Graph and creates a two dimensional array of the graph. 0 in the array means
	 * there is no connection between two nodes
	 * @param lst of input as a graph
	 */
	private void readGraph(List<String> lst) {
		if(lst.size()>2)
			throw new GraphReadException("No two graphs can in the same file can be processed");
		
		int validGraph=0;
		if(lst.get(0).contains("//")) 
			validGraph++;
		
		String graphString=lst.get(validGraph);
		String[] graphPaths=graphString.split(",");

		for(String str:graphPaths) {
			str=str.trim();
			if(str.length()<3 || Character.isDigit(str.charAt(0)) || Character.isDigit(str.charAt(1))) {
				throw new GraphReadException("Invalid graph: Check the input");
			}
			int weight;
			try {
				weight=Integer.parseInt(str.substring(2));
			}catch(NumberFormatException ex) {
				throw new GraphReadException("Invalid graph:"+ex.getMessage());
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
