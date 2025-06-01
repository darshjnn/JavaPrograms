package BinarySearchTree.BSTNode;

public class AVLNode {
    public int data, height;
    public AVLNode left, right;

    public AVLNode(int data) {
        this.data = data;
        height = 1;
    }
}
