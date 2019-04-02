/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;

/**
 *
 * @author Minh Thinh
 */
public class Ex3a {

    public static long convertToNumber(HighArray arr) {
        long num = 0;
        for (int i = 0; i < arr.getnElems(); i++) {
            num = (long) (num + arr.getA()[i] * Math.pow(10, arr.getnElems() - i - 1));
        }
        return num;
    }

    public static void main(String[] args) {
        HighArray arr = new HighArray(100); // Create the array with maxSize 100
        arr.insert(2);
        arr.insert(0);
        arr.insert(1);
        arr.insert(8);
        arr.display();
        System.out.println("*Array after being converted: " + convertToNumber(arr));
    }
}
