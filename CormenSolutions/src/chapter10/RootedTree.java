package chapter10;

import java.util.Random;

/**
 * This class implements the rooted tree. It has left child and right sibling
 * link as left and right respectively. Parent attribute of node represents
 * parent of this node and root node has null as the parent node. This
 * implementation only allows three child to one node and thus in one chain
 * there can be at most three nodes though we can change it by changing the
 * value of WIDTH constant.
 * 
 * @author rajan
 *
 * @param <E>
 */
public class RootedTree<E> {

	private static int WIDTH = 3;
	private Node<E> root;

	public RootedTree() {
		super();
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(E item) {
		Node<E> newNode = new Node<>(item);
		if (isEmpty()) {
			root = newNode;
		} else {
			Node<E> leftMostNode = root;
			while (leftMostNode != null) {
				Node<E> currentNode = leftMostNode, insertedNode = null;
				while (insertedNode == null && currentNode != null) {
					insertedNode = helperToInsert(currentNode, newNode);
					currentNode = currentNode.getRight();
				}
				if (insertedNode == null) {
					leftMostNode = leftMostNode.getLeft();
				} else {
					break;
				}

			}

		}
	}

	/**
	 * This is auxiliary insert method which is used by main insert method which
	 * takes only value for insertion.
	 * 
	 * @param currentNode
	 * @param newNode
	 * @return
	 */
	public Node<E> helperToInsert(Node<E> currentNode, Node<E> newNode) {
		Node<E> insertedNode = null;
		if (currentNode.getLeft() == null) {
			currentNode.setLeft(newNode);
			newNode.setParent(currentNode);
			insertedNode = newNode;
		} else {
			currentNode = currentNode.getLeft();
			int siblingCount = 0;
			while (currentNode.getRight() != null) {
				currentNode = currentNode.getRight();
				siblingCount++;
			}
			if (siblingCount < WIDTH - 1) {
				currentNode.setRight(newNode);
				newNode.setParent(currentNode.getParent());
				insertedNode = newNode;
			}
		}
		return insertedNode;
	}

	/**
	 * This method traverses the whole tree and prints the values stored in it. It
	 * uses stack as auxiliary storage and time taken to traverse the whole tree in
	 * O(n).
	 */
	public void traverseTree() {
		if (isEmpty()) {
			System.out.println("Tree is empty!");
		} else {
			StackUsingLinkedList<Node<E>> stack = new StackUsingLinkedList<>();
			Node<E> current = root.getLeft();
			stack.push(root);
			while (!stack.isEmpty()) {
				while (current.getLeft() != null) {
					stack.push(current);
					current = current.getLeft();
				}

				while (current != null) {
					System.out.println(current.getData() + ", ");
					current = current.getRight();
				}
				current = stack.pop();
				System.out.println(current.getData() + ", ");
				if (current.getRight() == null && !stack.isEmpty()) {
					current = stack.pop();
					System.out.println(current.getData() + ", ");
					current = current.getRight();
				} else {
					current = current.getRight();
				}
			}

		}
	}

	public static void main(String args[]) {
		RootedTree<Integer> tree = new RootedTree<>();
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			tree.insert(random.nextInt());
		}
		System.out.println("Items inserted!");
		tree.traverseTree();
	}

}
