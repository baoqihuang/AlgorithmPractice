
public class SecondLargestInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeNode {
	    public int key;
	    public TreeNode left;
	    public TreeNode right;
	    public TreeNode(int key) {
	      this.key = key;
	    }
	}
//	public int recursion(TreeNode root) {
//		if (root.left == null && root.right == null) {
//			
//		}
//	}
	public int secondLargest(TreeNode root) {
	    if (root.left == null && root.right == null) {
	      return Integer.MIN_VALUE;
	    } 
	    TreeNode cur = root;
	    while(cur.right != null ) {
	      //option 1 all right 
	      if (cur.right.right == null) {
	        if (cur.right.left == null) {
	          return cur.key;
	        } else {
	          cur = cur.right.left;
	          while (cur.right != null) {
	            cur = cur.right;
	          }
	          return cur.key;
	        }
	      }
	      cur = cur.right; 
	    }
	    if (root.right != null) {
	      return Integer.MIN_VALUE;
	    }
	    root = root.left;
	    if (root.right == null) {
	      return root.key;
	    }
	    while (root.right != null) {
	      root = root.right;
	    }
	    return root.key;

	  }

}
