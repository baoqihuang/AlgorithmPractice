package mid2;

public class MaxPathSum {
	 public class TreeNode {
	    public int key;
	    public TreeNode left;
	    public TreeNode right;
	    public TreeNode(int key) {
	      this.key = key;
	    }
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	private int max = Integer.MIN_VALUE;
	  public int maxPathSum(TreeNode root) {
	    // Write your solution here
	    helper(root);
	    return max;
	  }
	  public int helper(TreeNode root) {
	    //base case
	    if (root == null) {
	      return 0;
	    }
	    //step1 what we expect from lchild and rchild
	    int lchild = helper(root.left);
	    int rchild = helper(root.right);
	    //step2 what we should do in each level
	    if (root.left != null && root.right != null) {
	      int cur = lchild + rchild + root.key;
	      max = Math.max(cur, max);
	      return Math.max(lchild, rchild) + root.key;
	    }
	     //step3 what should be return
	    return root.left == null ? root.key + rchild : root.key + lchild;
	  }
}
