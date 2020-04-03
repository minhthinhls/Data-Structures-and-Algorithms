/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02_2020;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Student
 */
public class MainApp {

    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame("DSA-2020 Baseline App");
                mainFrame.setVisible(true);
            }
        });
    }
}
