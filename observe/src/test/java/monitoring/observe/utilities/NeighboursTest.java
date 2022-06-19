package monitoring.observe.utilities;

import org.junit.Test;

import monitoring.exceptions.GraphTraversalException;

public class NeighboursTest {
	@Test(expected = GraphTraversalException.class)
	public void NullGraphTest() {
		Neighbours.getNeighbours(null, 0, 0);
	}
	
	@Test(expected = GraphTraversalException.class)
	public void NullGraphTest2() {
		Neighbours.getNeighbours(null, 0, 0,1);
	}
}
