import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character> res = orderTasks(new char[][] {{'s', 't'},{'t', 'a'}, {'c', 'b'}});
		for (char ch : res) {
			System.out.println(ch);
		}
	}
	/*
	 * Build tasks. Given a list of build task dependency (e.g. [‘s’, ‘t’] indicates that to build ‘t’, 
	 * we need to build ‘s’ first). Return the order of the tasks to build so that we could build all tasks.
Example:
input [[‘s’, ‘t’], [‘t’, ‘a’]]
p: s
d: t
‘s’--> ‘t’---> ‘a’
input [[‘s’, ‘t’], [‘t’, ‘a’], [‘c’,’b’] ...]
   t -> s
   a -> t
   b -> c
 
Topological Sort
拓扑排序
 
LeetCode: Course Schedule
 
Node + Edge
Map<Character, Edge>
class Node {
	char val;
	List<Node> edges;
}

	 */
	public static List<Character> orderTasks (char[][] input) {
		List<Character> result = new ArrayList<>();
		if (input == null || input.length == 0 || input[0].length == 0) {
			return result;
		}
		//initial map and dedup array
		List<List<Character>> map = new ArrayList<>(26);
		for (int i = 0; i < 26; i++) {
			map.add(new ArrayList<Character>());
		}
		int[] visited = new int[26];
		Set<Character> pre = new HashSet<>();
		Set<Character> dpen = new HashSet<>();
		//initial dependency
		for (int i = 0; i < input.length; i++) {
			if (dpen.contains(input[i][0])) {
				pre.remove(input[i][0]);
			} else {
				pre.add(input[i][0]);
			} 
			dpen.add(input[i][1]);
			
			map.get(input[i][0] - 'a').add(input[i][1]);
		}
		//test
		for (char ch : dpen) {
			System.out.print(" d: " + ch);
		}
		System.out.println();
		for (char ch : pre) {
			System.out.print(" p: " + ch);
		}
		System.out.println();
		//dfs
		for (char ch : pre) {
			if (!dfs(map, visited, ch, result)) return null;
		}
		return result;
	}
	public static boolean dfs (List<List<Character>> map, int[] visited, char ch, List<Character> result) {
		visited[ch - 'a'] = 1;
		result.add(ch);
		List<Character> nextTask = map.get(ch - 'a');
		for (char next : nextTask) {
			if (visited[next - 'a'] == 1) return false; 
			if (visited[next - 'a'] == 0) {
				if (!dfs(map, visited, next, result)) return false;
			}
		}
		visited[ch - 'a'] = 2;
		return true;
	}

}
