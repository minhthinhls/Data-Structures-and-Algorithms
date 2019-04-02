/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

import java.util.Random;

/**
 *
 * @author Minh Thinh
 */
public class Array {

    private long[] a; // ref to array a
    private int nElems; // number of data items

    public Array(int max) { // constructor
        a = new long[max]; // create array
    }

    //-----------------------------------------------------------
    public long[] getA() {
        return a;
    }

    //-----------------------------------------------------------
    public void setA(long[] a) {
        this.a = a;
        nElems = a.length;
    }

    //-----------------------------------------------------------
    public int getSize() {
        return nElems;
    }

    //-----------------------------------------------------------
    public void setSize(int nElems) {
        this.nElems = nElems;
    }

    //-----------------------------------------------------------
    public long getValueAt(int index) {
        return a[index];
    }

    //-----------------------------------------------------------
    public void setValueAt(int index, long value) {
        a[index] = value;
    }

    //-----------------------------------------------------------
    public void insertSorted(long value) { // put element into array
        int j;
        for (j = 0; j < nElems; j++) { // find where it goes
            if (a[j] > value) { // (linear search)
                break;
            }
        }
        for (int k = nElems; k > j; k--) { // move bigger ones up
            a[k] = a[k - 1];
        }
        a[j] = value; // insert it
        nElems++; // increment size
    } // end insert()
    //-----------------------------------------------------------

    public void insertAtEnd(long value) { // put element into array
        a[nElems] = value; // Put it at the end of the array
        nElems++; // Increment the element by 1
    }

    //-----------------------------------------------------------
    public void display() { // displays array contents
        for (int j = 0; j < nElems; j++) { // for each element,
            System.out.print(a[j] + " "); // display it
        }
        System.out.println("");
    }

    //-----------------------------------------------------------
    public void randomInit(int numElements) {
        Random aRandom = new Random();
        nElems = numElements;
        for (int i = 0; i < nElems; i++) {
            a[i] = Math.abs(aRandom.nextLong() % 100000000);
            // Assign a random long integer value to current element of the array
        }
    }

    //-----------------------------------------------------------
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    } // End swap() function
    //-----------------------------------------------------------

    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
    } // End bubbleSort() function
    //-----------------------------------------------------------

    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) { // outer loop
            min = out; // minimum
            for (in = out + 1; in < nElems; in++) { // inner loop
                if (a[in] < a[min]) { // if min greater,
                    min = in; // we have a new min
                }
            }
            swap(out, min); // swap them
        } // end for(out)
    } // End selectionSort()
    //-----------------------------------------------------------

    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) { // out is dividing line
            long temp = a[out]; // remove marked item
            in = out; // start shifts at out
            while (in > 0 && a[in - 1] >= temp) { // until one is smaller,
                a[in] = a[in - 1]; // shift item right,
                --in; // go left one position
            }
            a[in] = temp; // insert marked item
        } // end for
    } // End insertionSort()
    //-----------------------------------------------------------

    public void bubbleSortInverse() {
        int out, in;
        for (out = nElems - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] < a[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
    } // End bubbleSortInverse()
    //-----------------------------------------------------------

    public void selectionSortInverse() {
        int out, in, max;
        for (out = 0; out < nElems - 1; out++) { // outer loop
            max = out; // maximum
            for (in = out + 1; in < nElems; in++) { // inner loop
                if (a[in] > a[max]) { // if max smaller,
                    max = in; // we have a new mmax
                }
            }
            swap(out, max); // swap them
        } // end for(out)
    } // End selectionSortInverse()
    //-----------------------------------------------------------

    public void insertionSortInverse() {
        int in, out;
        for (out = 1; out < nElems; out++) { // out is dividing line
            long temp = a[out]; // remove marked item
            in = out; // start shifts at out
            while (in > 0 && a[in - 1] <= temp) { // until one is larger,
                a[in] = a[in - 1]; // shift item right,
                --in; // go left one position
            }
            a[in] = temp; // insert marked item
        } // end for
    } // End insertionSortInverse()
    //-----------------------------------------------------------
}
