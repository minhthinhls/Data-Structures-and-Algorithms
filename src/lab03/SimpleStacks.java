/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

/**
 *
 * @author Minh Thinh
 */
class SimpleStack extends Stack {

    int decimal;

    public SimpleStack(int n, int decimal) {
        super(n);
        this.decimal = decimal;
    }

    /**
     * push the value to stack
     *
     * @param decimal
     * @return
     */
    public String DecimalToOctal(int decimal) {
        if (decimal == 0) {
            this.push(0);
        }
        while (decimal > 0) {
            int digit = decimal % 8;
            this.push(digit);
            decimal = decimal / 8;
        }
        String h = "";
        while (!this.isEmpty()) {
            h = h + this.pop();
        }
        return h;
    }
} // end class Stack
////////////////////////////////////////////////////////////////

public class SimpleStacks {

    //-----------------------------------------------------------
    static Stack concatenate(Stack stack1, Stack stack2) throws CloneNotSupportedException {
        Stack tempStack = new Stack(stack1.getMaxSize() + stack2.getMaxSize()); // Create tempStack to reverse stack2
        Stack temp1 = (Stack) stack1.clone(stack2.getMaxSize());
        Stack temp2 = (Stack) stack2.clone(); // Clone stack2 to temp2 to do reverse.

        while (!temp2.isEmpty()) { // Push the 2nd stack to a temporary stack with reverse value
            tempStack.push(temp2.pop());
        }
        while (!tempStack.isEmpty()) { // Push the temp stack to the 1st stack with the right vector !!!
            temp1.push(tempStack.pop());
        }
        return temp1;
    }

    //-----------------------------------------------------------
    static boolean checkItendical(Stack stack1, Stack stack2) throws CloneNotSupportedException {
        Stack tempA = (Stack) stack1.clone();
        Stack tempB = (Stack) stack2.clone();
        while (!tempA.isEmpty() && !tempB.isEmpty()) {
            if (tempA.pop() != tempB.pop()) {
                return false; // If there exist just 1 different value, then FALSE !
            }
        }
        /* Else return TRUE if the 2 stacks are equal in their size! Means that
           no element exists in both stack after popping while() loop.
         */
        return tempA.isEmpty() && tempB.isEmpty();
    }

    //-----------------------------------------------------------
    public static void main(String args[]) throws CloneNotSupportedException {
        SimpleStack stack = new SimpleStack(100, 255);
        System.out.println("(1) Convert " + stack.decimal + " from Decimal to Octal : " + stack.DecimalToOctal(stack.decimal));

        Stack s1 = new Stack(10);
        Stack s2 = new Stack(10);
        Stack s3 = new Stack(10);
        Stack s4 = new Stack(15);
        // Create 4 new stacks
        for (int i = 0; i < 10; i++) {
            s1.push(i);
            s2.push(i);
            s3.push(i + 1);
        } // Input value for stack 1,2,3
        for (int i = 0; i < 15; i++) {
            s4.push(i);
        } // Input value for stack 4
        System.out.println("(2) Concatenate 2 stacks: ");
        concatenate(s1, s4).display();
        System.out.println("(3) Check 2 stacks whether they are identical: ");
        System.out.println((checkItendical(s1, s2)) ? "Stack 1 & 2 are identical" : "Stack 1 & 2 are not identical");
        System.out.println((checkItendical(s1, s3)) ? "Stack 1 & 3 are identical" : "Stack 1 & 3 are not identical");
        System.out.println((checkItendical(s1, s4)) ? "Stack 1 & 4 are identical" : "Stack 1 & 4 are not identical");

    }
}
