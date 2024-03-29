
public class CountArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * Given an array A of length N containing all positive integers from [1...N]. How to get an array B 
	 * such that B[i] represents how many elements A[j] (j > i) in array A that are smaller than A[i].

Assumptions:

The given array A is not null.
Examples:

A = { 4, 1, 3, 2 }, we should get B = { 3, 0, 1, 0 }.
Requirement:

time complexity = O(nlogn).
	 */
	public int[] countArray(int[] array) {
	    // Write your solution here
		int[] indexArray = initialIndexArray(array);
		int[] countArray = new int[array.length];
		int[] helper = new int[array.length];
		mergeSort(array, indexArray, countArray, helper, 0, array.length - 1);
		return countArray;
	}
	public int[] initialIndexArray(int[] array) {
		int[] indices = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			indices[i] = i;
		}
		return indices;
	}
	public void mergeSort(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(array, indexArray, countArray, helper, left, mid);
		mergeSort(array, indexArray, countArray, helper, mid + 1, right);
		merge(array, indexArray, countArray, helper, left, mid, right);
	}
	public void merge(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int mid, int right) {
		copyArray(indexArray, helper, left, right);
		int l = left;
		int r = mid + 1;
		int cur = left;
		while (l <= mid) {
			if (r > right || array[helper[l]] <= array[helper[r]]) {
				countArray[helper[l]] += (r - mid - 1);
				indexArray[cur++] = helper[l++];
			} else {
				indexArray[cur++] = helper[r++];
			}
		}
	}
	public void copyArray(int[] indexArray, int[] helper, int left, int right) {
		for (int i = left; i <= right; i++) {
			helper[i] = indexArray[i];
		}
	}

}
