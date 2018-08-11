package maxHeap;

public class App {
	public static void main(String[] args) {
		int[] arr = { 11, 5, 7, 2, 9, 12, 4, 15, 6, 8 };
		MaxHeap maxHeap = new MaxHeap();
		maxHeap.sort(arr);

		for (int x : arr) {
			System.out.print(x + " ");
		}

	}
}
