package model;

public class HistorialOperaciones {
    private Stack<Operacion> historial;

    public HistorialOperaciones(){
        this.historial= new Stack<>();
    }

    public void addOperacion(Operacion operacion){
        if(operacion == null){
            throw new IllegalArgumentException("No se puede ingresar valores nulos");
        }
        this.historial.push(operacion);
        System.out.println("se ha añadido la operacion con exito\n");
    }

    public void popOperacion(){
        if(historial.isEmpty()){
            throw new IllegalArgumentException("El historial está vacio pibe");
        }
        Operacion opSacada= historial.peek();
        System.out.println("la operación sacada es " + opSacada + "\n");
        this.historial.pop();
    }

    //debe retornar las n operaciones CONFIRMADAS más recientes, dejando en el tope la mas recientes
    public Stack<Operacion> obtenerUltimasConfirmadas(int n){
        if(n<=0){
            return new Stack<>();
        } int finalizador= n;
        Stack<Operacion> pilaAux= this.historial;
        Stack<Operacion> pilaPreRetornar= new Stack<>();
        Stack<Operacion> pilaRetornar= new Stack<>();
        if(pilaAux.isEmpty()){
            throw new RuntimeException("La pila de operaciones está re vacia");
        }
        while(pilaAux.peek() != null){
            Operacion aux= pilaAux.pop();
            if(aux.getEstado()== true){
                pilaPreRetornar.push(aux);
            } finalizador--;
            if(finalizador== 0){
                while (pilaPreRetornar.getSize()!= 0){
                    Operacion auxInvertir= pilaPreRetornar.pop();
                    pilaRetornar.push(auxInvertir);
                }
                return pilaRetornar;
            }
        } while (pilaPreRetornar.getSize()!= 0){
            Operacion auxInvertir= pilaPreRetornar.pop();
            pilaRetornar.push(auxInvertir);
        } return pilaRetornar;
    }
}
