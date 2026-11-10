package model;

public class Accion {
    private String ID;
    private String descripcion;

    public Accion(String ID, String descripcion) {
        this.ID = ID;
        this.descripcion = descripcion;
    }

    public String getID() {
        return ID;}

    public void setID(String ID) {
        this.ID = ID;}

    public String getDescripcion() {
        return descripcion;}

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;}

    @Override
    public String toString() {
        return "Accion{" +
                "ID='" + ID + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
