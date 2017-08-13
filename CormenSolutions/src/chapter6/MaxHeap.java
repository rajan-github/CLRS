package chapter6;

import java.util.Arrays;

public class MaxHeap<E extends Comparable<E>> {

	private E[] array;
	private int heapSize = 0;

	@SuppressWarnings("unchecked")
	public MaxHeap() {
		super();
		array = (E[]) new Object[16];
	}

	public MaxHeap(E[] array) {
		super();
		this.array = array;
		this.heapSize = array.length;
	}

	private int left(int i) {
		return 2 * i + 1;
	}

	private int right(int i) {
		return 2 * i + 2;
	}

	private void maxHeapify(int i) {
		if (i >= 0 && i < this.heapSize) {
			int left = left(i), right = right(i), largest = i;
			if (left < heapSize && array[left].compareTo(array[largest]) > 0) {
				largest = left;
			}
			if (right < heapSize && array[right].compareTo(array[largest]) > 0) {
				largest = right;
			}
			if (largest != i) {
				E temp = this.array[i];
				this.array[i] = this.array[largest];
				this.array[largest] = temp;
				maxHeapify(largest);
			}
		}

	}

	private void buildMaxHeap() {
		int i = this.array.length / 2;
		while (i >= 0) {
			maxHeapify(i);
			i--;
		}
	}

	private void heapSort() {
		buildMaxHeap();
		while (this.heapSize > 0) {
			E temp = this.array[0];
			this.array[0] = this.array[this.heapSize - 1];
			this.array[this.heapSize - 1] = temp;
			heapSize -= 1;
			maxHeapify(0);
		}
	}

	@Override
	public String toString() {
		return "MaxHeap [array=" + Arrays.toString(array) + ", heapSize=" + heapSize + "]";
	}

	public static void main(String args[]) {
		// Integer[] array = { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };
		// Integer[] array = { 27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0 };
		// Integer[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		Integer[] array = { 5, 13, 2, 25, 7, 17, 20, 8, 4 };
		MaxHeap<Integer> heap = new MaxHeap<>(array);
		heap.heapSort();
		System.out.println(heap);
	}
}
