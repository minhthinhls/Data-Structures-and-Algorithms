/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalExam;

/**
 *
 * @author Minh Thinh
 */
// DoublyLinkedList.java
// Demonstrates doubly-linked list
// To run this program: C>java DoublyLinkedApp
////////////////////////////////////////////////////////////////
class Link {

    public long dData; // Data item.
    public Link next; // Next link in list.
    public Link previous; // Previous link in list.
// -------------------------------------------------------------

    public Link(long d) { // Constructor.
        dData = d;
    }
// -------------------------------------------------------------

    public void displayLink() { // Display this link.
        System.out.print(dData + " ");
    }
// -------------------------------------------------------------
} // end class Link
////////////////////////////////////////////////////////////////

class DoublyLinkedList {

    private Link first; // Refer to first item.
    private Link last; // Refer to last item.s
// -------------------------------------------------------------

    public Link getFirst() {
        return first;
    }
// -------------------------------------------------------------

    public Link getLast() {
        return last;
    }
// -------------------------------------------------------------

    public DoublyLinkedList() { // Constructor.
        first = null; // No items on list yet.
        last = null;
    }
// -------------------------------------------------------------

    public boolean isEmpty() { // True if no links.
        return first == null;
    }
// -------------------------------------------------------------

    public void insertFirst(long dd) { // Insert at front of list.
        Link newLink = new Link(dd); // Make new link.
        if (isEmpty()) { // If empty list, then
            last = newLink; // newLink <-- last
        } else {
            first.previous = newLink; // newLink <-- old first
        }
        newLink.next = first; // newLink --> old first
        first = newLink; // first --> newLink
    }
// -------------------------------------------------------------

    public void insertLast(long dd) { // Insert at end of list.
        Link newLink = new Link(dd); // Make new link.
        if (isEmpty()) { // If empty list, then
            first = newLink; // first --> newLink
        } else {
            last.next = newLink; // old last --> newLink
            newLink.previous = last; // old last <-- newLink
        }
        last = newLink; // newLink <-- last
    }
// -------------------------------------------------------------

    public Link deleteFirst() { // Delete first link.
        Link temp = first; // Assumes non-empty list.
        if (first.next == null) { // If only one item, then
            last = null; // null <-- last
        } else {
            first.next.previous = null; // null <-- old next
        }
        first = first.next; // first --> old next
        return temp;
    }
// -------------------------------------------------------------

    public Link deleteLast() { // Delete last link.
        Link temp = last; // Assumes non-empty list.
        if (first.next == null) { // If only one item, then
            first = null; // first --> null
        } else {
            last.previous.next = null; // old previous --> null
        }
        last = last.previous; // old previous <-- last
        return temp;
    }
// -------------------------------------------------------------

    /**
     * Insert data just after key.
     *
     * @param key
     * @param dd
     * @return
     */
    public boolean insertAfter(long key, long dd) { // Assumes non-empty list.
        Link current = first; // Start at the beginning.
        while (current.dData != key) { // Until match is found, then
            current = current.next; // Move to next link.
            if (current == null) {
                return false; // Didn’t find it !
            }
        }
        Link newLink = new Link(dd); // Make new link.
        if (current == last) { // If last link, then
            newLink.next = null; // newLink --> null
            last = newLink; // newLink <-- last
        } else { // Not last link, then
            newLink.next = current.next; // newLink --> old next
            current.next.previous = newLink; // newLink <-- old next
        }
        newLink.previous = current; // old current <-- newLink
        current.next = newLink; // old current --> newLink
        return true; // Found it! Did insertion.
    }
// -------------------------------------------------------------

    public Link deleteKey(long key) { // Delete item with given key.
        // Assumes non-empty list
        Link current = first; // Start at the beginning.
        while (current.dData != key) { // Until match is found, then
            current = current.next; // Move to next link.
            if (current == null) {
                return null; // Didn’t find it !
            }
        }
        if (current == first) { // Found it; Is first item ?
            first = current.next; // first --> old next
        } else { // Not first link !
            current.previous.next = current.next; // old previous --> old next
        }
        if (current == last) { // Last item ?
            last = current.previous; // old previous <-- last
        } else { // Not last link !
            current.next.previous = current.previous; // old previous <-- old next
        }
        return current; // Return current node !
    }
// -------------------------------------------------------------

