
/**
 * Finds a peak in the array by binary search. 
*/
public class PeakInArray {

	public static void main(String[] args) {
		int arr [] = {8,7,6,5,4,3};
		int arr2 [] = {1,2,8,7,6,5,4,3};
		int arr3 [] = {1,2,3,4,4,5,5,6,7};
		int arr4 [] = {1,2,3,4,5,7,7};
		System.out.println(findPeak(arr, 0, arr.length));
		System.out.println(findPeak(arr2, 0, arr2.length));
		System.out.println(findPeak(arr3, 0, arr3.length));
		System.out.println(findPeak(arr4, 0, arr4.length));
	}
	private static int findPeak(int arr[], int start, int end) {
		int mid = (start+end)/2;
		if (mid == 0 && arr[mid] >= arr[mid+1]) {
			return arr[mid];
		} if (mid == arr.length -1 && arr[mid-1] <= arr[mid]) {
			return arr[mid];
		} else if (arr[mid-1] > arr[mid]) {
			return findPeak(arr, start, mid-1);
		} else if (arr[mid+1] > arr[mid]) {
			return findPeak(arr, mid + 1, end);
		} else {
			return arr[mid];
		}
	}
}
