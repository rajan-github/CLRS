package chapter10;

/**
 * This is implementation of stack using an array of limited size.
 * 
 * @author rajan
 *
 */
public class Stack<E> {

	@SuppressWarnings("unchecked")
	private E data[] = (E[]) new Object[10];

	private int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return this.data.length == size;
	}

	public E pop() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Stack is empty!");
		}
		E temp = data[size];
		data[size] = null;
		size--;
		return temp;
	}

	public void push(E item) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("Stack is full!");
		}
		this.data[size] = item;
		size++;
	}

	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<>();
		Integer[] randoms = { 2, 3, 4, 6, 7, 3, 6, 7, 0 };
		for (Integer item : randoms) {
			stack.push(item);
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
