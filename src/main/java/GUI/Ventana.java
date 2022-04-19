package GUI;

import GUI.Panel;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(){
        setTitle("PathFinding");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        // setLocationRelativeTo(null);
        GUI.Panel panel = new Panel();
        add(panel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
}
