public class MaxPathSumBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Given a binary tree in which each node contains an integer number. 
	 * Find the maximum possible sum from any node to any node (the start node and the end node can be the same). 

Assumptions

​The root of the given binary tree is not null
Examples

   -1

  /    \

2      11

     /    \

    6    -14

one example of paths could be -14 -> 11 -> -1 -> 2

another example could be the node 11 itself

The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18

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
	public class TreeNode {
	    public int key;
	    public TreeNode left;
	    public TreeNode right;
	    public TreeNode(int key) {
	      this.key = key;
	    }
	}
	public int maxPathSum(TreeNode root) {
	    // Write your solution here
		int[] max = new int[1];
		helper(root, max);
		return max[0];
	}
	
	public int helper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		left = Math.max(left, 0);
		right = Math.max(right, 0);
		max[0] = Math.max(max[0], left + right + root.key);
		return Math.max(left, right) + root.key;
	}

}
