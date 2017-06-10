package chapter2;

public class BinarySearch {

	/**
	 * this method takes array, first valid index in array, last valid index in
	 * array and item to search for in the given array. After searchihg returns
	 * -1 if not found in array otherwise returns index in the array.
	 * 
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 * @param item
	 * @return index of the found position.
	 */
	public static int binarySearch(int[] array, int startIndex, int endIndex, int item) {
		if (startIndex < endIndex) {
			int mid = (endIndex + startIndex) / 2;
			if (array[mid] == item)
				return mid;
			else if (array[mid] < item)
				return binarySearch(array, mid + 1, endIndex, item);
			else
				return binarySearch(array, startIndex, mid - 1, item);
		} else if (startIndex == endIndex) {
			return (array[startIndex] == item) ? startIndex : -1;
		}
		return -1;
	}

	public static void main(String args[]) {
		int array[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println("Searching in the array-");
		System.out.println(binarySearch(array, 0, array.length - 1, 2));
	}

}
