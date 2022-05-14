package Laberinto;

import java.util.ArrayList;
import java.util.List;

public class Camino {

    private final List<Punto> camino;
    private final Laberinto laberinto;

    public Camino(Laberinto laberinto) {
        this.laberinto = laberinto;
        camino = new ArrayList<>();
    }

    public List<Punto> getCamino() {
        return camino;
    }

    public List<Punto> getVecinos() {
        List<Punto> vecinos = new ArrayList<>();
        Punto p = camino.get(camino.size() - 1);
        if (p.getX() > 0)
            vecinos.add(new Punto(p.getX() - 1, p.getY()));
        if (p.getX() < laberinto.getCOLUMNAS() - 1)
            vecinos.add(new Punto(p.getX() + 1, p.getY()));
        if (p.getY() > 0)
            vecinos.add(new Punto(p.getX(), p.getY() - 1));
        if (p.getY() < laberinto.getFILAS() - 1)
            vecinos.add(new Punto(p.getX(), p.getY() + 1));
        return vecinos;
    }
}
