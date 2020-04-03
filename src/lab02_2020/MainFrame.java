/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02_2020;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 *
 * @author Student
 */
public class MainFrame extends JFrame
        implements ComponentListener {

    static WorkingPanel workingPanel;
    static InfoPanel infoPanel;
    JSplitPane splitter;

    static JToolBar mainToolBar;
    static JToggleButton btnSelect;
    static JButton btnCircle, btnRect, btnGraph;

    public MainFrame(String title) {
        super(title);
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());

        //Install Toolbar
        mainToolBar = new JToolBar();
        JPanel mainToolBarPanel = new JPanel();
        btnSelect = new JToggleButton("Selecting");
        btnSelect.setSelected(true);
        btnCircle = new JButton("Circle");
        btnRect = new JButton("Rectangle");
        btnGraph = new JButton("Graph");

        mainToolBarPanel.setLayout(new FlowLayout());
        mainToolBarPanel.add(btnSelect);
        mainToolBarPanel.add(btnCircle);
        mainToolBarPanel.add(btnRect);
        mainToolBarPanel.add(btnGraph);
        mainToolBarPanel.setBorder(BorderFactory.createEtchedBorder());
        mainToolBar.add(mainToolBarPanel);
        this.add(mainToolBar, BorderLayout.NORTH);

        //Install components
        MainFrame.workingPanel = new WorkingPanel();
        MainFrame.workingPanel.setPreferredSize(new Dimension(1000, 600));
        JScrollPane workingScroller = new JScrollPane(MainFrame.workingPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );

        MainFrame.infoPanel = new InfoPanel();
        MainFrame.infoPanel.setPreferredSize(new Dimension(1000, 600));
        splitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                workingScroller, MainFrame.infoPanel);
        splitter.setOneTouchExpandable(true);
        //splitter.setResizeWeight(1.0);

        this.getContentPane().add(splitter);

        MainFrame.infoPanel.println("App. Started");
        //Add listener
        this.addComponentListener(this);
        btnSelect.addItemListener(workingPanel);
        btnCircle.addActionListener(workingPanel);
        btnRect.addActionListener(workingPanel);
        btnRect.addActionListener(workingPanel);
        
        /* SUCCESSFULLY IMPLEMENTED ! */
        btnGraph.addActionListener(workingPanel);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension size = this.getSize();
        System.out.println("Window resizes to: " + size.height);
        this.splitter.setDividerLocation(0.75);
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
