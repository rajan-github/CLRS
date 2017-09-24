package chapter10;

/**
 * This class represents the node in tree. It has left and right child and one
 * key attribute which is the data of the node.
 * 
 * @author rajan
 *
 */
public class Node<E> {

	private E data;
	private Node<E> left;
	private Node<E> right;
	private Node<E> parent;

	public Node(E data) {
		super();
		this.data = data;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getLeft() {
		return left;
	}

	public void setLeft(Node<E> left) {
		this.left = left;
	}

	public Node<E> getRight() {
		return right;
	}

	public void setRight(Node<E> right) {
		this.right = right;
	}

	public Node<E> getParent() {
		return parent;
	}

	public void setParent(Node<E> parent) {
		this.parent = parent;
	}

}
