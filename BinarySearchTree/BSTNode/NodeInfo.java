package BinarySearchTree.BSTNode;

public class NodeInfo {
    public boolean isBST;
    public int size, sum, min, max;
    
    public NodeInfo(boolean isBST, int size, int sum, int min, int max) {
        this.isBST = isBST;
        this.size = size;
        this.sum = sum;
        this.min = min;
        this.max = max;
    }

    public NodeInfo(boolean isBst, int sum, int min, int max) {
        this.isBST = isBst;
        this.sum = sum;
        this.min = min;
        this.max = max;
    }
}
