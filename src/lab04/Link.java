/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;

/**
 *
 * @author Minh Thinh
 */
public class Link {

    public long data; // data item
    public Link next; // next link in list
    // -------------------------------------------------------------

    public Link(long value) { // constructor
        data = value; // initialize data
        next = null;
    }

    // -------------------------------------------------------------
    public void displayLink() { // display ourself
        System.out.print("{" + data + "}-> ");
    }
} // end class Link
