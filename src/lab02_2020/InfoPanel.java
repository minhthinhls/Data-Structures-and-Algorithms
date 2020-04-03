/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02_2020;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Student
 */
public class InfoPanel extends JPanel
        implements ComponentListener {

    private JTextArea textArea;
    private JScrollPane textScroller;

    public InfoPanel() {
        //Create text area and set its properties
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);

        //Create ScollPane to make text scrollable
        textScroller = new JScrollPane(this.textArea);
        textScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //Create the title and border for the scroll panel
        TitledBorder titleBorder = BorderFactory.createTitledBorder("Message: ");
        titleBorder.setTitleColor(Color.blue);
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        Border textBorder = BorderFactory.createCompoundBorder(
                titleBorder,
                BorderFactory.createEmptyBorder(3, 3, 3, 3)
        );

        Border scollerBorder = BorderFactory.createCompoundBorder(
                textBorder,
                textScroller.getBorder() //current border of textScroller
        );
        textScroller.setBorder(scollerBorder); //new border to textScroller

        // add textScroller to the center this panel: use BorderLayout      
        this.setLayout(new BorderLayout());
        this.add(textScroller, BorderLayout.CENTER);

        // register to listen to changes of this components
        this.addComponentListener(this);
    }

    public void clear() {
        this.textArea.setText("");
    }

    public void println(String message) {
        this.textArea.append("\n" + message);
        this.textArea.setCaretPosition(this.textArea.getDocument().getLength());
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension size = this.getSize();
        this.textArea.setSize(size);
        this.textScroller.setSize(size);
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
