package chapter2;

import java.util.Arrays;

public class RecursiveInsertionSort {

	public static int[] insert(int[] array, int lastIndex, int item) {
		int i = lastIndex;
		while (i >= 0 && array[i] > item) {
			array[i + 1] = array[i];
			i--;
		}
		array[i + 1] = item;
		return array;
	}

	public static void insertionSort(int[] array, int start, int end) {
		if (start < end) {
			insertionSort(array, start, end - 1);
			insert(array, end - 1, array[end]);
		}
	}

	public static void main(String args[]) {
		int[] array = { 1, -5, 3, 4, 2, 8, -9, 10 };
		insertionSort(array, 0, array.length - 1);
		System.out.println("Printing array-");
		System.out.println(Arrays.toString(array));
	}

}
