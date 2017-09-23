package chapter10;

/**
 * This class implements stack using singly linked list. Its push, pop
 * operations takes O(1) as node is inserted and deleted at one end of list and
 * search is performed.
 * 
 * @author rajan
 * @see SinglyLinkedList
 * @param <E>
 */
public class StackUsingLinkedList<E> {

	private SinglyLinkedList<E> dataManager = new SinglyLinkedList<>();

	public StackUsingLinkedList() {
		super();
	}

	public boolean isEmpty() {
		return dataManager.isEmpty();
	}

	public void push(E item) {
		dataManager.insert(item);
	}

	public E pop() {
		return dataManager.deleteAtHead();
	}

	public static void main(String args[]) {
		StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
		Integer[] randoms = { 2, 3, 4, 6, 7, 3, 6, 7, 0, 11 };
		for (Integer item : randoms) {
			stack.push(item);
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
