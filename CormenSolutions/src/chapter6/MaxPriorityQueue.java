package chapter6;

import java.util.Arrays;

public class MaxPriorityQueue<E extends ObjectWithKey> {
	private E[] data;
	private int queueSize = 0;

	@SuppressWarnings("unchecked")
	public MaxPriorityQueue() {
		super();
		data = (E[]) new ObjectWithKey[16];
	}

	public MaxPriorityQueue(E[] data) {
		super();
		this.data = data;
		this.queueSize = data.length;
	}

	public E maximum() {
		return (this.queueSize > 0) ? this.data[0] : null;
	}

	private int left(int i) {
		return 2 * i + 1;
	}

	private int right(int i) {
		return 2 * i + 2;
	}

	private int parent(int i) {
		return (int) (Math.ceil(i / 2.0) - 1);
	}

	private void ensureSize() {
		if (this.queueSize >= this.data.length) {
			@SuppressWarnings("unchecked")
			E[] newArray = (E[]) new ObjectWithKey[2 * this.data.length];
			for (int i = 0; i < this.data.length; i++) {
				newArray[i] = this.data[i];
				this.data[i] = null;
			}
			this.data = newArray;
		}
	}

	public void insert(E object) {
		ensureSize();
		this.data[this.queueSize] = object;
		int i = this.queueSize;
		queueSize += 1;
		while (i > 0) {
			int parent = parent(i);
			if (this.data[parent].getKey() < this.data[i].getKey()) {
				E temp = this.data[parent];
				this.data[parent] = this.data[i];
				this.data[i] = temp;
				i = parent(i);
			} else {
				break;
			}
		}
	}

	public E extractMax() {
		E max = null;
		if (this.queueSize > 0) {
			max = this.data[0];
			this.data[0] = this.data[this.queueSize - 1];
			this.data[this.queueSize - 1] = null;
			this.queueSize -= 1;
			this.maxHeapify(0);
		}
		return max;

	}

	public void maxHeapify(int i) {
		if (i >= 0 && i < this.queueSize) {
			int left = left(i), right = right(i), largest = i;
			if (left < queueSize && data[left].getKey() > data[largest].getKey()) {
				largest = left;
			}
			if (right < queueSize && data[right].getKey() > data[largest].getKey()) {
				largest = right;
			}
			if (largest != i) {
				E temp = this.data[i];
				this.data[i] = this.data[largest];
				this.data[largest] = temp;
				maxHeapify(largest);
			}
		}

	}

	@Override
	public String toString() {
		return "MaxPriorityQueue [data=" + Arrays.toString(data) + ", queueSize=" + queueSize + "]";
	}

	public static void main(String args[]) {
		MaxPriorityQueue<Tasks> queue = new MaxPriorityQueue<>();
		queue.insert(new Tasks(0, "Zero task"));
		queue.insert(new Tasks(1, "First task"));
		queue.insert(new Tasks(2, "Second task"));
		queue.insert(new Tasks(2, "Third task"));
		queue.insert(new Tasks(4, "Fourth task"));
		queue.insert(new Tasks(0, "Fifth task"));
		System.out.println(queue.extractMax());
		System.out.println(queue.extractMax());
		System.out.println(queue.extractMax());
		System.out.println(queue.extractMax());
		System.out.println(queue.extractMax());
		System.out.println(queue.extractMax());
		System.out.println(queue);
	}

}
