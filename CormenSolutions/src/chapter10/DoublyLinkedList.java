package chapter10;

/**
 * This class implements the doubly linked list. It supports add, delete and
 * display operations.
 * 
 * @author rajan
 *
 */
public class DoublyLinkedList<E> {

	private static class Node<E> {
		E data;
		Node<E> prev;
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

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + ((prev == null) ? 0 : prev.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("unchecked")
			Node<E> other = (Node<E>) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (prev == null) {
				if (other.prev != null)
					return false;
			} else if (!prev.equals(other.prev))
				return false;
			return true;
		}

	}

	private Node<E> nilNode = new Node<>(null);

	public DoublyLinkedList() {
		super();
		nilNode.setNext(nilNode);
		nilNode.setPrev(nilNode);
	}

	public boolean isEmpty() {
		return nilNode.getNext().equals(nilNode);
	}

	public void insert(E item) {
		if (item == null) {
			throw new IllegalArgumentException("Null cannot be inserted");
		}
		Node<E> newNode = new Node<>(item);
		newNode.setPrev(nilNode.getPrev());
		newNode.setNext(nilNode);
		nilNode.getPrev().setNext(newNode);
		nilNode.setPrev(newNode);

	}

	public void delete(E item) {
		Node<E> start = nilNode;
		while (!start.getNext().equals(nilNode)) {
			Node<E> temp = start.getNext();
			if (temp.getData().equals(item)) {
				temp.getPrev().setNext(temp.getNext());
				temp.getNext().setPrev(temp.getPrev());
				break;
			} else {
				start = temp;
			}
		}
	}

	public void display() {
		Node<E> start = nilNode;
		while (!start.getNext().equals(nilNode)) {
			System.out.print(start.getNext().getData() + ", ");
			start = start.getNext();
		}
		System.out.println();
	}

	public static void main(String args[]) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		Integer[] randoms = { 12, 15, 19, 17, 13, 21, 34, 9 };
		for (Integer item : randoms) {
			list.insert(item);
		}
		list.display();
		for (Integer item : randoms) {
			list.delete(item);
		}
		list.display();
	}

}
