package lab02;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Minh Thinh
 */
public class BubbleSort {

    public static long now() {
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        return currentDate.getTime();
    }

    private static void swap(int[] a, int one, int two) {
        int temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    } // End swap() function

    public static void bubbleSort(int[] arr) {
        int out, in, nElems = arr.length;
        for (out = nElems - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    swap(arr, in, in + 1);
                }
            }
        }
    } // End bubbleSort() function

    public static void show(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static int[] randomInit(int numElements) {
        Random aRandom = new Random();
        int a[] = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            a[i] = Math.abs(aRandom.nextInt() % numElements);
            // Assign a random long integer value to current element of the array
        }
        return a;
    }

    public static void bubbleSortApp(int[] arr) {
        show(arr);
        long before = now();
        bubbleSort(arr);
        long after = now();
        show(arr);
        System.out.println("Sorting takes " + (after - before) + " ms\n");
    }

    public static void main(String[] args) {
        int sorted[] = new int[50000];
        for (int i = 0; i < 50000; i++) {
            sorted[i] = i;
        }
        bubbleSortApp(sorted);

        int inverseSorted[] = new int[50000];
        for (int i = 0; i < 50000; i++) {
            inverseSorted[i] = 49999 - i;
        }
        bubbleSortApp(inverseSorted);

        // Create an Array List.
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            list.add(i);
        }

        // Shuffle the elements in the array.
        Collections.shuffle(list);
        int[] randomArray = list.stream().mapToInt(Integer::intValue).toArray();

        bubbleSortApp(randomArray);

    }

}
