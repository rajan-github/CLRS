package chapter7;

import java.util.Arrays;
import java.util.Random;

/**
 * this class implements quicksort algorithm using the randomization to thwart
 * the possibility to get the worst case input. Expected running time of this
 * algorithm is O(logn).
 * 
 * @author rajan
 *
 */
public class RandomizedQuicksort {

	public static void randomizedQuickSort(int array[], int startIndex, int endIndex) {
		if (startIndex < endIndex && startIndex >= 0 && endIndex <= array.length) {
			int pivot = randomizedPartition(array, startIndex, endIndex);
			randomizedQuickSort(array, startIndex, pivot);
			randomizedQuickSort(array, pivot + 1, endIndex);
		}
	}

	private static int randomizedPartition(int[] array, int start, int end) {
		Random random = new Random();
		int randomNum = random.nextInt(end - start) + start;
		exchangeItem(array, randomNum, end - 1);
		return partition(array, start, end);
	}

	/**
	 * this method partition the given array around the last element of the array.
	 * This method runs in linear time. In the resulted array all elements left to
	 * the returned index are smaller and to the right of this returned index are
	 * all greater than the element at returned index.
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private static int partition(int array[], int start, int end) {
		int pivot = array[end - 1];
		int i = -1;
		for (int j = 0; j < end - 1; j++) {
			if (array[j] < pivot) {
				i += 1;
				exchangeItem(array, i, j);
			}
		}
		array[end - 1] = array[i + 1];
		array[i + 1] = pivot;
		return i + 1;
	}

	/**
	 * this method swaps the position of items array[i] and array[j].
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	private static void exchangeItem(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	public static void main(String args[]) {
		// int array[] = { 13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11 };
		int array[] = { 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 19, 21 };
		int arrayDecreasing[] = { 21, 19, 13, 12, 11, 9, 8, 7, 6, 5, 4, 2 };
		System.out.println("Sorting using the quickSort: ");
		randomizedQuickSort(array, 0, array.length);
		System.out.println(Arrays.toString(array));
		randomizedQuickSort(arrayDecreasing, 0, array.length);
		System.out.println(Arrays.toString(arrayDecreasing));
	}
}
