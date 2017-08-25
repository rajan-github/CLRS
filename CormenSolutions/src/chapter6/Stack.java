package chapter6;

import java.util.Arrays;

/**
 * this class implements stack with the help of max-priorityQueue.
 * 
 * @author rajan
 *
 */
public class Stack<T extends ObjectWithKey> {
	private T stack[];
	private int stackSize;

	@SuppressWarnings("unchecked")
	public Stack() {
		super();
		stack = (T[]) new ObjectWithKey[16];
		stackSize = 0;
	}

	@SuppressWarnings("unchecked")
	public Stack(T[] array) {
		super();
		this.stack = (T[]) new ObjectWithKey[array.length];
		for (int i = 0; i < array.length; i++) {
			this.insert(array[i]);
			array[i] = null;
		}
	}

	private int left(int i) {
		return 2 * i + 1;
	}

	private int right(int i) {
		return 2 * i + 2;
	}

	private int parent(int i) {
		return (int) (Math.ceil(i / 2.0) - 1);
	}

	private void ensureSize() {
		if (this.stackSize >= this.stack.length) {
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new ObjectWithKey[2 * this.stack.length];
			for (int i = 0; i < this.stack.length; i++) {
				newArray[i] = this.stack[i];
				this.stack[i] = null;
			}
			this.stack = newArray;
		}
	}

	/**
	 * this method is used to insert the item in stack and this in order to maintain
	 * the proper stack calls auxiliary methods to reorder stack. This method is
	 * also used when stack is initialized with an array and then this method is
	 * used to insert all items in stack.
	 * 
	 * @param object
	 */
	private void insert(T object) {
		ensureSize();
		object.setKey(Integer.MIN_VALUE);
		this.stack[this.stackSize] = object;
		int i = this.stackSize;
		stackSize += 1;
		increaseKey(i, (i) >= 0 ? this.stack[0].getKey() + 1 : 0);
	}

	public void increaseKey(int index, int key) {
		if ((index > 0 && index < this.stackSize) && key > this.stack[index].getKey()) {
			this.stack[index].setKey(key);
			while (index > 0) {
				int parent = parent(index);
				if (this.stack[parent].getKey() < this.stack[index].getKey()) {
					T temp = this.stack[parent];
					this.stack[parent] = this.stack[index];
					this.stack[index] = temp;
					index = parent(index);
				} else {
					break;
				}
			}
		}
	}

	private T extractMax() {
		T max = null;
		if (this.stackSize > 0) {
			max = this.stack[0];
			this.stack[0] = this.stack[this.stackSize - 1];
			this.stack[this.stackSize - 1] = null;
			this.stackSize -= 1;
			this.maxHeapify(0);
		}
		return max;

	}

	private void maxHeapify(int i) {
		if (i >= 0 && i < this.stackSize) {
			int left = left(i), right = right(i), largest = i;
			if (left < stackSize && stack[left].getKey() > stack[largest].getKey()) {
				largest = left;
			}
			if (right < stackSize && stack[right].getKey() > stack[largest].getKey()) {
				largest = right;
			}
			if (largest != i) {
				T temp = this.stack[i];
				this.stack[i] = this.stack[largest];
				this.stack[largest] = temp;
				maxHeapify(largest);
			}
		}

	}

	/**
	 * this method pushes an element into the stack and returns the size of the new
	 * stack. This is the public api which exposes the stack operations to public.
	 * 
	 * @param object
	 * @return
	 */
	public int push(T object) {
		this.insert(object);
		return this.stackSize;
	}

	/**
	 * this method pop the element. Since this is first in first out stack so this
	 * would first pop out elements which were first inserted. This method returns
	 * null if stack is empty.
	 * 
	 * @return
	 */
	public T pop() {
		return this.extractMax();
	}

	/**
	 * this method returns the current stack size.
	 * 
	 * @return
	 */
	public int getstackSize() {
		return stackSize;
	}

	@Override
	public String toString() {
		return "stack [stack=" + Arrays.toString(stack) + ", stackSize=" + stackSize + "]";
	}

	public static void main(String args[]) {
		Tasks[] tasks = { new Tasks(1, "Second"), new Tasks(3, "Third"), new Tasks(0, "First"),
				new Tasks(4, "Fourth") };
		Stack<Tasks> stack = new Stack<>(tasks);
		System.out.println(stack);
		System.out.println("Popping out the elements-");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
