import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ListNode> input = new ArrayList<>();
		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(9);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		n0.next = n1;
		n1.next = n2;
		n3.next = n4;
		n4.next = n5;
		n6.next = n7;
		n7.next = n8;
		input.add(n0);
		input.add(n3);
		input.add(n6);
		ListNode res = merge(input);
		while(res !=null) {
			System.out.println(res.value);
			res = res.next;
		}
	}
	/*
	 * Merge K sorted lists into one big sorted list in ascending order.

Assumptions

ListOfLists is not null, and none of the lists is null.
	 */
	
	public static class ListNode {
		public int value;
	    public ListNode next;
	    public ListNode(int value) {
	      this.value = value;
	      next = null;
	    }
	}
//	public static class Entry {
//		public int row;
//		public int col;
//		public int value;
//		public Entry (int row, int col, int value) {
//			this.row = row;
//			this.col = col;
//			this.value = value;
//		}
//	}
	 
	public static ListNode merge(List<ListNode> listOfLists) {
	    // Write your solution here.
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, new Comparator<ListNode>() {
			@Override
			public int compare (ListNode e1, ListNode e2) {
				if (e1.value == e2.value) {
					return 0;
				}
				return e1.value < e2.value ? -1 : 1;
			}
		});
		//Initialized by add all the inner list's first element in to minHeap
		for (int i = 0; i < listOfLists.size(); i++) {
			minHeap.offer(listOfLists.get(i));
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (!minHeap.isEmpty()) {
			ListNode min = minHeap.remove();
			cur.next = min;
			cur = cur.next;
			while (min.next != null && !minHeap.isEmpty() && min.next.value <= minHeap.peek().value) {
				min = min.next;
				cur.next = min;
				cur = cur.next;
			}
			if (min.next != null) {
				minHeap.offer(min.next);
			}
		}
		return dummy.next;
	}


}
