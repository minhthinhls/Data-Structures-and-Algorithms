package lab06;

import static java.lang.Math.pow;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Minh Thinh
 */
public class Tree {

    private Node root; // the only data field in Tree

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
// -------------------------------------------------------------

    public Tree() { // constructor
        root = null;
    } // no nodes in tree yet
// -------------------------------------------------------------

    public Node find(int key) { // find node with given key
        // (assumes non-empty tree)
        Node current = root; // start at root
        while (current.data != key) { // while no match
            if (key < current.data) { // go left?
                current = current.leftChild;
            } else {
                current = current.rightChild; // or go right?
            }
            if (current == null) { // if no child,
                return null; // didn’t find it
            }
        }
        return current; // found it
    } // end find()
// -------------------------------------------------------------

    public void insert(int data) {
        Node newNode = new Node(); // make new node
        newNode.data = data; // insert data

        if (root == null) { // no node in root
            root = newNode;
        } else { // root occupied
            Node current = root; // start at root
            Node parent;
            while (true) { // (exits internally)
                parent = current;
                if (data < current.data) { // go left?
                    current = current.leftChild;
                    if (current == null) { // if end of the line,
                        // insert on left
                        parent.leftChild = newNode;
                        return;
                    }
                } // end if go left
                else { // or go right?
                    current = current.rightChild;
                    if (current == null) { // if end of the line
                        // insert on right
                        parent.rightChild = newNode;
                        return;
                    }
                } // end else go right
            } // end while
        } // end else not root
    } // end insert()
// -------------------------------------------------------------

    public void insertRecursive(int data) {
        root = insertRecursive(root, data);
    }
// -------------------------------------------------------------

    private Node insertRecursive(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }
        if (head.data < data) {
            head.rightChild = insertRecursive(head.rightChild, data);
        } else {
            head.leftChild = insertRecursive(head.leftChild, data);
        }
        return head;
    }
// -------------------------------------------------------------

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; // go to right child
        while (current != null) { // until no more
            // left children,
            successorParent = successor;
            successor = current;
            current = current.leftChild; // go to left child
        }
        // if successor not
        if (successor != delNode.rightChild) { // right child,
            // make connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    // -------------------------------------------------------------
    public boolean delete(int key) // delete node with given key
    { // (assumes non-empty list)
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.data != key) // search for node
        {
            parent = current;
            if (key < current.data) // go left?
            {
                isLeftChild = true;
                current = current.leftChild;
            } else // or go right?
            {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) // end of the line,
            {
                return false; // didn’t find it
            }
        } // end while
        // found node to delete
        // delete() continued...
        // if no children, simply delete it
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) // if root,
            {
                root = null; // tree is empty
            } else if (isLeftChild) {
                parent.leftChild = null; // disconnect
            } else // from parent
            {
                parent.rightChild = null;
            }
        } // delete() continued...
        // if no right child, replace with left subtree
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) // left child of parent
            {
                parent.leftChild = current.leftChild;
            } else // right child of parent
            {
                parent.rightChild = current.leftChild;
            }
        } // if no left child, replace with right subtree
        else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) // left child of parent
            {
                parent.leftChild = current.rightChild;
            } else // right child of parent
            {
                parent.rightChild = current.rightChild;
            }
        } // delete() continued
        else // two children, so replace with inorder successor
        {
            // get successor of node to delete (current)
            Node successor = getSuccessor(current);
            // connect parent of current to successor instead
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            // connect successor to current’s left child
            successor.leftChild = current.leftChild;
        } // end else two children
        // (successor cannot have a left child)
        return true;
    } // end delete()
// -------------------------------------------------------------

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;

            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;

            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }
// -------------------------------------------------------------

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
// -------------------------------------------------------------

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.rightChild);
        }
    }

// -------------------------------------------------------------
    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.data + " ");
        }
    }
// -------------------------------------------------------------

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (!isRowEmpty) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }
            while (!globalStack.isEmpty()) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            } // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        } // end while isRowEmpty is false
        System.out.println("......................................................");
    } // end displayTree()

// -------------------------------------------------------------
    /**
     * Question A, counting number of elements in Binary Tree.
     *
     * @return
     */
    public int countElems() {
        return countElems(root);
    }

// -------------------------------------------------------------
    private int countElems(Node localRoot) {
        if (localRoot == null) { // Base case
            return 0;
        } else {
            return 1 + countElems(localRoot.leftChild) + countElems(localRoot.rightChild);
        }
    }

// -------------------------------------------------------------
    /**
     * Question B, finding max Height of a Binary Tree.
     *
     * @return
     */
    public int getHeight() {
        return getHeight(root);
    }

// -------------------------------------------------------------
    private int getHeight(Node local) {
        if (local == null) {
            return -1;
        }
        return Math.max(getHeight(local.leftChild) + 1, getHeight(local.rightChild) + 1);
    }

// -------------------------------------------------------------
    /**
     * Question C, finding number of leaves in a Binary Tree.
     *
     * @return
     */
    public int countLeaves() {
        return countLeaves(root);
    }

// -------------------------------------------------------------
    private int countLeaves(Node localRoot) {
        if (localRoot == null) { // Base case = 0
            return 0;
        }
        if (localRoot.leftChild == null && localRoot.rightChild == null) { // Base case = 1
            return 1;
        } else {
            return countLeaves(localRoot.leftChild) + countLeaves(localRoot.rightChild);
        }
    }

// -------------------------------------------------------------
    /**
     * Question D, to check whether this tree is Fully Balanced or not.
     *
     * @return
     */
    public boolean checkFullyBalanced() {
        return this.countElems() == pow(2, this.getHeight() + 1) - 1;
    }

// -------------------------------------------------------------
    /**
     * Question E, checking whether 2 trees are identical.
     *
     * @param subTree
     * @return
     */
    public boolean isIdentical(Tree subTree) {
        Tree mainTree = this;
        return isIdentical(mainTree, subTree);
    }

// -------------------------------------------------------------
    private boolean isIdentical(Tree main, Tree sub) {
        Node a = main.getRoot();
        Node b = sub.getRoot();
        return identicalTrees(a, b);
    }

// -------------------------------------------------------------
    /* Given two trees, return true if they are
       structurally identical */
    private boolean identicalTrees(Node a, Node b) {
        /*1. both empty */
        if (a == null && b == null) {
            return true;
        }

        /* 2. both non-empty -> compare them */
        if (a != null && b != null) {
            return (a.data == b.data
                    && identicalTrees(a.leftChild, b.leftChild)
                    && identicalTrees(a.rightChild, b.rightChild));
        }

        /* 3. one empty, one not -> false */
        return false;
    }
// -------------------------------------------------------------
// -------------------------------------------------------------
// -------------------------------------------------------------
    // Various other methods
} // End class Tree
