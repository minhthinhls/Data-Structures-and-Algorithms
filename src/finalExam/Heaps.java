/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalExam;

import lab06.Node;
import lab06.Tree;

/**
 *
 * @author Minh Thinh
 */
public class Heaps {

    private final Tree heapTree;

    public Tree getHeapTree() {
        return heapTree;
    }

    /**
     * Constructor to build the binary Tree from the @array[]
     *
     * @param arr
     */
    public Heaps(int arr[]) {
        heapTree = new Tree();
        try {
            heapTree.setRoot(new Node(arr[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        heapify(arr, heapTree.getRoot(), 1); // Start heapifying from the 1st position of array.
    }

    /**
     * This function is to heaping the array into binary Tree.
     *
     * @param arr
     * @param parent
     * @param parentPosition
     */
    private void heapify(int arr[], Node parent, int parentPosition) {
        if (parentPosition > arr.length) {
            return;
        }
        try {
            parent.leftChild = new Node(arr[2 * parentPosition - 1]);
            heapify(arr, parent.leftChild, 2 * parentPosition);
            parent.rightChild = new Node(arr[2 * parentPosition]);
            heapify(arr, parent.rightChild, 2 * parentPosition + 1);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * Heaping up the array into a max Heaped Array.
     *
     * @param arr
     * @param n
     * @param i
     */
    private static void maxHeapify(int arr[], int n, int i) {
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
            maxHeapify(arr, n, largest);
        }
    }

    /**
     * Heaping up all the array to form a fully heaped Array.
     *
     * @param arr
     */
    private static void buildMaxHeapify(int arr[]) {
        // Build heap (rearrange array).
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, arr.length, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = Array.randomInit(10);
        Array.print(arr);

        (new Heaps(arr)).heapTree.displayTree(); // Display array as heaped Binary Tree.
        System.out.println("=> Heapifying the array.........Success !!!");
        buildMaxHeapify(arr); // Build max heaped array.
        Array.print(arr);
        (new Heaps(arr)).heapTree.displayTree(); // Display array as max heaped Binary Tree.
    }

}
