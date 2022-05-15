package Pathfinding;

import Laberinto.*;

import java.util.*;

public class AStar implements IPathFinder{
     Laberinto laberinto;
     LinkedList<Camino> cp;

     public AStar(Laberinto laberinto) {
         this.laberinto =  laberinto;
         cp = new LinkedList<>();
         Camino camino = new Camino(laberinto);
         camino.getCamino().add(new Punto(0,0));
         cp.add(camino);
     }

     public Camino buscarCamino() {
         while (cp.size() > 0 && !cp.getFirst().isCompleto()) {
             imprimirCP();
             List<Camino> nuevos = new ArrayList<>(cp.pop().getVecinos());
             nuevos.forEach(camino -> cp.addLast(camino));
             ordenar();
             podar();
         }
         return (cp.size() > 0)? cp.get(0) : null;
     }

     private void imprimirCP() {
         cp.forEach(camino ->
                 System.out.println(camino.getLast() + " "
                                    + camino.getCosteHeuristico()));
     }

     private void ordenar() {
         cp.sort(Comparator.comparingDouble(camino -> camino.getCosteHeuristico()));
     }

     private void podar() {
         cp.forEach(camino -> {
             Punto p = camino.getLast();
             LinkedList<Camino> aux =  new LinkedList<>(cp);
             for (Camino c : cp){
                 if (c != camino && c.getLast().equals(p)) {
                     if (c.getCosteHeuristico() > camino.getCosteHeuristico()) {
                         aux.remove(c);
                     } else {
                         aux.remove(camino);
                         p = c.getLast();
                     }
                 }
             }
             cp = aux;
         });
     }
}
