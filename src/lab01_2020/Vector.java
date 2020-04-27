/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_2020;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Minh Thinh
 */
public class Vector implements Cloneable {

    static Random RANDOM = new Random();
    private double xDirect;
    private double yDirect;

    public Vector(double xDirect, double yDirect) {
        this.xDirect = xDirect;
        this.yDirect = yDirect;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            return (Vector) super.clone();
        } catch (Exception e) {
            return new Vector(this.xDirect, this.yDirect);
        }
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", xDirect, yDirect);
    }

    public Vector getPerp() {
        int seed = RANDOM.nextInt(2); // Random value [0, 1]; Or else, False or True !
        int gcd = BigInteger.valueOf((int) yDirect).gcd(BigInteger.valueOf((int) xDirect)).intValue();

        return seed == 0
                ? new Vector(-this.yDirect / gcd, this.xDirect / gcd)
                : new Vector(this.yDirect / gcd, -this.xDirect / gcd);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Vector thisVec = new Vector(2.0, 4.0);
        Object newVec = thisVec.clone();
        System.out.println(thisVec);
        System.out.println(thisVec.getPerp());
    }
}
