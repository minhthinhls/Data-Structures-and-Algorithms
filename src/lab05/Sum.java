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
public class Sum {

    private static StringBuilder sb = new StringBuilder();

    static double sumFraction(int n) { // While n > 0
        if (n < 1) {
            sb.append(n);
            return n;
        } else if (n == 1) {
            sb.append(1);
            return 1;
        } else {
            sb.append("1/").append(n).append(" + ");
            return (double) (1.0 / n + sumFraction(n - 1));
        }
    }

    static int sum(int n) {  // While n > 1
        if (n < 1) {
            sb.append(n);
            return n;
        } else if (n == 1) {
            sb.append(1);
            return 1;
        } else {
            sb.append(n).append(" + ");
            return n + sum(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(sumFraction(5) + " = " + sb.toString());
        sb = new StringBuilder();
        System.out.println(sum(5) + " = " + sb.toString());
    }
}
