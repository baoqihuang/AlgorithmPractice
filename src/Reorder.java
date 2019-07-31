
public class Reorder {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode first = new ListNode(1);
		ListNode sec = new ListNode(2);
		ListNode thir = new ListNode(3);
		ListNode four = new ListNode(4);
		first.setNext(sec);
		sec.setNext(thir);
		thir.setNext(four);
		reorder(first);
		System.out.println("first: " + first.getValue());
		System.out.println("second: " + first.getNext().getValue());
		System.out.println("third: " + first.getNext().getNext().getValue());
		System.out.println("four: " + first.getNext().getNext().getNext().getValue());
	}
	
	public static ListNode reorder(ListNode head) {
	    // Write your solution here
	    //null,N1 pass
	    //N1 -> N2 
	    //N1 -> N2 -> N3 -> N4
	    if(head == null || head.getNext() == null){
	        return head;
	    }
	    ListNode firstHalf = head;
	    ListNode mid = findMid(head);
	    ListNode secondHalf = mid.getNext();
	    mid.setNext(null);
	    return merge(firstHalf, reverse(secondHalf));
	  }
	  public static ListNode findMid(ListNode head){
	    if(head == null){
	        return head;
	    }
	    ListNode mid = head;
	    ListNode fast = head;
	    while(fast.getNext() != null && fast.getNext().getNext() != null){
	        mid = mid.getNext();
	        fast = fast.getNext().getNext();
	    }
	    return mid;
	  }

	  public static ListNode reverse(ListNode head){
	    //iteritive
	    ListNode prev = null;
	    while(head != null){
	        ListNode next = head.getNext();
	        head.setNext(prev);
	        prev = head;
	        head = next;
	    }
	    return prev;
	    //if(head == null || head.next == null){
	        //return head;
	    //}
	    //ListNode newHead = reverse(head.next);
	    //head.next.next = head;
	    //head.next = null;
	    //return newHead;
	  }

	  public static ListNode merge(ListNode one, ListNode two){
	    ListNode dummy = new ListNode(0);
	    ListNode temp = dummy;
	    while(one != null && two != null){
	        temp.setNext(one);
	        one = one.getNext();
	        temp = temp.getNext();
	        temp.setNext(two);
	        two = two.getNext();
	        temp = temp.getNext();
	    }
	    if(one == null){
	        temp.setNext(two);
	    }
	    if(two == null){
	        temp.setNext(one);
	    }
	    return dummy.getNext();
	  }

}
