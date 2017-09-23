package chapter10;

/**
 * This list implements circular linked list. It supports insert, delete and
 * search operations. It also supports reverse operation without recursion and
 * with constant space usage.
 * 
 * @author rajan
 *
 * @param <E>
 */
public class SinglyCircularList<E> {

	private static class Node<E> {
		E data;
		Node<E> next;

		public Node(E data) {
			super();
			this.data = data;
		}

		public E getData() {
			return data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

	}

	private Node<E> head;

	public SinglyCircularList() {
		super();
		this.head = new Node<E>(null);
		head.setNext(head);
	}

	public boolean isEmpty() {
		return head.getNext() == head;
	}

	public void insert(E item) {
		Node<E> newNode = new Node<>(item);
		newNode.setNext(head.getNext());
		head.setNext(newNode);
	}

	public E delete(E item) {
		if (isEmpty()) {
			return null;
		}
		Node<E> current = head.getNext(), prev = null;
		E data = null;
		while (current != head) {
			if (current.getData().equals(item)) {
				if (prev == null) {
					head.setNext(current.getNext());
				} else {
					prev.setNext(current.getNext());
				}
				data = current.getData();
				current = null;
				break;
			} else {
				prev = current;
				current = current.getNext();
			}
		}
		return data;
	}

	public Node<E> search(E item) {
		Node<E> current = head.getNext(), foundNode = null;
		while (current != head) {
			if (current.getData().equals(item)) {
				foundNode = current;
				break;
			} else {
				current = current.getNext();
			}
		}
		return foundNode;
	}

	public void display() {
		Node<E> current = head.getNext();
		while (current != head) {
			System.out.print(current.getData() + ", ");
			current = current.getNext();
		}
	}

	/**
	 * This method reverses the circular linked list. It takes O(n) time and
	 * constant space.
	 */
	public void reverse() {
		Node<E> current = head.getNext(), prev = head, next;
		head.setNext(null);
		while (current != head) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head.setNext(prev);
	}

	public static void main(String args[]) {
		SinglyCircularList<Integer> list = new SinglyCircularList<>();
		Integer[] randoms = { 12, 15, 19, 17, 13, 21, 34, 9 };
		for (Integer item : randoms) {
			list.insert(item);
		}
		System.out.println("Before reverse: ");
		list.display();
		list.reverse();
		System.out.println("After reverse: ");
		list.display();
		for (Integer item : randoms) {
			System.out.println("Found node for: " + item + " is- " + list.search(item));
		}
		for (Integer item : randoms) {
			list.delete(item);
		}
		System.out.println("is list empty: " + list.isEmpty());
		list.display();
	}

}
