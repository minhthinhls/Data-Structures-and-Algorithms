/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm_2020;

import lab02_2020.geom.Point2D;

/**
 *
 * @author Student
 */
public class Chain {

    Node<Point2D> head;

    public Chain() {
        /*add your code to: initialize the single-linked of nodes*/
        head = new Node<>(new Point2D(1.5, 3.2), null);
        head.next = new Node<>(new Point2D(4.1, 2.8), null);
        head.next.next = new Node<>(new Point2D(3.2, 1.0), null);
    }

    public void println() {
        /*add your code to: print node's data using next link */
        int counter = 0;
        Node curr = head;
        while (curr != null) {
            System.out.println(counter++ + " | " + curr.element);
            curr = curr.next;
        }
    }

    public void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next; // delete it: head --> old_head.next
    }

}
