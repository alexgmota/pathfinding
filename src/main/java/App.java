import GUI.Panel;
import GUI.Ventana;
import Laberinto.Laberinto;
import Pathfinding.AStar;
import Pathfinding.IPathFinder;

public class App {

    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto(Panel.getTamPantalla(), Panel.getTamPantalla(), Panel.getTamCelda());
        IPathFinder pf = new AStar(laberinto);
        Thread th = new Thread(pf::buscarCamino);
        th.start();
        new Ventana(laberinto, pf);
    }
}
