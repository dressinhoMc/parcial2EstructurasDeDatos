package model;

public class Operacion {
    private String ID;
    private boolean estado; //True: Confirmado/ false: anulada

    public Operacion(String ID, boolean estado){
        this.ID= ID;
        this.estado= estado;
    }

    public String getID() {
        return ID;}

    public void setID(String ID) {
        this.ID = ID;}

    public boolean getEstado() {
        return estado;}

    public void setEstado(boolean estado) {
        this.estado = estado;}

    @Override
    public String toString() {
        return "Operacion{" +
                "ID='" + ID + '\'' +
                ", estado=" + estado +
                '}';
    }
}
