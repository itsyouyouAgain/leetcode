class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize the TreeNode with a value.
    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Construct the binary tree.
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Define nodes p and q.
        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.left.right.right; // Node with value 4

        // Find the lowest common ancestor of nodes p and q.
        TreeNode lca = lowestCommonAncestor(root, p, q);

        // Print the result.
        System.out.println("The lowest common ancestor of nodes " + p.val + " and " + q.val + " is " + (lca != null ? lca.val : "not found"));
    }

    /**
     * Finds the lowest common ancestor of two nodes in a binary tree.
     *
     * @param root The root of the tree.
     * @param p The first node.
     * @param q The second node.
     * @return The lowest common ancestor node, or null if either node is not found.
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If reaching the end or finding one of the nodes, return root.
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search for the lowest common ancestor in the left and right subtrees.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return a node, it means p and q are found in different branches.
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side is not null, or null if both are null.
        return left != null ? left : right;
    }
}
