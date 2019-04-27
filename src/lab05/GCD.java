/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05;

/**
 *
 * @author Minh Thinh
 */
public class GCD {

    static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }

    public static void main(String[] args) {
        System.out.println("The GCD of (10, 26) is: " + gcd(10, 26));
    }
}
