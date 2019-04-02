/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Minh Thinh
 */
public class Radix {

    /**
     * The main function to that sorts array[] of size n using Radix Sort
     *
     * @param arr. Integer array[]
     * @param n
     */
    static void radixSort(int arr[], int n) {
        // Find the maximum number to know number of digits 
        int max = getMax(arr, n);

        /* Do counting sort for every digit. Note that instead 
        of passing digit number, exp is passed. exp is 10^i 
        where i is current digit number */
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    /**
     * The main function to that sorts array[] of size n using Radix Sort
     *
     * @param arr. Long array[]
     * @param n
     */
    static void radixSort(long arr[], int n) {
        // Find the maximum number to know number of digits 
        long max = getMax(arr, n);

        /* Do counting sort for every digit. Note that instead 
        of passing digit number, exp is passed. exp is 10^i 
        where i is current digit number */
        for (long exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    /**
     * A function to do counting sort of array[] according to the digit
     * represented by exponential.
     *
     * @param arr. Integer array[]
     * @param n
     * @param exp
     */
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        /* Change count[i] so that count[i] now contains 
        actual position of this digit in output[] */
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array 
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        /* Copy the output array to arr[], so that arr[] now 
        contains sorted numbers according to curent digit */
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    /**
     * A function to do counting sort of array[] according to the digit
     * represented by exponential.
     *
     * @param arr. Long array[]
     * @param n
     * @param exp
     */
    static void countSort(long arr[], int n, long exp) {
        long output[] = new long[n]; // output array 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) {
            int pos = Integer.valueOf(String.valueOf((arr[i] / exp) % 10));
            count[pos]++;
        }

        /* Change count[i] so that count[i] now contains 
        actual position of this digit in output[] */
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array 
        for (i = n - 1; i >= 0; i--) {
            int pos = Integer.valueOf(String.valueOf((arr[i] / exp) % 10));
            output[count[pos] - 1] = arr[i];
            count[pos]--;
        }

        /* Copy the output array to arr[], so that arr[] now 
        contains sorted numbers according to curent digit */
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    /**
     * A utility function to get maximum value in array[]
     *
     * @param arr. Integer array[]
     * @param n
     * @return
     */
    static int getMax(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * A utility function to get maximum value in array[]
     *
     * @param arr. Long array[]
     * @param n
     * @return
     */
    static long getMax(long arr[], int n) {
        long max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
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
    public static void main(String[] args) {
        // int arr[] = randomInit(500000);
        long arr[] = randomInit((long) 500000);
        long startTime = TimeUtils.now();
        radixSort(arr, arr.length);
        long endTime = TimeUtils.now();
        System.out.println("Time Radix sort: " + (endTime - startTime) + "ms");
        // printArray(arr);
    }

}
