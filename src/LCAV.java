import java.util.ArrayList;
import java.util.List;

public class LCAV {
	public class KnaryTreeNode {
		int key;
	    List<KnaryTreeNode> children;
	    public KnaryTreeNode(int key) {
	    	this.key = key;
	        this.children = new ArrayList<>();
	    }
	}
	 
	/*
	 * Given two nodes in a K-nary tree, find their lowest common ancestor.

Assumptions

-There is no parent pointer for the nodes in the K-nary tree.

-The given two nodes are guaranteed to be in the K-nary tree.

Examples



        5

      /   \

     9   12

   / | \      \

 1 2   3      14



The lowest common ancestor of 2 and 14 is 5.

The lowest common ancestor of 2 and 9 is 9.


	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
	    // Write your solution here
	    if (root == null || root == a || root == b) {
	      return root;
	    }
	    KnaryTreeNode found = null;
	    for (KnaryTreeNode child : root.children) {
      	KnaryTreeNode temp = lowestCommonAncestor(child, a, b);
	    	if (temp == null) {
	    		continue;
	    	}
        if (found == null) {
          found = temp ;
        } else {
          return root;
        }
	    }
	    return found;
	}

}
