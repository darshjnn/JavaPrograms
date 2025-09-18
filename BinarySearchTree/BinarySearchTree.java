/*
Implementation of Binary Search Tree.
All constructors for different nodes are in the 'Node' package inside the 'BinaryTree' package.

Inorder Traversal of Binary Search Tree gives a sorted sequence of elements.

*/

package BinarySearchTree;

import BinaryTree.Node.Node;
import BinarySearchTree.BSTNode.NodeInfo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class BinarySearchTree {
    // Creating a BST
    public Node buildBST(int[] arr) {
        if (arr == null) {
            return null;
        }

        Node root = null;

        for (int value : arr) {
            root = addNode(root, value);
        }

        return root;
    }

    public Node addNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (root.data > value) {
            root.left = this.addNode(root.left, value);
        } else {
            root.right = this.addNode(root.right, value);
        }

        return root;
    }

    // Inorder Traversal
    public void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + "  ");
        inorder(root.right);
    }

    // Level Order Traversal
    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.offer(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
    }

    // Search Element
    // Time complexity to search a key: O(H), H = height of Tree
    public boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data < key) {
            return this.search(root.right, key);
        } else {
            return this.search(root.left, key);
        }
    }

    // Deleting a Node
    public Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data < key) {
            root.right = delete(root.right, key);
        } else if (root.data > key) {
            root.left = delete(root.left, key);
        } else {
            // Voilà!!!
            // Case 1: Leaf Node, i.e., No Child Exists
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only Single Child Exists
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Both Children Exist
            Node inorderSuccessor = findInorderSuccessor(root.right);
            root.data = inorderSuccessor.data;
            root.right = this.delete(root.right, inorderSuccessor.data);
        }

        return root;
    }

    // Inorder successor in BST is left most node in right subtree
    public Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // Print in Range
    public void printInRange(Node root, int low, int high) {
        if (root == null) {
            return;
        }

        if (root.data < low) {
            this.printInRange(root.right, low, high);
        } else if (root.data > high) {
            this.printInRange(root.left, low, high);
        } else {
            this.printInRange(root.left, low, high);
            System.out.print(root.data + " ");
            this.printInRange(root.right, low, high);
        }
    }

    // Sum in Range
    public int sumInRange(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.data < low) {
            return this.sumInRange(root.right, low, high);
        } else if (root.data > high) {
            return this.sumInRange(root.left, low, high);
        } else {
            int left = this.sumInRange(root.left, low, high);
            int right = this.sumInRange(root.right, low, high);
            return left + right + root.data;
        }
    }

    // Root to Leaf Paths
    public void rootToLeaf(Node root) {
        if (root == null) {
            return;
        }

        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        getPaths(root, new ArrayList<>(), paths);

        for (ArrayList<Integer> path : paths) {
            System.out.println(path);
        }
    }

    public void getPaths(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            ArrayList<Integer> temp = new ArrayList<>(path);
            paths.add(temp);
        }

        this.getPaths(root.left, path, paths);
        this.getPaths(root.right, path, paths);

        path.removeLast();
    }

    // Validate a Binary Search Tree
    public boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }

        if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    // Mirror/Invert a BST
    public Node invertTree(Node root) {
        if (root == null) {
            return null;
        }

        Node left = this.invertTree(root.left);
        root.left = this.invertTree(root.right);
        root.right = left;

        return root;
    }

    // Create a Height Balance from Sorted Array
    public Node sortedArrayToBST(int[] arr, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        Node root = new Node(arr[mid]);
        root.left = this.sortedArrayToBST(arr, low, mid - 1);
        root.right = this.sortedArrayToBST(arr, mid + 1, high);

        return root;
    }

    // Convert BST to Balanced BST
    public Node balanceBST(Node root) {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> inorder = new ArrayList<>();
        this.getInorder(root, inorder);
        root = this.createBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    public void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        this.getInorder(root.left, inorder);
        inorder.add(root.data);
        this.getInorder(root.right, inorder);
    }

    public Node createBST(ArrayList<Integer> arr, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;

        Node root = new Node(arr.get(mid));
        root.left = this.createBST(arr, low, mid - 1);
        root.right = this.createBST(arr, mid + 1, high);

        return root;
    }

    // Merge Two BSTs
    public Node mergeBST(Node r1, Node r2) {
        if ((r1 == null) && (r2 == null)) {
            return null;
        }

        if (r1 == null) {
            return r2;
        }

        if (r2 == null) {
            return r1;
        }

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> merged = new ArrayList<>();

        this.getInorder(r1, arr1);
        this.getInorder(r2, arr2);

        int n = arr1.size(), m = arr2.size();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1.get(i) < arr2.get(j)) {
                merged.add(arr1.get(i));
                ++i;
            } else {
                merged.add(arr2.get(j));
                ++j;
            }
        }

        while (i < n) {
            merged.add(arr1.get(i));
            ++i;
        }

        while (j < m) {
            merged.add(arr2.get(j));
            ++j;
        }

        return this.createBST(merged, 0, (n + m - 2));
    }

    // Size and Sum of the largest BST in Binary Tree
    // Valid only for Positive data in the Nodes
    public NodeInfo largestBST(Node root) {
        if (root == null) {
            return new NodeInfo(true, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        NodeInfo left = this.largestBST(root.left);
        NodeInfo right = this.largestBST(root.right);

        int size = Math.max(left.size, right.size);
        int sum = Math.max(left.sum, right.sum);
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));

        // Check if the root also fits in the BST:
        if (root.data <= left.max || root.data >= right.min) {
            return new NodeInfo(false, size, sum, min, max);
        }

        // If the root fits in the BST:
        if (left.isBST && right.isBST) {
            size = Math.max(size, (left.size + right.size + 1));
            sum = Math.max(sum, (root.data + left.sum + right.sum));
            return new NodeInfo(true, size, sum, min, max);
        }

        return new NodeInfo(false, size, sum, min, max);
    }
}