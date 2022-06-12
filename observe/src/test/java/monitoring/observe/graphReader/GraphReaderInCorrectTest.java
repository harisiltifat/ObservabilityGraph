package monitoring.observe.graphReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import monitoring.exceptions.ReadGraphException;
import monitoring.graph.Node;
import monitoring.observe.GraphReader;

@RunWith(Parameterized.class)
public class GraphReaderInCorrectTest {
		private static final String path=  "./src/test/resources/graphs/incorrect";
		// creates the test data
		@Parameters(name = "Graph Reader Test with Incorrect {0}")
	    public static Collection<Object[]> data() {
	        Object[][] data = new Object[][]{
		        {"graph1"}
		        ,{"graph2"}
		        ,{"graph3"}
		        ,{"graph4"}
		        ,{"graph5"}
		        ,{"graph6"}
		        ,{"graph7"}
		        ,{"graph8"}
	        };
	        return Arrays.asList(data);
	    }
	    
	    // fields used together with @Parameter must be public
	    @Parameterized.Parameter(0)
	    public String graphName;

	    @Test(expected=ReadGraphException.class)
	    public void testGraph() {
			new GraphReader(path+java.io.File.separator + graphName+".txt");
	    }    
}
