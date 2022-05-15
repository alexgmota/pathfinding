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
         System.out.println();
     }

     private void ordenar() {
         cp.sort(Comparator.comparingDouble(camino -> camino.getCosteHeuristico()));
     }

     private void podar() {
         LinkedList<Camino> aux = new LinkedList<>(cp);
         HashMap<String, Camino> map = new HashMap<>();
         cp.forEach(camino -> {
             Punto p = camino.getLast();
             if (map.containsKey(p.toString())) {
                 if (map.get(p.toString()).getCosteHeuristico() > camino.getCosteHeuristico()){
                     aux.remove(map.get(p.toString()));
                     map.replace(p.toString(), camino);
                 } else {
                     aux.remove(camino);
                 }
             } else {
                 map.put(p.toString(), camino);
             }
         });
         cp = aux;
     }
}
