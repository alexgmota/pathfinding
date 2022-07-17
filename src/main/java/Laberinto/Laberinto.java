package Laberinto;

import Pathfinding.AStar;
import Pathfinding.IPathFinder;

import java.util.Random;

public class Laberinto {
    private final int MURO = 1;
    private final int VACIO = 0;
    private final int FILAS;
    private final int COLUMNAS;

    private final int[][] grid;

    public Laberinto(int width, int height, int tamCelda) {
        FILAS = height / tamCelda;
        COLUMNAS = width / tamCelda;
        grid = new int[FILAS][COLUMNAS];
        inicializarGrid();
    }

    private void inicializarGrid() {
        float probabilidadMuro = 0.35f;
        Random r = new Random();
        for(int i = 0; i < grid.length; i++)
            for (int j = 0; j <grid[0].length; j++)
                grid[i][j] = (r.nextFloat() < probabilidadMuro)? MURO : VACIO;
        grid[0][0] = VACIO;
        grid[grid.length - 1][grid[0].length - 1] = VACIO;
    }

    public boolean esMuro(int i, int j) {
        return grid[i][j] == MURO;
    }

    public int getCOLUMNAS() {
        return COLUMNAS;
    }

    public int getFILAS() {
        return FILAS;
    }

    public Punto getFin() {
        return new Punto(FILAS-1, COLUMNAS-1);
    }
}
