import mid2.MaxPathSum.TreeNode;

public class LCAIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).

Return null If any of the nodes is not in the tree.

Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes are not guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
	 */
	public class TreeNode {
	    public int key;
	    public TreeNode left;
	    public TreeNode right;
	    public TreeNode(int key) {
	      this.key = key;
	    }
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
	    // write your solution here
      TreeNode result = helper(root, one, two);
		  if (result == one) {
        if (helper(one, two, two) == null) {
          return null;
        }
      } else if (result == two) {
        if (helper(two, one, one) == null) {
          return null;
        }
      }
      return result;
	}
  public TreeNode helper(TreeNode root, TreeNode one, TreeNode two) {
	    // write your solution here
		if (root == null || root == one || root == two) {
			return root;
		}
		
		TreeNode left = helper(root.left, one, two);
		TreeNode right = helper(root.right, one, two);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
  }

}
