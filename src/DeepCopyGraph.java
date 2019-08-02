import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepCopyGraph {
	
	class GraphNode {
	   public int key;
	   public List<GraphNode> neighbors;
	   public GraphNode(int key) {
	     this.key = key;
	     this.neighbors = new ArrayList<GraphNode>();
	   }
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<GraphNode> copy(List<GraphNode> graph) {
	    List<GraphNode> result = new ArrayList<>();
	    if (graph.isEmpty()) {
	      return result;
	    }
	    Map<GraphNode, GraphNode> refreTable = new HashMap<>();
	    for (GraphNode node : graph) {
	      result.add(dfs(node, refreTable));
	    }
	    return result;
	  }
	  public GraphNode dfs (GraphNode node, Map<GraphNode, GraphNode> refreTable) {
	    if (refreTable.containsKey(node)) {
	      return refreTable.get(node);
	    }
	    GraphNode newNode = new GraphNode(node.key);
	    refreTable.put(node, newNode);
	    for (GraphNode nei : node.neighbors) {
	      newNode.neighbors.add(dfs(nei, refreTable));
	    }
	    return newNode;
	  }
}
