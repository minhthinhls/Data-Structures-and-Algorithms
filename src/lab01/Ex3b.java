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
public class Ex3b {

    public static long getMedian(HighArray arr) {
        int nElems = arr.getnElems(); // Number of elements in the array.
        Arrays.sort(arr.getA(), 0, nElems); // Array must be sorted first !
        if (nElems == 0) {
            return -1;
        }
        if (nElems % 2 == 0) {
            return ((arr.getA()[nElems / 2] + arr.getA()[nElems / 2 - 1]) / 2);
        } else {
            return (arr.getA()[nElems / 2]);
        }
    }

    public static void main(String[] args) {
        HighArray arr = new HighArray(100); // Create the array with maxSize 100
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.insert(11);
        arr.display();
        System.out.println("Median: " + getMedian(arr));
        arr.display();
    } // end main()
}
