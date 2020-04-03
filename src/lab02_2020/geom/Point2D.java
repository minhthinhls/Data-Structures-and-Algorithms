/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02_2020.geom;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Student
 */
public class Point2D extends GeomObject {

    public static int POINT_HALF_SIZE = 2;
    private double x;
    private double y;

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D oldPoint) {
        this.x = oldPoint.x;
        this.y = oldPoint.y;
    }

    @Override
    public Point2D clone() {
        return new Point2D(this.x, this.y);
    }

    @Override
    public String toString() {
        return String.format("P(%6.2f, %6.2f)", this.x, this.y);
    }

    public static Point2D[] generate(int N, double min, double max) {
        throw new UnsupportedOperationException("Reuse code from LAB1");
    }

    public static Point2D[] linear(int N, double a, double b, double xMin, double xMax) {
        Point2D[] list = new Point2D[N];
        double step = (xMax - xMin) / (N - 1); //xMax inclusive
        double x = xMin;
        for (int idx = 0; idx < N; idx++) {
            list[idx] = new Point2D(x, a * x + b); // IMPLEMENTED !
            x += step;
        }
        return list;
    }

    public static double distanceAB(Point2D a, Point2D b) {
        throw new UnsupportedOperationException("Reuse code from LAB1");
    }

    public double distanceTo(Point2D point) {
        throw new UnsupportedOperationException("Reuse code from LAB1");
    }

    /**
     * Successfully Implemented !
     *
     * @param g
     * @param mapper
     */
    @Override
    public void draw(Graphics g, SpaceMapping mapper) {
        Graphics2D g2 = (Graphics2D) g;
        Point2D point = mapper.logic2Device(this.getX(), this.getY());

        int x = (int) point.getX() - POINT_HALF_SIZE;
        int y = (int) point.getY() - POINT_HALF_SIZE;

        g2.setColor(this.faceColor);
        g2.fillRect(x, y, 2 * POINT_HALF_SIZE + 1, 2 * POINT_HALF_SIZE + 1);
    }

    public static int getPOINT_HALF_SIZE() {
        return POINT_HALF_SIZE;
    }

    public static void setPOINT_HALF_SIZE(int POINT_HALF_SIZE) {
        Point2D.POINT_HALF_SIZE = POINT_HALF_SIZE;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
