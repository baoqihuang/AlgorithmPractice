
public class LcaWithParentNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class TreeNodeP {
		public int key;
	    public TreeNodeP left;
	    public TreeNodeP right;
	    public TreeNodeP parent;
	    public TreeNodeP(int key, TreeNodeP parent) {
	    	this.key = key;
	    	this.parent = parent;
	    }
	}
	public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		int h1 = getHeight(one);
		int h2 = getHeight(two);
		if (h1 <= h2) {
			return mergeNode(one, two, h2 - h1);
		} else {
			return mergeNode(two, one, h1 - h2);
		}
	}
	public TreeNodeP mergeNode(TreeNodeP shorter, TreeNodeP longer, int diff) {
		while (diff > 0) {
			longer = longer.parent;
			diff --;
		}
		while (longer != shorter) {
			longer = longer.parent;
			shorter = shorter.parent;
		}
		return longer;
	}
	public int getHeight(TreeNodeP root) {
		int length = 0;
		while (root != null) {
			length++;
			root = root.parent;
		}
		return length;
	}
}















