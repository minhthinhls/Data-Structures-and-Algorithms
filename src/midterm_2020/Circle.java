/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm_2020;

import lab02_2020.geom.Point2D;

/**
 *
 * @author Student
 */
public class Circle {

    private Point2D center;
    private double radius;

    public Circle(Point2D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2); // PI * R ^ 2
    }

    @Override
    public String toString() {
        return String.format("C(center(%6.2f,%6.2f), radius:%6.2f)",
                center.getX(), center.getY(), radius);
    }
}
