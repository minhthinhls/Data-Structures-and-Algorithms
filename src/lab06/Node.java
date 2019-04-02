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

    int data; // Data used as key value
    Node leftChild; // This node’s left child
    Node rightChild; // This node’s right child

    public void displayNode() {
        System.out.print("{" + data + "}");
    }
}
