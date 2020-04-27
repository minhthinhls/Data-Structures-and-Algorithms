/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04_2020;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import lab02_2020.geom.Point2D;
import static lab04_2020.Question2.print;

/**
 *
 * @author Student
 */
public class Question3 {

    public static void main(String[] args) {
        Point2D[] points = {new Point2D(0, 0), new Point2D(1, 2), new Point2D(3, 4), new Point2D(5, 6)};
        List<Point2D> list = Arrays.asList(points);
        removeHittedPoints(list, new Point2D(1, 2), 2.5);
        print(list, "After");
    }

    public static void removeHittedPoints(List<Point2D> list, Point2D testPoint, double radius) {
        ListIterator<Point2D> it = list.listIterator();
        while (it.hasNext()) {
            Point2D point = it.next();
            if (point.distanceTo(testPoint) <= radius) {
                it.remove();
            }
        }
    }
}
