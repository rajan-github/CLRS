package chapter6;

import java.util.Arrays;

/**
 * this class implements queue(first in first out) using the min-priority queue.
 * 
 * @author rajan
 *
 * @param <T>
 */
public final class Queue<T extends ObjectWithKey> {

	private T queue[];
	private int queueSize;

	@SuppressWarnings("unchecked")
	public Queue() {
		super();
		queue = (T[]) new ObjectWithKey[16];
		queueSize = 0;
	}

	@SuppressWarnings("unchecked")
	public Queue(T[] queue) {
		super();
		this.queue = (T[]) new ObjectWithKey[queue.length];
		for (int i = 0; i < queue.length; i++) {
			this.insert(queue[i]);
			queue[i] = null;
		}
	}

	private int left(int i) {
		return 2 * i + 1;
	}

	private int right(int i) {
		return 2 * i + 2;
	}

	// private int parent(int i) {
	// return (int) (Math.ceil(i / 2.0) - 1);
	// }

	private void ensureSize() {
		if (this.queueSize >= this.queue.length) {
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new ObjectWithKey[2 * this.queue.length];
			for (int i = 0; i < this.queue.length; i++) {
				newArray[i] = this.queue[i];
				this.queue[i] = null;
			}
			this.queue = newArray;
		}
	}

	/**
	 * this method is used to insert the item in queue and this in order to maintain
	 * the proper queue calls auxiliary methods to reorder queue. This method is
	 * also used when queue is initialized with an array and then this method is
	 * used to insert all items in queue.
	 * 
	 * @param object
	 */
	private void insert(T object) {
		ensureSize();
		object.setKey(Integer.MAX_VALUE);
		this.queue[this.queueSize] = object;
		int i = this.queueSize;
		queueSize += 1;
		this.queue[i].setKey((i - 1) >= 0 ? this.queue[i - 1].getKey() - 1 : 0);
	}

	private T extractMin() {
		T min = null;
		if (this.queueSize > 0) {
			min = this.queue[0];
			this.queue[0] = this.queue[this.queueSize - 1];
			this.queue[this.queueSize - 1] = null;
			this.queueSize -= 1;
			this.minHeapify(0);
		}
		return min;

	}

	private void minHeapify(int i) {
		if (i >= 0 && i < this.queueSize) {
			int left = left(i), right = right(i), smallest = i;
			if (left < queueSize && queue[left].getKey() < queue[smallest].getKey()) {
				smallest = left;
			}
			if (right < queueSize && queue[right].getKey() < queue[smallest].getKey()) {
				smallest = right;
			}
			if (smallest != i) {
				T temp = this.queue[i];
				this.queue[i] = this.queue[smallest];
				this.queue[smallest] = temp;
				minHeapify(smallest);
			}
		}

	}

	/**
	 * this method pushes an element into the queue and returns the size of the new
	 * queue. This is the public api which exposes the queue operations to public.
	 * 
	 * @param object
	 * @return
	 */
	public int push(T object) {
		this.insert(object);
		return this.queueSize;
	}

	/**
	 * this method pop the element. Since this is first in first out queue so this
	 * would first pop out elements which were first inserted. This method returns
	 * null if queue is empty.
	 * 
	 * @return
	 */
	public T pop() {
		return this.extractMin();
	}

	/**
	 * this method returns the current queue size.
	 * 
	 * @return
	 */
	public int getQueueSize() {
		return queueSize;
	}

	@Override
	public String toString() {
		return "Queue [queue=" + Arrays.toString(queue) + ", queueSize=" + queueSize + "]";
	}

	public static void main(String args[]) {
		Tasks[] tasks = { new Tasks(1, "Second"), new Tasks(3, "Third"), new Tasks(0, "First"),
				new Tasks(4, "Fourth") };
		Queue<Tasks> queue = new Queue<>(tasks);
		System.out.println(queue);
		System.out.println("Popping out the elements-");
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());

	}

}
