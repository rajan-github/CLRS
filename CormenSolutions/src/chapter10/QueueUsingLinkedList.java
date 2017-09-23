package chapter10;

public class QueueUsingLinkedList<E> {

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

	}

	private Node<E> head, tail;

	public QueueUsingLinkedList() {
		super();
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void enQueue(E item) {
		Node<E> newNode = new Node<>(item);
		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public E deQueue() {
		if (isEmpty()) {
			return null;
		}
		E data;
		if (tail == head) {
			data = tail.getData();
			tail = null;
			head = null;
		} else {
			data = head.getData();
			head = head.getNext();
		}
		return data;
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
		QueueUsingLinkedList<Integer> list = new QueueUsingLinkedList<>();
		Integer[] randoms = { 12, 15, 19, 17, 13, 21, 34, 9 };
		for (Integer item : randoms) {
			list.enQueue(item);
		}
		list.display();
		while (!list.isEmpty()) {
			System.out.print("Dequeued: " + list.deQueue()+", ");
		}
		System.out.println("is list empty: " + list.isEmpty());
		list.display();
	}

}
