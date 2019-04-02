package lab02;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Calendar;
import java.util.Date;

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

    public static void main(String[] args) {
        int arr[] = new int[50000];
        for (int i = 0; i < 50000; i++) {
            arr[i] = i;
        }
        long a = now();
        bubbleSort(arr);
        long b = now();
        System.out.print(b - a + " ms\n");

        int arr2[] = new int[50000];
        for (int i = 0; i < 50000; i++) {
            arr2[i] = 49999 - i;
        }
        long x = now();
        bubbleSort(arr2);
        long y = now();
        System.out.print(y - x + " ms\n");

    }

}
