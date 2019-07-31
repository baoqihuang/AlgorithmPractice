
public class AddTwoNumber2 {
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
		l1.next = l2;
		l2.next = l3;
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		//1 -> 2 -> 3     4 -> 5 -> 6 -> 7
		//3 -> 2 -> 1     7 -> 6 -> 5 -> 4
		//result =  4 -> 6 -> 9 -> 0
		ListNode one = reverse(l1);
		ListNode two = reverse(l4);
		ListNode result = addTwoNumber(one, two);
		while(result != null) {
			System.out.println(result.key + " ->");
			result = result.next;
		}
	}
	public static ListNode addTwoNumber (ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int carr = 0;
		while (one != null || two != null) {
			int x = one == null ? 0 : one.key;
			int y = two == null ? 0 : two.key;
			int sum = x + y + carr;
			carr = sum / 10;
			ListNode temp = new ListNode(sum % 10);
			cur.next = temp;
			cur = cur.next;
			if (one != null) {
				one = one.next;
			}
			if (two != null) {
				two = two.next;
			}
		}
		return dummy.next;
	}
	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

}
