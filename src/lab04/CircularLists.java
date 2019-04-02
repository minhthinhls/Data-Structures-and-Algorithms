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
public class CircularLists {

    Link curr;
    int count;

    public CircularLists() {
        curr = null;
    }

    // -------------------------------------------------------------
    public boolean isEmpty() {
        return (curr == null);
    } // Check whether the CircularList empty yet?

    // -------------------------------------------------------------
    /**
     * To insert at the current node of the circle, this is the most important
     * function for building a Circular Linked List.
     *
     * @param value
     */
    public void insert(long value) {
        Link newLink = new Link(value);

        if (isEmpty()) {
            curr = newLink;
            curr.next = curr;
        } else {
            newLink.next = curr.next;
            curr.next = newLink;
        }
        curr = newLink;
        count++;
    }

    // -------------------------------------------------------------
    /**
     * Insert value at the n-th position after current node.
     *
     * @param value
     * @param n
     */
    public void insertAtNext(long value, int n) {
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        this.insert(value);
    }

    // -------------------------------------------------------------
    /**
     * Search the data and move current to this node.
     *
     * @param value
     */
    public void search(long value) {
        for (int i = 0; i < count; i++) {
            if (curr.data == value) {
                System.out.println("Find " + value + " !");
                return;
            }
            curr = curr.next;
        }
        System.out.println("Cannot find " + value);
    }

    // -------------------------------------------------------------
    /**
     * Delete the current node and the PREVIOUS node becomes new current.
     */
    public void delete() {
        System.out.println("$Delete current nodes, value: " + curr.data);
        Link next = curr.next;
        for (int i = 0; i < count - 1; i++) {
            curr = curr.next;
        } // Now current is the previous node.
        curr.next = next;
        count--;
    }

    // -------------------------------------------------------------
    /**
     * Delete the node contains parameter value and the previous becomes new
     * current.
     *
     * @param value
     */
    public void delete(long value) {
        // Move to the previous node before deleting node contains @param value.
        System.out.println("$Delete nodes with value: " + value);
        while (curr.next.data != value) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        count--;
    }

    // -------------------------------------------------------------
    /**
     * Step the current node forwarding n times.
     *
     * @param n
     */
    public void step(int n) {
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
    }

    // -------------------------------------------------------------
    public void displayCurrentLink() {
        System.out.print("Current Link is: ");
        curr.displayLink();
        System.out.println();
    }

    // -------------------------------------------------------------
    public void displayAmount(int n) { // How many node will be displayed
        Link node = curr;
        while (n > 0) {
            node.displayLink();
            node = node.next;
            n--;
        }
        System.out.println("");
    } // To choose

    // -------------------------------------------------------------
    public static void main(String[] args) {
        CircularLists cl = new CircularLists();
        cl.insert(10);
        cl.insert(20);
        cl.insert(30);
        cl.insert(40);
        cl.displayAmount(5);

        cl.displayCurrentLink();
        cl.search(30);
        cl.displayCurrentLink();
        cl.search(35);
        cl.displayCurrentLink();
        cl.delete();
        cl.displayAmount(5);
        cl.displayCurrentLink();
        cl.delete(40);
        cl.displayAmount(5);
        cl.displayCurrentLink();
    } // End main class.
} // End class.
