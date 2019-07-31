
public class ReverseAlernativeNode {
	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
	
	public static ListNode reverseAlternate(ListNode head) {
	    // Write your solution here
	    if (head == null || head.next == null || head.next.next == null) {
	      return head;
	    }
	    ListNode firstPart = pickOneSkipOne(head);
	    ListNode secondPart = pickOneSkipOne(head.next);
	    ListNode reverseSecond = reverse (secondPart.next);
	    firstPart.next = reverseSecond;
	    return firstPart;
	  }
	  public static ListNode pickOneSkipOne(ListNode head) {
		  if (head.next.next == null) {
			  return head;
		  }
	    ListNode dummy = new ListNode(0);
	    ListNode cur = dummy;
	    cur.next = head;
	    cur = cur.next;
	    System.out.println(head.value);
	    while (head.next.next != null) {
	      cur.next = head.next.next;
	      cur = cur.next;
	      head = head.next.next;
	    }
	    return dummy.next;
	  }
	  public static ListNode reverse (ListNode head) {
	    ListNode prev = null;
	    while (head != null) {
	      ListNode next = head.next;
	      head.next = prev;
	      prev = head;
	      head = next;
	    }
	    return prev;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		ListNode result = reverseAlternate(l1);
		while (result != null) {
			
			System.out.println(result.value);
			result = result.next;
		}
//		ListNode l4 = new ListNode(1);
//		ListNode l5 = new ListNode(1);
//		ListNode l6 = new ListNode(1);
//		ListNode l7 = new ListNode(1);
//		ListNode l8 = new ListNode(1);
	}

}





  

