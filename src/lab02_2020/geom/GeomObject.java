/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02_2020.geom;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Student
 */
public abstract class GeomObject {

    protected Color edgeColor;
    protected Color faceColor;
    protected int line_weight = 1;

    public GeomObject() {
        edgeColor = new Color(20, 200, 20);
        faceColor = new Color(255, 0, 0);
    }

    public abstract void draw(Graphics g, SpaceMapping mapper);
}
