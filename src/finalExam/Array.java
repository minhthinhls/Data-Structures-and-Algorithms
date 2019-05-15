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

    public static void print(List<Integer> arr) {
        System.out.print("*The closest set is: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int findMedian(int arr[]) {
        System.out.println("=> Sorting the array.........Success !!!");
        Arrays.sort(arr);
        print(arr);
        return arr[arr.length / 2];
    }

    public static List getClosestSet(int arr[], int k) {
        if ((arr.length - 1) / 2 < k) {
            throw new NullPointerException("The array is not large enough !");
        }
        List<Integer> closestElems = new ArrayList<>();
        Arrays.sort(arr);
        int median = arr.length / 2;
        for (int i = median - k; i <= median + k; i++) {
            closestElems.add(arr[i]);
        }
        return closestElems;
    }

    public static void main(String[] args) {
        int[] arr = randomInit(10);
        print(arr);
        System.out.println("=> The median: " + findMedian(arr));
        print(getClosestSet(arr, 2));
    }
}
