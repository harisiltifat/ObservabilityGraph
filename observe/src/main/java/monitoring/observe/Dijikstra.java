package monitoring.observe;

public class Dijikstra {
	
	private static int minDistance(int dist[], Boolean sptSet[])
	{
		int V=dist.length;
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (Boolean.FALSE.equals(sptSet[v]) && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	// Function that implements Dijkstra's single source shortest path
	// algorithm for a graph represented using adjacency matrix. Worst case Time complexity O(V2) 
	// where V is the total number of vertexes.
	protected static int shortestPath(int graph[][], int src, int dest)
	{
		int V=graph.length;
		int dist[] = new int[V]; // The output array. dist[i] will hold
		//This variable helps in finding the shortest path to itself. For e.g. B to B
		int destinationCount=1;
		if(src==dest)
			destinationCount=2;

		
		// the shortest distance from src to i

		// sptSet[i] will true if vertex i is included in shortest
		// path tree or shortest distance from src to i is finalized
		Boolean sptSet[] = new Boolean[V];

		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;
		int u=-1;
		int counter=0;
		while(u!=dest || counter!=destinationCount) {
			// Pick the minimum distance vertex from the set of vertices
			// not yet processed. u is always equal to src in first
			// iteration.
			u = minDistance(dist, sptSet);
			if(u==dest)
				counter++;

			// Mark the picked vertex as processed
			sptSet[u] = true;

			// Update dist value of the adjacent vertices of the
			// picked vertex.
			for (int v = 0; v < V; v++)

				// Update dist[v] only if is not in sptSet, there is an
				// edge from u to v, and total weight of path from src to
				// v through u is smaller than current value of dist[v]
				if (Boolean.FALSE.equals(sptSet[v]) && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		
		}
		//It means no shortest path is present
		if(dist[dest]==Integer.MAX_VALUE)
			return 0;
		
		return dist[dest];
	}
	
}
