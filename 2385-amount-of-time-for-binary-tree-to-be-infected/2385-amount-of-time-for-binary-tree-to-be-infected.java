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

    static class Result {
        int timeToBurn = 0;
    }

    public int amountOfTime(TreeNode root, int start) {
        Result res = new Result();
        burnTime(root, start, res);
        return res.timeToBurn;
    }

    private int burnTime(TreeNode node, int start, Result res) {
        if (node == null) return 0;

        if (node.val == start) {
            int maxDepth = subtreeDepth(node);
            res.timeToBurn = Math.max(res.timeToBurn, maxDepth - 1);
            return 1;
        }

        int left = burnTime(node.left, start, res);
        if (left > 0) {
            int rightDepth = subtreeDepth(node.right);
            res.timeToBurn = Math.max(res.timeToBurn, left + rightDepth);
            return left + 1;
        }

        int right = burnTime(node.right, start, res);
        if (right > 0) {
            int leftDepth = subtreeDepth(node.left);
            res.timeToBurn = Math.max(res.timeToBurn, right + leftDepth);
            return right + 1;
        }

        return 0;
    }

    private int subtreeDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(subtreeDepth(node.left), subtreeDepth(node.right));
    }
}
