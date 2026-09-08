package main.java;

import java.time.Duration;
import java.time.Instant;

public class MaxSubarrayDivideConquer {
	
	public static void main(String[] args) {
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4};
		long startTime, endTime, duration;
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();
		System.out.println("Brute Force: " + MaxSubarrayBruteForce.maxSubarray(arr));
		endTime = System.currentTimeMillis();
        duration = (endTime - startTime);
        System.out.println("The runtime in milliseconds: " + duration);
		startTime = System.currentTimeMillis();
        System.out.println("Divide & Conquer: " + MaxSubarrayDivideConquer.maxSubarray(arr, 0, arr.length - 1));
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);
        System.out.println("The runtime in milliseconds: " + duration);
        startTime = System.currentTimeMillis();
        System.out.println("Kadane: " + MaxSubarrayKadane.maxSubarray(arr));
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);
        System.out.println("The runtime in milliseconds: " + duration);
	}
	
	public class MaxSubarrayBruteForce {
	    public static int maxSubarray(int[] arr) {
	        int n = arr.length;
	        int maxSum = Integer.MIN_VALUE;

	        for (int i = 0; i < n; i++) {
	            int currentSum = 0;
	            for (int j = i; j < n; j++) {
	                currentSum += arr[j];
	                if (currentSum > maxSum) {
	                    maxSum = currentSum;
	                }
	            }
	        }
	        return maxSum;
	    }
	}
	
    public static int maxSubarray(int[] arr, int low, int high) {
        if (low == high) {
            return arr[low];
        }

        int mid = (low + high) / 2;

        int leftSum = maxSubarray(arr, low, mid);
        System.out.println("leftSum = " + leftSum);
        int rightSum = maxSubarray(arr, mid + 1, high);
        System.out.println("rightSum = " + rightSum);
        int crossSum = maxCrossingSum(arr, low, mid, high);
        System.out.println("crossSum = " + crossSum);
        System.out.println("------");
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private static int maxCrossingSum(int[] arr, int low, int mid, int high) {
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftMax) {
            	System.out.println("(mid, low) = " + mid + ", "  +low);
                leftMax = sum;
            }
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += arr[j];
            if (sum > rightMax) {
                rightMax = sum;
            }
        }
        System.out.println("leftMax = " + leftMax);
        System.out.println("rightMax = " + rightMax);
        return leftMax + rightMax;
    }
    
    public class MaxSubarrayKadane {
        public static int maxSubarray(int[] arr) {
            int maxEndingHere = arr[0];
            int maxSoFar = arr[0];
            //-2, 1, -3, 4, -1, 2, 1, -5, 4
            for (int i = 1; i < arr.length; i++) {
                maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
                maxSoFar = Math.max(maxSoFar, maxEndingHere);
            }

            return maxSoFar;
        }
    }
}