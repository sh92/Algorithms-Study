package quickSort;

public class Solution {

	public static void main(String[] args) {
		QuickSort qsort = new QuickSort();

		int[] arr = { 11, 5, 7, 2, 9, 12, 4, 15, 6, 8 };
		int length = arr.length;

		System.out.print("Original Array : ");
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		qsort.sort(arr, 0, length - 1);

		System.out.print("Sorted Array : ");
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
