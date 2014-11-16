
/**
 * Finds a peak in given array. Implements both one-d and two-d array.
 */
public class PeakInArray {

	public static void main(String[] args) {
		int arr[] = { 8, 7, 6, 5, 4, 3 };
		int arr2[] = { 1, 2, 8, 7, 6, 5, 4, 3 };
		int arr3[] = { 1, 2, 3, 4, 4, 5, 5, 6, 7 };
		int arr4[] = { 1, 2, 3, 4, 5, 7, 7 };
		System.out.println(findPeak(arr, 0, arr.length));
		System.out.println(findPeak(arr2, 0, arr2.length));
		System.out.println(findPeak(arr3, 0, arr3.length));
		System.out.println(findPeak(arr4, 0, arr4.length));
		int arr2D[][] = { { 7, 8, 10, 10 }, 
						  { 14, 13, 12, 11 },
						  { 15, 9, 11, 21 }, 
						  { 16, 17, 19, 20 } };
		System.out.println(findPeak(arr2D));

	}

	/**
	 * Finds peak in one-d array using binary search
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private static int findPeak(int arr[], int start, int end) {
		int mid = (start + end) / 2;
		if (mid == 0 && arr[mid] >= arr[mid + 1]) {
			return arr[mid];
		}
		if (mid == arr.length - 1 && arr[mid - 1] <= arr[mid]) {
			return arr[mid];
		} else if (arr[mid - 1] > arr[mid]) {
			return findPeak(arr, start, mid - 1);
		} else if (arr[mid + 1] > arr[mid]) {
			return findPeak(arr, mid + 1, end);
		} else {
			return arr[mid];
		}
	}

	/**
	 * Finds max value for a given column
	 * @param arr
	 * @param col
	 * @return
	 */
	private static int findMax(int arr[][], int col) {
		int maxIdx = 0, maxVal = arr[0][col];
		for (int i = 0; i < arr[0].length; i++) {
			if (maxVal < arr[i][col]) {
				maxIdx = i;
				maxVal = arr[i][col];
			}
		}
		return maxIdx;

	}

	/**
	 * Finds peak in a 2-d array
	 * 
	 * @param arr
	 * @return
	 */
	private static int findPeak(int arr[][]) {
		int j = 0;
		int i = findMax(arr, j);
		if (arr[i][j] > arr[i][j + 1]) {
			return arr[i][j];
		}
		for (j = 1; j < arr[0].length - 1; j++) {
			i = findMax(arr, j);
			if (arr[i][j - 1] < arr[i][j] && arr[i][j + 1] < arr[i][j]) {
				return arr[i][j];
			}
		}
		i = findMax(arr, j);
		if (arr[i][j - 1] < arr[i][j]) {
			return arr[i][j];
		}
		return -1;
	}
}
