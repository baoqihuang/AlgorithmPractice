import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedListWithOtherPointer {
	static class RandomListNode {
		 public int value;
		 public RandomListNode next;
		 public RandomListNode random;
		 public RandomListNode(int value) {
			 this.value = value;
		 }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		RandomListNode n1 = new RandomListNode(1);
//		RandomListNode n2 = new RandomListNode(2);
//		RandomListNode n3 = new RandomListNode(3);
//		RandomListNode n4 = new RandomListNode(4);
//		RandomListNode n5 = new RandomListNode(5);
	}
	
	public static RandomListNode copy(RandomListNode head) {
	    if (head == null) {
	      return head;
	    }
	    Map<RandomListNode, RandomListNode> refrenceTable = new HashMap<>();
	    RandomListNode dummy = new RandomListNode(0);
	    RandomListNode cur = dummy;
	    while (head != null) {
	    	if (!refrenceTable.containsKey(head)) {
	    			refrenceTable.put(head, new RandomListNode(head.value));
	    		}
	    		cur.next = refrenceTable.get(head);
	    	if (head.random != null) {
	    		if (!refrenceTable.containsKey(head.random)) {
	    			refrenceTable.put(head.random, new RandomListNode(head.random.value));
	    		}
	    		cur.next.random = refrenceTable.get(head.random);
	    	}
	    	head = head.next;
	    	cur = cur.next;
	    }
	    return dummy.next;
	    
	}
	public static void printList(RandomListNode head) {
		while (head != null) {
			System.out.print(head.value + "->");
		}
	}

}
