package main.java;

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int k = 23;

        int result = binarySearch(array, 0, array.length - 1, k);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
	}
	
	// Recursive Binary Search function
    public static int binarySearch(int[] A, int low, int high, int k) {
        if (low > high) {
            return -1; // Element not found
        }

        int mid = low + (high - low) / 2;

        if (A[mid] == k) {
            return mid; // Element found
        } else if (k < A[mid]) {
            return binarySearch(A, low, mid - 1, k);
        } else {
            return binarySearch(A, mid + 1, high, k);
        }
    }

}
