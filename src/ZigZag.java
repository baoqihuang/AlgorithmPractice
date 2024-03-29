import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigZag {
	
	  public class TreeNode {
	    public int key;
	    public TreeNode left;
	    public TreeNode right;
	    public TreeNode(int key) {
	      this.key = key;
	    }
	  }
	 /*
	  * Get the list of keys in a given binary tree layer by layer in zig-zag order.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

the result is [5, 3, 8, 11, 4, 1]
              5 (pollLast and offerFirst from left to right)   level odd

      	 /        \
			 ->
       3            8   (pollLst   offserFirst from right to left)

  	 /   \        /    \
  	  		 <-
 	1     4      9     11 (pollLst offserLast from right to left)
 	
   / \   / \    / \    / \
    
  2  5   6 1   10 5    2  3
  		  // odd pollLast and add rightChild and  leftChild offerLast  ->  5  3  8    {8, 3}
		  //even pollFirst and add leftChild and rightChild offserFirst
 
[5]  [8 3]
Corner Cases

What if the binary tree is null? Return an empty list in this case.
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
	  public List<Integer> zigZag(TreeNode root) {
		    // Write your solution here
			  List<Integer> result = new ArrayList<>();
			  if (root == null) {
				  return result;
			  }
			  Deque<TreeNode> deque = new ArrayDeque<>();
			  deque.offerFirst(root);
			  boolean ifOdd = false;
			  // odd pollLast and add rightChild and  leftChild offerLast  ->  5  3  8    {8, 3}
			  //even pollFirst and add leftChild and rightChild offserFirst
	      TreeNode cur = new TreeNode(0);
			  while(!deque.isEmpty()) {
				  int size = deque.size();
				  for (int i = 0; i < size; i++) {
					  if (ifOdd) {
						  cur = deque.pollFirst();
						  result.add(cur.key);
						  if (cur.left != null) {
							  deque.offerLast(cur.left);
						  }
						  if (cur.right != null) {
							  deque.offerLast(cur.right);
						  }
					  } else {
						  cur = deque.pollLast();
						  result.add(cur.key);
						  if (cur.right != null) {
							  deque.offerFirst(cur.right);
						  }
						  if (cur.left != null) {
							  deque.offerFirst(cur.left);
						  }
					  }
				  }
				  ifOdd = !ifOdd;
			  }
			  return result;
		  }

}











