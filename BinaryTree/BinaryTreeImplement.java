/*
Implementation of Binary Tree.
All constructors for different nodes are in 'Node' package.

*/

package BinaryTree;

import BinaryTree.Node.Node;
import BinaryTree.Node.NodeInfo;

public class BinaryTreeImplement {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        // Create Binary Tree
        // Pointer is passed in the form of single length array for tracking index.
        Node root = tree.buildTree(arr, new int[] { 0 });

        // Preorder 
        System.out.print("Preorder Traversal: ");
        tree.preorder(root);

        // Inorder Traversal
        System.out.print("\nInorder Traversal: ");
        tree.inorder(root);

        // Postorder Traversal
        System.out.print("\nPostorder Traversal: ");
        tree.postorder(root);

        // Level Order Traversal
        System.out.println("\nLevel Order Traversal: ");
        tree.levelOrder(root);

        // Height of Tree
        System.out.println("\nHeight of Tree: " + tree.height(root));

        // Minimum Depth of Tree
        System.out.println("\nMinimum Depth of Tree: " + tree.minDepth(root));

        // Count Nodes
        System.out.println("\nNo. of Nodes: " + tree.count(root));

        // Sum of Nodes
        System.out.println("\nSum of Nodes: " + tree.sum(root));

        // Diameter of Tree from approach 1
        System.out.println("\nDiameter (approach 1): " + tree.diameter(root));

        // Diameter & Height of Tree from approach 2
        NodeInfo rootInfo = tree.treeInfo(root);
        System.out.println("\nDiameter (approach 2): " + rootInfo.diameter);
        System.out.println("Height (approach 2): " + rootInfo.height);

        // Check if the tree is subtree of another tree
        Node root2 = new Node(2);
        root2.left = new Node(4);
        root2.right = new Node(5);
        System.out.println("\nIs Sub Tree?: " + tree.isSubtree(root, root2));

        // Top View of the Tree
        System.out.print("\nTop View of Tree: ");
        tree.topView(root);

        // Bottom View of the Tree
        System.out.print("\nBottom View of Tree: ");
        tree.bottomView(root);

        // All Nodes at Kth level
        System.out.print("\n\nAll Nodes at 3rd level: ");
        tree.kthLevel(root, 3);

        // Lowest Common Ancestor: Approach 1
        System.out.print("\n\nLowest Common Ancestor (approach 1): ");
        System.out.println(tree.lowestCommonAncestor1(root, 4, 5));

        // Lowest Common Ancestor: Approach 1
        System.out.print("\nLowest Common Ancestor (approach 2): ");
        System.out.println(tree.lowestCommonAncestor2(root, 4, 5).data);

        // Minimum Distance Between 2 Nodes
        System.out.print("\nMinimum Dist Between Nodes 4 & 6: ");
        System.out.println(tree.minDist(root, 4, 6) + " Edges");

        // Kth Ancestor
        System.out.print("\nFirst Ancestor of 4: ");
        tree.kAncestor(root, 4, 1);

        // Transform to Sum Tree
        System.out.println("\nTransform to Sum Tree: ");
        tree.sumTree(root);
        tree.levelOrder(root);

        System.out.println("\n-------------------------------------------");
    }
}