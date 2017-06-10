package chapter2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CompositesInSet {

	/**
	 * this method takes 'item' of type int set in which it find composites of
	 * the 'item' which sum to item. This also return as soon as it finds the
	 * first composite set which sum to 'item' in the set.
	 * 
	 * @return true if there exist in composites in the set otherwise returns
	 *         false.
	 */
	public static boolean compositeExistInSet(Set<Integer> items, int item) {
		Iterator<Integer> iterator = items.iterator();
		int[] array = new int[items.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) iterator.next();
		}
		MergeSort.mergeSort(array, 0, array.length - 1);
		for (int k : array) {
			if (BinarySearch.binarySearch(array, 0, array.length - 1, (item - k)) != -1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] array = { 9, 7, 8, 4, 3, 2, 5, 1, 0 };
		Set<Integer> set = new HashSet<Integer>();
		for (int item : array) {
			set.add(item);
		}
		System.out.println("Looking weather composites found...");
		System.out.println(compositeExistInSet(set, 10));
	}
}
