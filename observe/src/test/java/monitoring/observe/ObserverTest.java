package monitoring.observe;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ObserverTest {

	// creates the test data
	@Parameterized.Parameters(name = "Test with {0}")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
	        {"graph1", 9, 5, 13, 22, -1, 2, 3, 9, 9, 7}
	        ,{"graph2", -1, -1, -1, -1, -1, 2, 3, 9, 9, 7}
	        ,{"graph3", -1, 5, -1, -1, -1, 2, 3, 9, 9, 7}  
	        ,{"graph4", -1, -1, -1, -1, -1, 2, 3, 9, 9, 7}
	        ,{"graphWithoutDescription", -1, -1, -1, -1, -1, 2, 3, 9, 9, 7}
        };
        return Arrays.asList(data);
    }
    
    // fields used together with @Parameter must be public
    @Parameterized.Parameter(0)
    public String graphName;
    @Parameterized.Parameter(1)
    //abc represents average latency of trace a-b-c
    public int abc;
    //ad represents average latency of trace a-d
    @Parameterized.Parameter(2)
    public int ad;
    //adc represents average latency of trace a-d-c
    @Parameterized.Parameter(3)
    public int adc;
    //aebcd represents average latency of trace a-e-b-c-d
    @Parameterized.Parameter(4)
    public int aebcd;
    //aed represents average latency of trace a-e-d
    @Parameterized.Parameter(5)
    public int aed;
    //cc represents the number of traces originating in service C and ending in service C with a maximum of 3 hops.
    @Parameterized.Parameter(6)
    public int cc;
    //ac represents The number of traces originating in A and ending in C with exactly 4 hops.
    @Parameterized.Parameter(7)
    public int ac;
    //The length of the shortest trace (in terms of latency) between A and C.
    @Parameterized.Parameter(8)
    public int acShortestLength;
    //The length of the shortest trace (in terms of latency) between B and B.
    @Parameterized.Parameter(9)
    public int bbShortestLength;
    
    //The number of different traces from C to C with an average latency of less than 30
    @Parameterized.Parameter(10)
    public int cc30;
    
    
	// The average latency of the trace A-B-C.
	@Test
	public void averageLatencyABC() {
		String path = "./src/test/resources/graphs/correct";
		GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");
		int avgLatency = GraphTraversal.getAverageLatencyABC(graphReader.getGraph());
		assertEquals(abc, avgLatency);
	}
	
	@Test
	public void averageLatencyAD() {
		String path = "./src/test/resources/graphs/correct";
		GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");
		int avgLatency = GraphTraversal.getAverageLatencyAD(graphReader.getGraph());
		assertEquals(ad, avgLatency);
	}

	@Test
	public void averageLatencyADC() {
		String path = "./src/test/resources/graphs/correct";
		GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");
		int avgLatency = GraphTraversal.getAverageLatencyADC(graphReader.getGraph());
		assertEquals(adc, avgLatency);
	}
	
	@Test
	public void averageLatencyAEBCD() {
		String path = "./src/test/resources/graphs/correct";
		GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");
		int avgLatency = GraphTraversal.getAverageLatencyAEBCD(graphReader.getGraph());
		assertEquals(aebcd, avgLatency);
	}
	
	@Test
	public void averageLatencyAED() {
		String path = "./src/test/resources/graphs/correct";
		GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");
		int avgLatency = GraphTraversal.getAverageLatencyAED(graphReader.getGraph());
		assertEquals(aed, avgLatency);
	}
	
	@Test
	public void tracesCtoC3Hops() {
		String path = "./src/test/resources/graphs/correct";
		GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");
		int tracesCtoC = GraphTraversal.getTracesCtoC3Hops(graphReader.getGraph());
		assertEquals(cc, tracesCtoC);
	}
	
	@Test
	public void tracesAtoC4Hops() {
		String path = "./src/test/resources/graphs/correct";
		GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");
		int tracesAtoC = GraphTraversal.getTracesAtoC4Hops(graphReader.getGraph());
		assertEquals(ac, tracesAtoC);
	}
	
	@Test
	public void tracesCtoC30Latency() {
		String path = "./src/test/resources/graphs/correct";
		GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");
		int tracesAtoC = GraphTraversal.getTracesCtoC30Latency(graphReader.getGraph());
		assertEquals(cc30, tracesAtoC);
	}
	
	@Test
	public void shortestlengthTraceAtoC() {
		String path = "./src/test/resources/graphs/correct";
		GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");
		int tracesAtoC = GraphTraversal.getShortestTraceAtoC(graphReader.getGraph());
		assertEquals(acShortestLength, tracesAtoC);
	}
	
	@Test
	public void shortestlengthTraceBtoB() {
		String path = "./src/test/resources/graphs/correct";
		GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");
		int tracesBtoB = GraphTraversal.getShortestTraceBtoB(graphReader.getGraph());
		assertEquals(bbShortestLength, tracesBtoB);
	}

}
