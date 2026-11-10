package main.java.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<T extends Comparable<T>> {
    private int  weight;
    private TreeNode<T> root;

    public Tree() {
        this.weight = 0;
        this.root = null;
    }

    public int getWeight(TreeNode<T> left) {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }


    //  Recorrido Inorden
    public void recorrerInorder(){
        recorrerInorder(root);
    }

    private void  recorrerInorder(TreeNode<T> root){
        if(root == null) return;
        recorrerInorder(root.getLeft());
        System.out.println(root.getData());
        recorrerInorder(root.getRight());
    }


    //  Recorrido Preorden
    public void recorrerPreorder(){
        recorrerPreorder(root);
    }

    private void  recorrerPreorder(TreeNode<T> root){
        if(root == null) return;
        System.out.println(root.getData());
        recorrerPreorder(root.getLeft());
        recorrerPreorder(root.getRight());
    }

    // Recorrido Postorden
    public void recorrerPostorder(){
        recorrerPostorder(root);
    }

    private void  recorrerPostorder(TreeNode<T> root){
        if(root == null) return;
        recorrerPostorder(root.getLeft());
        recorrerPostorder(root.getRight());
        System.out.println(root.getData());
    }

    // Obtener Peso
    public int obtenerPeso(){
        return obtenerPeso(root);
    }
    public int obtenerPeso(TreeNode<T> raiz) {
        if (raiz == null) return 0;

        return 1 + obtenerPeso(raiz.getLeft())+obtenerPeso(raiz.getRight());
    }

    // Obtener Altura
    public int obtenerAltura() {
        return obtenerAltura(root);
    }

    private int obtenerAltura(TreeNode<T> node) {
        if (node == null) return 0;

        int alturaIzquierda = obtenerAltura(node.getLeft());
        int alturaDerecha = obtenerAltura(node.getRight());

        return 1 + (alturaIzquierda > alturaDerecha ? alturaIzquierda : alturaDerecha);
    }

    // Recorrido en amplitud
    public void recorridoAmplitud(){
        if (root == null) return;
        Queue<TreeNode<T>> discovered = new LinkedList<>();

        discovered.add(root);

        while (!discovered.isEmpty()){
            TreeNode<T> actual = discovered.poll();
            System.out.println(actual.getData());

            TreeNode<T> left = actual.getLeft();
            TreeNode<T> right = actual.getRight();

            if (left != null){
                discovered.add(left);
            }

            if (right != null){
                discovered.add(right);
            }
        }

    }

    // Binary Search
    public boolean nodeExists(T data){
        return nodeExists(root, data);
    }

    private boolean nodeExists(TreeNode<T> auxRoot, T data) {
        if (auxRoot == null) return false;
        int comp = auxRoot.getData().compareTo(data);
        if (comp == 0) return true;
        if (comp > 0){
            return nodeExists(auxRoot.getLeft(), data);
        }else{
            return nodeExists(auxRoot.getRight(), data);
        }
    }

    // Insert binary
    public void insert(T data){
        root = insert(root, data);
    }
    private TreeNode<T> insert(TreeNode<T> auxRoot, T data) {
        if (auxRoot == null){
            weight++;
            return new TreeNode<>(data);
        }else{
            int comp = auxRoot.getData().compareTo(data);
            if (comp == 0){
                throw new RuntimeException("Ya existe un elemento");
            }
            if (comp > 0){
                auxRoot.setLeft(insert(auxRoot.getLeft(), data));
                auxRoot.getLeft().setFather(auxRoot);
            }else{
                auxRoot.setRight(insert(auxRoot.getRight(), data));
                auxRoot.getRight().setFather(auxRoot);
            }
            return auxRoot;
        }
    }

    // Delete
    public void delete(T data){
        if (!nodeExists(data)) return;
        root = delete(root, data);
        if (root != null) root.setFather(null);
        weight--;
    }

    private TreeNode<T> delete(TreeNode<T> auxRoot, T data) {
        if (auxRoot == null) return null;

        int comp = auxRoot.getData().compareTo(data);
        if (comp > 0) {
            auxRoot.setLeft(delete(auxRoot.getLeft(), data));
            if (auxRoot.getLeft() != null) auxRoot.getLeft().setFather(auxRoot);
            return auxRoot;
        }
        if (comp < 0) {
            auxRoot.setRight(delete(auxRoot.getRight(), data));
            if (auxRoot.getRight() != null) auxRoot.getRight().setFather(auxRoot);
            return auxRoot;
        }

        // Leaf or node with one child: return the child to bypass this node.
        if (auxRoot.getLeft() == null || auxRoot.getRight() == null) {
            TreeNode<T> child = auxRoot.getLeft() != null
                    ? auxRoot.getLeft()
                    : auxRoot.getRight();
            if (child != null) child.setFather(auxRoot.getFather());
            auxRoot.setLeft(null);
            auxRoot.setRight(null);
            auxRoot.setFather(null);
            return child;
        }

        // Two children: copy the inorder predecessor, then remove it.
        TreeNode<T> predecessor = auxRoot.getLeft();
        while (predecessor.getRight() != null) {
            predecessor = predecessor.getRight();
        }
        auxRoot.setData(predecessor.getData());
        auxRoot.setLeft(delete(auxRoot.getLeft(), predecessor.getData()));
        if (auxRoot.getLeft() != null) auxRoot.getLeft().setFather(auxRoot);
        return auxRoot;
    }


    public int contarEquiposEnRango(TreeNode<Equipo> root, int lowerLimit, int upperLimit) {

        //casos base
        if(root == null) return 0;
        if(lowerLimit > upperLimit) return 0;

        int nodo = root.getData().getCodigo();

        int left = 0;
        int right = 0;

        // caso recursivo izquierda
        if (nodo > lowerLimit) {
            left = contarEquiposEnRango(root.getLeft(), lowerLimit, upperLimit);
        }

        // caso recursivo derecha
        if (nodo < upperLimit) {
            right = contarEquiposEnRango(root.getRight(), lowerLimit, upperLimit);
        }

        int actual = 0;
        if ((lowerLimit <= nodo) && (nodo <= upperLimit)) {
            actual = 1;
        }

        return actual + left + right;

    }



}
