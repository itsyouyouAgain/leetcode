class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return sum;
    }

    // helper method to perform dfs on the tree to accumulate values within the range
    void traverse(TreeNode root, int low, int high){
        //base case
        if(root == null) return;

        // If the current node's value is less than the low boundary, skip the left subtree
        if(root.val < low){
            traverse(root.right, low, high);
        }
        // If the current node's value is greater than the low boundary, skip the left subtree
        else if(root.val > high){
            traverse(root.left, low, high);
        }
        // If the current node's value is within the [low, high] range, add it to sum
        else{
            sum += root.val;
            // Continue the search in both left and right subtrees since there could be more valid nodes
            traverse(root.right, low, high);
            traverse(root.left, low, high);
        }
    }

    public static void main(String[] args) {
        // Create the binary tree from the example
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        // Create a Solution instance and use it to compute the range sum
        Solution solution = new Solution();
        int low = 7;
        int high = 15;
        int result = solution.rangeSumBST(root, low, high);

        // Output the result
        System.out.println("Output: " + result);
        System.out.println("Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.");
    }
}
// Time Complexity: O(n) in the worst case; however, for balanced trees, each check potentially reduces the remaining subtree size in half, approaching O(log n) on average.
// Space Complexity: O(log n) for balanced trees due to recursion depth; O(n) in the worst case for unbalanced trees.





