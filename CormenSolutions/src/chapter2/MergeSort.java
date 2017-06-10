package chapter2;

import java.util.Arrays;

public class MergeSort {

	public static int[] merge(int[] array, int p, int q, int r) {
		int[] list1 = Arrays.copyOfRange(array, p, q + 1);
		int[] list2 = Arrays.copyOfRange(array, q + 1, r + 1);
		int j = 0, k = 0, i = p;
		while ((j < list1.length) || (k < list2.length)) {
			if ((k < list2.length && j < list1.length && list1[j] >= list2[k]) || j >= list1.length) {
				array[i] = list2[k];
				k++;
			} else if (j < list1.length) {
				array[i] = list1[j];
				j++;
			}
			i++;
		}
		return array;
	}

	/**
	 * 
	 * @param array
	 * @param p
	 * @param r
	 *            this method sorts the given array and takes two parameters. p
	 *            is the first index in the array while r is the last index in
	 *            the array.
	 */
	public static void mergeSort(int[] array, int p, int r) {
		if (p < r) {
			int q = (int) Math.floor((p + r) / 2);
			mergeSort(array, p, q);
			mergeSort(array, q + 1, r);
			merge(array, p, q, r);
		}
	}

	public static void main(String args[]) {
		int array[] = { -10, 5, 7, 9, 2, 3, 4, -8, -10000 };
		mergeSort(array, 0, array.length - 1);
		System.out.println("Sorted array is-");
		System.out.println(Arrays.toString(array));
	}
}
