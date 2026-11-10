package model;

public class Cola<T>{
    private int size;
    private SimpleNode<T> firstNode;
    private SimpleNode<T> lastNode;

    public Cola(){
        this.size= 0;
        firstNode= null;
        lastNode= null;
    }

    public int getSize(){return size;}

    public boolean isEmpty(){return firstNode == null;}

    public void encolar(T data){
        SimpleNode<T> newSimpleNode= new SimpleNode<>(data);
        if(isEmpty()){
            firstNode= newSimpleNode;
            lastNode= newSimpleNode;
        }else{
            lastNode.setNext(newSimpleNode);
            lastNode= newSimpleNode;
        }size++;
    }

    public T desenconlar() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacia crack\n");
        } else {
            T data = firstNode.getData();
            firstNode = firstNode.getNext();
            if (firstNode == null) {
                lastNode = null;
            }
            size--;
            return data;
        }
    }

    public void invertirColaRecursivo(){
        if(isEmpty()){
            System.out.println("papu, la lista está vacia\n");
            return;
        }T elemento= desenconlar();
        invertirColaRecursivo();
        encolar(elemento);
    }

    public void encolarFirst(T data){
        SimpleNode<T> newSimpleNode= new SimpleNode<>(data);
        if(isEmpty()){
            firstNode= newSimpleNode;
        }else{
            newSimpleNode.setNext(firstNode);
            firstNode= newSimpleNode;
        }size++;
    }

    public void desencolarElementoEspecifico(T elemento){
        if(isEmpty()){
            throw new RuntimeException("La cola está vacia");
        }if (firstNode.getData().equals(elemento)) {
            desenconlar();
            return;
        }
        Cola<T> colaAux = new Cola<>();
        boolean encontrado = false;
        while (isEmpty()!= true) {
            T elementoActual = desenconlar();
            if (!encontrado && elementoActual.equals(elemento)) {
                encontrado = true;
            }else {
                colaAux.encolar(elementoActual);
            }
        }while (colaAux.isEmpty()!= true) {
            encolar(colaAux.desenconlar());
        }
    }

    public Cola<T> cloneRecursivo() {
        Cola<T> colaClonada = new Cola<>();
        cloneRecursivo(this.firstNode, colaClonada);
        return colaClonada;
    }

    private void cloneRecursivo(SimpleNode<T> node, Cola<T> colaClonada) {
        if (node == null) {
            return;
        }
        colaClonada.encolar(node.getData());
        cloneRecursivo(node.getNext(), colaClonada);
    }

}

