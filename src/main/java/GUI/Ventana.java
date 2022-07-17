package GUI;

import Laberinto.Laberinto;
import Pathfinding.IPathFinder;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(Laberinto laberinto, IPathFinder pf){
        setTitle("PathFinding");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        // setLocationRelativeTo(null);
        GUI.Panel panel = new Panel(laberinto, pf);
        add(panel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
}
