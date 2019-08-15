public class DeleteNodeInBST {

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
	/*
	 * Delete the target key K in the given binary search tree if the binary search tree contains K. 
	 * Return the root of the binary search tree.
	 * Find your own way to delete the node from the binary search tree, 
	 * after deletion the binary search tree's property should be maintained.
	 * Assumptions
	 * There are no duplicate keys in the binary search tree
	 * The smallest larger node is first candidate after deletion
	 */
	public TreeNode deleteTree(TreeNode root, int key) {
        root = delete(root, key);
	    return root;
    }
    public int smallestLarger(TreeNode root, int target) {
	    // Write your solution here
		int smallest = Integer.MAX_VALUE;
		while (root != null) {
			if (root.key > target) {
				if (root.key < smallest) {
					smallest = root.key;
				}
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return smallest;
		
	}

	private TreeNode delete(TreeNode node, int data) {

		if (node == null) {
			return null;
		}

		if (node.key < data) {
			node.right = delete(node.right, data);
			
		} else if (node.key > data) {
			node.left = delete(node.left, data);
			
		} else {

			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				int smallestL = smallestLarger(node.left, data);
				node.key = smallestL;
				node.right = delete(node.right, smallestL);
			}
		}
		return node;

	}
}
