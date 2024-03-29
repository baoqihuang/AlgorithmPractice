
public class ClosetNumInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * In a binary search tree, find the node containing the closest number to the given target number.

Assumptions:

The given root is not null.
There are no duplicate keys in the binary search tree.
Examples:

    5

  /    \

2      11

     /    \

    6     14

closest number to 4 is 5

closest number to 10 is 11

closest number to 6 is 6

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
	 */
	public static class TreeNode {
		public int key;
	    public TreeNode left;
	    public TreeNode right;
	    public TreeNode(int key) {
	    	this.key = key;
	    }
	}
	public int closest(TreeNode root, int target) {
	    // Write your solution here
		int cloest = Integer.MIN_VALUE;
		int minD = Integer.MAX_VALUE;
		while (root != null) {
			int curD = Math.abs(root.key - target);
			if (curD == 0) {
				return root.key;
			} else if (root.key > target) {
				if (curD < minD) {
					minD = curD;
					cloest = root.key;
				}
				root = root.left;
			} else {
				if (curD < minD) {
					minD = curD;
					cloest = root.key;
				}
				root = root.right;
			}
		}
		return cloest;
	}
	 
}
