/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02_2020.geom;

/**
 *
 * @author Student
 */
public class SpaceMapping {

    private int minDevX, maxDevX;
    private int minDevY, maxDevY;
    private double minLogX, maxLogX;
    private double minLogY, maxLogY;

    public SpaceMapping() {
        this.minDevX = 0;
        this.maxDevX = 800;
        this.minDevY = 0;
        this.maxDevY = 600;

        this.minLogX = 0;
        this.maxLogX = 1.0;
        this.minLogY = 0;
        this.maxLogY = 1.0;
    }

    public double wL() {
        return this.maxLogX - this.minLogX;
    }

    public double hL() {
        return this.maxLogY - this.minLogY;
    }

    public double wD() {
        return this.maxDevX - this.minDevX;
    }

    public double hD() {
        return this.maxDevY - this.minDevY;
    }

    public double sxL2D() {
        double wL = this.maxLogX - this.minLogX;
        double wD = this.maxDevX - this.minDevX;
        return wD / wL;
    }

    public double syL2D() {
        double hL = this.maxLogY - this.minLogY;
        double hD = this.maxDevY - this.minDevY;
        return hD / hL;
    }

    public double sxD2L() {
        double wL = this.maxLogX - this.minLogX;
        double wD = this.maxDevX - this.minDevX;
        return wL / wD;
    }

    public double syD2L() {
        double hL = this.maxLogY - this.minLogY;
        double hD = this.maxDevY - this.minDevY;
        return hL / hD;
    }

    public Point2D oLinD() {
        return new Point2D(
                this.minDevX - this.minLogX * this.sxL2D(),
                this.maxDevY + this.minLogY * this.syL2D()
        );
    }

    public double step() {
        return 5.0 * Math.min(this.sxD2L(), this.syD2L());
    }

    public void updateDevViewPort(int minDevX, int maxDevX, int minDevY,
            int maxDevY) {
        this.minDevX = minDevX;
        this.maxDevX = maxDevX;
        this.minDevY = minDevY;
        this.maxDevY = maxDevY;
    }

    public void updateLogViewPort(double minLogX, double maxLogX, double minLogY, double maxLogY) {
        this.minLogX = minLogX;
        this.maxLogX = maxLogX;
        this.minLogY = minLogY;
        this.maxLogY = maxLogY;
    }

    public void updateLogViewPort(Viewport vp) {
        this.minLogX = vp.getxMin();
        this.maxLogX = vp.getxMax();
        this.minLogY = vp.getyMin();
        this.maxLogY = vp.getyMax();
    }

    public Point2D device2Logic(Point2D devPoint) {
        return device2Logic((int) devPoint.getX(), (int) devPoint.getY());
    }

    public Point2D device2Logic(int devX, int devY) {
        double txD2L = this.oLinD().getX() * sxD2L();
        double tyD2L = -this.oLinD().getY() * syD2L(); // "-" meansflipped
        double logX = sxD2L() * devX - txD2L;
        double logY = -syD2L() * devY - tyD2L;
        return new Point2D(logX, logY);
    }

    public Point2D logic2Device(Point2D logPoint) {
        return logic2Device(logPoint.getX(), logPoint.getY());
    }

    public Point2D logic2Device(double logX, double logY) {
        double txL2D = this.oLinD().getX();
        double tyL2D = -this.oLinD().getY();
        double devX = sxL2D() * logX + txL2D;
        double devY = -syL2D() * logY - tyL2D;
        return new Point2D(devX, devY);
    }

}
