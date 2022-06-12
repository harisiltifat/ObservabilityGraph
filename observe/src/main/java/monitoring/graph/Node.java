package monitoring.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
	//respresents position of node in the graph
    private int pos;
    
    //respresents number of hops needed to reach to this node
    private int hops;
    
    public Node(int pos, int hops) {
    	this.pos=pos;
    	this.hops = hops;
    }
	public int getHops() {
		return hops;
	}
	public int getPos() {
		return pos;
	}
}
