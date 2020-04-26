/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
public class Node {

    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" + data + "}-> ";
    }

    public void displayNode() { // display ourself
        System.out.print("{" + data + "}-> ");
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);

        Node n2 = new Node(2);
        n1.next = n2;

        Node n3 = new Node(3);
        n2.next = n3;

        n3.next = n1;

        // xoa n2;
        n1.next = n3;

        // them n4
        Node n4 = new Node(4);
        n4.next = n3.next;
        n3.next = n4;

        System.out.println(n1);
        System.out.println(n1.next);
        System.out.println(n1.next.next);
        System.out.println(n1.next.next.next);
        System.out.println(n1.next.next.next.next);
        System.out.println(n1.next.next.next.next.next);
    }

}
