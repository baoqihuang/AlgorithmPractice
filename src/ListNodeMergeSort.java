
public class ListNodeMergeSort {
	static class ListNode {
		public int value;
	    public ListNode next;
	    public ListNode(int value) {
	      this.value = value;
	      next = null;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		ListNode result = mergeSort(l1);
		while (result != null) {
			System.out.println(result.value);
			result = result.next;
		}
	}
	
	
	
	
	  public static ListNode mergeSort(ListNode head) {
	    // Write your solution here
	    if (head == null || head.next == null) {
	      return head;
	    }
	    ListNode end = findEnd(head);
	    ListNode newHead = mergeSort(head, end);
	    return newHead;
	  }
	  public static ListNode mergeSort(ListNode head, ListNode end) {
		  if (head == end) {
			  return head;
		  }
	    ListNode one = head;
	    ListNode mid = findMid(head);
	    ListNode second = mid.next;
	    mid.next = null;
	    ListNode listOne = mergeSort(one, mid);
	    ListNode listTwo = mergeSort(second, end);
	    ListNode newHead = merge(listOne, listTwo);
	    return newHead;
	  }
	  public static ListNode merge(ListNode one, ListNode second) {
	    ListNode dummy = new ListNode(0);
	    ListNode cur = dummy;
	    while (one != null && second != null) {
	      if (one.value <= second.value) {
	        cur.next = one;
	        one = one.next;
	      } else {
	        cur.next = second;
	        second = second.next;
	      }
	      cur = cur.next;
	    }
	    if (one != null) {
	      cur.next = one;
	    }
	    if (second != null) {
	      cur.next = second;
	    }
	    return dummy.next;
	  }
	  public static ListNode findMid (ListNode head) {
	    if (head.next == null) {
	      return head;
	    }
	    ListNode mid = head;
	    ListNode fast = head;
	    while (fast.next != null && fast.next.next != null) {
	      mid = mid.next;
	      fast = fast.next.next;
	    }
	     return mid; 
	  }
	  public static ListNode findEnd (ListNode head) {
	    while (head.next != null) {
	      head = head.next;
	    }
	    return head;
	  }
}



