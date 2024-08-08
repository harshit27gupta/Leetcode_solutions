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
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateMaxPathSum(root);
        return maxPathSum;
    }

    private int calculateMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(0, calculateMaxPathSum(node.left));
        int rightMax = Math.max(0, calculateMaxPathSum(node.right));

        int currentPathSum = node.val + leftMax + rightMax;

        maxPathSum = Math.max(maxPathSum, currentPathSum);

        return node.val + Math.max(leftMax, rightMax);
    }
}
