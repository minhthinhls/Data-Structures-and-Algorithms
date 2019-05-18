/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Minh Thinh
 */
public class Array {

    public static int[] randomInit(int numElements) {
        Random aRandom = new Random();
        int arr[] = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            arr[i] = Math.abs(aRandom.nextInt() % 100); // Assign a random integer value to current element of the array.
        }
        return arr;
    }

    public static void print(int arr[]) {
        System.out.print("*The array is: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(Iterable<Integer> items) {
        System.out.print("*The closest set is: ");
        for (int i : items) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int findMedian(int arr[]) {
        System.out.println("=> Sorting the array.........Success !!!");
        Arrays.sort(arr); // The array must be sorted before finding median !
        print(arr);
        return arr[arr.length / 2];
    }

    /**
     * 
     * @param arr
     * @param kItems
     * @return List of items closest to the median.
     */
    public static List getClosestItemSet(int arr[], int kItems) {
        if (arr.length - 1 < kItems) {
            throw new NullPointerException("The array is not large enough !");
        }
        if (kItems % 2 == 0) { // If kItems is even !
            return getClosestRangeSet(arr, kItems / 2); // Range = numElems / 2;
        }
        // Else if kItems is odd !
        final int range = kItems / 2;
        final int median = arr.length / 2;
        List<Integer> closestElems = getClosestRangeSet(arr, range);
        try {
            int distanceA = arr[median] - arr[median - range - 1];
            int distanceB = arr[median + range + 1] - arr[median];
            /* Add the element has closer value to median ! */
            if (distanceA <= distanceB) { // Add left-most item !
                closestElems.add(0, arr[median - range - 1]);
            } else { // Add right-most item !
                closestElems.add(arr[median + range + 1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            /* If right-most item does not exist, then add left-most item ! */
            closestElems.add(0, arr[median - range - 1]);
        }
        return closestElems;
    }

    /**
     * Range is the adjacent distance to cover neighbor elements into the set.
     *
     * @param arr
     * @param range
     * @return
     */
    public static List getClosestRangeSet(int arr[], int range) {
        if ((arr.length - 1) / 2 < range) {
            throw new NullPointerException("The array is not large enough !");
        }
        List<Integer> closestElems = new ArrayList<>();
        Arrays.sort(arr); // Make sure the array is sorted !
        int median = arr.length / 2;
        for (int i = median - range; i <= median + range; i++) {
            if (i == median) {
                continue; // Skip median value !
            }
            closestElems.add(arr[i]);
        }
        return closestElems;
    }

    public static void main(String[] args) {
        int[] arr = randomInit(10);
        print(arr);
        System.out.println("=> The median: " + findMedian(arr));
        print(getClosestItemSet(arr, 5));
    }
}
