package monitoring.observe;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.sun.java.util.jar.pack.Package.File;

@RunWith(Parameterized.class)
public class ObserverTest {

	// creates the test data
	@Parameterized.Parameters(name = "Test with {0}")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
	        {"graph1", 9, 5, 13, 22, "NO SUCH TRACE", 2, 3, 9, 9, 7}
	        ,{"graph2", 9, 5, 13, 22, "NO SUCH TRACE", 2, 3, 9, 9, 7}
	        ,{"graph3", 9, 5, 13, 22, "NO SUCH TRACE", 2, 3, 9, 9, 7}
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
    
    
	// The average latency of the trace A-B-C.
	@Test
	public void averageLatencyABC() {
		String path = "./graphs";
		GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName);
		
		GraphTraversal graphTraversal = new GraphTraversal(graphReader.getGraph());

		int avgLatency = graphTraversal.getAverageLatencyABC();
		assertEquals(5, avgLatency);
	}

	

}
