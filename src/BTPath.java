import java.util.ArrayList;
import java.util.List;

public class BTPath {
	public static class TreeNode {
		 public int key;
		 public TreeNode left;
		 public TreeNode right;
		 public TreeNode(int key) {
		 this.key = key;
		 left = null;
		 right = null;
		 }
	}

	public static void main(String[] args) {
		System.out.println("3 to string : " + Integer.toString(3));
		// TODO Auto-generated method stub
		//Input: TreeNode.fromLevelOrderSpecial(new String[]{"1","2","5","3","4","#","6"})
		//expected [1->2->3,1->2->4,1->5->6] but was: [1->2->3,1->2-4,1-5->6]
		//     1
		//    /   \
		//   2     5
		// /  \   /  \
		//3    4 null 6
		//Input: TreeNode.fromLevelOrderSpecial(new String[]{"3","9","20","#","#","15","7"})
		//expected [3->9,3->20->15,3->20->7] but was: [11->9,11->20->15,11->20->7]
		//     3
		//    /   \
		//   9     20
		// /  \   /  \
		//n    n 15   6
//		TreeNode t1 = new TreeNode(1);
//		TreeNode t2 = new TreeNode(2);
//		TreeNode t3 = new TreeNode(5);
//		TreeNode t4 = new TreeNode(3);
//		TreeNode t5 = new TreeNode(4);
//		TreeNode t6 = new TreeNode(6);
//		t1.left = t2;
//		t1.right = t3;
//		t2.left = t4;
//		t2.right = t5;
//		t3.right = t6;
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
//		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
//		t2.left = t4;
//		t2.right = t5;
		t3.left = t4;
		t3.right = t5;
		String[] res = binaryTreePaths(t1);
		for (String str : res) {
			
			System.out.println(str);
		}
	}
	public static String[] binaryTreePaths(TreeNode root) {
	    // Write your solution here
		String f = new String("first");
		System.out.println(f == "first");
	    List<String> result = new ArrayList<>(); 
	    if (root == null) {
	      return new String[0];
	    }
	    StringBuilder sb = new StringBuilder(Integer.toString(root.key));
	    if (root.left == null && root.right == null) {
	    	String[] s = new String[] {Integer.toString(root.key)};
	    	return s;
	    }
	    binaryTreePaths(root, result, sb);
	    String[] answer = new String[result.size()];
	    for (int i = 0; i < result.size(); i++) {
	      answer[i] = result.get(i);
	    }
	    return answer;
	  }
	  public static void binaryTreePaths (TreeNode root, List<String> result, StringBuilder sb) {

	    if (root.left == null && root.right == null) {
	      result.add(sb.toString());
	    }
	    if (root.left != null) {
	    	System.out.println("left :" + sb.toString());
	      sb.append("->" + root.left.key);
	      binaryTreePaths(root.left, result, sb);
	      delete(sb);
	    }

	    if (root.right != null) {
	    	System.out.println("right :" + sb.toString());
	    	sb.append("->" + root.right.key);
	      binaryTreePaths(root.right, result, sb);
	      delete(sb);
	    }
	  }
	  public static void delete (StringBuilder sb) {
	    int i = sb.length() - 1;
	    while (i >= 0 && Character.isDigit(sb.charAt(i))) {
	      sb.deleteCharAt(i);
	      i--;
	    }
	    sb.delete(sb.length() - 2, sb.length());
	  }

}
