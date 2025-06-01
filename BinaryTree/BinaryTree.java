package BinaryTree;

import BinaryTree.Node.Node;
import BinaryTree.Node.NodeInfo;
import BinaryTree.Node.NodeDistance;

import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;

public class BinaryTree {
    // Create a Binary Tree from an array
    // Pointer is created in the form of a single length array for tracking index.
    public Node buildTree(int[] arr, int[] pointer) {
        if (arr.length == 0 || arr.length <= pointer[0]) {
            return null;
        }

        if (arr[pointer[0]] == -1) {
            ++pointer[0];
            return null;
        }

        Node root = new Node(arr[pointer[0]]);

        pointer[0] = pointer[0] + 1;
        root.left = buildTree(arr, pointer);
        root.right = buildTree(arr, pointer);

        return root;
    }

    // DFS Traversal: Preorder, Postorder, Inorder
    // Preorder Traversal: Root -> Left -> Right
    public void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + "  ");

        preorder(root.left);
        preorder(root.right);
    }

    // Inorder Traversal: Left -> Root -> Right
    public void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + "  ");
        inorder(root.right);
    }

    // Postorder Traversal: Left -> Right -> Root
    void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + "  ");
    }

    // BFS Traversal: Level Order
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
                System.out.print(curr.data + "  ");
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
    }

    // Height of Tree
    int height(Node root) {
        if (root == null) {
            return 0;
        }

        int left = 0, right = 0;

        left += height(root.left);
        right += height(root.right);

        return Math.max(left, right) + 1;
    }

    // Minimum Depth of Tree
    @SuppressWarnings("DuplicatedCode")
    int minDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (root.left == null) {
            return right + 1;
        }

        if (root.right == null) {
            return left + 1;
        }

        return Math.min(left, right) + 1;
    }

    // Count Number of Nodes
    int count(Node root) {
        if (root == null) {
            return 0;
        }

        int left = count(root.left);
        int right = count(root.right);

        return left + right + 1;
    }

    // Sum of Nodes
    int sum(Node root) {
        if (root == null) {
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);

        return left + right + root.data;
    }

    // Diameter of Tree: Normal Zindagi Approach -> Time Complexity: O(n^2)
    int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int diameter = this.height(root.left) + this.height(root.right) + 1;

        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    }

    // Diameter of Tree: Mentos Zindagi Approach -> Time Complexity: O(n)
    NodeInfo treeInfo(Node root) {
        if (root == null) {
            return new NodeInfo(0, 0);
        }

        NodeInfo left = treeInfo(root.left);
        NodeInfo right = treeInfo(root.right);

        int height = Math.max(left.height, right.height) + 1;
        int currDiameter = left.height + right.height + 1;
        int diameter = Math.max(currDiameter, Math.max(left.diameter, right.diameter));

        return new NodeInfo(height, diameter);
    }

    // Check if the given Tree is Subtree
    boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    boolean isSubtree(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data == root2.data) {
            return isIdentical(root1, root2);
        }

        return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    // Top View of Tree
    void topView(Node root) {
        if (root == null) {
            System.out.println("Tree is Empty...");
            return;
        }

        HashMap<Integer, Node> map = new HashMap<>();
        Queue<NodeDistance> q = new LinkedList<>();

        int max = 0, min = 0;
        q.offer(new NodeDistance(root, 0));
        q.offer(null);

        while (!q.isEmpty()) {
            NodeDistance curr = q.poll();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.offer(null);
                }
            } else {
                if (!map.containsKey(curr.xDistance)) {
                    map.put(curr.xDistance, curr.node);
                }
                if (curr.node.left != null) {
                    q.offer(new NodeDistance(curr.node.left, curr.xDistance - 1));
                    min = Math.min(min, curr.xDistance - 1);
                }
                if (curr.node.right != null) {
                    q.offer(new NodeDistance(curr.node.right, curr.xDistance + 1));
                    max = Math.max(max, curr.xDistance + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + "  ");
        }
    }

    // Bottom View of Tree
    void bottomView(Node root) {
        if (root == null) {
            System.out.println("Tree is Empty...");
            return;
        }

        Queue<NodeDistance> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.offer(new NodeDistance(root, 0));
        q.offer(null);

        while (!q.isEmpty()) {
            NodeDistance curr = q.poll();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.offer(null);
                }
            } else {
                map.put(curr.xDistance, curr.node);
                if (curr.node.left != null) {
                    min = Math.min(min, curr.xDistance - 1);
                    q.offer(new NodeDistance(curr.node.left, curr.xDistance - 1));
                }
                if (curr.node.right != null) {
                    max = Math.max(max, curr.xDistance + 1);
                    q.offer(new NodeDistance(curr.node.right, curr.xDistance + 1));
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + "  ");
        }
    }

    // All Nodes at Kth level
    void kthLevel(Node root, int k) {
        getNodes(root, k, 1);
    }

    void getNodes(Node root, int k, int level) {
        if (root == null) {
            return;
        }

        if (k == level) {
            System.out.print(root.data + "  ");
            return;
        }

        getNodes(root.left, k, level + 1);
        getNodes(root.right, k, level + 1);
    }

    // Lowest Common Ancestor: Normal Zindagi Approach
    int lowestCommonAncestor1(Node root, int p, int q) {
        if (root == null) {
            System.out.print("Tree is Empty...  ");
            return Integer.MIN_VALUE;
        }

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if (!this.getPath(root, p, path1) || !this.getPath(root, q, path2)) {
            System.out.println("No Common Ancestor...");
            return Integer.MIN_VALUE;
        }

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        return path1.get(i - 1).data;
    }

    boolean getPath(Node root, int node, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);
        if (root.data == node) {
            return true;
        }

        if (getPath(root.right, node, path) || getPath(root.left, node, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    // Lowest Common Ancestor: Mentos Zindagi
    Node lowestCommonAncestor2(Node root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root;
        }

        Node left = lowestCommonAncestor2(root.left, p, q);
        Node right = lowestCommonAncestor2(root.right, p, q);

        if (right == null) {
            return left;
        }

        if (left == null) {
            return right;
        }

        return root;
    }

    // Minimum Distance Between Two Nodes in terms of Edges
    public int minDist(Node root, int p, int q) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        Node commonAncestor = lowestCommonAncestor2(root, p, q);
        int pDist = getDist(commonAncestor, p);
        int qDist = getDist(commonAncestor, q);

        return pDist + qDist;
    }

    public int getDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int left = getDist(root.left, n);
        int right = getDist(root.right, n);

        if (left == -1 && right == -1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    // Kth Ancestor of a Node
    public int kAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int left = kAncestor(root.left, n, k);
        int right = kAncestor(root.right, n, k);

        if (left == -1 && right == -1) {
            return -1;
        }

        int dist = Math.max(left, right) + 1;
        if (dist == k) {
            System.out.println(root.data);
        }

        return dist;
    }

    // Transform to Sum Tree
    public int sumTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftChild = sumTree(root.left);
        int left = root.left == null ? 0 : root.left.data;

        int rightChild = sumTree(root.right);
        int right = root.right == null ? 0 : root.right.data;

        int data = root.data;
        root.data = leftChild + left + rightChild + right;

        return data;
    }
}