import java.util.LinkedList;

public class MergeSort3Stack {
	public static void sort(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		LinkedList<Integer> s3 = new LinkedList<Integer>();
		sortHelper(s1, s2, s3, s1.size());
	}

	public static void sortHelper(LinkedList<Integer> out, LinkedList<Integer> in, LinkedList<Integer> buffer, int num) {
		if (num <= 1) {
			return;
		}
		for (int i = 0; i < num - num / 2; i++) {
			in.offerFirst(out.pollFirst());
		}
		sortHelper(out, in, buffer, num / 2);
		sortHelper(in, out, buffer, num - num / 2);
		int iOut = 0;
		int iIn = 0;
		while (iOut < num / 2 && iIn < num - num / 2) {
			int tOut = out.peekFirst();
			int tIn = in.peekFirst();
			if (tOut < tIn) {
				buffer.offerFirst(out.pollFirst());
				iOut++;
			} else {
				buffer.offerFirst(in.pollFirst());
				iIn++;
			}
		}
		while (iIn < num - num / 2) {
			buffer.offerFirst(in.pollFirst());
			iIn++;
		}
		while (buffer.size() > 0) {
			out.offerFirst(buffer.pollFirst());
		}
	}
	
	public static void sortWith2Stack(LinkedList<Integer> s1) {
	    LinkedList<Integer> s2 = new LinkedList<Integer>();
	    if(s1.size() <= 1){
	        return;
	    }
	    // Write your solution here.
	    int totalNums = s1.size();
	    int unsorted = totalNums;
	    while(unsorted > 0){
	    	System.out.println("unsorted: " + unsorted);
		    int globalMin = Integer.MAX_VALUE;
	        int count = 1;
	        while(!s1.isEmpty()){
	            if(s1.peekFirst() < globalMin){
	                globalMin = s1.peekFirst();
	            }
	            else if(s1.peekFirst() == globalMin){
	                count++;
	            }
	            s2.offerFirst(s1.pollFirst());
	            System.out.println(globalMin);
	        }
	        while(s2.size() > totalNums - unsorted){
	        	System.out.println("s2 peek :" + s2.peekFirst());
	            if(s2.peekFirst() != globalMin){
	                s1.offerFirst(s2.peekFirst());
	            }
	            s2.pollFirst();
	        }
	        unsorted -= count;

	        while(count >= 1){
	            s2.offerFirst(globalMin);
	            count --;
	        }
	    }
	    while(!s2.isEmpty()) {
	    	s1.offerFirst(s2.pollFirst());
	    }
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> test = new LinkedList<>();
		test.add(2);
		test.add(15);
		test.add(5);
		test.add(50);
		test.add(10);

		sortWith2Stack(test);
		System.out.println("test is empty : "+ test.isEmpty());
		while(!test.isEmpty()) {
			System.out.println(test.pollFirst());
		}
		
	}

}
