
public class LCAInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Given two keys in a binary search tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary search tree

There are no duplicate keys in the binary search tree

The given two nodes are guaranteed to be in the binary search tree

Examples

        5

      /   \

     2     12

   /  \      \

  1    3      14

The lowest common ancestor of 1 and 14 is 5

The lowest common ancestor of 1 and 3 is 2
	 */
	public class TreeNode{
		TreeNode left;
		TreeNode right;
		int key;
		public TreeNode(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}
	public TreeNode lcaBST(TreeNode root, int a , int b) {
		if (root.key > a && root.key > b) {
			return lcaBST(root.left, a, b);
		} else if (root.key < a && root.key < b) {
			return lcaBST(root.right, a, b);
		} else {
			return root;
		}
	}

}
