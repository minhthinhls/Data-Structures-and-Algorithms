/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author Minh Thinh
 */
public class ArithmeticExpression {

    // Method to evaluate value of a postfix expression
    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ') {
                continue;
            }

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    sb.append(tokens[i++]);
                }
                i--; // Step back i for 1 value.
                values.push(Integer.parseInt(sb.toString()));
            } else if (tokens[i] == 'x') {
                Scanner input = new Scanner(System.in);
                int a = input.nextInt();
                values.push(a);
            } // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            } // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop(); // Pop the brace '(' out of operator stack.
            } // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-'
                    || tokens[i] == '*' || tokens[i] == '/') {
                /* While top of 'ops' has same or greater precedence to current
                token, which is an operator. Apply operator on top of 'ops'
                to top two elements in values stack */
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        /* Entire expression has been parsed at this point, apply remaining
        ops to remaining values */
        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        // Top of 'values' now contains result, return it
        return values.pop();
    }

    /**
     *
     * @param op1
     * @param op2
     * @return true if 'op2' has higher or same precedence as 'op1' otherwise
     * returns false.
     */
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        } else {
            return true;
        }
    }

    /* A utility method to apply an operator 'op' on operands 'a' 
    and 'b'. Return the result */
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

    public static void main(String args[]) {
        System.out.println("10 + 5 * 4 = " + ArithmeticExpression.evaluate("10 + 5 * 4"));
        System.out.println("100 * ( 5 + 4 ) = " + ArithmeticExpression.evaluate("100 * ( 5 + 4 )"));
        System.out.println("100 + ( 5 + 4 ) / 3 = " + ArithmeticExpression.evaluate("100 + ( 5 + 4 ) / 3"));
        System.out.println("2 * 2 * 100 + ( 5 * 4 + 1 ) / 3 = " + ArithmeticExpression.evaluate("2 * 2 * 100 + ( 5 * 4 + 1 ) / 3"));
        System.out.print("Enter x: ");
        System.out.println("100 * ( x + 4 ) / 3 = " + ArithmeticExpression.evaluate("100 * ( x + 4 ) / 3"));
    }
}
