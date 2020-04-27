/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
public class LinkList {

    private Node head; // ref to first link on list
    private Node last; // ref to last link on list
    // -------------------------------------------------------------

    public void LinkList() { // constructor
        head = null; // no items on list yet
        last = null;
    }

    // -------------------------------------------------------------
    public boolean isEmpty() { // true if list is empty
        return (head == null);
    }

    // -------------------------------------------------------------
    public void insertFirst(int id) {
        Node newLink = new Node(id); // make new link
        if (head == null) {
            last = newLink;
        }
        newLink.next = head; // newLink --> old first
        head = newLink; // first --> newLink
    }

    // -------------------------------------------------------------
    public void insertLast(int id) {
        Node newLink = new Node(id); // make new link
        if (head == null && last == null) {
            head = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    // -------------------------------------------------------------
    public void deleteFirst() { // delete first item
        if (head == null) {
            return;
        }
        head = head.next; // delete it: first-->old next
    }

    // -------------------------------------------------------------
    public void deleteLast() { // delete first item
        if (head == null || last == null) {
            return;
        }
        Node curr = head;
        Node prev = curr;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        last = prev;
    }

    // -------------------------------------------------------------
    public void displayList() {
        System.out.print("List (First-->Last): ");
        Node current = head; // start at beginning of list
        while (current != null) { // until end of list
            current.displayNode(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }   // end class LinkList
}

class LinkListApp {

    public static void main(String[] args) {
        LinkList linkList = new LinkList(); // make new list
        linkList.insertFirst(44); // insert four items
        linkList.insertFirst(22);
        linkList.insertLast(66);
        linkList.insertLast(88);

        linkList.displayList(); // display list

        linkList.deleteFirst();
        linkList.displayList(); // display list

        linkList.deleteLast();
        linkList.deleteLast();
        linkList.displayList(); // display list
//        while (!theList.isEmpty()) { // until it’s empty
//            Node aLink = theList.deleteFirst(); // delete link
//            System.out.print("Deleted Node "); // display it
//            aLink.displayNode();
//            System.out.println("");
//        }
//        theList.displayList(); // display list
    } // end main()
} // end class LinkListApp
////////////////////////////////////////////////////////////////