    public void displayForward() {
        System.out.print("List (first-->last): ");
        Link current = first; // Start at the beginning.
        while (current != null) { // Until end of list, then
            current.displayLink(); // Display data !
            current = current.next; // Move to next link.
        }
        System.out.println("");
    }
// -------------------------------------------------------------

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        Link current = last; // Start at the end.
        while (current != null) { // Until start of list, then
            current.displayLink(); // Display data !
            current = current.previous; // Move to previous link.
        }
        System.out.println("");
    }
// -------------------------------------------------------------

    /**
     * Implement the insertion sort for Doubly Linked List.
     */
    public void insertionSort() {
        Link sorted;
        Link unsorted;
        System.out.print("=> Sorting the Linked List.........");
        try {
            for (sorted = this.first; sorted.next != null; sorted = sorted.next) {
                long temp = sorted.next.dData;
                for (unsorted = sorted.next; unsorted.previous != null && unsorted.previous.dData > temp; unsorted = unsorted.previous) {
                    unsorted.dData = unsorted.previous.dData;
                }
                unsorted.dData = temp;
            }
            System.out.println("Success !!!");
        } catch (Exception e) {
            System.out.println("Not Success. Error found !!!");
            e.printStackTrace();
        } finally {
            this.displayForward(); // Display list forward.
        }
    }
// -------------------------------------------------------------
} // end class DoublyLinkedList
////////////////////////////////////////////////////////////////

class DoublyLinkedApp {

    public static void insertFirst(DoublyLinkedList list, int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("*Inserting to first position: ");
        for (int value : arr) {
            list.insertFirst(value);
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString());
        list.displayForward(); // Display list forward.
    }

    public static void insertLast(DoublyLinkedList list, int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("*Inserting to last position: ");
        for (int value : arr) {
            list.insertLast(value);
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString());
        list.displayForward(); // Display list forward.
    }

    public static void insertAfter(DoublyLinkedList list, int[][] arr) {
        StringBuilder sb = new StringBuilder();
        try {
            for (int[] a : arr) {
                list.insertAfter(a[0], a[1]);
                sb.append(String.format("\n*Inserting %d after %d's position:", a[1], a[0]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(sb.toString());
            list.displayForward(); // Display list forward.
        }
    }

    public static void deleteFirst(DoublyLinkedList list, int nTimes) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("*Deleting first position %d times, value: ", nTimes));
        for (int i = 0; i < nTimes; i++) {
            sb.append(String.format("%d ", list.getFirst().dData));
            list.deleteFirst();
        }
        System.out.println(sb.toString());
        list.displayForward(); // Display list forward.
    }

    public static void deleteLast(DoublyLinkedList list, int nTimes) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("*Deleting last position %d times, value: ", nTimes));
        for (int i = 0; i < nTimes; i++) {
            sb.append(String.format("%d ", list.getLast().dData));
            list.deleteLast();
        }
        System.out.println(sb.toString());
        list.displayForward(); // Display list forward.
    }

    public static void deleteKey(DoublyLinkedList list, int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("*Deleting keys: ");
        for (int value : arr) {
            sb.append(value).append(" ");
            list.deleteKey(value);
        }
        System.out.println(sb.toString());
        list.displayForward(); // Display list forward.
    }

    public static void main(String[] args) { // make a new list
        DoublyLinkedList list = new DoublyLinkedList();

        insertFirst(list, new int[]{22, 44, 66});
        insertLast(list, new int[]{11, 33, 55});
        list.insertionSort();

        list.displayBackward(); // Display list backward.

        deleteFirst(list, 1); // Delete first item 1 time.
        deleteLast(list, 2); // Delete last item 2 times.
        deleteKey(list, new int[]{44}); // Delete item with key 44.

        insertAfter(list, new int[][]{{22, 77}, {33, 88}}); // Insert {77, 88} after {22, 33}.
    } // end main()
} // end class DoublyLinkedApp
////////////////////////////////////////////////////////////////
