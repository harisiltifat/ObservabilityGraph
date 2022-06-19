package monitoring.observe.utilities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import monitoring.observe.utilities.GraphOutput;

public class GraphOutputTest {

	@Test
	public void testGraphOuput() {
		assertEquals("5",GraphOutput.getAnswer(5));
	}
	
	@Test
	public void testGraphOuputNoSuchTrace() {
		assertEquals("NO SUCH TRACE",GraphOutput.getAnswer(-1));
	}
}
