package BinaryTree.Node;

public class Node {
    public Node left, right;
    public int data;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
    
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
