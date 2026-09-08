package main.java;

public class DivideConquerShortestPath {
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] A = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
    	int n = A.length;
    	for (int i = n/2 - 1; i >= 0; i--) {
    		maxHeapify(A, i, n);
    	}
    	for (int i = n - 1; i > 0; i--) {
            swap(A, 0, i);       // đưa phần tử lớn nhất về cuối
            maxHeapify(A, 0, i); // heapify phần còn lại
        }
    	System.out.println("Max-Heap array:");
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }
	}

    public static void maxHeapify(int[] A, int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest;

        // Kiểm tra con trái
        if (l < n && A[l] > A[i]) {
            largest = l;
        } else {
        	largest = i;
        }

        // Kiểm tra con phải
        if (r < n && A[r] > A[largest]) {
            largest = r;
        }

        // Nếu cần hoán đổi
        if (largest != i) {
            swap(A, i, largest);
            maxHeapify(A, largest, n); // đệ quy
        }
    }

	private static void swap(int[] A, int i, int j) {
		// TODO Auto-generated method stub
		int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
	}

}
