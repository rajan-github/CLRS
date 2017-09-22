package chapter10;

/**
 * This class implements a queue with the help of two stacks. It takes two
 * stacks and emulate the enqueue and dequeue operations using push and pops on
 * stack.
 * 
 * @author rajan
 *
 */
public class QueueWithTwoStack<E> {

	private Stack<E> pushStack;
	private Stack<E> popStack;

	public QueueWithTwoStack(Stack<E> pushStack, Stack<E> popStack) {
		super();
		this.pushStack = pushStack;
		this.popStack = popStack;
	}

	public boolean isFull() {
		return pushStack.isFull() || popStack.isFull();
	}

	public boolean isEmpty() {
		return pushStack.isEmpty() && popStack.isEmpty();
	}

	public void enqueue(E item) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("Queue is full!");
		}
		if (this.isEmpty()) {
			pushStack.push(item);
		} else {
			while (!popStack.isEmpty()) {
				pushStack.push(popStack.pop());
			}
			pushStack.push(item);
		}

	}

	public E dequeue() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Queue is empty!");
		}
		while (!pushStack.isEmpty()) {
			popStack.push(pushStack.pop());
		}
		return popStack.pop();
	}

	public static void main(String args[]) {
		QueueWithTwoStack<Integer> queue = new QueueWithTwoStack<>(new Stack<Integer>(), new Stack<Integer>());
		Integer[] randoms = { 2, 3, 4, 6, 7, 3, 6, 7, 0, 11 };
		for (Integer item : randoms) {
			queue.enqueue(item);
		}
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}

}
