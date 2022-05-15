package GUI;

import Laberinto.Laberinto;
import Laberinto.Camino;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private final int tamPantalla = 600;
    private final int tamCelda = 40;
    Laberinto laberinto;

    public Panel() {
        setPreferredSize(new Dimension(tamPantalla, tamPantalla));
        setSize(new Dimension(tamPantalla, tamPantalla));
        laberinto = new Laberinto(tamPantalla, tamPantalla, tamCelda);
    }

    @Override
    public void paint(Graphics g) {
        pintarLaberinto((Graphics2D) g);
        pintarCamino((Graphics2D) g);
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

    private void pintarCamino(Graphics2D g) {
        Camino camino = laberinto.buscarCamino();
        if (camino != null){
            g.setPaint(Color.cyan);
            camino.getCamino().forEach(p -> {
                int x = p.getX()*tamCelda;
                int y = p.getY()*tamCelda;
                g.fillRect(x, y, tamCelda, tamCelda);
            });
        } else {
            g.setPaint(Color.RED);
            g.drawString("No se ha encontrado camino", 10, 10);
        }
    }
}
