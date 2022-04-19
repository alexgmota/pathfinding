import GUI.Ventana;
import Laberinto.Laberinto;

public class App {

    public static void main(String[] args) {
         Laberinto lab = new Laberinto(800, 800, 20);
         new Ventana();
    }
}
