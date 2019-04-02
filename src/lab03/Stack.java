/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

// stack.java
// demonstrates stacks
// to run this program: C>java StackApp
////////////////////////////////////////////////////////////////
public class Stack {

    private int maxSize; // size of stack array
    private long[] stackArray;
    private String[] stackString;
    private int top; // top of stack
    //--------------------------------------------------------------

    public Stack(int s) { // constructor for choosing s element
        maxSize = s; // set array size
        stackArray = new long[maxSize]; // create array
        top = -1; // no items yet
    }

    //--------------------------------------------------------------
    public Stack() { // constructor for choosing base=100 element
        maxSize = 100; // set array size
        stackArray = new long[maxSize]; // create array
        top = -1; // no items yet
    }

    //--------------------------------------------------------------
    public int getMaxSize() {
        return maxSize;
    }

    //--------------------------------------------------------------
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    //--------------------------------------------------------------
    @Override
    public Stack clone() throws CloneNotSupportedException {
        Stack stack = new Stack(this.maxSize);
        stack.maxSize = this.maxSize;
        stack.top = this.top;
        stack.stackArray = new long[this.maxSize]; // Create memory slot !!!!
        /* stack.stackArray = this.stackArray , if we write like this then it will 
        insert the same memory address, not create a new one !
         */
        for (int i = 0; i < maxSize; i++) {
            stack.stackArray[i] = this.stackArray[i];
        } // Copy value from the object over there to this new one for returning
        return stack;
    }

    //--------------------------------------------------------------
    public Stack clone(int extend) throws CloneNotSupportedException {
        Stack stack = new Stack(this.maxSize + extend);
        stack.maxSize = this.maxSize + extend;
        stack.top = this.top;
        stack.stackArray = new long[this.maxSize + extend]; // Create memory slot !!!!
        /* stack.stackArray = this.stackArray , if we write like this then it will 
        insert the same memory address, not create a new one !
         */
        for (int i = 0; i < maxSize; i++) {
            stack.stackArray[i] = this.stackArray[i];
        } // Copy value from the object over there to this new one for returning
        return stack;
    }

    //--------------------------------------------------------------
    public void push(long j) { // put item on top of stack
        stackArray[++top] = j; // increment top, insert item
    }

    //--------------------------------------------------------------
    public void push(String j) { // put item on top of stack
        stackString[++top] = j; // increment top, insert item
    }

    //--------------------------------------------------------------
    public long pop() { // take item from top of stack
        return stackArray[top--]; // access item, decrement top
    }

    //--------------------------------------------------------------
    public long peek() { // peek at top of stack
        return stackArray[top];
    }

    //--------------------------------------------------------------
    public boolean isEmpty() { // true if stack is empty
        return (top == -1);
    }

    //--------------------------------------------------------------
    public boolean isFull() { // true if stack is full
        return (top == maxSize - 1);
    }

    //--------------------------------------------------------------
    public void display() { // displays array contents
        System.out.println("*Displaying the stack: ");
        if (top < 0) {
            System.out.println("=> The stack is empty !");
            return;
        }
        for (int j = 0; j <= top; j++) { // for each element,
            System.out.print(stackArray[j] + " "); // display it
        }
        System.out.println("");
    }
} // end class Stack
////////////////////////////////////////////////////////////////

class StackApp {

    public static void main(String[] args) {
        Stack theStack = new Stack(10); // make new stack
        theStack.push(20); // push items onto stack
        theStack.push(40);
        theStack.display(); // Show value in the stack

        theStack.push(60);
        theStack.push(80);
        theStack.display(); // Show value in the stack

        // In the while loop, we take out the value of the stack
        while (!theStack.isEmpty()) { // until it’s empty,
            // Delete item from stack
            long value = theStack.pop();
            System.out.println("$Pop out " + value); // display it
        } // end while
        theStack.display(); // Show value in the stack
    } // end main()
}// end class StackApp
////////////////////////////////////////////////////////////////
