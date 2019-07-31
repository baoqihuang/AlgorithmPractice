
public class ListNode {
	private int value;
	private ListNode next = null;
	public ListNode(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int newValue) {
		this.value = newValue;
	}
	
	public ListNode getNext() {
		return this.next;
	}
	public void setNext(ListNode n) {
		this.next = n;
	}
	
}	
