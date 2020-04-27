/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm_2020;

/**
 *
 * @author Student
 */
public class Node<E> {

    E element;
    Node<E> next;

    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

}
