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
        if (p.getX() > 0)
            addPunto(vecinos, new Punto(p.getX() - 1, p.getY()));
        if (p.getX() < laberinto.getCOLUMNAS() - 1)
            addPunto(vecinos, new Punto(p.getX() + 1, p.getY()));
        if (p.getY() > 0)
            addPunto(vecinos, new Punto(p.getX(), p.getY() - 1));
        if (p.getY() < laberinto.getFILAS() - 1)
            addPunto(vecinos, new Punto(p.getX(), p.getY() + 1));
        return vecinos;
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
        double distancia = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY());
        return getCoste() + distancia;
    }

    public Punto getLast() {
        return camino.getLast();
    }
}
