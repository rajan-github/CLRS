package chapter10;

/**
 * This program implements queue using the limited size array.
 * 
 * @author rajan
 *
 */
public class Queue<E> {

	@SuppressWarnings("unchecked")
	private E data[] = (E[]) new Object[10];

	private int start = 0, end = 0, total = 0;

	public boolean isEmpty() {
		return total == 0;
	}

	public boolean isFull() {
		return total == data.length;
	}

	public void enqueue(E item) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("Queue is full!");
		}
		data[end] = item;
		total++;
		end = (end < data.length - 1) ? (end + 1) : 0;
	}

	public E dqueue() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Queue is empty");
		}
		E temp = data[start];
		data[start] = null;
		total--;
		start = (start < data.length - 1) ? start + 1 : 0;
		return temp;
	}

	public static void main(String args[]) {
		Queue<Integer> queue = new Queue<>();
		Integer[] randoms = { 2, 3, 4, 6, 7, 3, 6, 7, 0, 11 };
		for (Integer item : randoms) {
			queue.enqueue(item);
		}
		while (!queue.isEmpty()) {
			System.out.println(queue.dqueue());
		}
	}

}
