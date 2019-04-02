/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;

import java.util.Arrays;

/**
 *
 * @author Minh Thinh
 */
public class Ex3c {

    public static long minGap(HighArray arr, int nElems) {
        if (nElems < 2) {
            return 0;
        }
        Arrays.sort(arr.getA(), 0, nElems); // Array must be sorted first !
        System.out.println("*The array after being sorted -> ");
        arr.display();
        long min = arr.getA()[1] - arr.getA()[0];
        for (int i = 2; i < nElems; i++) {
            if (arr.getA()[i] - arr.getA()[i - 1] < min) {
                min = arr.getA()[i] - arr.getA()[i - 1];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int maxSize = 100; // array size
        HighArray arr; // reference to array
        arr = new HighArray(maxSize); // create the array
        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display(); // Display the array before sorting and find minGap.
        System.out.println("*The min gap is: " + minGap(arr, arr.getnElems()));
    } // end main()

}
