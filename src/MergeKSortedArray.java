import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = new int[][] {{3},{1,2,3,4,5},{1,5}};
		int[] res = merge(test);
		for (int n : res) {
			System.out.print(n + " , ");
		}
	}
	/*
	 * Merge K sorted array into one big sorted array in ascending order.

Assumptions

The input arrayOfArrays is not null, none of the arrays is null either.
	 */
	public static class Entry {
		int row;
		int col;
		int value;
		public Entry(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
	}
	public static int[] merge(int[][] arrayOfArrays) {
	    // Write your solution here
		PriorityQueue<Entry> minHeap = new PriorityQueue<>(11, new Comparator<Entry>() {
			@Override
			public int compare (Entry e1, Entry e2) {
				if (e1.value == e2.value) {
					return 0;
				}
				return e1.value < e2.value ? -1 : 1;
			}
		});
		//initialized minHeap
		int length = 0;
		for (int i = 0; i < arrayOfArrays.length; i++) {
			int len = arrayOfArrays[i].length;
			length += len;
			if (len > 0) {
				minHeap.offer(new Entry(i, 0, arrayOfArrays[i][0]));
			}
		}
		int[] result = new int[length];
		int i = 0;
		while (!minHeap.isEmpty()) {
			Entry cur = minHeap.remove();
			result[i++] = cur.value;
			int row = cur.row;
			int col = cur.col;
			while (col + 1 < arrayOfArrays[row].length && !minHeap.isEmpty()&& arrayOfArrays[row][col + 1] <= minHeap.peek().value) {
				result[i++] = arrayOfArrays[row][col + 1];
				col++;
			}
			if (col + 1 < arrayOfArrays[row].length) {
				minHeap.offer(new Entry(row, col + 1, arrayOfArrays[row][col + 1]));
			}
		}
		return result;
	}
}
