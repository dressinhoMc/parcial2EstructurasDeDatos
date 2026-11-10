package model;

import java.util.Objects;

public class Solicitud {
    private String ID;
    private boolean prioridad; //true si es alta y false si es normal
    private int duracionEstimada;

    public Solicitud(String ID, boolean prioridad, int duracionEstimada) {
        this.ID = ID;
        this.prioridad = prioridad;
        this.duracionEstimada = duracionEstimada;
    }

    public String getID() {
        return ID;}

    public void setID(String ID) {
        this.ID = ID;}

    public boolean getPrioridad() {
        return prioridad;}

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;}

    public int getDuracionEstimada() {
        return duracionEstimada;}

    public void setDuracionEstimada(int duracionEstimada) {
        this.duracionEstimada = duracionEstimada;}

    @Override
    public String toString() {
        return "Solicitud{" +
                "ID='" + ID + '\'' +
                ", prioridad=" + prioridad +
                ", duracionEstimada=" + duracionEstimada +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Solicitud solicitud = (Solicitud) o;
        return prioridad == solicitud.prioridad && duracionEstimada == solicitud.duracionEstimada &&
                Objects.equals(ID, solicitud.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, prioridad, duracionEstimada);
    }
}
