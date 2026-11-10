package model;

public class HistorialAcciones {
    private Stack<Accion> historial;

    public HistorialAcciones(){
        this.historial= new Stack<>();
    }

    public void addAccion(Accion accion){
        if(accion == null){
            throw new IllegalArgumentException("No se puede ingresar valores nulos");
        }
        this.historial.push(accion);
        System.out.println("se ha añadido la Accion con exito\n");
    }

    public void popAccion(){
        if(historial.isEmpty()){
            throw new IllegalArgumentException("El historial está vacio pibe");
        }
        Accion accionSacada= historial.peek();
        System.out.println("la accion sacada es " + accionSacada + "\n");
        this.historial.pop();
    }

    //retorne una nueva pila con las acciones comprendidas entre esas posiciones, incluidos ambos extremos.
    public Stack<Accion> obtenerSegmento(int inicio, int fin){
        if(inicio<1 || inicio>fin || fin>this.historial.getSize() || this.historial.peek()==null ||
        inicio>this.historial.getSize()){
            return new Stack<>();
        }
        Stack<Accion> pilaAux= historial.cloneRecursivo(historial.getTop());
        Stack<Accion> pilaBasurero= new Stack<>();
        Stack<Accion> pilaPreRetornar= new Stack<>();
        Stack<Accion> pilaRetornar= new Stack<>();
        int contadorInicio= inicio;
        while(contadorInicio>1){
            pilaBasurero.push(pilaAux.pop());
            contadorInicio--;
        }while ((fin- inicio)>=0){
            pilaPreRetornar.push(pilaAux.pop());
            fin--;
        }while (pilaPreRetornar.getSize()!= 0){
            pilaRetornar.push(pilaPreRetornar.pop());
        }return pilaRetornar;
    }

}
