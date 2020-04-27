/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
public class Test {

    public static void main(String[] args) {
        int a = 0, i = 16;
        int counter = 0;
        while (i > 0) {
            a += i;
            i /= 2;
            counter++;
            System.out.println(i);
        }
        System.out.println(counter);
    }
}
