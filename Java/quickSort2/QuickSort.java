package quickSort;

public class QuickSort {
	public void sort(int[] arr, int low, int high) {
		if (low < high) {
			int p = partition(arr, low, high);
			sort(arr, low, p - 1);
			sort(arr, p + 1, high);
		}
	}

	private int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		int temp = 0;
		for (int j = low; j < high - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

}
