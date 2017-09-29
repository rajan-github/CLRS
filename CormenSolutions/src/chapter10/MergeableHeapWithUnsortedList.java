package chapter10;

/**
 * This class implements mergeable heaps by using unsorted doubly linked list.
 * It has INSERT, MINIMUM, EXTRACT-MIN AND UNION operations.
 * 
 * @author rajan
 *
 * @param <E>
 */
public class MergeableHeapWithUnsortedList<E extends Comparable<E>> {

	private Node<E> root;

	public MergeableHeapWithUnsortedList() {
		super();
		root = new Node<E>(null);
		root.setNextNode(root);
		root.setPrevNode(root);
	}

	private static class Node<E> {
		E data;
		Node<E> prevNode;
		Node<E> nextNode;

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

		public Node<E> getPrevNode() {
			return prevNode;
		}

		public void setPrevNode(Node<E> prevNode) {
			this.prevNode = prevNode;
		}

		public Node<E> getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node<E> nextNode) {
			this.nextNode = nextNode;
		}

	}

	public boolean isEmpty() {
		return this.root.getNextNode().getData() == null;
	}

	public void insert(E item) {
		if (item == null) {
			throw new IllegalArgumentException("Null values can't be inserted!");
		}
		Node<E> newNode = new Node<>(item);
		newNode.setNextNode(root.getNextNode());
		newNode.setPrevNode(root);
		newNode.getNextNode().setPrevNode(newNode);
		root.setNextNode(newNode);
	}

	public E minimum() {
		E data = null;
		if (!isEmpty()) {
			E min = root.getNextNode().getData();
			Node<E> head = root.getNextNode();
			while (head != root) {
				if (head.getData().compareTo(min) < 0) {
					min = head.getData();
				}
				head = head.getNextNode();
			}
			data = min;
		}
		return data;
	}

	public E extractMinimum() {
		E data = null;
		if (!isEmpty()) {
			Node<E> min = root.getNextNode();
			Node<E> head = root.getNextNode();
			while (head != root) {
				if (head.getData().compareTo(min.getData()) < 0) {
					min = head;
				}
				head = head.getNextNode();
			}
			min.getPrevNode().setNextNode(min.getNextNode());
			min.getNextNode().setPrevNode(min.getPrevNode());
			data = min.getData();
		}
		return data;
	}

	public void union(MergeableHeapWithUnsortedList<E> heap2) {
		while (!heap2.isEmpty()) {
			this.insert(heap2.extractMinimum());
		}
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Heap is empty!");
		}
		Node<E> head = root.getNextNode();
		while (head != root) {
			System.out.print(head.getData() + ", ");
			head = head.getNextNode();
		}
	}

	public static void main(String args[]) {
		MergeableHeapWithUnsortedList<Integer> heap = new MergeableHeapWithUnsortedList<>();

		Integer[] randoms = { 11, 10, 9, 8, 23, -23, 56, -100 };
		for (Integer item : randoms) {
			heap.insert(item);
		}

		MergeableHeapWithUnsortedList<Integer> heap2 = new MergeableHeapWithUnsortedList<>();
		Integer[] randoms2 = { 1231, 1467, -980, 675, 5362 };

		for (Integer item : randoms2) {
			heap2.insert(item);
		}

		heap.union(heap2);

		while (!heap.isEmpty()) {
			System.out.print(heap.extractMinimum() + ", ");
		}
		System.out.println(heap.isEmpty());

	}

}
