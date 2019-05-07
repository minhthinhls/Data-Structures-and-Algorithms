package lab06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Minh Thinh
 */
public class TreeApp extends Tree {

    public static void main(String[] args) throws IOException {
        Tree mainTree = new Tree();
        Tree subTree = new Tree();

        insert(mainTree, new int[]{50, 25, 75, 12, 37, 87, 72, 11, 13, 33, 40, 70, 74, 85, 89});
        insert(subTree, new int[]{50, 25, 75, 12, 37, 87, 72, 90, 11, 13, 85});

        System.out.println("Number of Elems in Main Tree = " + mainTree.countElems());
        System.out.println("Height of Main Binary Tree = " + mainTree.getHeight());
        System.out.println("Number of Leaves in Main Tree = " + mainTree.countLeaves());
        System.out.println("The Main tree is fully Balanced = " + mainTree.checkFullyBalanced());
        System.out.println("The Sub tree is fully Balanced = " + subTree.checkFullyBalanced());
        System.out.println("The Main tree is identical to subTree = " + mainTree.isIdentical(subTree));

        System.out.println("This is Main Tree: ");
        mainTree.displayTree();
        System.out.println("This is Sub Tree: ");
        subTree.displayTree();
        /*        
        while(true)
        {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            
            int choice = getChar();
            switch(choice)
            {
                case 's':
                    mainTree.displayTree();
                break;
                
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    mainTree.insert(value);
                break;
                
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = mainTree.find(value);
                    if(found != null)
                    {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    }
                    else
                        System.out.print("Could not find ");
                    System.out.print(value + '\n');
                break;
                
                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = mainTree.delete(value);
                    if(didDelete)
                        System.out.print("Deleted " + value + '\n');
                    else
                        System.out.print("Could not delete ");
                    System.out.print(value + '\n');
                break;
                
                case 't':
                    System.out.print("Enter type 1, 2 or 3: ");
                    value = getInt();
                    mainTree.traverse(value);
                break;
                
                default:
                    System.out.print("Invalid entry\n");
            } // end switch
        } // end while
         */
    } // end main()

    // -------------------------------------------------------------
    public static void insert(Tree tree, int[] arr) {
        for (int value : arr) {
            tree.insert(value);
        }
    }

    //--------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // -------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    //--------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
    // -------------------------------------------------------------
} // End class TreeApp
////////////////////////////////////////////////////////////////
