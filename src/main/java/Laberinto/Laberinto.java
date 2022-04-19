package Laberinto;

import java.util.Random;

public class Laberinto {
    public final int MURO = 0;
    public final int VACIO = 1;

    private final int[][] grid;

    public Laberinto(int width, int height, int tamCelda) {
        grid = new int[height/tamCelda][width/tamCelda];
        inicializarGrid();
    }

    private void inicializarGrid() {
        float probabilidadMuro = 0.2f;
        Random r = new Random();
        for(int i = 0; i < grid.length; i++)
            for (int j = 0; j <grid[0].length; j++)
                grid[i][j] = (r.nextFloat() < probabilidadMuro)? MURO : VACIO;
        grid[0][0] = VACIO;
        grid[grid.length-1][grid[0].length-1] = VACIO;
    }

    public boolean esMuro(int i, int j) {
        return grid[i][j] == MURO;
    }

    public int[][] getGrid() {
        return grid;
    }
}
