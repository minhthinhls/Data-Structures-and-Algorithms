/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm_2020;

/**
 *
 * @author Student
 */
public class ChainDemo {

    public static void main(String[] args) {
        Chain chain = new Chain();
        chain.println();
        chain.removeFirst();
        System.out.println(new String(new char[40]).replace('\0', '-'));
        chain.println();
    }
}
