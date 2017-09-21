package chapter10;

/**
 * This class implements Dequeue: a variant of queue which allows to insert or
 * delete at both ends.
 * 
 * @author rajan
 *
 */
public class Dequeue<E> {

	@SuppressWarnings("unchecked")
	private E[] data = (E[]) new Object[10];

	private int total = 0, start = 0, end = 0;

	public boolean isEmpty() {
		return total == 0;
	}

	public boolean isFull() {
		return total == data.length;
	}

	public void enEqueueAtFront(E item) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("Dequeue is full!");
		}
		if (start == 0) {
			System.err.println("Front of the dequeue is full");
			return;
		}
		if (isEmpty()) {
			data[start] = item;
		} else {
			start -= 1;
			data[start] = item;
		}
		total++;
	}

	public E dequeueAtFront() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Dequeue is empty!");
		}
		E temp = data[start];
		data[start] = null;
		total--;
		start = (start < data.length - 1) ? start + 1 : 0;
		return temp;
	}

	public void enEqeueAtEnd(E item) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("Dequeue is full!");
		}
		data[end] = item;
		total++;
		end = (end < data.length - 1) ? (end + 1) : 0;
	}

	public E dequeueAtEnd() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Dequeue is empty!");
		}
		E temp;
		if (end == 0) {
			temp = data[data.length - 1];
			end = data.length - 1;
			data[end] = null;
		} else {
			end -= 1;
			temp = data[end];
			data[end] = null;
		}
		total--;
		return temp;
	}

	public static void main(String args[]) {
		Dequeue<Integer> dqueue = new Dequeue<>();
		Integer[] randoms = { 2, 3, 4, 6, 7, 3, 6, 7, 0, 11 };
		for (Integer item : randoms) {
			dqueue.enEqeueAtEnd(item);
		}
		while (!dqueue.isEmpty()) {
			System.out.println(dqueue.dequeueAtEnd());
		}
	}

}
