package GUI;

import Laberinto.Laberinto;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private final int tamPantalla = 800;
    private final int tamCelda = 20;
    Laberinto laberinto;

    public Panel() {
        setPreferredSize(new Dimension(tamPantalla, tamPantalla));
        setSize(new Dimension(tamPantalla, tamPantalla));
        laberinto = new Laberinto(tamPantalla, tamPantalla, tamCelda);
    }

    @Override
    public void paint(Graphics g) {
        pintarLaberinto((Graphics2D) g);
    }

    private void pintarLaberinto (Graphics2D g) {
        for(int i = 0; i < tamPantalla; i+=tamCelda) {
            for (int j = 0; j < tamPantalla; j+=tamCelda) {
                if (laberinto.esMuro(i/tamCelda, j/tamCelda))
                    g.setPaint(Color.DARK_GRAY);
                else
                    g.setPaint(Color.orange);
                g.fillRect(i,j,tamCelda,tamCelda);
            }
        }

    }
}
