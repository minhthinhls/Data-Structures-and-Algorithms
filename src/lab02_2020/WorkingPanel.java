/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02_2020;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import lab02_2020.geom.Graph;
import lab02_2020.geom.Point2D;
import lab02_2020.geom.SpaceMapping;

/**
 *
 * @author Student
 */
public class WorkingPanel extends JPanel
        implements MouseMotionListener, MouseListener,
        ItemListener, ActionListener, ComponentListener {

    SpaceMapping spaceMapping = new SpaceMapping();
    Graph sin, quad;

    public WorkingPanel() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.addComponentListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
        String message = String.format("mouseDragged: Device(x,y)=(%d,%d);Logic(x,y)=(%6.2f, %6.2f)",
                e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
        String message = String.format("mouseMoved: Device(x,y)=(%d,%d);Logic(x,y)=(%6.2f, %6.2f)",
                e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if ((e.getClickCount() == 2) && !e.isConsumed()) {
            String message = String.format("Mouse Double Clicked: (x,y)=(%d,%d)", e.getX(), e.getY());
            MainFrame.infoPanel.println(message);
            e.consume();
        } else {
            String message = String.format("Mouse Clicked: (x,y)=(%d,%d)", e.getX(), e.getY());
            MainFrame.infoPanel.println(message);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        String message = String.format("mousePressed: (x,y)=(%d,%d)", e.getX(), e.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        String message = String.format("mouseReleased: (x,y)=(%d,%d)", e.getX(), e.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        String message = String.format("mouseEntered: (x,y)=(%d,%d)", e.getX(), e.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        String message = String.format("mouseExited: (x,y)=(%d,%d)", e.getX(), e.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int state = e.getStateChange();
        if (state == ItemEvent.SELECTED) {
            MainFrame.infoPanel.println("Selected");
            MainFrame.btnSelect.setText("Selecting");
        } else {
            MainFrame.infoPanel.println("DeSelected");
            MainFrame.btnSelect.setText("Drawing");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MainFrame.btnCircle) {
            MainFrame.infoPanel.println("action: draw Circle");
        } else if (e.getSource() == MainFrame.btnRect) {
            MainFrame.infoPanel.println("action: draw Rect");
        } else if (e.getSource() == MainFrame.btnGraph) {
//            sin = Graph.quadratic(1, 1, 1, 1, 1, 1);
            quad = Graph.quadratic(2, 5, 10, 1, 10, 0.01);
            this.repaint();
        }
    }

    /**
     * Successfully Implemented !
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        if (sin != null) {
            MainFrame.infoPanel.println("action: draw Sin Graph");
            sin.draw(g, spaceMapping);
        }
        if (quad != null) {
            MainFrame.infoPanel.println("action: draw Quadratic Graph");
            quad.draw(g, spaceMapping);
        }
        if (sin == null && quad == null) {
            MainFrame.infoPanel.println("action: Cannot Draw !");
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension size = this.getSize();
        int xGap = 50, yGap = 20;
        this.spaceMapping.updateDevViewPort(xGap, size.width - 2 * xGap, yGap, size.height - 2 * yGap);
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
