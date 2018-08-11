package maxHeap;

import java.util.Arrays;

public class MaxHeap {
	private int capacity = 10;
	private int size = 0;
	int[] items = new int[capacity];

	public MaxHeap() {
	}

	public void sort(int[] items) {
		this.size = items.length;
		this.capacity = findFullBinaryTreeSize(size) * 2;
		this.items = items;
		int n = size;
		// Max heap 구성
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapifyDown(i);
		}
		// 최대 값 뽑아내서 맨 끝에 두고 사이즈 줄여나가는 방식
		for (int i = n - 1; i >= 0; i--) {
			swap(0, i);
			heapify(i, 0);
		}
	}

	private void heapify(int n, int index) {
		int parentIndex = index;
		int leftIndex = getLeftChidlIndex(parentIndex);
		int rightIndex = getRightChidlIndex(parentIndex);
		if (leftIndex < n && items[parentIndex] < items[leftIndex]) {
			parentIndex = leftIndex;
		}
		if (rightIndex < n && items[parentIndex] < items[rightIndex]) {
			parentIndex = rightIndex;
		}
		if (index != parentIndex) {
			swap(parentIndex, index);
			heapify(n, parentIndex);
		}
	}

	private int findFullBinaryTreeSize(int length) {
		int sum = 0;
		int idx = 1;
		while (sum <= length - 1) {
			sum += Math.pow(2, idx++);
		}
		return sum;
	}

	private int getLeftChidlIndex(int parentIdenx) {
		return 2 * parentIdenx + 1;
	}

	private int getRightChidlIndex(int parentIdenx) {
		return 2 * parentIdenx + 2;
	}

	private int getParentIndex(int chidlIndex) {
		return (chidlIndex - 2) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChidlIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChidlIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return items[getLeftChidlIndex(index)];
	}

	private int rightChild(int index) {
		return items[getRightChidlIndex(index)];
	}

	private int parent(int index) {
		return items[getParentIndex(index)];
	}

	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}

	private void ensureExtraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}

	public int peek() {
		if (size == 0)
			throw new IllegalStateException();
		return items[0];
	}

	public int poll() {
		if (size == 0)
			throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown(0);
		return item;
	}

	public void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp(size - 1);
	}

	private void heapifyUp(int index) {
		while (hasParent(index) && parent(index) < items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void heapifyDown(int index) {
		while (hasLeftChild(index)) {
			int biggerChildIndex = getLeftChidlIndex(index);
			if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
				biggerChildIndex = getRightChidlIndex(index);
			}

			if (items[index] >= items[biggerChildIndex]) {
				break;
			}
			swap(index, biggerChildIndex);
			index = biggerChildIndex;
		}
	}
}
