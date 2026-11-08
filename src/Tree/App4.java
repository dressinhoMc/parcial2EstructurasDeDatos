package Tree;

public class App4 {
    static void main(String[] args) {
        //Un laboratorio registra sus equipos en un árbol binario de búsqueda. La clave de cada nodo es el código
        // entero del equipo. Los códigos son únicos.
        Tree<Integer> equipo = new Tree<Integer>();

        //registrar equipo
        equipo.insert(50);
        equipo.insert(30);
        equipo.insert(70);
        equipo.insert(20);
        equipo.insert(40);
        equipo.insert(60);
        equipo.insert(80);
        equipo.insert(55);
        equipo.insert(65);

    }
}
