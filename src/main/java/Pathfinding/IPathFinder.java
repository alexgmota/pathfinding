package Pathfinding;

import Laberinto.Camino;

public interface IPathFinder {
    Camino buscarCamino();
    Camino getCaminoActual();
}
