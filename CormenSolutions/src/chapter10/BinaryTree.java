package chapter10;

import java.util.Random;

public class BinaryTree<E> {

	private Node<E> root;

	public BinaryTree() {
		super();
	}

	public Node<E> getRoot() {
		return root;
	}

	public void setRoot(Node<E> root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * This function is used to get the child type left or right randomly. It
	 * returns 'left' or 'right' string randomly and based on that we choose child.
	 * 
	 * @return
	 */
	public String getChildType() {
		Random random = new Random();
		int number = random.nextInt();
		if (number % 2 == 0)
			return "left";
		return "right";
	}

	/**
	 * This method inserts new item in tree randomly in left or right subtree if
	 * tree is not empty otherwise sets the root of the tree.
	 * 
	 * @param item
	 */
	public void insert(E item) {
		Node<E> newNode = new Node<>(item);
		if (isEmpty()) {
			root = newNode;
		} else {
			Node<E> current = root;
			while (true) {
				if (getChildType() == "left") {
					if (current.getLeft() == null) {
						current.setLeft(newNode);
						newNode.setParent(current);
						break;
					} else {
						current = current.getLeft();
					}
				} else {
					if (current.getRight() == null) {
						current.setRight(newNode);
						newNode.setParent(current);
						break;
					} else {
						current = current.getRight();
					}
				}
			}

		}
	}

	/**
	 * This is recursive method to traverse the whole tree. It takes root of the
	 * tree and traverses the whole tree.
	 * 
	 * @param root
	 */
	public void traverseTree(Node<E> root) {
		if (root != null) {
			System.out.println(root.getData());
			traverseTree(root.getLeft());
			traverseTree(root.getRight());
		}
	}

	/**
	 * This function returns elements of tree as it traverses it. It is non
	 * recursive version and it uses stack as auxiliary storage.
	 * 
	 * @return
	 */
	public void traverseWithStack() {
		StackUsingLinkedList<Node<E>> stack = new StackUsingLinkedList<>();
		Node<E> current = root;
		while (current != null) {
			if (current.getLeft() != null) {
				stack.push(current);
				current = current.getLeft();
				continue;
			}
			System.out.println(current.getData());
			if (!stack.isEmpty()) {
				current = stack.pop();
				System.out.println(current.getData());
			}
			current = current.getRight();

		}

	}

	public static void main(String args[]) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		Integer[] randoms = { 12, 15, 19, 17, 13, 21, 34, 9 };
		for (Integer item : randoms) {
			tree.insert(item);
		}
		System.out.println("Traversing with recursive method-");
		tree.traverseTree(tree.getRoot());
		System.out.println("Traversing without recursive method-");
		tree.traverseWithStack();
	}

}
