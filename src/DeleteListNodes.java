
public class DeleteListNodes {

	public static class ListNode {
		ListNode next;
		int key;
		ListNode(int key) {
			this.key = key;
			next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode result = deleteNodes(l1, new int[] {0, 3, 4});
		while (result != null) {
			System.out.println(result.key);
			result = result.next;
		}
		//1 -> 2 -> 3     4 -> 5 -> 6 -> 7
		//3 -> 2 -> 1     7 -> 6 -> 5 -> 4
		//result =  4 -> 6 -> 9 -> 0

		
	}
	public static ListNode deleteNodes(ListNode head, int[] indices) {
	    // Write your solution here
	    if (head == null || indices.length == 0) {
	      return head;
	    }
	    ListNode dummy = new ListNode(0);
	    ListNode cur = dummy;
	    ListNode prev = head;
	    int i = 0;
	    int count = 0;
	    while(head != null) {
	    	System.out.println("cur.key: "+cur.key + " prev.key: "+prev.key + " i: "+i+" count: " +count);
	      if(count == indices[i]) {
	    	  if (i < indices.length - 1) {
	    		  i++;
	    	  } else {
	    		  cur.next = null;
	    	  }
	      } else {
	        cur.next = head;
	        cur = cur.next;
	      }
	      count++;
	      prev = head;
	      head = head.next;
	    }
	    return dummy.next;
	  }

}
