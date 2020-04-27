/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
class DoublyLinkedList {

    private Node head; // Refer to head item.
    private Node last; // Refer to last item.s
// -------------------------------------------------------------

    public Node getHead() {
        return head;
    }
// -------------------------------------------------------------

    public Node getLast() {
        return last;
    }
// -------------------------------------------------------------

    public DoublyLinkedList() { // Constructor.
        head = null; // No items on list yet.
        last = null;
    }
// -------------------------------------------------------------

    public boolean isEmpty() { // True if no links.
        return head == null;
    }
// -------------------------------------------------------------

    public void insertFirst(int dd) { // Insert at front of list.
        Node newLink = new Node(dd); // Make new link.
        if (isEmpty()) { // If empty list, then
            last = newLink; // newLink <-- last
        } else {
            head.prev = newLink; // newLink <-- old head
        }
        newLink.next = head; // newLink --> old head
        head = newLink; // head --> newLink
    }
// -------------------------------------------------------------

    public void insertLast(int dd) { // Insert at end of list.
        Node newLink = new Node(dd); // Make new link.
        if (isEmpty()) { // If empty list, then
            head = newLink; // head --> newLink
        } else {
            last.next = newLink; // old last --> newLink
            newLink.prev = last; // old last <-- newLink
        }
        last = newLink; // newLink <-- last
    }
// -------------------------------------------------------------

    public Node deleteFirst() { // Delete head link.
        Node temp = head; // Assumes non-empty list.
        if (head.next == null) { // If only one item, then
            last = null; // null <-- last
        } else {
            head.next.prev = null; // null <-- old next
        }
        head = head.next; // head --> old next
        return temp;
    }
// -------------------------------------------------------------

    public Node deleteLast() { // Delete last link.
        Node temp = last; // Assumes non-empty list.
        if (head.next == null) { // If only one item, then
            head = null; // head --> null
        } else {
            last.prev.next = null; // old previous --> null
        }
        last = last.prev; // old previous <-- last
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
    public boolean insertAfter(long key, int dd) { // Assumes non-empty list.
        Node current = head; // Start at the beginning.
        while (current.data != key) { // Until match is found, then
            current = current.next; // Move to next link.
            if (current == null) {
                return false; // Didn’t find it !
            }
        }
        Node newLink = new Node(dd); // Make new link.
        if (current == last) { // If last link, then
            newLink.next = null; // newLink --> null
            last = newLink; // newLink <-- last
        } else { // Not last link, then
            newLink.next = current.next; // newLink --> old next
            current.next.prev = newLink; // newLink <-- old next
        }
        newLink.prev = current; // old current <-- newLink
        current.next = newLink; // old current --> newLink
        return true; // Found it! Did insertion.
    }
// -------------------------------------------------------------

    public Node deleteKey(long key) { // Delete item with given key.
        // Assumes non-empty list
        Node current = head; // Start at the beginning.
        while (current.data != key) { // Until match is found, then
            current = current.next; // Move to next link.
            if (current == null) {
                return null; // Didn’t find it !
            }
        }
        if (current == head) { // Found it; Is head item ?
            head = current.next; // head --> old next
        } else { // Not head link !
            current.prev.next = current.next; // old previous --> old next
        }
        if (current == last) { // Last item ?
            last = current.prev; // old previous <-- last
        } else { // Not last link !
            current.next.prev = current.prev; // old previous <-- old next
        }
        return current; // Return current node !
    }
// -------------------------------------------------------------

    public void displayForward() {
        System.out.print("List (first-->last): ");
        Node current = head; // Start at the beginning.
        while (current != null) { // Until end of list, then
            current.displayNode(); // Display data !
            current = current.next; // Move to next link.
        }
        System.out.println("");
    }
// -------------------------------------------------------------

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        Node current = last; // Start at the end.
        while (current != null) { // Until start of list, then
            current.displayNode(); // Display data !
            current = current.prev; // Move to previous link.
        }
        System.out.println("");
    }
// -------------------------------------------------------------

    /**
     * Implement the insertion sort for Doubly Linked List.
     */
    public void insertionSort() {
        Node sorted;
        Node unsorted;
        System.out.print("=> Sorting the Linked List.........");
        try {
            for (sorted = this.head; sorted.next != null; sorted = sorted.next) {
                int temp = sorted.next.data;
                for (unsorted = sorted.next; unsorted.prev != null && unsorted.prev.data > temp; unsorted = unsorted.prev) {
                    unsorted.data = unsorted.prev.data;
                }
                unsorted.data = temp;
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
            sb.append(String.format("%d ", list.getHead().data));
            list.deleteFirst();
        }
        System.out.println(sb.toString());
        list.displayForward(); // Display list forward.
    }

    public static void deleteLast(DoublyLinkedList list, int nTimes) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("*Deleting last position %d times, value: ", nTimes));
        for (int i = 0; i < nTimes; i++) {
            sb.append(String.format("%d ", list.getLast().data));
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

        deleteFirst(list, 1); // Delete head item 1 time.
        deleteLast(list, 2); // Delete last item 2 times.
        deleteKey(list, new int[]{44}); // Delete item with key 44.

        insertAfter(list, new int[][]{{22, 77}, {33, 88}}); // Insert {77, 88} after {22, 33}.
    } // end main()
} // end class DoublyLinkedApp
////////////////////////////////////////////////////////////////
