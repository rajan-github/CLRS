package chapter7;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * This class tests the {@link QuicksortWithEqualElements} by randomly
 * generating array values.
 * 
 * @author rajan
 *
 */
public class QuicksortWithEqualElementsTester {

	@Test
	public void quickSortTest() {
		int testArraySize = 1000;
		QuicksortWithEqualElements<Integer> sorter = new QuicksortWithEqualElements<>();
		Random random = new Random();
		Integer array[] = new Integer[testArraySize];
		for (int k = 0; k < 1000; k++) {
			for (int i = 0; i < testArraySize; i++) {
				array[i] = random.nextInt();
			}
			sorter.randomizedQuickSort(array, 0, array.length);
			// System.out.println(Arrays.toString(array));
			assertTrue(isInNonDecreasingOrder(array));
		}
	}

	public boolean isInNonDecreasingOrder(Integer[] array) {
		boolean result = true;
		if (array.length > 0) {
			int firstItem = array[0];
			for (int i = 1; i < array.length; i++) {
				if (firstItem > array[i]) {
					result = false;
					break;
				} else {
					firstItem = array[i];
				}
			}
		}
		return result;
	}

}
