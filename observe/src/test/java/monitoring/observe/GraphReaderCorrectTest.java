package monitoring.observe;

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

import monitoring.graph.Node;

@RunWith(Parameterized.class)
public class GraphReaderCorrectTest {
		private static final String path=  "./src/test/resources/graphs/correct";
	// creates the test data
		@Parameters(name = "Graph Reader Test with correct {0}")
	    public static Collection<Object[]> data() {
	        Object[][] data = new Object[][]{
		        {"graph1",5,8,5}
		        ,{"graph2",5,8,4}
		        ,{"graph3",5,10,4}
	        };
	        return Arrays.asList(data);
	    }
	    
	    // fields used together with @Parameter must be public
	    @Parameterized.Parameter(0)
	    public String graphName;
	    
	    // fields used together with @Parameter must be public
	    @Parameterized.Parameter(1)
	    public int atob;
	    
	    @Parameterized.Parameter(2)
	    public int ctod;
	    
	    @Parameterized.Parameter(3)
	    public int nodesCount;
	    
	    @Test(expected=NullPointerException.class)
	    public void testNullGraphName() {
	    	new GraphReader(null);
	    }
	    
	    @Test
	    public void testcountGraphNodes() {
			GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");
	    	int[][] graph=graphReader.getGraph();
	    	int count=graph.length;
	    	assertEquals(nodesCount,count);
	    }
	    
	    @Test
	    public void testcorrectGraphPaths() {
			GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");

			int[][] graph=graphReader.getGraph();
	    	List<Integer> lstWeight=new ArrayList<>();

	    	int weightAB=graph['A'-'A']['B'-'A'];

	       	int weightCD=graph['C'-'A']['D'-'A'];
	    	lstWeight.add(weightAB);
	    	lstWeight.add(weightCD);
	    	
	    	Integer[] weights= {atob,ctod}; 
	    	List<Integer> lst2=new ArrayList<>(Arrays.asList(weights));
	    	assertTrue(lstWeight.equals(lst2));
	    }
	    
}
