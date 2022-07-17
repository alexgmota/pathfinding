package Laberinto;

import java.util.LinkedList;
import java.util.List;

public class Camino {

    private final LinkedList<Punto> camino;
    private final Laberinto laberinto;

    public Camino(Laberinto laberinto) {
        this.laberinto = laberinto;
        camino = new LinkedList<>();
    }

    public List<Punto> getCamino() {
        return camino;
    }

    public boolean isCompleto() {
        Punto p = getLast();
        return p.getX() == laberinto.getFILAS()-1 &&
                p.getY() == laberinto.getCOLUMNAS()-1;
    }

    public List<Camino> getVecinos() {
        LinkedList<Camino> vecinos = new LinkedList<>();
        Punto p = camino.getLast();
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        for (int i = 0; i < dx.length; i++) {
            Punto aux = new Punto(p.getX()+ dx[i], p.getY() + dy[i]);
            if (dentroLaberinto(aux))
                addPunto(vecinos, aux);
        }
        return vecinos;
    }

    private boolean dentroLaberinto(Punto p) {
        return p.getX() >= 0 && p.getX() < laberinto.getCOLUMNAS()
                && p.getY() >= 0 && p.getY() < laberinto.getFILAS();
    }

    private void addPunto(LinkedList<Camino> vecinos, Punto p) {
        if (!camino.contains(p) && !laberinto.esMuro(p.getX(), p.getY())){
            Camino aux = (Camino) clone();
            aux.getCamino().add(p);
            vecinos.add(aux);
        }
    }

    @Override
    protected Object clone() {
        Camino aux = new Camino(laberinto);
        aux.camino.addAll(this.camino);
        return aux;
    }

    public int getCoste() {
        return camino.size()-1;
    }

    public double getCosteHeuristico() {
        Punto p = camino.getLast();
        Punto fin = laberinto.getFin();
        int x = p.getX() - fin.getX();
        int y = p.getY() - fin.getY();
        double distancia = Math.sqrt(x*x + y*y);
        return getCoste() + distancia;
    }

    public Punto getLast() {
        return camino.getLast();
    }
}
