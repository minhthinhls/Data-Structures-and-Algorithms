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
public class LinkList {

    private Link first; // ref to first link on list
    // -------------------------------------------------------------

    public void LinkList() { // constructor
        first = null; // no items on list yet
    }

    // -------------------------------------------------------------
    public boolean isEmpty() { // true if list is empty
        return (first == null);
    }

    // -------------------------------------------------------------
    public void insertFirst(int id) { // make new link
        Link newLink = new Link(id);
        newLink.next = first; // newLink --> old first
        first = newLink; // first --> newLink
    }

    // -------------------------------------------------------------
    public Link deleteFirst() { // delete first item
        // (Assumes list not empty)
        Link temp = first; // save reference to link
        first = first.next; // delete it: first-->old next
        return temp; // return deleted link
    }

    // -------------------------------------------------------------
    public void displayList() {
        System.out.print("List (First-->Last): ");
        Link current = first; // start at beginning of list
        while (current != null) { // until end of list
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }   // end class LinkList
}

class LinkListApp {

    public static void main(String[] args) {
        LinkList theList = new LinkList(); // make new list
        theList.insertFirst(22); // insert four items
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertFirst(88);
        theList.displayList(); // display list
        while (!theList.isEmpty()) { // until it’s empty
            Link aLink = theList.deleteFirst(); // delete link
            System.out.print("Deleted Node "); // display it
            aLink.displayLink();
            System.out.println("");
        }
        theList.displayList(); // display list
    } // end main()
} // end class LinkListApp
////////////////////////////////////////////////////////////////
