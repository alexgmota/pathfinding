package GUI;

import Laberinto.Laberinto;
import Laberinto.Camino;
import Laberinto.Punto;
import Pathfinding.IPathFinder;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private static final int tamPantalla = 800;
    private static final int tamCelda = 10;
    Laberinto laberinto;
    IPathFinder pf;

    public Panel(Laberinto laberinto, IPathFinder pf) {
        setPreferredSize(new Dimension(tamPantalla, tamPantalla));
        setSize(new Dimension(tamPantalla, tamPantalla));
        this.laberinto = laberinto;
        this.pf = pf;
    }

    public static int getTamPantalla() {
        return tamPantalla;
    }

    public static int getTamCelda() {
        return tamCelda;
    }
    @Override
    public void paint(Graphics g) {
        pintarLaberinto((Graphics2D) g);
        pintarCamino((Graphics2D) g);
        repaint();
    }

    private void pintarLaberinto (Graphics2D g) {
        for(int i = 0; i < tamPantalla; i+=tamCelda) {
            for (int j = 0; j < tamPantalla; j+=tamCelda) {
                if (laberinto.esMuro(i/tamCelda, j/tamCelda))
                    g.setPaint(new Color(0x0D4AA6));
                else
                    g.setPaint(Color.black);
                g.fillRect(i,j,tamCelda,tamCelda);
            }
        }

    }

    private void pintarCamino(Graphics2D g) {
        Camino camino = pf.getCaminoActual();
        int r = (int) (tamCelda * 0.7);
        if (camino != null){
            g.setPaint(new Color(0x29F21B));
            camino.getCamino().forEach(p -> {
                Punto punto = new Punto ((int) (p.getX() * tamCelda + tamCelda*0.15),
                            (int) (p.getY() * tamCelda + tamCelda*0.15));
                g.fillOval(punto.getX(),punto.getY(), r, r);
            });
        } else {
            g.setPaint(Color.RED);
            g.setFont(new Font("Arial", Font.PLAIN , 40));
            g.drawString("No se ha encontrado camino", 20, 45);
        }
    }
}
