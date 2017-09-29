package chapter10;

/**
 * This class implements the rooted tree. It has left child and right sibling
 * link as left and right respectively. Parent attribute of node represents
 * parent of this node and root node has null as the parent node.
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
					insertedNode = insert(currentNode, newNode);
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

	public Node<E> insert(Node<E> currentNode, Node<E> newNode) {
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

	// TODO: complete it
	public void traverseTree() {
		if (isEmpty()) {
			System.out.println("Tree is empty!");
		} else {
			Node<E> leftMostNode = root;
			while (leftMostNode != null) {
				// System.out.print(leftMostNode.getData() + ", ");
				Node<E> currentNode = leftMostNode;
				while (currentNode != null) {
					System.out.print(currentNode.getData() + ", ");
					Node<E> childNode = currentNode.getLeft();
					while (childNode != null) {
						System.out.print(childNode.getData() + ", ");
						childNode = childNode.getRight();
					}
					currentNode = currentNode.getRight();
				}

				leftMostNode = leftMostNode.getLeft();
			}
		}
	}

	public static void main(String args[]) {
		RootedTree<Integer> tree = new RootedTree<>();
		Integer[] randoms = { 2, 3, 4, 6, 7, 3, 6, 7, 0, 11 };
		for (Integer item : randoms) {
			tree.insert(item);
		}
		System.out.println("Items inserted!");
		tree.traverseTree();
	}

}
