/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

import java.util.Random;

/**
 *
 * @author Minh Thinh
 */
public class Heap {

    /**
     * The main function to that sorts array[] of size n using Heap Sort.
     *
     * @param arr. Integer array[]
     */
    static void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array).
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap.
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end.
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap.
            heapify(arr, i, 0);
        }
    }

    /**
     * The main function to that sorts array[] of size n using Heap Sort.
     *
     * @param arr. Long array[]
     */
    static void heapSort(long arr[]) {
        int n = arr.length;

        // Build heap (rearrange array).
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap.
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end.
            long temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap.
            heapify(arr, i, 0);
        }
    }

    /**
     * To heap a subtree rooted with node i which is an index in array[].
     *
     * @param arr. Integer array[]
     * @param n. The size of heap
     * @param i
     */
    static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root.
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root.
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root.
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree.
            heapify(arr, n, largest);
        }
    }

    /**
     * To heap a subtree rooted with node i which is an index in array[].
     *
     * @param arr. Long array[]
     * @param n. The size of heap
     * @param i
     */
    static void heapify(long arr[], int n, int i) {
        int largest = i; // Initialize largest as root.
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root.
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root.
        if (largest != i) {
            long swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree.
            heapify(arr, n, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /* A utility function to print array of size n */
    static void printArray(long arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //-----------------------------------------------------------
    public static int[] randomInit(int numElements) {
        int arr[] = new int[numElements];
        Random aRandom = new Random();
        for (int i = 0; i < numElements; i++) {
            arr[i] = Math.abs(aRandom.nextInt() % 100000000);
            // Assign randomly positive integers to the array.
        }
        return arr;
    }

    //-----------------------------------------------------------
    public static long[] randomInit(long numElements) {
        long arr[] = new long[Integer.valueOf(String.valueOf(numElements))];
        Random aRandom = new Random();
        for (int i = 0; i < numElements; i++) {
            arr[i] = Math.abs(aRandom.nextLong() % 100000000);
            // Assign randomly positive integers to the array.
        }
        return arr;
    }

    /* Driver function to check for above function */
    public static void main(String args[]) {
        // int arr[] = randomInit(500000);
        long arr[] = randomInit((long) 500000);
        long startTime = TimeUtils.now();
        heapSort(arr);
        long endTime = TimeUtils.now();
        System.out.println("Time Heap sort: " + (endTime - startTime) + "ms");
        // printArray(arr);
    }

}
