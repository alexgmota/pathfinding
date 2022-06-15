package GUI;

import Laberinto.Laberinto;
import Laberinto.Camino;
import Laberinto.Punto;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private final int tamPantalla = 600;
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
        pintarCamino((Graphics2D) g);
    }

    private void pintarLaberinto (Graphics2D g) {
        for(int i = 0; i < tamPantalla; i+=tamCelda) {
            for (int j = 0; j < tamPantalla; j+=tamCelda) {
                if (laberinto.esMuro(i/tamCelda, j/tamCelda))
                    g.setPaint(new Color(0x0D4AA6));
                else
                    g.setPaint(new Color(0xF2AE27));
                g.fillRect(i,j,tamCelda,tamCelda);
            }
        }

    }

    private void pintarCamino(Graphics2D g) {
        Camino camino = laberinto.buscarCamino();
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
