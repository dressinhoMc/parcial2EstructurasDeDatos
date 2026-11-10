package model;

public class Stack<T> {
    private int size;
    private SimpleNode<T> top;

    public Stack() {
        this.size=0;
        this.top=null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(T data){
        SimpleNode newSimpleNode= new SimpleNode<>(data);
        if(isEmpty()){
            top= newSimpleNode;
        }else{
            newSimpleNode.setNext(top);
            top= newSimpleNode;
        }
        size++;
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("Está vacia men");
        }else{
            T data= top.getData();
            top= top.getNext();
            size--;
            return data;
        }
    }

    public SimpleNode<T> getTop(){
        return this.top;
    }

    public T peek(){
        return top.getData();
    }

    public Stack<T> cloneRecursivo(SimpleNode<T> node) {
        if (node == null) {
            return new Stack<>();}
        Stack<T> cloned = cloneRecursivo(node.getNext());
        cloned.push(node.getData());
        return cloned;
    }

    public int getSize(){
        return this.size;
    }

    public void addAll(Stack<T> pilaExtra) {
        if (pilaExtra == null || pilaExtra.isEmpty()) {
            return;
        }
        Stack<T> temp = new Stack<>();
        SimpleNode<T> nodoAux = pilaExtra.top;
        while (nodoAux != null) {
            temp.push(nodoAux.getData());
            nodoAux = nodoAux.getNext();
        }
        nodoAux = temp.top;
        while (nodoAux != null) {
            this.push(nodoAux.getData());
            nodoAux = nodoAux.getNext();
        }
    }
}