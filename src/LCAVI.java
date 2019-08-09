import java.util.ArrayList;
import java.util.List;

public class LCAVI {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Given M nodes in a K-nary tree, find their lowest common ancestor.

Assumptions

- M >= 2.

- There is no parent pointer for the nodes in the K-nary tree.

- The given M nodes are guaranteed to be in the K-nary tree.

Examples

        5

      /   \

     9   12

   / | \      \

  1 2 3     14



The lowest common ancestor of 2, 3, 14 is 5.

The lowest common ancestor of 2, 3, 9 is 9.
	 
*/
	public class KnaryTreeNode {
	      int key;
	      List<KnaryTreeNode> children;
	      public KnaryTreeNode(int key) {
	          this.key = key;
	          this.children = new ArrayList<>();
	      }
	  }
	
	public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
	    // Write your solution here
	    if (nodes.contains(root) || root == null) {
	      return root;
	    }
	    KnaryTreeNode found = null;
	    for (KnaryTreeNode node : root.children) {
	      KnaryTreeNode temp = lowestCommonAncestor(node, nodes);
	      if (temp == null) {
	        continue;
	      } 
	      if (found == null) {
	        found = temp;
	      } else {
	        return root;
	      }
	    }
	    return found;
	  }

}
