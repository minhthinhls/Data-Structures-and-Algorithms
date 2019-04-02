/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import java.util.Stack;

/**
 *
 * @author Minh Thinh
 */
public class SpecialArray {

    int[] array = new int[20];
    Stack<int[]> state = new Stack<>();
    Stack<int[]> toRedo = new Stack<>();

    SpecialArray(int[] arr) {
        this.array = arr;
        state.push(this.array.clone());
        this.display();
    }

    public void update(int position, int value) {
        try {
            array = state.peek().clone();
            array[position] = value;
            state.push(array.clone());
            toRedo.clear();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        } finally {
            this.display();
        }
    }

    public void undo() {
        if (state.size() < 2) {
            return;
        }
        try {
            array = state.peek();
            toRedo.push(state.pop());
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        } finally {
            this.display();
        }
    }

    public void redo() {
        if (toRedo.size() < 1) {
            return;
        }
        try {
            state.push(toRedo.pop());
            array = state.peek();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        } finally {
            this.display();
        }
    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        for (int i : state.peek()) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}

class Application {

    public static void main(String[] args) {
        SpecialArray sa = new SpecialArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
        sa.update(8, 999999);
        sa.update(9, 1000000);
        sa.undo();
        sa.redo();
        sa.undo();
        sa.update(1, 222222);
        sa.undo();
        sa.update(3, 444444);
        sa.redo();
        sa.redo();
        sa.undo();
        sa.undo();
    } // end main()
}// end class Application
////////////////////////////////////////////////////////////////
