import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Map<Integer, Integer> s = new HashMap<>();
//		s.put(1, 1);
//		s.put(1, s.get(1) + 1);
//		s.put(2, 12);
//		//System.out.println(s.get(1));
//		
//		for (Map.Entry<Integer, Integer> entry : s.entrySet()) {
//			//entry.setValue(10);
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}
//		s.remove(2);
//		
//		for (Map.Entry<Integer, Integer> entry : s.entrySet()) {
//			//entry.setValue(10);
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}
//		Set<Integer> set = new HashSet<>();
//		set.add(2);
//		set.add(3);
//		set.add(10);
//		for (int n : set) {
//			System.out.println(n);
//		}
//		System.out.println(2 > 1.8);
		PriorityQueue<Integer> q = new PriorityQueue();
		int[] a = new int[2];
		int[] b = {0, 0};
		String sa = "a";
		String sb = "b";
		String sc = "a" + "b";
		System.out.println(sc == "a" + "b");
		System.out.println(sc == sa + "b");
		System.out.println(sc == "a" + sb);
		System.out.println(1 + "/" + 1);
		//System.out.println(StringUtils.isNumeric("123"));
		System.out.println();
		int[] array = new int[] {1,2,3,4};
		System.out.println(-array[0]);
	}

}
