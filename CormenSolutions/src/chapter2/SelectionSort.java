package chapter2;

import java.util.Arrays;

public class SelectionSort {

	public static int[] sort(int[] array, int index) {
		if (index == array.length-1) {
			return array;
		}
		int smallest = findSmallest(array, index, array.length - 1, index);
		int temp = array[index];
		array[index] = array[smallest];
		array[smallest] = temp;
		return sort(array, index + 1);
	}

	public static int findSmallest(int array[], int lowIndex, int highIndex, int smallest) {
		if (lowIndex > highIndex) {
			return smallest;
		}
		return findSmallest(array, lowIndex + 1, highIndex, array[smallest] < array[lowIndex] ? smallest : lowIndex);
	}

	public static void main(String[] args) {
		System.out.println("Printing the smallest");
		System.out.println(Arrays.toString(sort(new int[] { 9, 9, 8, 7, 6, 5, 4, 3, 2, 1 }, 0)));
	}
}
