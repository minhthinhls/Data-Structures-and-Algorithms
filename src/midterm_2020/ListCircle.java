/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import lab02_2020.geom.Point2D;

/**
 *
 * @author Student
 */
public class ListCircle {

    private static final double circleMax = 5.0;
    private static final double circleMin = -5.0;
    private static final double radiusMax = 5.0;
    private static final double radiusMin = 1.0;

    public static void main(String[] args) {
        List<Circle> list = genCircles(5);
        printList(list);
        processList(list, 30.0);
        System.out.println(new String(new char[40]).replace('\0', '-'));
        printList(list);
    }

    public static List<Circle> genCircles(int N) {
        /*add your code here*/
        List<Circle> circles = new ArrayList<>();
        int i = 0;
        while (i++ < N) {
            double xCircle = Math.random() * (circleMax - circleMin + 1) + circleMin;
            double yCircle = Math.random() * (circleMax - circleMin + 1) + circleMin;
            double randRadius = Math.random() * (radiusMax - radiusMin + 1) + radiusMin;
            circles.add(new Circle(new Point2D(xCircle, yCircle), randRadius));
        }
        return circles;
    }

    public static void printList(List<Circle> list) {
        int i = 0;
        for (Circle c : list) {
            System.out.printf("%d | %s | %6.2f\n", i++, c, c.area());
        }
    }

    public static void processList(List<Circle> list, double threshold) {
        ListIterator<Circle> it = list.listIterator();
        while (it.hasNext()) {
            Circle c = it.next();
            if (c.area() <= threshold) {
                it.remove();
            }
        }
    }

}
