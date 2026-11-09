package Tree;

public class Equipo implements Comparable<Equipo> {

    private int codigo;
    private String nombre;

    public Equipo(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Equipo other) {
        return Integer.compare(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}