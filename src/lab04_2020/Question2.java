/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04_2020;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Student
 */
public class Question2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // Add elements
        for (int idx = 0; idx < 10; idx++) {
            list.add(idx);
        }

        // (1)Print elements - Use Index, travel forward
        print(list, "Before");

        // (2)Remove odd numbers & mul even number by 10
        ListIterator<Integer> it = list.listIterator();

        for (int idx = 0; idx < list.size(); idx++) {
            if (it.hasNext()) {
                int item = it.next();
                if (item % 2 != 0) {
                    it.remove();
                    idx--;
                } else {
                    it.set(item * 10);
                }
            }
        }
        // (3) Print after changing
        print(list, "After");
    }

    public static void print(Collection collection, String state) {
        System.out.printf("%-25s", state + " modification:");
        for (Object object : collection) {
            System.out.printf("%-3s", object);
        }
        System.out.println();
    }
}
