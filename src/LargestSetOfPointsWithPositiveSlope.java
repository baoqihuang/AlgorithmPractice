import java.util.Arrays;
import java.util.Comparator;

public class LargestSetOfPointsWithPositiveSlope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Point {
		public int x;
		public int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class MyComparator implements Comparator<Point> {
		@Override
		public int compare (Point p1, Point p2) {
			return p1.x != p2.x ? p1.x - p2.x : p2.y - p1.y;
		}
	}
	public int largest(Point[] points) {
		Arrays.sort(points, new MyComparator());
		int result = 0;
		//longest ascending subsequence
		int[] longest = new int[points.length];
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < i; j++) {
				if (points[j].y < points[i].y) {
					longest[i] = Math.max(longest[i], longest[j]);
				}
			}
			longest[i]++;
			result = Math.max(result, longest[i]);
		}
		return result;
	}

}


























