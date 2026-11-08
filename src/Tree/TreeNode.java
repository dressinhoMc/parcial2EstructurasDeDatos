package Tree;

public class TreeNode<T> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;
    private TreeNode<T> father;

    public TreeNode(T data, TreeNode<T> father) {
        this.father = father;
        this.data = data;
    }

    public TreeNode(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public TreeNode<T> getFather() {
        return father;
    }

    public void setFather(TreeNode<T> father) {
        this.father = father;
    }
}
