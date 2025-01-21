/*
Quick Sort

Based on Divide & Conquer Approach.
It works on Pivot & Partition Approach.

Pivot: The element around which the array is rotated.

Time Complexity: Worst = O(n^2)
                Average: O(nlogn)

Space Complexity: O(1)

Worst occurs when pivot is always the SMALLEST or the LARGEST element.

*/

package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, (pivotIndex - 1));
            quickSort(arr, (pivotIndex + 1), high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 5, 2, 8};
        int n = arr.length;

        System.out.println("Array before Sorting: ");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        quickSort(arr, 0, (n - 1));

        System.out.println("Array after Sorting: ");
        System.out.println(Arrays.toString(arr));
    }
}