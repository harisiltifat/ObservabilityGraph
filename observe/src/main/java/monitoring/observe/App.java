package monitoring.observe;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if(args==null || args.length==0)
    		throw new IllegalArgumentException("File path not provided in the arguments");
    	
    	String path = args[0];
		GraphReader graphReader = new GraphReader(path);
		int[][] graph=graphReader.getGraph();
		int avgLatencyABC = GraphTraversal.getAverageLatencyABC(graph);
		System.out.println("1."+GraphOutput.getAnswer(avgLatencyABC));
		
		int avgLatencyAD = GraphTraversal.getAverageLatencyAD(graph);
		System.out.println("2."+GraphOutput.getAnswer(avgLatencyAD));
		
		int avgLatencyADC = GraphTraversal.getAverageLatencyADC(graph);
		System.out.println("3."+GraphOutput.getAnswer(avgLatencyADC));
		
		int avgLatencyAEBCD = GraphTraversal.getAverageLatencyAEBCD(graph);
		System.out.println("4."+GraphOutput.getAnswer(avgLatencyAEBCD));
		
		int avgLatencyAED = GraphTraversal.getAverageLatencyAED(graph);
		System.out.println("5."+GraphOutput.getAnswer(avgLatencyAED));
		
		int tracesCtoC3hops = GraphTraversal.getTracesCtoC3Hops(graph);
		System.out.println("6."+GraphOutput.getAnswer(tracesCtoC3hops));
		
		int tracesAtoC4hops = GraphTraversal.getTracesAtoC4Hops(graph);
		System.out.println("7."+GraphOutput.getAnswer(tracesAtoC4hops));
		
		int shortestLengthAtoC = GraphTraversal.getShortestTraceAtoC(graph);
		System.out.println("8."+GraphOutput.getAnswer(shortestLengthAtoC));
		
		int shortestLengthBtoB = GraphTraversal.getShortestTraceBtoB(graph);
		System.out.println("9."+GraphOutput.getAnswer(shortestLengthBtoB));
		
		int tracesCtoC30Latency = GraphTraversal.getTracesCtoC30Latency(graph);
		System.out.println("10."+GraphOutput.getAnswer(tracesCtoC30Latency));
		
    }
}
