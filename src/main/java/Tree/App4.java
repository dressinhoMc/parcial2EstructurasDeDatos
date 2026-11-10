package main.java.Tree;

public class App4 {
    static void main(String[] args) {
        //Un laboratorio registra sus equipos en un árbol binario de búsqueda. La clave de cada nodo es el código
        // entero del equipo. Los códigos son únicos.
        Tree<Equipo> laboratory = new Tree<Equipo>();

        //registrar equipo
        laboratory.insert(new Equipo(55, "Matraz"));
        laboratory.insert(new Equipo(53, "Microscopio"));
        laboratory.insert(new Equipo(48, "Centrifuga"));
        laboratory.insert(new Equipo(51, "Petri"));
        laboratory.insert(new Equipo(54, "Tubo"));
        laboratory.insert(new Equipo(59, "Pipeta"));
        laboratory.insert(new Equipo(56, "Embudo"));
        laboratory.insert(new Equipo(63, "Pipeta"));

        System.out.println("Equipo de Laboratorio:");
        laboratory.recorrerPreorder();
        // 55, 53, 48, 51, 54, 59, 56, 63

        int x = laboratory.contarEquiposEnRango(laboratory.getRoot(), 48, 59);
        System.out.println("Equipos en el rango 48 y 59: " + x);

        System.out.println(laboratory.contarEquiposEnRango(laboratory.getRoot(), 54, 56));
    }

}
