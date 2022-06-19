package monitoring.tracking;

/**
 * Use to track the progress of graph traversal.
 * @author iltifat
 *
 */
public class NodeTrack {
	//respresents position of node in the graph
    private int pos;
    
    //respresents number of hops needed to reach to this node
    private int hops;
    
    //respresents total average latency required to reach this node
    private int avgLatency;
    
    public NodeTrack(int pos, int hops) {
    	this.pos=pos;
    	this.hops = hops;
    }
    
    public NodeTrack(int pos, int hops, int avgLatency) {
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
