package chapter7;

import java.util.Arrays;
import java.util.Random;

/**
 * This class implements Quicksort algorithm which handles inputs with equal
 * elements efficiently. Simple quicksort algorithm takes O(n^2) if all the
 * elements are equal in input but this algorithm takes that input and handles
 * it with O(n).
 * 
 * @author rajan
 * @see Quicksort
 *
 */
public class QuicksortWithEqualElements<E extends Comparable<E>> {

	public void randomizedQuickSort(E[] array, int startIndex, int endIndex) {
		if (startIndex < endIndex && startIndex >= 0 && endIndex <= array.length) {
			int indexes[] = randomizedPartition(array, startIndex, endIndex);
			randomizedQuickSort(array, startIndex, indexes[0] + 1);
			randomizedQuickSort(array, indexes[1] + 1, endIndex);
		}
	}

	public int[] randomizedPartition(E[] array, int start, int end) {
		Random random = new Random();
		int randomNum = random.nextInt(end - start) + start;
		E temp = array[end - 1];
		array[end - 1] = array[randomNum];
		array[randomNum] = temp;
		return partition(array, start, end);
	}

	public int[] partition(E[] array, int start, int end) {
		int q = start - 1, t = start - 1;
		E pivot = array[end - 1];
		for (int j = start; j < end; j++) {
			if (array[j].compareTo(pivot) < 0) {
				E temp = array[j];
				int index = j;
				while (index > q && index > 0) {
					array[index] = array[index - 1];
					index--;
				}
				t++;
				q++;
				array[q] = temp;
			} else if (array[j].compareTo(pivot) > 0) {
				continue;
			} else {
				t++;
				E item = array[t];
				array[t] = array[j];
				array[j] = item;
			}
		}
		int[] indexes = new int[2];
		indexes[0] = q;
		indexes[1] = t;
		return indexes;
	}

	public static void main(String args[]) {
		QuicksortWithEqualElements<Integer> sorter = new QuicksortWithEqualElements<>();
		Integer[] randoms = { 1, 2, 3, 4, 4, 0, -9 };
		sorter.randomizedQuickSort(randoms, 0, randoms.length);
		System.out.println(Arrays.toString(randoms));
	}

}
