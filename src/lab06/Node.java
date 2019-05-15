package lab06;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Minh Thinh
 */
public class Node {

    public int data; // Data used as key value
    public Node leftChild; // This node’s left child
    public Node rightChild; // This node’s right child

    public Node() {
        // Create new node.
    }

    public Node(int data) {
        this.data = data;
    }

    public void displayNode() {
        System.out.print("{" + data + "}");
    }
}
