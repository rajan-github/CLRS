package chapter10;

/**
 * This class implements Mergeable MIN heap using the sorted doubly linked list
 * which offers INSERT, MINIMUM, EXTRACT-MIN AND UNION operations.
 * 
 * @author rajan
 * @see Node
 * @param <E>
 */
public class MergeableHeap<E extends Comparable<E>> {
	private Node<E> root = new Node<>(null);

	public MergeableHeap() {
		super();
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
		return root.getNextNode() == root;
	}

	public void insert(E item) {
		if (item == null) {
			throw new IllegalArgumentException("Cannot insert null in heap!");
		}
		Node<E> newNode = new Node<>(item);
		if (isEmpty()) {
			root.setNextNode(newNode);
			root.setPrevNode(newNode);
			newNode.setPrevNode(root);
			newNode.setNextNode(root);
		} else if (root.getPrevNode().getData().compareTo(newNode.getData()) <= 0) {
			root.getPrevNode().setNextNode(newNode);
			newNode.setPrevNode(root.getPrevNode());
			newNode.setNextNode(root);
			root.setPrevNode(newNode);
		} else {
			Node<E> head = root;
			while (head.getNextNode() != root && head.getNextNode().getData().compareTo(newNode.getData()) <= 0) {
				head = head.getNextNode();
			}
			head = head.getNextNode();
			newNode.setNextNode(head);
			newNode.setPrevNode(head.getPrevNode());
			head.getPrevNode().setNextNode(newNode);
			head.setPrevNode(newNode);
		}
	}

	public E minimum() {
		return root.getNextNode().getData();
	}

	public E extractMinimum() {
		E data = null;
		if (!isEmpty()) {
			data = root.getNextNode().getData();
			root.getNextNode().setPrevNode(root);
			root.setNextNode(root.getNextNode().getNextNode());
		}
		return data;
	}

	public void union(MergeableHeap<E> heap) {
		while (!heap.isEmpty()) {
			this.insert(heap.extractMinimum());
		}
	}

	public void display() {
		if (!isEmpty()) {
			Node<E> head = root.getNextNode();
			while (head != root) {
				System.out.print(head.getData() + ", ");
				head = head.getNextNode();
			}
		}

	}

	public static void main(String args[]) {
		MergeableHeap<Integer> heap = new MergeableHeap<>();
		Integer[] randoms = { 11, 10, 9, 8, 23, -23, 56, -100 };
		for (Integer item : randoms) {
			heap.insert(item);
		}

		MergeableHeap<Integer> heap2 = new MergeableHeap<>();
		Integer[] randoms2 = { 1231, 1467, -980, 675, 5362 };

		for (Integer item : randoms2) {
			heap2.insert(item);
		}

		heap.union(heap2);

		while (!heap.isEmpty()) {
			System.out.print(heap.extractMinimum() + ", ");
		}
		System.out.println(heap.isEmpty());
		// heap.display();
	}
}
