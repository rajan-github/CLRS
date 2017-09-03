package chapter7;

import java.util.Arrays;

/**
 * this is simple implementation of the quicksort algorithm which runs in O(lgn)
 * time on average and doesn't implement any randomization technique to improve
 * the running time.
 * 
 * @author rajan
 *
 */
public class Quicksort {

	/**
	 * this method is implements the quicksort algorithm which sorts arrays in
	 * O(lgn) time in best case. This accepts two arguments called startIndex,
	 * endIndex which are start and end indexes respectively of the array which is
	 * being sorted. Here endIndex is exclusive while start index is inclusive.
	 * 
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 */
	public static void quickSort(int array[], int startIndex, int endIndex) {
		if (startIndex < endIndex && startIndex >= 0 && endIndex <= array.length) {
			int pivot = partition(array, startIndex, endIndex);
			quickSort(array, startIndex, pivot);
			quickSort(array, pivot + 1, endIndex);
		}
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
				int temp = array[j];
				i += 1;
				array[j] = array[i];
				array[i] = temp;
			}
		}
		array[end - 1] = array[i + 1];
		array[i + 1] = pivot;
		return i + 1;
	}

	public static void main(String args[]) {
		// int array[] = { 2, 8, 7, 1, 3, 5, 6, 4 };
		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println("Sorting using the quickSort: ");
		quickSort(array, 0, array.length);
		System.out.println(Arrays.toString(array));
	}
}
