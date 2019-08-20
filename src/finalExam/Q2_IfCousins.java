package finalExam;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q2_IfCousins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				TreeNode n1 = new TreeNode(1);
				TreeNode n2 = new TreeNode(2);
				TreeNode n3 = new TreeNode(3);
				TreeNode n4 = new TreeNode(4);
				TreeNode n5 = new TreeNode(5);
				TreeNode n6 = new TreeNode(6);
				TreeNode n7 = new TreeNode(7);
				TreeNode n8 = new TreeNode(8);
				TreeNode n9 = new TreeNode(9);
				TreeNode n0 = new TreeNode(10);
				//               1
				//           /      \
				//          2        3
				//       /     \   /    \
				//      4      5  6      7
				//     / \    /
				//    8  9   10
				n1.left = n2;
				n1.right = n3;
				
				n2.left = n4;
				n2.right = n5;
				
				n3.left = n6;
				n3.right = n7;
				
				n4.left = n8;
				n4.right = n9;
				
				n5.left = n0;
				System.out.print(ifCousins(n1, n8, n9));
				
	}
	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int key;
		public TreeNode(int key) {
			this.key = key;
		    this.left = null;
		    this.right = null;
		}
	}
//	public static boolean ifCousins2(TreeNode root, TreeNode a, TreeNode b) { 
//		if (root == null) {
//			return false;
//		}
//		return lca(root, a, b) == -1;
//	}
//	public static int lca(TreeNode root, TreeNode a, TreeNode b) {
//		//0 means none of a and b,  1 means only one a or b, -1 means a and b are cousin
//		if (root == null) {
//			return 0;
//		}
//		if (a == root || b == root) {
//			return 1;
//		}
//		int left = lca(root.left, a, b);
//		int right = lca(root.right, a, b);
//		if ((left == 0 && right == 0) || ())
//	}
	public static boolean ifCousins(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
		    boolean hasA = false;
		    boolean hasB = false;
		    for (int i = 0; i < size; i++) {
		    	TreeNode cur = queue.poll();
		    	int count = 0;
		    	if (cur.left != null) {
		    		if (cur.left == a) {
		    			count++;
		    			hasA = true;
		    		}
		    		if (cur.left == b) {
		    			count++;
		    			hasB = true;
		    		}
		    		queue.offer(cur.left);
		    	}
		     	if (cur.right != null) {
		     		if (cur.right == a) {
		    			count++;
		    			hasA = true;
		    		}
		    		if (cur.right == b) {
		    			count++;
		    			hasB = true;
		    		}
		     		queue.offer(cur.right);
		     	}
		     	if (count == 2) {
		     		return false;
		     	}
		    }
		    if (hasA && hasB) {
		    	return true;
		    }
		}
		return false;
	}

}
