/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // Step 1: Get total sum of tree
        totalSum = getTotalSum(root);

        // Step 2: Find maximum product
        getSubtreeSum(root);

        return (int)(maxProduct % MOD);
    }

    // DFS to compute total sum
    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    // DFS to compute subtree sums and products
    private long getSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = getSubtreeSum(node.left);
        long right = getSubtreeSum(node.right);

        long subSum = node.val + left + right;

        maxProduct = Math.max(maxProduct, subSum * (totalSum - subSum));

        return subSum;
    }
}
