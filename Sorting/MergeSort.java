/*
Merge Sort

Based on Divide & Conquer Approach.
It is Depth First Sorting technique. 

Time Complexity: O(nlogn)

Space Complexity: O(n)

*/

package Sorting;

import java.util.Arrays;

public class MergeSort {
    // O(n)
    public static void conquer(int[] arr, int si, int mid, int ei) {
        int idx1 = si; // Iterator for left Part
        int idx2 = mid + 1; // Iterator for right Part
        int[] merged = new int[ei - si + 1];
        int x = 0;

        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] >= arr[idx2]) {
                merged[x++] = arr[idx2++];
            } else {
                merged[x++] = arr[idx1++];
            }
        }

        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    // O(logn)
    public static void divide(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2; // To avoid space complexity issue

        divide(arr, si, mid);
        divide(arr, (mid + 1), ei);
        conquer(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 1, 3, 9, 4 };

        System.out.println("Array before Sorting: ");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        divide(arr, 0, 6);

        System.out.println("Array after Sorting: ");
        System.out.println(Arrays.toString(arr));
    }
}
