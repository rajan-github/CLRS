package chapter10;

/**
 * This class implements singly linked list. As insertion takes place at head of
 * the list insertion time is constant O(1) and delete takes O(n) where n is the
 * size of the list because in worst case whole list will be searched.
 * 
 * @author rajan
 *
 */
public class SinglyLinkedList<E> {

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

		// public void setData(E data) {
		// this.data = data;
		// }

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

	}

	private Node<E> head;

	public SinglyLinkedList() {
		super();
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void insert(E item) {
		Node<E> newNode = new Node<>(item);
		newNode.setNext(head);
		head = newNode;
	}

	public void delete(E item) {
		Node<E> current = head, prev = null;
		while (current != null) {
			if (current.getData().equals(item)) {
				if (prev == null)
					head = current.getNext();
				else
					prev.setNext(current.getNext());
				current = null;
				break;
			} else {
				prev = current;
				current = current.getNext();
			}
		}
	}

	public E deleteAtHead() {
		if (isEmpty()) {
			System.out.println("List is empty!");
			return null;
		}
		E temp = head.getData();
		head = head.getNext();
		return temp;
	}

	public void display() {
		Node<E> current = head;
		while (current != null) {
			System.out.print(current.getData() + ", ");
			current = current.getNext();
		}
		System.out.println();
	}

	public static void main(String args[]) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		Integer[] randoms = { 12, 15, 19, 17, 13, 21, 34, 9 };
		for (Integer item : randoms) {
			list.insert(item);
		}
		list.display();
		for (Integer item : randoms) {
			list.delete(item);
		}
		System.out.println("is list empty: " + list.isEmpty());
		list.display();
	}

}
