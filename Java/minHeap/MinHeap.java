package minHeap;

import java.util.Arrays;

public class MinHeap {
	private int capacity = 10;
	private int size = 0;
	int[] items = new int[capacity];

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
		heapifyDown();
		return item;
	}

	public void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChidlIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChidlIndex(index);
			}

			if (items[index] < items[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}
}
