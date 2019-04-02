/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

import java.util.Arrays;

/**
 *
 * @author Minh Thinh
 */
public class SortingApp {

    static void SortApp(Array arr, String sortType, boolean doInverse) {
        long startTime, endTime, duration;
        // Get time just before running sorting algorithm.
        startTime = TimeUtils.now();
        switch (sortType) {
            case "Bubble":
                if (doInverse) {
                    arr.bubbleSortInverse();
                } else {
                    arr.bubbleSort();
                }
                break;
            case "Selection":
                if (doInverse) {
                    arr.selectionSortInverse();
                } else {
                    arr.selectionSort();
                }
                break;
            case "Insertion":
                if (doInverse) {
                    arr.insertionSortInverse();
                } else {
                    arr.insertionSort();
                }
                break;
            case "Radix":
                Radix.radixSort(arr.getA(), arr.getA().length);
                break;
            case "Heap":
                Heap.heapSort(arr.getA());
                break;
            default:
                System.out.println("Please choose sorting type !!!");
                return;
        }
        // Get time just after running sorting.
        endTime = TimeUtils.now();

        // Counting time needed.
        duration = endTime - startTime;
        System.out.println("*Time " + ((doInverse) ? "Inversely " : "") + sortType + " sort: " + duration + "ms");
        arr.display();
    }

    static void run(int maxSize) {
        // Create the array with maxSize.
        Array array = new Array(maxSize);
        System.out.println("# Sorting time with " + maxSize + " items randomly ordered in array.");
        // Initializing arrays.
        array.randomInit(maxSize);
        Array bubble = new Array(maxSize);
        bubble.setA(array.getA().clone());
        Array selection = new Array(maxSize);
        selection.setA(array.getA().clone());
        Array insertion = new Array(maxSize);
        insertion.setA(array.getA().clone());
        Array radix = new Array(maxSize);
        radix.setA(array.getA().clone());
        Array heap = new Array(maxSize);
        heap.setA(array.getA().clone());
        /* Start sorting */
        array.display();
        SortApp(bubble, "Bubble", false);
        SortApp(selection, "Selection", false);
        SortApp(insertion, "Insertion", false);
        SortApp(radix, "Radix", false);
        SortApp(heap, "Heap", false);
        System.out.println("");
    }

    static void runSpecial(int maxSize) {
        // Create the array with maxSize.
        Array array = new Array(maxSize);
        // Initializing arrays.
        array.randomInit(maxSize);
        Arrays.sort(array.getA());
        Array bubble = new Array(maxSize);
        bubble.setA(array.getA().clone());
        Array selection = new Array(maxSize);
        selection.setA(array.getA().clone());
        Array insertion = new Array(maxSize);
        insertion.setA(array.getA().clone());
        array.display();
        SortApp(bubble, "Bubble", false);
        SortApp(selection, "Selection", false);
        SortApp(insertion, "Insertion", false);
        System.out.println("");
        SortApp(bubble, "Bubble", true);
        SortApp(selection, "Selection", true);
        SortApp(insertion, "Insertion", true);
    }

    public static void main(String[] args) {

        // Calculate the time
        System.out.println("*TABLE 1: \n");
        run(10000);
        run(15000);
        run(20000);
        run(25000);
        run(30000);
        run(35000);
        run(40000);
        run(45000);
        run(50000);
        // Finish TABLE 1

        System.out.println("*TABLE 2: \n");
        runSpecial(10000);
        // Finish TABLE 2
    } // End main()
}
