import java.util.ArrayDeque;
import java.util.Queue;

public class DistanceOfTwoNodeBT {

	public static void main(String[] args) {
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
		System.out.println(distance(n1, 8, 10));
	    TreeNode lCA = lca (n1, 8, 10);
	    int k1H = level(n1, find(n1, 8));
	    int k2H = level(n1, find(n1, 10));
	    int lcaH = level(n1, lCA);
	    System.out.println("k1 level: " + k1H + " , k2 level: " + k2H + " , lca level: " + lcaH + " lca key: " + lCA.key);
	}
	public static class TreeNode {
	    public int key;
	    public TreeNode left;
	    public TreeNode right;
	    public TreeNode(int key) {
	      this.key = key;
	      this.left = null;
	      this.right = null;
	    }
	}
	public static int distance(TreeNode root, int k1, int k2) {
	    // Write your solution here
	    TreeNode lCA = lca (root, k1, k2);
	    int k1H = level(root, find(root, k1));
	    int k2H = level(root, find(root, k2));
	    int lcaH = level(root, lCA);
	    return k1H + k2H - 2 * lcaH;
	  }
	  public static TreeNode find(TreeNode root, int key) {
	    if (root == null) {
	      return null;
	    } else {
	    	if (root.key == key) {
	    		return root;
	    	}
	    }
	    return root.right == null ? find(root.left, key) : find(root.right, key);
	  }
	  public static int level (TreeNode root, TreeNode target) {
	    Queue<TreeNode> queue = new ArrayDeque<>();
	    queue.offer(root);
	    int level = 0;
	    while (!queue.isEmpty()) {
	      int size = queue.size();
	      for (int i = 0; i < size; i++) {
	        TreeNode cur = queue.poll();
	        System.out.println("cur: " + cur + " , target: " + target);
	        if (cur.key == target.key) {
	          return level;
	        }
	        if (cur.left != null) {
	          queue.offer(cur.left);
	        }
	        if (cur.right != null) {
	          queue.offer(cur.right);
	        }
	      }
	      level++;
	    }
	    return 0;
	  }
	  public static TreeNode lca (TreeNode root, int k1, int k2) {
	    if (root == null || root.key == k1 || root.key == k2) {
	      return root;
	    }
	    TreeNode left = lca(root.left, k1, k2);
	    TreeNode right = lca(root.right, k1, k2);

	    if (left == null && right == null) {
	      return null;
	    } else if (left != null && right != null) {
	      return root;
	    }
	    return left == null ? right : left;
	  }

}
