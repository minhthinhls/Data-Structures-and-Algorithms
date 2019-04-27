/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05;

import java.util.Arrays;

/**
 *
 * @author Minh Thinh
 */
public class Array {

    private static int[] array;
    private static StringBuilder sb = new StringBuilder();

    static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    static void displayArray(int[] arr) {
        Arrays.stream(arr).forEach(x -> sb.append(", ").append(x));
        System.out.println("The current array is: " + sb.toString().substring(2));
    }

    static int findMin(int array[], int n) { // N is the number of elements in array
        if (n == 1) {
            return array[0];
        } else {
            return min(array[n - 1], findMin(array, n - 1));
        }
    }

    static int findSum(int array[], int n) { // N is the number of elements in array
        if (n == 1) {
            return array[0];
        } else {
            return (array[n - 1] + findSum(array, n - 1));
        }
    }

    public static void main(String[] args) {
        array = new int[]{-1, 4, 5, 2, 10, 22, 15};
        displayArray(array);
        System.out.println("*Array's smallest elements: " + findMin(array, array.length));
        System.out.println("*Array's sum of all elements: " + findSum(array, array.length));
    }

}
