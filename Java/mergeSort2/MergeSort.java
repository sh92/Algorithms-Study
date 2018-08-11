package mergeSort;

public class MergeSort {
	void merge(int arr[], int s, int m, int e) {
		int n1 = m - s + 1;
		int n2 = e - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i) {
			L[i] = arr[s + i];
		}
		for (int j = 0; j < n2; ++j) {
			R[j] = arr[m + 1 + j];
		}
		int i = 0, j = 0;
		int k = s;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	static void printArray(int[] arr) {
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 11, 5, 7, 2, 9, 12, 4, 15, 6, 8 };

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}
}
