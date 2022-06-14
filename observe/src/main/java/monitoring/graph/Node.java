package monitoring.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
	//respresents position of node in the graph
    private int pos;
    
    //respresents number of hops needed to reach to this node
    private int hops;
    
    private int avgLatency;
    
    public Node(int pos, int hops) {
    	this.pos=pos;
    	this.hops = hops;
    }
    
    public Node(int pos, int hops, int avgLatency) {
    	this.pos=pos;
    	this.hops = hops;
    	this.avgLatency=avgLatency;
    }
	public int getHops() {
		return hops;
	}
	public int getPos() {
		return pos;
	}
	public int getAvgLatency() {
		return avgLatency;
	}
	
}
