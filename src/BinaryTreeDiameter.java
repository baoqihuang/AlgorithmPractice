
public class BinaryTreeDiameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static class TreeNode {
		public int key;
	    public TreeNode left;
	    public TreeNode right;
	    public TreeNode(int key) {
	    	this.key = key;
	    }
	}
	public int diameter(TreeNode root) {
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
		if (root.left != null && root.right != null) {
			int diameter = left + right + 1;
			if (diameter > max[0]) {
				max[0] = diameter;
			}
			return Math.max(left, right) + 1;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return root.left == null ? right : left;
	}

}
