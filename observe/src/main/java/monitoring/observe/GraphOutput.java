package monitoring.observe;

public class GraphOutput {
	private GraphOutput() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String getAnswer(int input) {
		if(input==-1)
			return "NO SUCH TRACE";
		
		return Integer.toString(input);
	}
}
