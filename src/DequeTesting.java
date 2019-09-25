import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offerLast(3);
		deque.offerLast(8);
		System.out.println(deque.pollLast());
		System.out.println(deque.pollLast());
	}

}
