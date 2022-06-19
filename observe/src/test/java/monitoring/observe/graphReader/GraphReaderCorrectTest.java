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

import monitoring.observe.GraphReader;
import monitoring.tracking.NodeTrack;

@RunWith(Parameterized.class)
public class GraphReaderCorrectTest {
		private static final String path=  "./src/test/resources/graphs/correct";
	// creates the test data
		@Parameters(name = "Graph Reader Test with correct {0}")
	    public static Collection<Object[]> data() {
	        Object[][] data = new Object[][]{
		        {"graph1",'A','B',5, 'A','E',7}
		        ,{"graphWithoutDescription",'B','A',5, 'D','A',2}
	        };
	        return Arrays.asList(data);
	    }
	    
	    @Parameterized.Parameter(0)
	    public String graphName;
	    
	    @Parameterized.Parameter(1)
	    public char firstNode;
	    
	    @Parameterized.Parameter(2)
	    public char secondNode;
	    
	    @Parameterized.Parameter(3)
	    public int weightFirstPath;
	    
	    @Parameterized.Parameter(4)
	    public char secondLastNode;
	    
	    @Parameterized.Parameter(5)
	    public char lastNode;
	    
	    @Parameterized.Parameter(6)
	    public int weightLastPath;
	    
	    @Test(expected=NullPointerException.class)
	    public void testNullGraphName() {
	    	new GraphReader(null);
	    }
	    
	    //Test the start path and end path. If they are correctly represented in the graph then remaining should be correctly represented as well.
	    @Test
	    public void testcorrectGraphPaths() {
			GraphReader graphReader = new GraphReader(path+java.io.File.separator + graphName+".txt");

			int[][] graph=graphReader.getGraph();
	    	List<Integer> lstWeight=new ArrayList<>();

	    	int weightGraphFirstPath=graph[firstNode-'A'][secondNode-'A'];

	       	int weightGraphLastPath=graph[secondLastNode-'A'][lastNode-'A'];
	    	lstWeight.add(weightGraphFirstPath);
	    	lstWeight.add(weightGraphLastPath);
	    	
	    	Integer[] weights= {weightFirstPath,weightLastPath}; 
	    	List<Integer> lst2=new ArrayList<>(Arrays.asList(weights));
	    	assertTrue(lstWeight.equals(lst2));
	    }
	    
}
